package tn.esprit.spring;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.model.Contrat;
import tn.esprit.spring.model.Employe;
import tn.esprit.spring.payload.ContratPayload;
import tn.esprit.spring.payload.EmployeePayload;
import tn.esprit.spring.service.ContratService;
import tn.esprit.spring.service.EmployeService;

@SpringBootTest
public class ContratTest {
	@Autowired
	ContratService contratService;
	@Autowired
	EmployeService employeService;

	@Test
	void testAddContrat() {
		Employe employe = new Employe();
		EmployeePayload employeePayload = new EmployeePayload();
		employe.setNom("Kriden");
		employe.setPrenom("MohamedHedi");
		employe.setEmail("mohamedhedi.kriden@esprit.tn");
		employe.setActif(true);
		employe = employeService.addEmploye(employeePayload);

		ContratPayload contratPayload = new ContratPayload();
		contratPayload.setReference(3L);
		contratPayload.setSalaire(2500L);
		contratPayload.setTypeContrat("CDI");
		contratPayload.setDateDebut(new Date());
		contratPayload.setIdEmploye(employe.getId());
		Contrat contrat = contratService.addContrat(contratPayload);
		assertTrue(contrat != null);

	}

}
