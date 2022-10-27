package fr.solutec.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class DemandeAmis {
	@Id
	@GeneratedValue
	private Long id;
	private Boolean acceptation;

	@CreationTimestamp
	private Date demandDate;

	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User demandeur;

	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User receveur;
}
