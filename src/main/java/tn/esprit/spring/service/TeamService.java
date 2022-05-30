package tn.esprit.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.esprit.spring.model.Team;
import tn.esprit.spring.payload.TeamPayload;

public interface TeamService {
	
	Team addTeam(TeamPayload teamPayload);
	Team updateTeam(Team team);
	void deleteTeam(Long id);
	List<Team> findAllTeams();
	Team findTeamById(Long id);

}
