package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import tn.esprit.spring.model.Entreprise;
import tn.esprit.spring.repository.EntrepriseRepository;
@Service
public class EntrepriseServiceImpl implements EntrepriseService{
	private static final Logger logger = LogManager.getLogger(EntrepriseServiceImpl.class);
	@Autowired
	private EntrepriseRepository entrepriseRepository;
	@Override
	public Entreprise addEntreprise(Entreprise entreprise) {
		Entreprise entrepriseTobeSaved = new Entreprise();
		logger.info("start mapping process");
		entrepriseTobeSaved.setName(entreprise.getName());
		entrepriseTobeSaved.setRaisonSocial(entreprise.getRaisonSocial());
		logger.info("end mapping process");
		logger.info("save entreprise");
		// TODO Auto-generated method stub
		return entrepriseRepository.save(entrepriseTobeSaved);

		
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
