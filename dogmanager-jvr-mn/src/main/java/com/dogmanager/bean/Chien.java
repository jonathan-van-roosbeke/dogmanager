package com.dogmanager.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Contains method to greet users by their name and location.
 * 
 * @author Jonathan Van Roosbeke
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chien {
	private int idPuceChien;
	private String nomChien;
	private int ageChien;
	private Couleur couleur;
	private Race race;
}