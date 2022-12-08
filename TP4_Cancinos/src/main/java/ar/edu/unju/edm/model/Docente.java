package ar.edu.unju.edm.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class Docente {
	@Min(value=100 , message="El Legajo debe ser mayor o igual a 100")
	private int legajo;
	@Size (min=3, max=30, message="El nombre debe tener entre 3 y 30 caracteres")
	@NotEmpty (message="El nombre del docente no puede estar vacio")
	private String nombre;
	@NotBlank (message="El apellido del docente no puede estar vacio")
	private String apellido;
	@NotEmpty @Email
	private String email;
	@NotEmpty (message="El teléfono no puede estar vacío")
	private long telefono;
	
	public Docente() {
		// TODO Auto-generated constructor stub
	}

	public Docente(int legajo, String nombre, String apellido, String email, long telefono) {
		super();
		this.legajo = legajo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
	}

	public int getLegajo() {
		return legajo;
	}

	public void setLegajo(int legajo) {
		this.legajo = legajo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Docente [legajo=" + legajo + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", telefono=" + telefono + "]";
	}
	
	
	
}
