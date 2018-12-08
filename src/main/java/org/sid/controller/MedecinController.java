/*package org.sid.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Controller
@RestController
@RequestMapping(value="/medecin")
public class MedecinController {
	
	@GetMapping("/add")
	public String addMedecin() {
		return "addMedecin";
		
	}
	@Secured("ADMIN")
	@GetMapping("/index")
	public String index() {
		return "menuMedecin";
		
	}
	


}
*/