package fr.solutec.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class User {
	@Id
	@GeneratedValue
	private Long id;
	private String nom;
	private String prenom;
	private String login;
	private String password;
	private String tel;
	private String email;
	private Boolean organisateur;
	private int nbToken;
	private int nbPoint;
	private User parrain;
	private User filleul;
	private String nomEntreprise;
	private String siret;
	private int nbTokenEvent;

}