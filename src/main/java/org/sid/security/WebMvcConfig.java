package org.sid.security;


import java.util.List;
import javax.validation.Valid;
import org.sid.models.Poste;
import org.sid.models.Role;
import org.sid.models.Service;
import org.sid.models.Utilisateur;
import org.sid.service.Account;
import org.sid.service.RegisterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Controller
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	@Autowired
	private Account account;
	public void addViewControllers(ViewControllerRegistry registry) {

		registry.addViewController("/").setViewName("login");
		registry.addViewController("/medecin").setViewName("menuMedecin");
		registry.addViewController("/admin").setViewName("menuAdmin");
		registry.addViewController("/secretaire/index").setViewName("menuSecretaire");
		registry.addViewController("/addService").setViewName("ajoutservice");
		registry.addViewController("/addPoste").setViewName("ajoutPoste");
		registry.addViewController("/addRole").setViewName("ajoutRole");
		registry.addViewController("/login").setViewName("login");
	}
	
	@GetMapping("/addUser")
	public String registerForm(Model model) {

		model.addAttribute("RegisterForm",new RegisterForm());
		List<Poste>lpostes=account.getAllPost();
		List<Service>lservices=account.getAllService();
		List<Role>lroles=account.getAllRole();
		model.addAttribute("postes", lpostes);
		model.addAttribute("services", lservices);
		model.addAttribute("roles", lroles);

		return "ajoutUser";
		
	}
	@PostMapping("/addUser")
	public String checkForm(@Valid RegisterForm uform,BindingResult bindingresult)
	{
		if(bindingresult.hasErrors())
		{
			return "ajoutUser";
		}
		Utilisateur u=new Utilisateur();
		u.setDateNaiss(uform.getDatenaiss());
		u.setEmail(uform.getEmail());
		u.setEnabled(uform.getEnabled());
		u.setMatricule(uform.getMatricule());
		u.setNom(uform.getNom());
		//u.setPassword("passer");
		u.setPrenom(uform.getPrenom());
		u.setTel(uform.getTel());
	//	u.setPoste();
		 account.saveUser(u);
		return "redirect:/meunuMedecin";
		
	}
	
	@GetMapping("/medecin")
	public String medecinForm(Model model) {

		model.addAttribute("RegisterForm",new RegisterForm());
		List<Poste>lpostes=account.getAllPost();
		List<Service>lservices=account.getAllService();
		List<Role>lroles=account.getAllRole();
		model.addAttribute("postes", lpostes);
		model.addAttribute("services", lservices);
		model.addAttribute("roles", lroles);

		return "ajoutUser";
		
	}
	@PostMapping("/medecin")
	public String medecinChech(@Valid RegisterForm register,BindingResult bindingresult)
	{
		if(bindingresult.hasErrors())
		{
			return "ajoutUser";
		}
		return "redirect:/meunuMedecin";
		
	}
	
	
}