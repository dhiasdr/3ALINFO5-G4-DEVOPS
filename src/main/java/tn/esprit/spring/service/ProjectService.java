package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.model.Project;

public interface ProjectService {
	Project addProject(Project project);
	Project updateProject(Project project);
	void deleteProject(Long id);
	List<Project> findAllProjects();
	Project findProjectById(Long id);
}
