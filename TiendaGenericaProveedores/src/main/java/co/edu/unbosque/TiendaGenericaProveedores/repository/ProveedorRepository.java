package co.edu.unbosque.TiendaGenericaProveedores.repository;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.TiendaGenericaProveedores.model.Proveedor;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {

	boolean existsByNitProveedor(Integer nitProveedor);

	// ← NUEVO: busca el objeto completo por NIT
	Optional<Proveedor> findByNitProveedor(Integer nitProveedor);

	List<Proveedor> findByCiudadProveedor(String ciudadProveedor);

	List<Proveedor> findByNombreProveedorContainingIgnoreCase(String nombreProveedor);

}