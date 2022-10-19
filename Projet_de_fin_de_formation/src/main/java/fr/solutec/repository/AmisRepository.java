package fr.solutec.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Amis;
import fr.solutec.entities.User;


public interface AmisRepository extends CrudRepository<Amis, Long> {
	public Optional<Amis> findByDemandeur(User demandeur);
	public Optional<Amis> findByReceveur(User receveur);
}
