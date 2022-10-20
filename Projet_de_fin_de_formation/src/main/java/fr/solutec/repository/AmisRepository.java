package fr.solutec.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Amis;
import fr.solutec.entities.User;


public interface AmisRepository extends CrudRepository<Amis, Long> {
	public List<Amis> findByDemandeur(User demandeur);
	public List<Amis> findByReceveur(User receveur);
	
	@Query(value = "SELECT a FROM Amis a WHERE a.receveur.id = ?1 OR a.demandeur.id = ?1 AND a.acceptation = true")
	public List<Amis> getMesAmis(Long id);
}
