package org.sid.service;

import java.util.List;

import org.sid.models.Poste;
import org.sid.models.Role;
import org.sid.models.Service;
import org.sid.models.Utilisateur;

public interface Account {
	public Utilisateur saveUser(Utilisateur user);
	public Role saveRole(Role role);
	public void addRoleToUser(String matricule,String libelle);
	public Utilisateur findByMatricule(String matricule);
	public List<Poste>getAllPost();
	public List<Service>getAllService();
	public List<Role>getAllRole();
}
