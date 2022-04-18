package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import tn.esprit.spring.model.Contrat;
import tn.esprit.spring.model.Departement;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.DepartementRepository;

@Service
public class ContratServiceImpl implements ContratService {
	@Autowired
	private ContratRepository contratRepository;

	@Override
	public Contrat addContrat(Contrat contrat) {
		return contratRepository.save(contrat);
	}

	@Override
	public Contrat updateContrat(Contrat contrat) {
		return contratRepository.save(contrat);
	}

	@Override
	public void deleteContrat(Long id) {
		contratRepository.deleteById(id);
	}

	@Override
	public List<Contrat> findAllContrats() {
		return (List<Contrat>) contratRepository.findAll();
	}

	@Override
	public Contrat findContratById(Long id) {
		return contratRepository.findById(id).get();
	}

}
