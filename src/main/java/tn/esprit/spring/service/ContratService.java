package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.model.Contrat;
import tn.esprit.spring.payload.ContratPayload;

public interface ContratService {
	Contrat addContrat(ContratPayload contratPayload);
	Contrat updateContrat(Contrat contrat);
	void deleteContrat(Long id);
	List<Contrat> findAllContrats();
	Contrat findContratById(Long id);
}
