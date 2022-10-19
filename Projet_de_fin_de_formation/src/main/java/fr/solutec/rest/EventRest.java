package fr.solutec.rest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Event;
import fr.solutec.entities.User;
//import fr.solutec.entities.UserEvent;
import fr.solutec.repository.EventRepository;


@RestController @CrossOrigin("*")
public class EventRest {
	@Autowired
	private EventRepository eventRepos;

	@PostMapping("event")
	public Event createEvent(@RequestBody Event e) {
		return eventRepos.save(e);
	}

	@GetMapping("events")
	public Iterable<Event> allEvent() {
	return eventRepos.findAll();
		}
	@GetMapping("event/{artiste}")
	public Optional<Event> getAllEventByArtiste(@PathVariable String artiste) {
		return eventRepos.findByArtiste(artiste);
	}
	
	@PutMapping("modi/event/{id}")
	public Event modiEvent(@RequestBody Event e, @PathVariable Long id) {
		e.setId(id);
		return eventRepos.save(e);
	}
	@GetMapping("event/after")
	public Iterable<Event> upcomingEvents() {
		Date d = new Date();
		return eventRepos.findByDateAfter(d);
	}

	@GetMapping("event/before")
	public Iterable<Event> pastEvents() {
		Date d = new Date();
		return eventRepos.findByDateBefore(d);
	}
	@GetMapping("event/today")
	public Iterable<Event> todayEvents() {
		Date d = new Date();
		return eventRepos.findByDate(d);
	}
	
}
