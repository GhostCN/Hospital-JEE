package org.sid.service;

import java.util.List;

import org.sid.dao.PosteRepository;
import org.sid.dao.RoleRepository;
import org.sid.dao.ServiceRepository;
import org.sid.dao.UserRepository;
import org.sid.models.Poste;
import org.sid.models.Role;
import org.sid.models.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@Transactional
public class AccountImpl implements Account{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private PosteRepository posteRepository;
	@Autowired
	private ServiceRepository serviceRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Override
	public Utilisateur saveUser(Utilisateur user) {
		String mpass=bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(mpass);
		return userRepository.save(user);
	}

	@Override
	public Role saveRole(Role role) {
		// TODO Auto-generated method stub
		return roleRepository.save(role);
	}

	@Override
	public void addRoleToUser(String matricule, String libelle) {
		Utilisateur user=userRepository.findByMatricule(matricule);
		Role role=roleRepository.findByLibelle(libelle);
		user.getRoles().add(role);
		
	}

	@Override
	public Utilisateur findByMatricule(String matricule) {
		
		return userRepository.findByMatricule(matricule);
	}

	@Override
	public List<Poste> getAllPost() {
		
		return posteRepository.findAll();
	}

	@Override
	public List<org.sid.models.Service> getAllService() {
		// TODO Auto-generated method stub
		return serviceRepository.findAll();
	}

	@Override
	public List<Role> getAllRole() {
		// TODO Auto-generated method stub
		return roleRepository.findAll();
	}

}
