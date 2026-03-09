package co.edu.unbosque.TiendaGenericaProveedores.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.unbosque.TiendaGenericaProveedores.model.Proveedor;


@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {

    Optional<Proveedor> findByNombre(String nombre_proveedor);
    boolean existsByNit(Integer nit_proveedor);
    List<Proveedor> findByCiudad(String ciudad_proveedor);
    List<Proveedor> findByNombreContainingIgnoreCase(String nombre_proveedor);
}
