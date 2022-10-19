package fr.solutec.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Inscriptions;
import fr.solutec.entities.User;

public interface InscriptionsRepository extends CrudRepository<Inscriptions, Long>{

	public Iterable<Inscriptions> findByAcheteur(User u);
	
}
 