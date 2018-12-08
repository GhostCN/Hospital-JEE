package org.sid.web;

import org.sid.models.Utilisateur;
import org.sid.service.Account;
import org.sid.service.RegisterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountRestController {
	@Autowired
	private Account account;
	@PostMapping("/register")
	public Utilisateur register(@RequestBody RegisterForm uform)
	{
		Utilisateur u=new Utilisateur();
		u.setDateNaiss(uform.getDatenaiss());
		u.setEmail(uform.getEmail());
		u.setEnabled(uform.getEnabled());
		u.setMatricule(uform.getMatricule());
		u.setNom(uform.getNom());
		u.setPassword("passer");
		u.setPrenom(uform.getPrenom());
		u.setTel(uform.getTel());
		//u.setPoste();
		
		return account.saveUser(u);
	}
}
