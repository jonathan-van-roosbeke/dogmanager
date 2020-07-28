package com.dogmanager.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Couleur {
	@Id
	@Column(name = "id_race")
	private int idCouleur;
	@Column(name = "nom_race")
	private String couleur;

}
