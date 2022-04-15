package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.model.Project;
import tn.esprit.spring.payload.ProjectPayload;

public interface ProjectService {
	Project addProject(ProjectPayload projectPayload);
	Project updateProject(Project project);
	void deleteProject(Long id);
	List<Project> findAllProjects();
	Project findProjectById(Long id);
}
