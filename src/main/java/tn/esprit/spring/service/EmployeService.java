package tn.esprit.spring.service;


import java.util.List;

import tn.esprit.spring.model.Employe;
import tn.esprit.spring.payload.EmployeePayload;




public interface EmployeService {
	
	Employe addEmploye(EmployeePayload employePayload);
	Employe updateEmploye(Employe employe);
	void deleteEmploye(Integer id);
	Employe findEmployeById(Integer id);
	List<Employe> findAllEmploye();
	void affecterEmployeATeam(int employeId, int teamId);
	

}
