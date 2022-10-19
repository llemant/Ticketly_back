package fr.solutec.entities;

import java.io.Serializable;

import lombok.NoArgsConstructor;

@NoArgsConstructor

public class AchatsConstraint implements Serializable {
	
	private Long user;
	private Long avantage;

}
