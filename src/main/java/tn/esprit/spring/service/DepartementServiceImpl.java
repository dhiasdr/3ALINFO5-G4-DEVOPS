package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.model.Departement;
import tn.esprit.spring.model.Project;
import tn.esprit.spring.repository.DepartementRepository;
import tn.esprit.spring.repository.ProjectRepository;

@Service
public class DepartementServiceImpl implements DepartementService{
	
	@Autowired
	private DepartementRepository departementRepository;

	@Override
	public Departement addDepartement(Departement departement) {
		return departementRepository.save(departement);
	}

	@Override
	public Departement updateDepartement(Departement departement) {
		return departementRepository.save(departement);
	}

	@Override
	public void deleteDepartement(Long id) {
		departementRepository.deleteById(id);
	}

	@Override
	public List<Departement> findAllDepartement() {
		return (List<Departement>) departementRepository.findAll();
	}

	@Override
	public Departement findDepartementById(Long id) {
		return departementRepository.findById(id).get();
	}

}
