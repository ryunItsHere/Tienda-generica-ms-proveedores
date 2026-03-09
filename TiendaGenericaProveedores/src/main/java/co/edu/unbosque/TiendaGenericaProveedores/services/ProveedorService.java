package co.edu.unbosque.TiendaGenericaProveedores.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unbosque.TiendaGenericaProveedores.DTO.ProveedorDTO;
import co.edu.unbosque.TiendaGenericaProveedores.model.Proveedor;
import co.edu.unbosque.TiendaGenericaProveedores.repository.ProveedorRepository;

@Service
public class ProveedorService {

	@Autowired
	private ProveedorRepository proveedorRepo;

	public ProveedorService() {
	}

	public boolean exist(Long id) {
		return proveedorRepo.existsById(id);
	}

	public int create(ProveedorDTO dto) {

		if (proveedorRepo.existsByNit_proveedor(dto.getNit_proveedor())) {
			return 1;
		}

		Proveedor proveedor = new Proveedor();

		proveedor.setCiudad_proveedor(dto.getCiudad_proveedor());
		proveedor.setDireccion_proveedor(dto.getDireccion_proveedor());
		proveedor.setNit_proveedor(dto.getNit_proveedor());
		proveedor.setNombre_proveedor(dto.getNombre_proveedor());
		proveedor.setTelefono_proveedor(dto.getTelefono_proveedor());

		proveedorRepo.save(proveedor);

		return 0;
	}

	public List<Proveedor> getAll() {
		return proveedorRepo.findAll();
	}

	public Proveedor getById(Long id) {
		Optional<Proveedor> found = proveedorRepo.findById(id);
		return found.orElse(null);
	}

	public List<Proveedor> getByCiudad(String ciudad) {
		return proveedorRepo.findByCiudad_proveedor(ciudad);
	}

	public List<Proveedor> searchByNombre(String nombre) {
		return proveedorRepo.findByNombre_proveedorContainingIgnoreCase(nombre);
	}

	public int updateById(Long id, ProveedorDTO dto) {

		Optional<Proveedor> foundOpt = proveedorRepo.findById(id);

		if (foundOpt.isEmpty()) {
			return 2;
		}

		Proveedor proveedor = foundOpt.get();

		if (!proveedor.getNit_proveedor().equals(dto.getNit_proveedor())
				&& proveedorRepo.existsByNit_proveedor(dto.getNit_proveedor())) {
			return 1;
		}

		proveedor.setCiudad_proveedor(dto.getCiudad_proveedor());
		proveedor.setDireccion_proveedor(dto.getDireccion_proveedor());
		proveedor.setNit_proveedor(dto.getNit_proveedor());
		proveedor.setNombre_proveedor(dto.getNombre_proveedor());
		proveedor.setTelefono_proveedor(dto.getTelefono_proveedor());

		proveedorRepo.save(proveedor);

		return 0;
	}

	public int deleteById(Long id) {

		Optional<Proveedor> found = proveedorRepo.findById(id);

		if (found.isPresent()) {
			proveedorRepo.delete(found.get());
			return 0;
		} else {
			return 1;
		}
	}
}