package com.dogmanager.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Race {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_race")
	private int idRace;
	@Column(name = "nom_race")
	private String nomRace;

//	@OneToMany(mappedBy = "race")
//	private List<Chien> chien = new ArrayList<>();

}