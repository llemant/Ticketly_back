package fr.solutec.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Event;

public interface EventRepository extends CrudRepository<Event, Long> {
	
	public Iterable<Event> findByDateAfter(Date d);

	public Iterable<Event> findByDateBefore(Date d);
	
	public Iterable<Event> findByDate(Date d);
	
	public Iterable<Event> findByTitre(String titre);
	
	public Iterable<Event> findByGenre(String genre);
	
	public Optional<Event> findByLieu(String lieu);

	public Optional<Event> findByArtiste(String artiste);
	
	//public Iterable<Event> finBydateandHeure(Date date, String heure);
	

}
