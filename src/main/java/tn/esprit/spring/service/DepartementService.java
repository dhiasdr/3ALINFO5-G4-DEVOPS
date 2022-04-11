package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.model.Departement;

public interface DepartementService {
	Departement addDepartement(Departement departement);
	Departement updateDepartement(Departement departement);
	void deleteDepartement(Long id);
	List<Departement> findAllDepartement();
	Departement findDepartementById(Long id);

}
