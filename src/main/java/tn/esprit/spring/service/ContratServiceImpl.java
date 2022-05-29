package tn.esprit.spring.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import tn.esprit.spring.model.Contrat;
import tn.esprit.spring.model.Departement;
import tn.esprit.spring.payload.ContratPayload;
import tn.esprit.spring.repository.ContratRepository;
import tn.esprit.spring.repository.DepartementRepository;

@Service
public class ContratServiceImpl implements ContratService {
	private static final Logger logger = LogManager.getLogger(ContratServiceImpl.class);
	@Autowired
	private ContratRepository contratRepository;
	@Autowired
	private EmployeService employeService;

	@Override
	public Contrat addContrat(ContratPayload contratPayload) {
		
			Contrat contrat= new Contrat();
			logger.info("start mapping process");
			contrat.setReference(contratPayload.getReference());
			contrat.setSalaire(contratPayload.getSalaire());
			contrat.setTypeContrat(contratPayload.getTypeContrat());
			contrat.setDateDebut(contratPayload.getDateDebut());
			logger.info("end mapping process");
			logger.info("save contrat");
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
