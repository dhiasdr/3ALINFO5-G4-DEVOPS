package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.model.Entreprise;
import tn.esprit.spring.repository.EntrepriseRepository;
@Service
public class EntrepriseServiceImpl implements EntrepriseService{
	@Autowired
	private EntrepriseRepository entrepriseRepository;

	@Override
	public Entreprise addEntreprise(Entreprise entreprise) {
		// TODO Auto-generated method stub
		return entrepriseRepository.save(entreprise);

		
	}

	@Override
	public Entreprise updateEntreprise(Entreprise entreprise) {
		// TODO Auto-generated method stub
		return entrepriseRepository.save(entreprise);
	}

	@Override
	public void deleteEntreprise(Long id) {
		entrepriseRepository.deleteById(id);

		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Entreprise> findAllEntreprise() {
		// TODO Auto-generated method stub
		return (List<Entreprise>) entrepriseRepository.findAll();
	}

	@Override
	public Entreprise findEntrepriseById(Long id) {
		// TODO Auto-generated method stub
		return entrepriseRepository.findById(id).get();
		
	}

}
