package ar.edu.unju.edm.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.edm.model.Alumno;
import ar.edu.unju.edm.util.ListaAlumnos;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {
	
	private static final Log LOGGER = LogFactory.getLog(AlumnoController.class);
	
	@GetMapping("/nuevo")
	public String getNuevoAlumnoPage(Model model) {
//		redirigimos a la pagina del formulario donde se van a setear las propiedades del alumno
		model.addAttribute("alumno", new Alumno());
		LOGGER.info("Se creo el objeto alumno y se mando como parametro para el formulario de la pagina a la que re dirige -> '/alumno/nuevo'");
		return "nuevo_alumno";
	}
	
	@PostMapping("/guardado")
	public ModelAndView getAlumnoGuardadoPage(@Validated @ModelAttribute("alumno")Alumno alumno, BindingResult bindingResult) {
//		Capturamos el alumno que viene en la uri, creamos una vista ModelAndView que tenga la pagina donde mostraremos la lista de alumnos
//		@Validated sirve para las anotaciones de la clase
//		@BindingResult contiene el resultado de la validación (los errores)
		if(bindingResult.hasErrors()) {  //Si el objeto bindingResult tiene algun error entonces
			ModelAndView mav = new ModelAndView("nuevo_alumno"); //Creamos una vista en la pagina nuevo_alumno
			mav.addObject("alumno", alumno); //mandamos al mismo alumno que contenia los campos con errores al formulario para completarse de nuevo
			return mav;//retornamos la pagina del formulario con el mismo alumno que tenia errores en los campos
		}
		
//		Creamos una vista que contenga la pagina alumno_guardado, mismo tramite que docente digamo
		ModelAndView mav = new ModelAndView("lista_alumnos");
		
//		Creamos un objeto de la clase listaAlumnos, donde esta el array, aunque no me queda muy en claro aun
		ListaAlumnos listaAlumnos = new ListaAlumnos();
		
//		Recuperamos el array y agregamos el objeto alumno a la lista
		if(listaAlumnos.getListaAlumnos().add(alumno)) {
			LOGGER.info("Se agrego un objeto al arrayList de alumnos");
		}
		
//		enviamos el array de alumnos a la pagina lista_alumnos
		mav.addObject("listaAlumnos", listaAlumnos.getListaAlumnos());
		return mav;
	}
	
//	@GetMapping("/alumno/lista_alumnos")
//	public ModelAndView getListaAlumnosPage () {
//		ModelAndView mav = new ModelAndView("lista_alumnos");
//		mav.addObject("listaAlumnos", listaAlumnos)
//	}
}
