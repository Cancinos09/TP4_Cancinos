package ar.edu.unju.edm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class indexController {
	
	@GetMapping("/home")
	public String getIndexPage() {
		return"index";
	}
	
	@GetMapping("/agenda")
	public String getAgendaPage() {
		return "agenda";
	}
	
	@GetMapping("/beneficios")
	public String getBeneficiosPage() {
		return "beneficios";
	}
	
	@GetMapping("/contacto")
	public String getContactoPage() {
		return "contacto";
	}
	
}
