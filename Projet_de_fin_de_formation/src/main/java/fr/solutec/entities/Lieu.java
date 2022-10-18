package fr.solutec.entities;

import java.util.Date;

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
public class Lieu {
	@Id	@GeneratedValue
	private Long id;
	private String pays;
	private String ville;
	private String adresse;
	private String nom;
	private int capacity;

}
