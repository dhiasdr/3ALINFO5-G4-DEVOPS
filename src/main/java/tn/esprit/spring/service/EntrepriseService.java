package tn.esprit.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.esprit.spring.model.Entreprise;

public interface EntrepriseService {
	
	Entreprise addEntreprise(Entreprise entreprise);
	Entreprise updateEntreprise(Entreprise entreprise);
	void deleteEntreprise(Long id);
	List<Entreprise> findAllEntreprise();
	Entreprise findEntrepriseById(Long id);

}
