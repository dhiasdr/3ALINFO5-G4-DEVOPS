package tn.esprit.spring;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.model.Departement;
import tn.esprit.spring.model.Entreprise;
import tn.esprit.spring.payload.DepartementPayload;
import tn.esprit.spring.service.DepartementService;
import tn.esprit.spring.service.EntrepriseService;

@SpringBootTest
public class DepartementTest {
	@Autowired
	DepartementService departementService;
	@Autowired
	EntrepriseService entrepriseService;

	@Test
	void testUpdateDepartement() {
		Entreprise entreprise = new Entreprise();
		entreprise.setName("entreprise");
		entreprise.setRaisonSocial("raisonsocial");
		entreprise = entrepriseService.addEntreprise(entreprise);
		Departement departement = new Departement();
		DepartementPayload departementPayload = new DepartementPayload();
		departementPayload.setName("dep_1");
		departementPayload.setIdEntreprise(entreprise.getId());
		departement = departementService.addDepartement(departementPayload);
		String oldName = departement.getName();
		Long id = departement.getId();
		Departement newDepartement = new Departement();
		newDepartement.setId(id);
		newDepartement.setName("dep_2");
		departementService.updateDepartement(newDepartement);
		Departement updatedDepartement = departementService.findDepartementById(id);
		assertTrue(updatedDepartement != null && updatedDepartement.getName() != oldName );

	}

}