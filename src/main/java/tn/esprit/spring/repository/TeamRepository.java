package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.model.Team;

@Repository
public interface TeamRepository extends  CrudRepository<Team, Long>{

}
