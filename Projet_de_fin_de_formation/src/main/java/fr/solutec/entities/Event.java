package fr.solutec.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

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
	private int placedispo;
	@Temporal(TemporalType.DATE)
	@CreationTimestamp 
	private Date date;
	private String heure;
	private String genre;
	private int prix;
	@ManyToOne
	private User organisateur;
	@ManyToOne
	private Lieu lieu;
	
	
	
} 
