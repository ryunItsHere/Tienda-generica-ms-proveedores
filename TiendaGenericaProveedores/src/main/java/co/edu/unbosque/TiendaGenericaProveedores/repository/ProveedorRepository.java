package co.edu.unbosque.TiendaGenericaProveedores.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.TiendaGenericaProveedores.model.Proveedor;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {


	boolean existsByNit_proveedor(Integer nit_proveedor);

	List<Proveedor> findByCiudad_proveedor(String ciudad_proveedor);

	List<Proveedor> findByNombre_proveedorContainingIgnoreCase(String nombre_proveedor);
}
