package tn.esprit.spring;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.model.Entreprise;
import tn.esprit.spring.model.Team;
import tn.esprit.spring.payload.TeamPayload;
import tn.esprit.spring.service.EntrepriseService;
import tn.esprit.spring.service.TeamService;

@SpringBootTest
public class TeamTest {
	@Autowired 
	TeamService teamService;
	@Test
	void testFindTeam() {
        Team team=new Team();
        TeamPayload teamPayload = new TeamPayload();
        team.setName("Team1");
        team.setDescription("Teams");
        team= teamService.addTeam(teamPayload);

		assertTrue(teamService.findTeamById(team.getId())!=null);

	}


}
