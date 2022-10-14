package fr.solutec.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor 
@AllArgsConstructor 
@Data
@Entity
public class Event {

	@Id @GeneratedValue
	private Long id;
	private String artiste;
	private String titre;	
	private int place;
	private Date date;
	private String heure;
	private String genre;
	private int prix;
	@ManyToOne
	private User organisateur;
	@ManyToOne
	private Lieu lieu;
	
	
	
} 
