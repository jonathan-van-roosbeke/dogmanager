package com.dogmanager.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
	@Column(name = "id_puce_chien")
	private int idPuceChien;
	@Column(name = "nom_chien")
	private String nomChien;
	@Column(name = "age_chien")
	private int ageChien;
	@Column(name = "id_couleur")
	private int idCouleur;
	@Column(name = "id_race")
	private int idRace;
	@Column(name = "id_utilisateur")
	private int idUtilisateur;

//	@ManyToOne
//	@JoinColumn(name = "utilisateur_id")
//	private Utilisateur utilisateur;

//	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinColumn(name = "id_couleur", nullable = false, insertable = false, updatable = false)

	@ManyToOne
	@JoinColumn(name = "id_couleur", nullable = false, insertable = false, updatable = false)
	private Couleur couleur;

	@ManyToOne
	@JoinColumn(name = "id_race", nullable = false, insertable = false, updatable = false)
	private Race race;

	public Chien(int idPuceChien, String nomChien, int ageChien, int idUtilisateur, int idCouleur, int idRace) {
		super();
		this.idPuceChien = idPuceChien;
		this.nomChien = nomChien;
		this.ageChien = ageChien;
		this.idUtilisateur = idUtilisateur;
		this.idCouleur = idCouleur;
		this.idRace = idRace;
	}

	@Override
	public String toString() {
		return "Chien [idPuceChien=" + idPuceChien + ", nomChien=" + nomChien + ", ageChien=" + ageChien + "]";
	}
}