package tn.esprit.spring;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.model.Employe;
import tn.esprit.spring.model.Role;
import tn.esprit.spring.payload.EmployeePayload;
import tn.esprit.spring.service.EmployeService;

@SpringBootTest
public class EmployeeTest {

	@Autowired
	EmployeService employeService;
	
	@Test
	void testFindEmployee() {
		Employe employe= new Employe();
		EmployeePayload employePayload = new EmployeePayload();
		employePayload.setNom("Nouira");
		employePayload.setPrenom("Rania");
		employePayload.setEmail("rania.nouira@esprit.tn");
		employePayload.setRole(Role.INGENIEUR);
		employePayload.setActif(true);
		employe= employeService.addEmploye(employePayload);
		assertTrue(employeService.findEmployeById(employe.getId())!=null);
	}
	
}
