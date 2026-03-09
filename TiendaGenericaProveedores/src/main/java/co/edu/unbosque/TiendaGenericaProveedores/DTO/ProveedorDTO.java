package co.edu.unbosque.TiendaGenericaProveedores.DTO;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProveedorDTO {

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Long id;
	private String ciudadProveedor;
	private String direccionProveedor;
	private Integer nitProveedor;
	private String nombreProveedor;
	private String telefonoProveedor;

	public ProveedorDTO() {
	}

	public ProveedorDTO(String ciudadProveedor, String direccionProveedor, Integer nitProveedor,
			String nombreProveedor, String telefonoProveedor) {
		super();
		this.ciudadProveedor = ciudadProveedor;
		this.direccionProveedor = direccionProveedor;
		this.nitProveedor = nitProveedor;
		this.nombreProveedor = nombreProveedor;
		this.telefonoProveedor = telefonoProveedor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCiudadProveedor() {
		return ciudadProveedor;
	}

	public void setCiudadProveedor(String ciudadProveedor) {
		this.ciudadProveedor = ciudadProveedor;
	}

	public String getDireccionProveedor() {
		return direccionProveedor;
	}

	public void setDireccionProveedor(String direccionProveedor) {
		this.direccionProveedor = direccionProveedor;
	}

	public Integer getNitProveedor() {
		return nitProveedor;
	}

	public void setNitProveedor(Integer nitProveedor) {
		this.nitProveedor = nitProveedor;
	}

	public String getNombreProveedor() {
		return nombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}

	public String getTelefonoProveedor() {
		return telefonoProveedor;
	}

	public void setTelefonoProveedor(String telefonoProveedor) {
		this.telefonoProveedor = telefonoProveedor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ciudadProveedor, direccionProveedor, id, nitProveedor, nombreProveedor, telefonoProveedor);
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
		return Objects.equals(ciudadProveedor, other.ciudadProveedor)
				&& Objects.equals(direccionProveedor, other.direccionProveedor)
				&& Objects.equals(id, other.id)
				&& Objects.equals(nitProveedor, other.nitProveedor)
				&& Objects.equals(nombreProveedor, other.nombreProveedor)
				&& Objects.equals(telefonoProveedor, other.telefonoProveedor);
	}
}