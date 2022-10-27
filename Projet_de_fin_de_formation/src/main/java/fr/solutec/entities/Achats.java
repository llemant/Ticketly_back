package fr.solutec.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@IdClass(AchatsConstraint.class)
public class Achats implements Serializable {
	@Id
	@ManyToOne
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User user;
	@Id
	@ManyToOne
	private Avantage avantage;
	private int quantite;
	private int total;
}
