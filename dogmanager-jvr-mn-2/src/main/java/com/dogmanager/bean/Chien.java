package com.dogmanager.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
@Entity
public class Chien {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_puce_chien")
	private int idPuceChien;
	@Column(name = "nom_chein")
	private String nomChien;
	@Column(name = "age_chein")
	private int ageChien;
	@Column(name = "id_couleur")
	private int idCouleur;
	@Column(name = "id_race")
	private int idRace;
	@Column(name = "id_utilisateur")
	private int idUtilisateur;

}