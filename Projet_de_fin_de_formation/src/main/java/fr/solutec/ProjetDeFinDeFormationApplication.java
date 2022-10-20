package fr.solutec;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.stream.Stream;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.solutec.entities.Achats;
import fr.solutec.entities.Amis;
import fr.solutec.entities.Avantage;
import fr.solutec.entities.Event;
import fr.solutec.entities.Inscriptions;
import fr.solutec.entities.Lieu;
import fr.solutec.entities.User;
import fr.solutec.repository.AchatsRepository;
import fr.solutec.repository.AmisRepository;
import fr.solutec.repository.AvantageRepository;
import fr.solutec.repository.EventRepository;
import fr.solutec.repository.InscriptionsRepository;
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
	@Autowired
	private AvantageRepository avantageRepos;
	@Autowired
	private AchatsRepository achatsRepos;
	@Autowired
	private InscriptionsRepository inscriptionRepos;
	@Autowired
	private AmisRepository amisRepos;

	DateFormat d = new SimpleDateFormat("dd/MM/yyyy");

	public static void main(String[] args) {
		SpringApplication.run(ProjetDeFinDeFormationApplication.class, args);
		 System.out.println("☺♂☺♂☺♂  Run successful create by JoJO  ☺♂☺♂☺♂");

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
		User u5 = new User(null, "Martinez Alonso", "Caroline", "Caro", "Caroo", "0600000005", "macarolinen@esic.fr",
				true, 20000, 3500, null, null, 0);

		Stream.of(u1, u2, u3, u4, u5).forEach(u -> {
			userRepos.save(u);
		});

		Lieu l1 = new Lieu(null, "France", "Paris", "Rue Francis de Pressensé, Saint-Denis, 93200", "StadedeFance",
				80000);
		Lieu l2 = new Lieu(null, "France", "Lille", "17 Place Mendès France, Lille, 59000", "Le Nouveau Siècle", 59000);
		Lieu l3 = new Lieu(null, "Allemagne", "Berlin", "Friedrichstrasse 107, Berlin 10117", "Friedrichstadt-Palast",
				10117);
		Lieu l4 = new Lieu(null, "France", "Nancy", "10 rue Sonnini, Manoncourt-En-Vermois, 54210", "Domaine Des Anges",
				54210);

		Stream.of(l1, l2, l3, l4).forEach(l -> {
			lieuRepos.save(l);
		});

		Event e1 = new Event(null, "Indochine", "Concert Indochine The Last Tourney 1", 30000, d.parse("10/12/2022"), "20h", "Concert", 55, "https://www.cnc.fr/documents/36995/1603590/Affiche-Annecy-Festival-2022.jpg/0891600e-355b-baf3-fc74-10e65bf71b59?t=1646740149502", u3, "Chine");
		Event e2 = new Event(null, "Caroline Martinez", "Caro fait son One Woman Show", 6300, d.parse("19/02/2023"), "20h30", "Humour", 15, "https://images.midilibre.fr/api/v1/images/view/626278a83188675ed45b26e4/large/image.jpg?v=2", u5, "Esic");
		Event e3 = new Event(null, "", "France-Brésil", 50000, d.parse("23/12/2022"), "20h", "Football Masculin", 70, "https://images.midilibre.fr/api/v1/images/view/626278a83188675ed45b26e4/large/image.jpg?v=2", u3, "Paris");
		Event e4 = new Event(null, "Ahadi Mahaboubi", "Tous à Nancy pour Nöel", 100, d.parse("25/12/2022"), "20h", "Apéritif Dinatoire", 10, "https://images.midilibre.fr/api/v1/images/view/626278a83188675ed45b26e4/large/image.jpg?v=2", u3, "Nancy");
		Event e5 = new Event(null, "Lelouiiiis", "Event of ze day", 100, d.parse("20/10/2022"), "20h", "Apéritif Dinatoire", 10, "https://images.midilibre.fr/api/v1/images/view/626278a83188675ed45b26e4/large/image.jpg?v=2", u3, "ESIC baby");
		Event e6 = new Event(null, "Lelouiiiis", "Event of ze past1", 100, d.parse("25/12/2020"), "20h", "Apéritif Dinatoire", 10, "https://images.midilibre.fr/api/v1/images/view/626278a83188675ed45b26e4/large/image.jpg?v=2", u3, "In the past");
		Event e7 = new Event(null, "Lelouiiiis", "Event of ze past2", 100, d.parse("25/12/2019"), "20h", "Apéritif Dinatoire", 10, "https://images.midilibre.fr/api/v1/images/view/626278a83188675ed45b26e4/large/image.jpg?v=2", u3, "In the past");

		Stream.of(e1, e2, e3, e4, e5, e6, e7).forEach(e -> {
			eventRepos.save(e);
		});

		Avantage a1 = new Avantage(null, "Popcorn", 100);
		Avantage a2 = new Avantage(null, "Masseur Shiatsu", 150);
		Avantage a3 = new Avantage(null, "Boisson gratuite", 200);		
		Avantage a4 = new Avantage(null, "Paquet de bonbons", 300);
		
		Stream.of(a1, a2, a3, a4).forEach(a -> {
			avantageRepos.save(a);
		});

		Achats b1 = new Achats(u1, a1, 2, 200);
		Achats b2 = new Achats(u2, a2, 1, 100);
		Achats b3 = new Achats(u1, a3, 5, 500);

		Stream.of(b1, b2, b3).forEach(b -> {
			achatsRepos.save(b);
		});
		

		Inscriptions i1 = new Inscriptions(null, u5, e4, null, 2);
		Inscriptions i2 = new Inscriptions(null, u5, e3, null, 1);
		Inscriptions i3 = new Inscriptions(null, u4, e4, null, 2);
		Inscriptions i4 = new Inscriptions(null, u3, e3, null, 2);
		Inscriptions i5 = new Inscriptions(null, u3, e4, null, 2);
		Inscriptions i6 = new Inscriptions(null, u3, e5, null, 2);
		Inscriptions i7 = new Inscriptions(null, u3, e6, null, 2);
		Inscriptions i8 = new Inscriptions(null, u3, e7, null, 2);
		
		Stream.of(i1, i2, i3, i4, i5, i6, i7, i8).forEach(i -> {
			inscriptionRepos.save(i);
		});
		
		System.out.println("Run successful");

		
		Amis ami1 = new Amis(null, true, null, u1, u2);
		Amis ami2 = new Amis(null, false, null, u1, u3);
		Amis ami3 = new Amis(null, true, null, u2, u3);
		Amis ami4 = new Amis(null, true, null, u4, u1);
		Amis ami5 = new Amis(null, true, null, u5, u2);
		Amis ami6 = new Amis(null, false, null, u4, u2);
		Amis ami7 = new Amis(null, true, null, u1, u5);
		
		Stream.of(ami1, ami2, ami3, ami4, ami5, ami6, ami7).forEach(ami -> {
			amisRepos.save(ami);
		});
		

		System.out.println("Main successful");
	}

}


