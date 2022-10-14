package fr.solutec.rest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	public Event createEvent(@RequestBody Event ev) {
		return eventRepos.save(ev);
	}

	@GetMapping("events")
	public Iterable<Event> allEvent() {
	return eventRepos.findAll();
		}
	

}
