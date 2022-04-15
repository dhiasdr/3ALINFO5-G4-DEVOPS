package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.model.Team;
import tn.esprit.spring.repository.TeamRepository;
@Service
public class TeamServiceImpl implements TeamService{
	@Autowired
	private TeamRepository teamRepository;

	@Override
	public Team addTeam(Team team) {
		// TODO Auto-generated method stub
		return teamRepository.save(team);

		
	}

	@Override
	public Team updateTeam(Team team) {
		// TODO Auto-generated method stub
		return teamRepository.save(team);
	}

	@Override
	public void deleteTeam(Long id) {
		teamRepository.deleteById(id);

		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Team> findAllTeams() {
		// TODO Auto-generated method stub
		return (List<Team>) teamRepository.findAll();
	}

	@Override
	public Team findTeamById(Long id) {
		// TODO Auto-generated method stub
		return teamRepository.findById(id).get();
		
	}

}
