package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import tn.esprit.spring.model.Departement;
import tn.esprit.spring.model.Employe;
import tn.esprit.spring.model.Team;
import tn.esprit.spring.payload.EmployeePayload;
import tn.esprit.spring.repository.EmployeRepository;
import tn.esprit.spring.repository.TeamRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
public class EmployeServiceImpl implements EmployeService {

	private static final Logger logger = LogManager.getLogger(DepartementServiceImpl.class);
	@Autowired
	private EmployeRepository employeRepository;
	@Autowired
	private TeamRepository teamRepository;
	@Autowired
	private TeamService teamService;

	public Employe addEmploye(EmployeePayload employePayload) {
		Employe employe=new Employe();
		logger.info("start mapping process");
		employe.setNom(employePayload.getNom());
		employe.setPrenom(employePayload.getPrenom());
		employe.setEmail(employePayload.getEmail());
		employe.setRole(employePayload.getRole());
		employe.setActif(employePayload.isActif());
		logger.info("end mapping process");
		logger.info("save employee");

		return employeRepository.save(employe);
	}

	@Override
	public Employe updateEmploye(Employe employe) {
		// TODO Auto-generated method stub
		return employeRepository.save(employe);
	}

	@Override
	public void deleteEmploye(Integer id) {
		employeRepository.deleteById(id);

	}

	@Override
	public Employe findEmployeById(Integer id) {
		// TODO Auto-generated method stub
		return employeRepository.findById(id).get();	}

	@Override
	public List<Employe> findAllEmploye() {
		// TODO Auto-generated method stub
		return (List<Employe>) employeRepository.findAll();	}

	@SuppressWarnings("unchecked")
	@Override
	public void affecterEmployeATeam(int employeId, int teamId) {
		Team teamManagedEntity = teamRepository.findById((long) teamId).get();
		Employe employeManagedEntity = employeRepository.findById(employeId).get();

		if(teamManagedEntity.getEmployee() == null){

			List<Employe> employes = new ArrayList<>();
			employes.add(employeManagedEntity);
			teamManagedEntity.setEmployee(employes);
		}else{

			((List<Employe>) teamManagedEntity.getEmployee()).add(employeManagedEntity);

		}
	}





}