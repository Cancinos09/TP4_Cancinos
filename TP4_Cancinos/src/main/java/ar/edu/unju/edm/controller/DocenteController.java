package ar.edu.unju.edm.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.edm.model.Docente;

@Controller
@RequestMapping("/docente")
public class DocenteController {
	
	List<Docente> listaDocentes=new ArrayList<>();
	
	Logger logger = LoggerFactory.getLogger(DocenteController.class);
	@GetMapping("/nuevo")
	public String getNuevoDocentePage(Model model) {
		model.addAttribute("docente", new Docente());
		logger.info("Se creo el Objeto docente y se mando adjunto con la pagina 'nuevo_Docente'");
		return "nuevo_Docente";
	}
//	siempre que se mande un formulario es PostMapping
//	En estos controladores van las siguientes anotaciones
	@PostMapping("/guardado")
	public String getDocenteGuardadoPage(@Validated @ModelAttribute("docente")Docente docente, BindingResult bindingResult) {
//		@Validates viene del framework Validation
//		bindingResult contiene el resultado de la validación
//		Contiene los errores que pueden haber ocurrido
		
		listaDocentes.add(docente);
		logger.info("Se capturo el objeto Docente con sus parametros y se guardo en un array, aunque creo que no lo hice tan bien xdd");
		return "docente_guardado";
	}
	
	@GetMapping("/lista_docentes")
	public ModelAndView getListaDocentesPage() {
		ModelAndView mav = new ModelAndView("lista_docentes");
		mav.addObject("listaDocentes",listaDocentes);
		logger.info("Se envio la lista de docentes en un metodo de tipo ModelAndView que tiene como parametro la pagina 'lista_docentes'");
		return mav;
	}

//	@GetMapping("/lista_docentes")
//	public String getListaDocentesPage() {
//		
//		return "lista_docentes";
//	}
}
