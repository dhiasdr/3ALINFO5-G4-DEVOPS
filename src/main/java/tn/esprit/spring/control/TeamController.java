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

import tn.esprit.spring.model.Team;
import tn.esprit.spring.payload.TeamPayload;
import tn.esprit.spring.service.EntrepriseService;
import tn.esprit.spring.service.TeamService;
@Controller
public class TeamController {

	@Autowired	
	private TeamService teamService;
	
	@PostMapping(value = "/addTeam")
	public ResponseEntity addTeam(@RequestBody TeamPayload teamPayload) {
		Team teamPostSave = null;
		try {
			teamPostSave = teamService.addTeam(teamPayload);
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(teamPostSave);
	}

	@PutMapping(value = "/updateTeam")
	public ResponseEntity updateTeam(@RequestBody Team team) {
		Team teamPostUpdate = null;
		try {
			teamPostUpdate = teamService.updateTeam(team);
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(teamPostUpdate);
	}

	@DeleteMapping(value = "/deleteTeam/{id}")
	public ResponseEntity deleteTeam(@PathVariable Long id) {
		try {
			teamService.deleteTeam(id);
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body("Team is deleted");
	}

	@GetMapping(value = "/findAllTeams")
	public ResponseEntity findAllTeams() {
		List<Team> teams = new ArrayList<>();
		try {
			teams= teamService.findAllTeams();
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(teams);
	}

	@GetMapping(value = "/findTeamById/{id}")
	public ResponseEntity findTeamById(@PathVariable Long id) {
		Team team = null;
		try {
			team = teamService.findTeamById(id);
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(team);
	}

}
