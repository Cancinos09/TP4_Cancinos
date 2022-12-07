package ar.edu.unju.edm.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.edu.unju.edm.model.Curso;
import ar.edu.unju.edm.model.Docente;

@Controller
public class Curso_idiomaController {
	
//	Simulando un repositorio
	public List<Curso> getCursos(){
		List<Curso> listaCursos = new ArrayList<>();
		listaCursos.add(new Curso(145, "aleman", "presencial"));
		listaCursos.add(new Curso(122, "frances", "virtual"));
		listaCursos.add(new Curso(112, "español", "virtual"));
		
		return listaCursos;
	}
	public List<Docente> getDocentes(){
		List<Docente> listaDocentes = new ArrayList<>();
		listaDocentes.add(new Docente(111, "Alejandro", "Vega", "alejandro@unju.com", 3884123));
		listaDocentes.add(new Docente(222, "Gustavo", "Sosa", "gustso@gmail.com", 3885678));
		
		return listaDocentes;
	}

	@GetMapping("/curso_idiomas")
	public String getCursoIdiomas(Model model) {
		model.addAttribute("curso", this.getCursos());
		model.addAttribute("docente", this.getDocentes());
		return "curso_idiomas";
	}
}
