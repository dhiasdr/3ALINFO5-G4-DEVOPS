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

import tn.esprit.spring.model.Project;
import tn.esprit.spring.service.ProjectService;

@Controller
public class ProjectController {
	@Autowired
	private ProjectService projectService;

	@PostMapping(value = "/addProject")
	public ResponseEntity addProject(@RequestBody Project project) {
		Project projectPostSave = null;
		try {
			projectPostSave = projectService.addProject(project);
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(projectPostSave);
	}

	@PutMapping(value = "/updateProject")
	public ResponseEntity updateProject(@RequestBody Project project) {
		Project projectPostUpdate = null;
		try {
			projectPostUpdate = projectService.updateProject(project);
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(projectPostUpdate);
	}

	@DeleteMapping(value = "/deleteProject/{id}")
	public ResponseEntity deleteProject(@PathVariable Long id) {
		try {
			projectService.deleteProject(id);
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body("Project deleted");
	}

	@GetMapping(value = "/findAllProjects")
	public ResponseEntity findAllProjects() {
		List<Project> projects = new ArrayList<>();
		try {
			projects = projectService.findAllProjects();
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(projects);
	}

	@GetMapping(value = "/findProject/{id}")
	public ResponseEntity findProject(@PathVariable Long id) {
		Project project = null;
		try {
			project = projectService.findProjectById(id);
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
		return ResponseEntity.status(HttpStatus.OK).body(project);
	}
}
