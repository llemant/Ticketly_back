package fr.solutec.entities;

import java.sql.Blob;
import java.util.Date;
import java.time.LocalDateTime;  

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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

	@Id
	@GeneratedValue
	private Long id;
	private String artiste;
	private String titre;
	private int nbPlace;
	@Temporal(TemporalType.DATE)	
	private Date date;
	private String heure;
	private String genre;
	private int prix;
	private String image;
	@ManyToOne
	private User organisateur;
	private String lieu;

}
