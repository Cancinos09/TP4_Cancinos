package ar.edu.unju.edm.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.edm.model.Alumno;
import ar.edu.unju.edm.service.IAlumnoService;
import ar.edu.unju.edm.util.ListaAlumnos;

@Service
// importante la definicion de que la clase implementa la interfaz
public class AlumnoServiceImp implements IAlumnoService {

//	Aca vamos a definir el 'COMO' se van a implementar cada uno de los metodos de la interfaz
	
	
	@Autowired
//	Inyecta la dependencia maracda como un bean (@component) de un objeto que ya está en memoria
//	Esto significa que no tendremos que instanciar (crear) un objeto de la clase 
	private ListaAlumnos listaAlumnos;
	
	
	@Override
	public Alumno getAlumno() {
		return new Alumno();
	}  

	@Override
	public boolean guardarAlumno(Alumno alumno) {
//		Para guardar un alumno necesitamos colocarlo en la lista de alumnos
//		y para evitar tener que generar un lista, utilizamos @autowired
		
//		guardamos en la variable respuesta el resultado del metodo que devuelve un booleano
//		solicitamos la lista de alumnos, y le agregamos el objeto alumno
//		boolean respuesta = listaAlumnos.getListaAlumnos().add(alumno);
		
//		si se pudo guardar en la lista la respuesta sera true
//		en su defecto la respuesta sera false
		return listaAlumnos.getListaAlumnos().add(alumno);
	}

	@Override
	public void modificarAlumno(Alumno alumno) {
//		implementando el metodo par buscar y reemplazar los datos del alumno
		for(Alumno a :listaAlumnos.getListaAlumnos()) {
			if(a.getDni() == alumno.getDni()) {
				a.setApellido(alumno.getApellido());
				a.setNombre(alumno.getNombre());
				a.setEmail(alumno.getEmail());
				a.setTelefono(alumno.getTelefono());
			}
		}
	}

	@Override
	public void eliminarAlumno(long dni) {
		for(Alumno a:listaAlumnos.getListaAlumnos()) {
			if(a.getDni() == dni) {
				listaAlumnos.getListaAlumnos().remove(a);
			}
		}

	}

	@Override
	public ListaAlumnos getListaAlumno() {
//		retorna el objeto que accede a la lista de alumnos
		return listaAlumnos;
	}

	@Override
	public Alumno buscarAlumno(long dni) {
//	Creamos un Optional de tipo Alumno, buscar por dni al objeto de tipo alumno que coincida con el valor del parametro
		Optional<Alumno> alumno = listaAlumnos.getListaAlumnos().stream().filter(a -> a.getDni() == dni).findFirst();
//		retorna el objeto alumno que coincidio con el dni
		return alumno.get();
	}

}
