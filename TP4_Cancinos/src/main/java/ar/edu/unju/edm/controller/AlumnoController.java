package ar.edu.unju.edm.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.edm.model.Alumno;
import ar.edu.unju.edm.service.IAlumnoService;

@Controller
@RequestMapping("/alumno")
public class AlumnoController {
	
	@Autowired
	private IAlumnoService alumnoService;
	
	private static final Log LOGGER = LogFactory.getLog(AlumnoController.class);
	
//	Creamos un objeto de la clase listaAlumnos, donde esta el array, aunque no me queda muy en claro aun
	/*ListaAlumnos listaAlumnos = new ListaAlumnos();*/
	
	@GetMapping("/nuevo")
	public String getNuevoAlumnoPage(Model model) {
//		redirigimos a la pagina del formulario donde se van a setear las propiedades del alumno
		model.addAttribute("alumno", /*new Alumno()*/ alumnoService.getAlumno());
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
		
//		Recuperamos el array y agregamos el objeto alumno a la lista
		if(alumnoService.guardarAlumno(alumno)/*listaAlumnos.getListaAlumnos().add(alumno)*/) {
			LOGGER.info("Se agrego un objeto al arrayList de alumnos");
		}
		
//		enviamos el array de alumnos a la pagina lista_alumnos
		mav.addObject("listaAlumnos", alumnoService.getListaAlumno().getListaAlumnos());
		return mav;
	}
	
	
	
	@GetMapping("/lista_alumnos")
	public ModelAndView getListaAlumnosPage () {
		ModelAndView mav = new ModelAndView("lista_alumnos");
		mav.addObject("listaAlumnos", alumnoService.getListaAlumno().getListaAlumnos());
		LOGGER.info("Se mando la lista de alumnos a travez de la interfaz alumnoService a la pagina lista_alumnos");
		return mav;
	}
	
	
	@GetMapping("/editar/{dni}")
	public ModelAndView getEditarAlumnoPage(@PathVariable("dni")long dni ) {
//		una vez recuperado el dni enviamos el valor a la pagina editar_alumno
		ModelAndView mav = new ModelAndView("editar_alumno");
		Alumno alumno = alumnoService.buscarAlumno(dni);
		mav.addObject("alumno", alumno);
		return mav;
	}
	
	@PostMapping("/modificar")
	public ModelAndView getEditarDatosAlumnosPage (@Validated @ModelAttribute("alumno")Alumno alumno, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {  //Si el objeto bindingResult tiene algun error entonces
			LOGGER.info("Ocurrio un error al editar el alumno"+alumno);
			ModelAndView mav = new ModelAndView("nuevo_alumno"); //Creamos una vista en la pagina nuevo_alumno
			mav.addObject("alumno", alumno); //mandamos al mismo alumno que contenia los campos con errores al formulario para completarse de nuevo
			return mav;//retornamos la pagina del formulario con el mismo alumno que tenia errores en los campos
		}
		ModelAndView mav = new ModelAndView("redirect:/alumno/lista_alumnos");
		alumnoService.modificarAlumno(alumno);
		
//		pedimos la lista y pasamos todos los objetos a modificar
		return mav;
	}
	
	@GetMapping("/eliminar/{dni}")
	public ModelAndView getEliminarAlumnoPage(@PathVariable("dni")long dni) {
		LOGGER.info("Se obtiene el dni del alumno por uri. Se recorre la lista comparando el dni y una vez encontrado se lo remueve de la lista de alumnos. Redirigiendo a la pagina 'lista_alumnos'");
		ModelAndView mav = new ModelAndView("redirect:/alumno/lista_alumnos");
		alumnoService.eliminarAlumno(dni);
		return mav;
		
	}
}
