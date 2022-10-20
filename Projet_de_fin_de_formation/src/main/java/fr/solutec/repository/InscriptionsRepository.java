package fr.solutec.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Inscriptions;
import fr.solutec.entities.User;

public interface InscriptionsRepository extends CrudRepository<Inscriptions, Long>{

	public Iterable<Inscriptions> findByAcheteur(User u);
	
	@Query(value = "SELECT i FROM Inscriptions i WHERE i.acheteur.id = ?1 AND i.event.date = CURRENT_DATE")
	public List<Inscriptions> getEventToday(Long id);
	
}
 