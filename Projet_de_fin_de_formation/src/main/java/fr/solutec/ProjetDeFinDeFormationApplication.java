package fr.solutec;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.solutec.entities.Achats;
import fr.solutec.entities.Avantage;
import fr.solutec.entities.Event;
import fr.solutec.entities.Lieu;
import fr.solutec.entities.User;
import fr.solutec.repository.AchatsRepository;
import fr.solutec.repository.AvantageRepository;
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
	@Autowired
	private AvantageRepository avantageRepos;
	@Autowired
	private AchatsRepository achatsRepos;

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




		Event e1 = new Event(null, "Indochine", "Concert Indochine The Last Tourney 1", 30000, d.parse("10/12/2022"), "20h", "Concert", 55, "https://images.midilibre.fr/api/v1/images/view/626278a83188675ed45b26e4/large/image.jpg?v=2", u3, "Chine");
		Event e2 = new Event(null, "Caroline Martinez", "Caro fait son One Woman Show", 6300, d.parse("19/02/2023"), "20h30", "Humour", 15, "https://images.midilibre.fr/api/v1/images/view/626278a83188675ed45b26e4/large/image.jpg?v=2", u5, "Esic");
		Event e3 = new Event(null, "", "France-Brésil", 50000, d.parse("23/12/2022"), "20h", "Football Masculin", 70, "https://images.midilibre.fr/api/v1/images/view/626278a83188675ed45b26e4/large/image.jpg?v=2", u3, "Paris");
		Event e4 = new Event(null, "Ahadi Mahaboubi", "Tous à Nancy pour Nöel", 100, d.parse("25/12/2022"), "20h", "Apéritif Dinatoire", 10, "https://images.midilibre.fr/api/v1/images/view/626278a83188675ed45b26e4/large/image.jpg?v=2", u3, "Nancy");

		Stream.of(e1, e2, e3, e4).forEach(e -> {
			eventRepos.save(e);
		});

		Avantage a1 = new Avantage(null, "Popcorn", 100);
		Avantage a2 = new Avantage(null, "Masseur Shiatsu", 100);
		Avantage a3 = new Avantage(null, "Boisson gratuite", 100);		
		Avantage a4 = new Avantage(null, "Paquet de bonbons", 100);
		
		Stream.of(a1, a2, a3, a4).forEach(a -> {
			avantageRepos.save(a);
		});

		Achats b1 = new Achats(u1, a1, 2, 200);
		Achats b2 = new Achats(u2, a2, 1, 100);
		Achats b3 = new Achats(u1, a3, 5, 500);

		Stream.of(b1, b2, b3).forEach(b -> {
			achatsRepos.save(b);
		});

		System.out.println("****************\n*****************\n☺♂☺♂☺♂  Run sera toujours, haha successful create by JoJO BONUS ****************\n*****************\n☺♂☺♂☺♂****************\n*****************\n");
	}

}

/*
 * structure model Event :
 * 
 * private Long id; private String artiste; private String titre; private int
 * place; private Date date; private String heure; private String genre; private
 * int prix; private String photo; private User organisateur; private Lieu lieu;
 */
