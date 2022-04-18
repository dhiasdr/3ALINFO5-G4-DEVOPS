package tn.esprit.spring.control;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import tn.esprit.spring.model.Contrat;
import tn.esprit.spring.model.Project;
import tn.esprit.spring.service.ContratService;
import tn.esprit.spring.service.ProjectService;
@Controller
public class ContratController {
	@Autowired
	private ContratService contratService;

	@PostMapping(value = "/addContrat")
	public ResponseEntity addContrat(@RequestBody Contrat contrat) {
		Contrat contratPostSave = null;
		try {
			contratPostSave = contratService.addContrat(contrat);
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(contratPostSave);
	}

	@PutMapping(value = "/updateContrat")
	public ResponseEntity updateContrat(@RequestBody Contrat contrat) {
		Contrat contratPostSave = null;
		try {
			contratPostSave = contratService.updateContrat(contrat);
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(contratPostSave);
	}

	@DeleteMapping(value = "/deleteContrat/{id}")
	public ResponseEntity deleteContrat(@PathVariable Long id) {
		try {
			contratService.deleteContrat(id);
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body("Contrat deleted");
	}

	@GetMapping(value = "/findAllContrats")
	public ResponseEntity findAllContrats() {
		List<Contrat> contrats = new ArrayList<>();
		try {
			contrats = contratService.findAllContrats();
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(contrats);
	}

	@GetMapping(value = "/findContrat/{id}")
	public ResponseEntity findContrat(@PathVariable Long id) {
		Contrat contrat = null;
		try {
			contrat = contratService.findContratById(id);
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(contrat);
	}
}
