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
@CrossOrigin(origins = "*") // <--- CAMBIO 1: Vital para que el Frontend no se bloquee (CORS)
@Transactional
public class ProveedorController {

	@Autowired
	private ProveedorService proveedorServ;

	public ProveedorController() {
	}

	// CREATE
	@PostMapping(
			path = "/createjson",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> createNewWithJSON(@RequestBody ProveedorDTO proveedorDTO) {
		// CAMBIO 2: Cambié ResponseEntity<String> a ResponseEntity<?>
		// para evitar errores de renderizado en React si devuelve texto plano.

		int status = proveedorServ.create(proveedorDTO);

		switch (status) {
			case 0:
				return new ResponseEntity<>(proveedorDTO, HttpStatus.CREATED);
			case 1:
				return new ResponseEntity<>("NIT ya en uso", HttpStatus.BAD_REQUEST);
			default:
				return new ResponseEntity<>("Error interno", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// READ
	@GetMapping("/getall")
	public ResponseEntity<List<Proveedor>> getAll() {
		List<Proveedor> proveedores = proveedorServ.getAll();
		// CAMBIO 3: React explota si recibe NO_CONTENT (204).
		// Es mejor devolver una lista vacía [] con un OK (200).
		return new ResponseEntity<>(proveedores, HttpStatus.OK);
	}

	@GetMapping("/getbyid/{id}")
	public ResponseEntity<Proveedor> getById(@PathVariable Long id) {
		Proveedor found = proveedorServ.getById(id);
		if (found != null) {
			return new ResponseEntity<>(found, HttpStatus.OK);
		}
		return ResponseEntity.notFound().build();
	}

	// ─────────────────────────────────────────
	// ENDPOINTS POR NIT (integración MS-Productos)
	// ─────────────────────────────────────────

	// Verifica si existe por NIT → usado por MS-Productos
	@GetMapping("/existsbynit/{nit}")
	public ResponseEntity<Boolean> existsByNit(
			@PathVariable Integer nit) {
		boolean found = proveedorServ.existsByNit(nit);
		if (found) {
			return new ResponseEntity<>(true, HttpStatus.OK);
		}
		return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
	}

	// Retorna proveedor completo por NIT
	@GetMapping("/getbynit/{nit}")
	public ResponseEntity<Proveedor> getByNit(
			@PathVariable Integer nit) {
		Proveedor found = proveedorServ.getByNit(nit);
		if (found != null) {
			return new ResponseEntity<>(found, HttpStatus.OK);
		}
		return ResponseEntity.notFound().build();
	}

	// ─────────────────────────────────────────
	// BÚSQUEDAS ADICIONALES
	// ─────────────────────────────────────────
	@GetMapping("/getbyciudad")
	public ResponseEntity<List<Proveedor>> getByCiudad(
			@RequestParam String ciudad) {
		List<Proveedor> result = proveedorServ.getByCiudad(ciudad);
		if (result.isEmpty()) {
			return new ResponseEntity<>(
					result, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@GetMapping("/searchbyname")
	public ResponseEntity<List<Proveedor>> searchByNombre(
			@RequestParam String nombre) {
		List<Proveedor> result = proveedorServ.searchByNombre(nombre);
		if (result.isEmpty()) {
			return new ResponseEntity<>(
					result, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	// ─────────────────────────────────────────
	// UPDATE
	// ─────────────────────────────────────────
	@PutMapping(
			path = "/updatejson",
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateWithJSON(
			@RequestParam Long id,
			@RequestBody ProveedorDTO proveedorDTO) {

		int status = proveedorServ.updateById(id, proveedorDTO);

		switch (status) {
			case 0:
				return new ResponseEntity<>(
						"Proveedor actualizado correctamente",
						HttpStatus.OK);
			case 1:
				return new ResponseEntity<>(
						"NIT ya en uso", HttpStatus.CONFLICT);
			case 2:
				return new ResponseEntity<>(
						"Proveedor no encontrado",
						HttpStatus.NOT_FOUND);
			default:
				return new ResponseEntity<>(
						"Error al actualizar proveedor",
						HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// ─────────────────────────────────────────
	// DELETE
	// ─────────────────────────────────────────
	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id) {
		int status = proveedorServ.deleteById(id);
		if (status == 0) {
			return new ResponseEntity<>(
					"Proveedor eliminado correctamente", HttpStatus.OK);
		}
		return new ResponseEntity<>(
				"Error al eliminar proveedor, no encontrado",
				HttpStatus.NOT_FOUND);
	}
}