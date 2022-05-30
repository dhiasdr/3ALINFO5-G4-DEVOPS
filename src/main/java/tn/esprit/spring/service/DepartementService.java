package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.model.Departement;
import tn.esprit.spring.model.Project;
import tn.esprit.spring.payload.DepartementPayload;
import tn.esprit.spring.payload.ProjectPayload;

public interface DepartementService {
	//Departement addDepartement(Departement departement);
	Departement addDepartement(DepartementPayload departementPayload);
	Departement updateDepartement(Departement departement);
	void deleteDepartement(Long id);
	List<Departement> findAllDepartement();
	Departement findDepartementById(Long id);

}
