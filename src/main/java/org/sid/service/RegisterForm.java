package org.sid.service;

import java.util.Date;

import lombok.Data;


public class RegisterForm {
	private String matricule,nom,prenom,tel,email;
	private Date datenaiss;
	private Boolean enabled;
	private int poste,service;
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getDatenaiss() {
		return datenaiss;
	}
	public void setDatenaiss(Date datenaiss) {
		this.datenaiss = datenaiss;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	public int getPoste() {
		return poste;
	}
	public void setPoste(int poste) {
		this.poste = poste;
	}
	public int getService() {
		return service;
	}
	public void setService(int service) {
		this.service = service;
	}

}
