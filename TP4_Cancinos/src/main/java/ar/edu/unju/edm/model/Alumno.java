package ar.edu.unju.edm.model;

import org.springframework.stereotype.Component;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
// Marcar la clase para que spring la tenga en memoria como un BEAN para no tener que construir objetos
@Component
public class Alumno {
	
	@Min (value=1000000, message="El dni debe ser mayor a 1.000.000")
	private int dni;
	@Size(min=3, max=30, message="El nombre debe tener entre 3 y 30 caracteres")
	@NotEmpty (message="El campo nombre no puede estar vacio")
	private String nombre;
	@Size(min=3, max=30, message="El apellido debe tener entre 3 y 30 caracteres")
	@NotEmpty (message="El campo apellido no puede estar vacio")
	private String apellido;
	@NotBlank @Email
	private String  email;
	@NotBlank
	private String telefono;
	
	public Alumno() {
		// TODO Auto-generated constructor stub
	}


	public Alumno(int dni, String nombre, String apellido, String email, String telefono) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.telefono = telefono;
	}



	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
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

	
	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	@Override
	public String toString() {
		return "Alumno [dni=" + dni + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email
				+ ", telefono=" + telefono + "]";
	}
	
	
}
