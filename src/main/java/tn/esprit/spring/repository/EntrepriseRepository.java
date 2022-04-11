package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.model.Entreprise;

public interface EntrepriseRepository extends  CrudRepository<Entreprise, Long>{

}
