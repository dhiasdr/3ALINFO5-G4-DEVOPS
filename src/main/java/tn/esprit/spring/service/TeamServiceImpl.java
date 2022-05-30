package tn.esprit.spring.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.model.Team;
import tn.esprit.spring.payload.TeamPayload;
import tn.esprit.spring.repository.TeamRepository;
@Service
public class TeamServiceImpl implements TeamService{
	private static final Logger logger = LogManager.getLogger(TeamServiceImpl.class);
	@Autowired
	private TeamRepository teamRepository;
	
	@Override
	public Team addTeam(TeamPayload teamPayload) {
		Team team = new Team();
		logger.info("start mapping process");
		team.setName(teamPayload.getName());
		team.setDescription(teamPayload.getDescription());
		logger.info("end mapping process");
		logger.info("save team");
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
