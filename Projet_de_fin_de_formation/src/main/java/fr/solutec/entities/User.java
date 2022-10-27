package fr.solutec.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
	private String nomEntreprise;
	private String siret;
	private int nbTokenEvent;
	private String sexe;
}