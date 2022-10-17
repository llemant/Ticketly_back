package fr.solutec;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.solutec.entities.Event;
import fr.solutec.entities.Lieu;
import fr.solutec.entities.User;
import fr.solutec.repository.EventRepository;
import fr.solutec.repository.LieuRepository;
import fr.solutec.repository.UserRepository;

@SpringBootApplication
public class ProjetDeFinDeFormationApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepos;
	@Autowired
	private EventRepository eventRepos;	
	@Autowired
	private LieuRepository lieuRepos;

	DateFormat d = new SimpleDateFormat("dd/MM/yyyy");

	public static void main(String[] args) {
		SpringApplication.run(ProjetDeFinDeFormationApplication.class, args);
		System.out.println("Main successful");

	}

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Lemant", "Louis", "lemlo", "lemlo123", "0600000001", "lelouis@esic.fr", false, 10000,
				2500, null, null, 0);
		User u2 = new User(null, "Defossez", "Lise", "defli", "defli123", "0600000002", "relise@esic.fr", false, 10000,
				2500, null, null, 0);
		User u3 = new User(null, "Mahaboubi", "Ahadi", "mahah", "mahah123", "0600000003", "maahadi@esic.fr", true,
				10000, 2500, null, null, 0);
		User u4 = new User(null, "Lajus", "Quentin", "lajqu", "lajqu123", "0600000004", "laquentin@esic.fr", false,
				10000, 2500, null, null, 0);

		Stream.of(u1, u2, u3, u4).forEach(u -> {
			userRepos.save(u);
		});

		Lieu l1 = new Lieu(null,"France", "Paris", "Rue Francis de Pressensé, Saint-Denis,Seine-Saint-Denis 93200",
		"Stade de Fance",80000);
		Lieu l2 = new Lieu(null,"France", "Lille", "17 Place Mendès France, Lille, 59000",
		"Le Nouveau Siècle",59000);
		Lieu l3 = new Lieu(null,"Allemagne", "Berlin", "Friedrichstrasse 107, Berlin 10117", "Friedrichstadt-Palast", 10117);
		
		Stream.of(l1, l2, l3).forEach(l -> {
			lieuRepos.save(l);
		});
		
		
		Event e1 = new Event(null, "Indochine", "Concert Indochine The Last Tourney 1", 30000, d.parse("10/12/2022"), "20h", "Concert", 55,"https://images.midilibre.fr/api/v1/images/view/626278a83188675ed45b26e4/large/image.jpg?v=2", u3, l1);

		
		Stream.of(e1).forEach(e -> {
			eventRepos.save(e);
		});
		
		System.out.println("Run successful");
	}

}
/*
 * structure model Event :
 * 
	private Long id;
	private String artiste;
	private String titre;	
	private int place;
	private Date date;
	private String heure;
	private String genre;
	private int prix;
	private String photo;
	private User organisateur;
	private Lieu lieu;
 */
