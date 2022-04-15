package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.model.Departement;
import tn.esprit.spring.model.Employe;
import tn.esprit.spring.repository.EmployeRepository;

@Service
public class EmployeServiceImpl implements EmployeService {

	@Autowired
	private EmployeRepository employeRepository;

	@Override
	public Employe addEmploye(Employe employe) {
		// TODO Auto-generated method stub
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
	
	

	
	
}
