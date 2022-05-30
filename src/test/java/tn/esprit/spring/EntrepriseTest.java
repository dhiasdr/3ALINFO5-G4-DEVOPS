package tn.esprit.spring;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.model.Entreprise;

import tn.esprit.spring.service.EntrepriseService;
@SpringBootTest
public class EntrepriseTest {
	@Autowired 
	EntrepriseService entrepriseService;
	@Test
	void testFindEntreprise() {
        Entreprise entreprise=new Entreprise();
        entreprise.setName("entreprise");
        entreprise.setRaisonSocial("raisonsocial");
        entreprise= entrepriseService.addEntreprise(entreprise);

		assertTrue(entrepriseService.findEntrepriseById(entreprise.getId())!=null);

	}


}
