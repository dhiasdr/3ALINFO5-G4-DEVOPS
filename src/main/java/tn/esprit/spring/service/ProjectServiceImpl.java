package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.model.Project;
import tn.esprit.spring.payload.ProjectPayload;
import tn.esprit.spring.repository.ProjectRepository;
import tn.esprit.spring.repository.TeamRepository;

@Service
public class ProjectServiceImpl implements ProjectService {
	@Autowired
	private ProjectRepository projectRepository;
	@Autowired
	private TeamService teamService;
	@Override
	public Project addProject(ProjectPayload projectPayload) {
		Project project= new Project();
		project.setCode(projectPayload.getCode());
		project.setDescription(projectPayload.getDescription());
		project.setName(projectPayload.getName());
		project.setStartDate(projectPayload.getStartDate());
		project.setEndDate(projectPayload.getEndDate());
		project.setTeam(teamService.findTeamById(projectPayload.getIdTeam()));
		return projectRepository.save(project);
	}

	@Override
	public Project updateProject(Project project) {
		return projectRepository.save(project);
	}

	@Override
	public void deleteProject(Long id) {
		projectRepository.deleteById(id);
	}

	@Override
	public List<Project> findAllProjects() {
		return (List<Project>) projectRepository.findAll();
	}

	@Override
	public Project findProjectById(Long id) {
		return projectRepository.findById(id).get();
	}

}
