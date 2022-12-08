package ar.edu.unju.edm.service;

import ar.edu.unju.edm.model.Alumno;
import ar.edu.unju.edm.util.ListaAlumnos;

public interface IAlumnoService {
//	UNA INTERFAZ DEFINE 'QUE' SE HARA
//	TODO ESTO SON DECLARACIONES DE LO QUE SIOSI SE TIENE QUE HACER
	
//	no tiene cuerpo, no es necesario ya que eso se tiene que sobreescribir en la clase implementadora
	
//	Metodo que solicita un alumno, por el tipo de metodo, nos damos cuenta que tiene que devolver un objeto de tipo alumno
	public Alumno getAlumno();
	
//	Metodo para saber si fue guardado el alumno
	public boolean guardarAlumno(Alumno alumno);
	
	public void modificarAlumno(Alumno alumno);
	
	public void eliminarAlumno(long dni);
	
	public ListaAlumnos getListaAlumno();
	
	public Alumno buscarAlumno (long dni);

}
