package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.model.Contrat;

public interface ContratService {
	Contrat addContrat(Contrat contrat);
	Contrat updateContrat(Contrat contrat);
	void deleteContrat(Long id);
	List<Contrat> findAllContrats();
	Contrat findContratById(Long id);
}
