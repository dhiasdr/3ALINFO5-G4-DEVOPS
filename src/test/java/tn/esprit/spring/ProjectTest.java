package tn.esprit.spring;

import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.model.Project;
import tn.esprit.spring.model.Team;
import tn.esprit.spring.payload.ProjectPayload;
import tn.esprit.spring.payload.TeamPayload;
import tn.esprit.spring.service.ProjectService;
import tn.esprit.spring.service.TeamService;

@SpringBootTest
public class ProjectTest {
	@Autowired
	ProjectService projectService;
	@Autowired
	TeamService teamService;
	
	@Test
	void testAddProject() {
        TeamPayload teamPayload=new TeamPayload();
        teamPayload.setName("team2");
        teamPayload.setDescription("desc");
        Team team= teamService.addTeam(teamPayload);
        ProjectPayload projectPayload= new ProjectPayload();
        projectPayload.setCode("code");
        projectPayload.setDescription("desc");
        projectPayload.setName("name");
        projectPayload.setStartDate(new Date());
        projectPayload.setEndDate(new Date());
        projectPayload.setIdTeam(team.getId());
        Project project = projectService.addProject(projectPayload);
		assertTrue(project!=null);

	}
}
