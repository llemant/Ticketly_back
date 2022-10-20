package fr.solutec.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
public class Inscriptions {
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	private User acheteur;
	
	@ManyToOne
	private Event event;

	@Temporal(TemporalType.DATE)
	@CreationTimestamp
	private Date dateInscription;
	
	private int ticketQuantity;
}
