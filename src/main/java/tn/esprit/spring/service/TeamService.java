package tn.esprit.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.esprit.spring.model.Team;

public interface TeamService {
	
	Team addTeam(Team team);
	Team updateTeam(Team team);
	void deleteTeam(Long id);
	List<Team> findAllTeams();
	Team findTeamById(Long id);

}
