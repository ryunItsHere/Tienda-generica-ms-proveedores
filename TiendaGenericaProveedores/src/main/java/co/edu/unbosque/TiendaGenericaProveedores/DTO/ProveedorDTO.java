package co.edu.unbosque.TiendaGenericaProveedores.DTO;

import java.util.Objects;

public class ProveedorDTO {
	
	private Long id;
	private String ciudad_proveedor;
	private String direccion_proveedor;
	private Integer nit_proveedor;
	private String nombre_poveedor;
	private String telefono_proveedor;
	
	public ProveedorDTO() {
		// TODO Auto-generated constructor stub
	}

	public ProveedorDTO(Long id, String ciudad_proveedor, String direccion_proveedor, Integer nit_proveedor,
			String nombre_poveedor, String telefono_proveedor) {
		super();
		this.id = id;
		this.ciudad_proveedor = ciudad_proveedor;
		this.direccion_proveedor = direccion_proveedor;
		this.nit_proveedor = nit_proveedor;
		this.nombre_poveedor = nombre_poveedor;
		this.telefono_proveedor = telefono_proveedor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCiudad_proveedor() {
		return ciudad_proveedor;
	}

	public void setCiudad_proveedor(String ciudad_proveedor) {
		this.ciudad_proveedor = ciudad_proveedor;
	}

	public String getDireccion_proveedor() {
		return direccion_proveedor;
	}

	public void setDireccion_proveedor(String direccion_proveedor) {
		this.direccion_proveedor = direccion_proveedor;
	}

	public Integer getNit_proveedor() {
		return nit_proveedor;
	}

	public void setNit_proveedor(Integer nit_proveedor) {
		this.nit_proveedor = nit_proveedor;
	}

	public String getNombre_poveedor() {
		return nombre_poveedor;
	}

	public void setNombre_poveedor(String nombre_poveedor) {
		this.nombre_poveedor = nombre_poveedor;
	}

	public String getTelefono_proveedor() {
		return telefono_proveedor;
	}

	public void setTelefono_proveedor(String telefono_proveedor) {
		this.telefono_proveedor = telefono_proveedor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ciudad_proveedor, direccion_proveedor, id, nit_proveedor, nombre_poveedor,
				telefono_proveedor);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProveedorDTO other = (ProveedorDTO) obj;
		return Objects.equals(ciudad_proveedor, other.ciudad_proveedor)
				&& Objects.equals(direccion_proveedor, other.direccion_proveedor) && Objects.equals(id, other.id)
				&& Objects.equals(nit_proveedor, other.nit_proveedor)
				&& Objects.equals(nombre_poveedor, other.nombre_poveedor)
				&& Objects.equals(telefono_proveedor, other.telefono_proveedor);
	}
	
	
	
	

}
