package tn.esprit.spring.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.model.Project;
import tn.esprit.spring.payload.ProjectPayload;
import tn.esprit.spring.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {
	private static final Logger logger = LogManager.getLogger(ProjectServiceImpl.class);
	@Autowired
	private ProjectRepository projectRepository;
	@Autowired
	private TeamService teamService;
	@Override
	public Project addProject(ProjectPayload projectPayload) {
		Project project= new Project();
		logger.info("start mapping process");
		project.setCode(projectPayload.getCode());
		project.setDescription(projectPayload.getDescription());
		project.setName(projectPayload.getName());
		project.setStartDate(projectPayload.getStartDate());
		project.setEndDate(projectPayload.getEndDate());
		project.setTeam(teamService.findTeamById(projectPayload.getIdTeam()));
		logger.info("end mapping process");
		logger.info("save project");
		return projectRepository.save(project);
	}

	@Override
	public Project updateProject(Project project) {
		logger.info("start update process");
		return projectRepository.save(project);
	}

	@Override
	public void deleteProject(Long id) {
		logger.info("start delete process");
		projectRepository.deleteById(id);
	}

	@Override
	public List<Project> findAllProjects() {
		logger.info("find all projects");
		return (List<Project>) projectRepository.findAll();
	}

	@Override
	public Project findProjectById(Long id) {
		logger.info("find project with id: "+id);
		return projectRepository.findById(id).get();
	}

}
