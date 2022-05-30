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

import tn.esprit.spring.model.Employe;
import tn.esprit.spring.payload.EmployeePayload;
import tn.esprit.spring.service.EmployeService;


@Controller
public class EmployeController  {

	@Autowired	
	private EmployeService employeService;
	
	@PostMapping(value = "/addEmploye")
	public ResponseEntity addEmploye(@RequestBody EmployeePayload employePayload) {
		Employe employePostSave = null;
		try {
			employePostSave = (Employe) employeService.addEmploye(employePayload);
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(employePostSave);
	}

	@PutMapping(value = "/updateEmploye")
	public ResponseEntity updateEmploye(@RequestBody Employe employe) {
		Employe employePostUpdate = null;
		try {
			employePostUpdate = (Employe) employeService.updateEmploye(employe);
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(employePostUpdate);
	}

	@DeleteMapping(value = "/deleteEmploye/{id}")
	public ResponseEntity deleteEmploye(@PathVariable Integer id) {
		try {
			employeService.deleteEmploye(id);
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body("Employe deleted");
	}

	@GetMapping(value = "/findAllEmploye")
	public ResponseEntity findAllEmploye() {
		List<Employe> employes = new ArrayList<>();
		try {
			employes= employeService.findAllEmploye();
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(employes);
	}

	@GetMapping(value = "/findEmploye/{id}")
	public ResponseEntity findEmploye(@PathVariable Integer id) {
		Employe employe = null;
		try {
			employe = employeService.findEmployeById(id);
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(employe);
	}

	@PutMapping(value = "/affecterEmployeATeam/{idemp}/{idteam}") 
	public void affecterEmployeATeam(@PathVariable("idemp")int employeId, @PathVariable("idteam")int teamId) {
		employeService.affecterEmployeATeam(employeId, teamId);
		
	}
	
	

	
	

	
	

	
	
    
	
	
	
}
