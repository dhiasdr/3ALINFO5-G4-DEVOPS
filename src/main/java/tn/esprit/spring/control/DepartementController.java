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

import tn.esprit.spring.model.Departement;
import tn.esprit.spring.payload.DepartementPayload;
import tn.esprit.spring.service.DepartementService;

@Controller
public class DepartementController {
	@Autowired
	private DepartementService departementService;
	
	@PostMapping(value = "/addDepartement")
	public ResponseEntity addDepartement(@RequestBody DepartementPayload departementPayload) {
		Departement departementPostSave = null;
		try {
			departementPostSave = departementService.addDepartement(departementPayload);
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(departementPostSave);
	}

	@PutMapping(value = "/updateDepartement")
	public ResponseEntity updateDepartement(@RequestBody Departement departement) {
		Departement departementPostUpdate = null;
		try {
			departementPostUpdate = departementService.updateDepartement(departement);
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(departementPostUpdate);
	}

	@DeleteMapping(value = "/deleteDepartement/{id}")
	public ResponseEntity deleteDepartement(@PathVariable Long id) {
		try {
			departementService.deleteDepartement(id);
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body("Departement deleted");
	}

	@GetMapping(value = "/findAllDepartements")
	public ResponseEntity findAllDepartements() {
		List<Departement> departements = new ArrayList<>();
		try {
			departements = departementService.findAllDepartement();
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(departements);
	}

	@GetMapping(value = "/findDepartements/{id}")
	public ResponseEntity findDepartements(@PathVariable Long id) {
		Departement departement = null;
		try {
			departement = departementService.findDepartementById(id);
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(departement);
	}

}
