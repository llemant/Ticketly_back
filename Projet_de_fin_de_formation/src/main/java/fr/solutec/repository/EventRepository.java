package fr.solutec.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Event;
import fr.solutec.entities.User;

public interface EventRepository extends CrudRepository<Event, Long> {
	
	public Iterable<Event> findByDateAfter(Date d);

	public Iterable<Event> findByDateBefore(Date d);
	
	public Iterable<Event> findByDate(Date d);
	
	public Iterable<Event> findByTitre(String titre);
	
	public Iterable<Event> findByGenre(String genre);
	
	public Optional<Event> findByLieu(String lieu);

	public Optional<Event> findByArtiste(String artiste);
	
	@Query(value = "SELECT e FROM Event e WHERE e.organisateur.id = ?1 AND e.date < CURRENT_DATE")
	public Iterable<Event> findByOrganisateurIdPast(Long id);
	
	
	public Iterable<Event> findByOrganisateurId(Long id);
	

}
