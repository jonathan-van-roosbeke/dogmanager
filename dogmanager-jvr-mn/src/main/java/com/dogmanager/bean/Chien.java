package com.dogmanager.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chien {
	
	private int idPuceChien;
	private String nomChien;
	private int ageChien;
	private int idCouleur;
	private int idRace;
	private int idUtilisateur;

}
