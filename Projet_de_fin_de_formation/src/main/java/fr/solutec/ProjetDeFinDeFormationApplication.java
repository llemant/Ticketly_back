package fr.solutec;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

		System.out.println("Run successful");
	}

}

/*
 * structure model User :
 * 
 * private Long id; 
 * private String nom; 
 * private String prenom; 
 * private String login; 
 * private String password; 
 * private String tel; 
 * private String email;
 * private Boolean organisateur; 
 * private int nbToken; 
 * private int nbPoint;
 * private String nomEntreprise;
 * private String siret; 
 * private int nbTokenEvent;
 */