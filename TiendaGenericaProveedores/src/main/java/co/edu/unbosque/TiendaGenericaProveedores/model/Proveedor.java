package co.edu.unbosque.TiendaGenericaProveedores.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "proveedor")
public class Proveedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Long id;

	@Column(nullable = false, length = 20)
	private String ciudad_proveedor;

	@Column(nullable = false, length = 20)
	private String direccion_proveedor;

	@Column(unique = true, nullable = false)
	private String nit_proveedor;

	@Column(nullable = false, length = 80)
	private String nombre_proveedor;

	@Column(nullable = false, length = 20)
	private String telefono_proveedor;

	public Proveedor() {
		// TODO Auto-generated constructor stub
	}

	public Proveedor(Long id, String ciudad_proveedor, String direccion_proveedor, String nit_proveedor,
			String nombre_proveedor, String telefono_proveedor) {
		super();
		this.id = id;
		this.ciudad_proveedor = ciudad_proveedor;
		this.direccion_proveedor = direccion_proveedor;
		this.nit_proveedor = nit_proveedor;
		this.nombre_proveedor = nombre_proveedor;
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

	public String getNit_proveedor() {
		return nit_proveedor;
	}

	public void setNit_proveedor(String nit_proveedor) {
		this.nit_proveedor = nit_proveedor;
	}

	public String getNombre_proveedor() {
		return nombre_proveedor;
	}

	public void setNombre_proveedor(String nombre_proveedor) {
		this.nombre_proveedor = nombre_proveedor;
	}

	public String getTelefono_proveedor() {
		return telefono_proveedor;
	}

	public void setTelefono_proveedor(String telefono_proveedor) {
		this.telefono_proveedor = telefono_proveedor;
	}

}
