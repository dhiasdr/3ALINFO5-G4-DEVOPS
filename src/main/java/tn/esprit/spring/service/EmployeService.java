package tn.esprit.spring.service;


import java.util.List;

import tn.esprit.spring.model.Employe;




public interface EmployeService {
	
	Employe addEmploye(Employe employe);
	Employe updateEmploye(Employe employe);
	void deleteEmploye(Integer id);
	Employe findEmployeById(Integer id);
	List<Employe> findAllEmploye();
	

}
