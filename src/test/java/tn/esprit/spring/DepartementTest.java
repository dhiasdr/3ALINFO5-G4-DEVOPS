package tn.esprit.spring;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.model.Departement;
import tn.esprit.spring.model.Employe;
import tn.esprit.spring.model.Entreprise;
import tn.esprit.spring.model.Role;
import tn.esprit.spring.payload.DepartementPayload;
import tn.esprit.spring.payload.EmployeePayload;
import tn.esprit.spring.service.DepartementService;
import tn.esprit.spring.service.EmployeService;
import tn.esprit.spring.service.EntrepriseService;

@SpringBootTest
public class DepartementTest {
	@Autowired
	DepartementService departementService;
	@Autowired
	EntrepriseService entrepriseService;

	@Test
	void testDeleteDepartement() {
		Entreprise entreprise = new Entreprise();
		entreprise.setName("entreprise");
		entreprise.setRaisonSocial("raisonsocial");
		entreprise = entrepriseService.addEntreprise(entreprise);
		Departement departement = new Departement();
		DepartementPayload departementPayload = new DepartementPayload();
		departementPayload.setName("dep_1");
		departementPayload.setIdEntreprise(entreprise.getId());
		departement = departementService.addDepartement(departementPayload);
		Long id = departement.getId();
		departementService.deleteDepartement(id);

		assertTrue(departementService.findDepartementById(id) == null);

	}
}
