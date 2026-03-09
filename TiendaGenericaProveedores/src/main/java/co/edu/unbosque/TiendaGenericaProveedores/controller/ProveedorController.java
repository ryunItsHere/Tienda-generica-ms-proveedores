package co.edu.unbosque.TiendaGenericaProveedores.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import co.edu.unbosque.TiendaGenericaProveedores.DTO.ProveedorDTO;
import co.edu.unbosque.TiendaGenericaProveedores.model.Proveedor;
import co.edu.unbosque.TiendaGenericaProveedores.services.ProveedorService;

@RestController
@RequestMapping("/proveedor")
@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:8081", "*" })
@Transactional
public class ProveedorController {

	@Autowired
	private ProveedorService proveedorServ;

	public ProveedorController() {
	}

	@PostMapping(path = "/createjson", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> createNewWithJSON(@RequestBody ProveedorDTO proveedorDTO) {

		int status = proveedorServ.create(proveedorDTO);

		switch (status) {
		case 0:
			return new ResponseEntity<>("{Proveedor creado correctamente}", HttpStatus.CREATED);
		case 1:
			return new ResponseEntity<>("{Error al crear proveedor, NIT ya en uso}", HttpStatus.NOT_ACCEPTABLE);
		default:
			return new ResponseEntity<>("{Error al crear proveedor}", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getall")
	public ResponseEntity<List<Proveedor>> getAll() {

		List<Proveedor> proveedores = proveedorServ.getAll();

		if (proveedores.isEmpty()) {
			return new ResponseEntity<>(proveedores, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(proveedores, HttpStatus.ACCEPTED);
		}
	}

	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Proveedor> getById(@PathVariable Long id) {

		Proveedor found = proveedorServ.getById(id);

		if (found != null) {
			return new ResponseEntity<>(found, HttpStatus.ACCEPTED);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping("/exists/{id}")
	public ResponseEntity<Boolean> exists(@PathVariable Long id) {

		boolean found = proveedorServ.exist(id);

		if (found) {
			return new ResponseEntity<>(true, HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>(false, HttpStatus.NO_CONTENT);
		}
	}

	@GetMapping("/getbyciudad")
	public ResponseEntity<List<Proveedor>> getByCiudad(@RequestParam String ciudad) {

		List<Proveedor> result = proveedorServ.getByCiudad(ciudad);

		if (result.isEmpty()) {
			return new ResponseEntity<>(result, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
		}
	}

	@GetMapping("/searchbyname")
	public ResponseEntity<List<Proveedor>> searchByNombre(@RequestParam String nombre) {

		List<Proveedor> result = proveedorServ.searchByNombre(nombre);

		if (result.isEmpty()) {
			return new ResponseEntity<>(result, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
		}
	}

	@PutMapping(path = "/updatejson", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateWithJSON(@RequestParam Long id, @RequestBody ProveedorDTO proveedorDTO) {

		int status = proveedorServ.updateById(id, proveedorDTO);

		switch (status) {
		case 0:
			return new ResponseEntity<>("Proveedor actualizado correctamente", HttpStatus.ACCEPTED);
		case 1:
			return new ResponseEntity<>("NIT ya en uso", HttpStatus.IM_USED);
		case 2:
			return new ResponseEntity<>("Proveedor no encontrado", HttpStatus.NOT_FOUND);
		default:
			return new ResponseEntity<>("Error al actualizar proveedor", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {

		int status = proveedorServ.deleteById(id);

		if (status == 0) {
			return new ResponseEntity<>("Proveedor eliminado correctamente", HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<>("Error al eliminar proveedor, no encontrado", HttpStatus.NOT_FOUND);
		}
	}
}