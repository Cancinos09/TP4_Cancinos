package ar.edu.unju.edm.util;

import java.util.ArrayList;

import ar.edu.unju.edm.model.Alumno;

public class ListaAlumnos {
	private ArrayList<Alumno> listaAlumnos;
	
	public ListaAlumnos() {
//		creamos el arrayList
		listaAlumnos = new ArrayList<Alumno>();
//		podemos precargar el arrayList de alumnos
		listaAlumnos.add(new Alumno(43939792, "Cancinos Mendoza", "Mario Juan Carlos", "mariocancinos16@gmail.com", "3884171025"));
		listaAlumnos.add(new Alumno(42730256, "Peña", "Lara", "laraperev@gmail.com", "3885888706"));
	}
//	Constructor parametrizado
	public ListaAlumnos(ArrayList<Alumno> listaAlumnos) {
		super();
		this.listaAlumnos = listaAlumnos;
	}

//	Metodos accesores
	public ArrayList<Alumno> getListaAlumnos() {
		return listaAlumnos;
	}

	public void setListaAlumnos(ArrayList<Alumno> listaAlumnos) {
		this.listaAlumnos = listaAlumnos;
	}
	
	
}
