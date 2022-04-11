package tn.esprit.spring.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import tn.esprit.spring.model.Entreprise;
import tn.esprit.spring.service.EntrepriseService;
@Controller
public class EntrepriseController {
	

	@Autowired	
	private EntrepriseService entrepriseService;
	
	@PostMapping(value = "/addEntreprise")
	public ResponseEntity addEntreprise(@RequestBody Entreprise entreprise) {
		Entreprise entreprisePostSave = null;
		try {
			entreprisePostSave = entrepriseService.addEntreprise(entreprise);
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(entreprisePostSave);
	}

	@PutMapping(value = "/updateEntreprise")
	public ResponseEntity updateEntreprise(@RequestBody Entreprise entreprise) {
		Entreprise entreprisePostUpdate = null;
		try {
			entreprisePostUpdate = entrepriseService.updateEntreprise(entreprise);
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(entreprisePostUpdate);
	}

	@DeleteMapping(value = "/deleteEntreprise/{id}")
	public ResponseEntity deleteEntreprise(@PathVariable Long id) {
		try {
			entrepriseService.deleteEntreprise(id);
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body("Entreprise deleted");
	}

	@GetMapping(value = "/findAllEntreprises")
	public ResponseEntity findAllEntreprise() {
		List<Entreprise> entreprises = new ArrayList<>();
		try {
			entreprises= entrepriseService.findAllEntreprise();
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(entreprises);
	}

	@GetMapping(value = "/findEntreprise/{id}")
	public ResponseEntity findEntreprise(@PathVariable Long id) {
		Entreprise entreprise = null;
		try {
			entreprise = entrepriseService.findEntrepriseById(id);
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(entreprise);
	}

}
