package ar.edu.unju.edm.model;

import java.time.LocalDate;

public class Curso {
	private int codigo;
	private String titulo;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private int cantidadHoras;
	private String modalidad;
	private Docente docente;
	
	public Curso() {
		// TODO Auto-generated constructor stub
	}

	public Curso(int codigo, String titulo, LocalDate fechaInicio, LocalDate fechaFin, int cantidadHoras,
			String modalidad, Docente docente) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.cantidadHoras = cantidadHoras;
		this.modalidad = modalidad;
		this.docente = docente;
	}
	

	public Curso(int codigo, String titulo, String modalidad) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.modalidad = modalidad;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public int getCantidadHoras() {
		return cantidadHoras;
	}

	public void setCantidadHoras(int cantidadHoras) {
		this.cantidadHoras = cantidadHoras;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public Docente getDocente() {
		return docente;
	}

	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	@Override
	public String toString() {
		return "Curso [codigo=" + codigo + ", titulo=" + titulo + ", fechaInicio=" + fechaInicio + ", fechaFin="
				+ fechaFin + ", cantidadHoras=" + cantidadHoras + ", modalidad=" + modalidad + ", docente=" + docente
				+ "]";
	}
	
}
