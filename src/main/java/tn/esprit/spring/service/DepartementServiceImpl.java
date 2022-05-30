package tn.esprit.spring.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.model.Departement;
import tn.esprit.spring.model.Project;
import tn.esprit.spring.payload.DepartementPayload;
import tn.esprit.spring.payload.ProjectPayload;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.ProjectRepository;

@Service
public class DepartementServiceImpl implements DepartementService {
	private static final Logger logger = LogManager.getLogger(DepartementServiceImpl.class);
	@Autowired
	private DepartementRepository departementRepository;
	@Autowired
	private EntrepriseService entrepriseService;

	@Override
	public Departement addDepartement(DepartementPayload departementPayload) {
		Departement departement = new Departement();
		logger.info("start mapping process");
		departement.setName(departementPayload.getName());
		departement.setEntreprise(entrepriseService.findEntrepriseById(departementPayload.getIdEntreprise()));
		logger.info("end mapping process");
		logger.info("save departement");
		return departementRepository.save(departement);
	}

	@Override
	public Departement updateDepartement(Departement departement) {
		logger.info("start update process");
		return departementRepository.save(departement);
	}

	@Override
	public void deleteDepartement(Long id) {
		logger.info("start delete process");
		departementRepository.deleteById(id);
	}

	@Override
	public List<Departement> findAllDepartement() {
		logger.info("find all departments");
		return (List<Departement>) departementRepository.findAll();
	}

	@Override
	public Departement findDepartementById(Long id) {
		logger.info("find department with id: " + id);
		return departementRepository.findById(id).orElse(null);
	}

}
