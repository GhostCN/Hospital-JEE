package org.sid.dao;

import org.sid.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Utilisateur, Long>{
public Utilisateur findByMatricule(String matricule);
}
