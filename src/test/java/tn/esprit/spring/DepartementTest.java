package tn.esprit.spring;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.model.Departement;
import tn.esprit.spring.payload.DepartementPayload;
import tn.esprit.spring.service.DepartementService;

@SpringBootTest
public class DepartementTest {
	@Autowired
	DepartementService departementService;
	@Test
	void testDeleteDepartement() {
		Departement departement = new Departement();
        DepartementPayload departementPayload=new DepartementPayload();
        departementPayload.setName("dep_1");
        departementPayload.setIdEntreprise(1l);
        departement= departementService.addDepartement(departementPayload);
        Long id = departement.getId();
        departementService.deleteDepartement(id);
        
		assertTrue(departementService.findDepartementById(id)==null);

	}

}
