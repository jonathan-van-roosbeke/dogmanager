package com.dogmanager.dto;

import lombok.Data;

@Data
public class RetourService<T> {

	T contenu;
	boolean reussi;
	String msg;

}

//RetourService<Chien> retour = new RetourService<>();
//try {
//
//	chienDao.update(chien, newChien);
//	retour.setContenu(chien);
//	retour.setReussi(true);
//	retour.setMsg("Mise a jour avec sucsee");
//} catch (Exception e) {
//	retour.setReussi(false);
//	retour.setMsg("Failed: " + e.getMessage());
//}
//return retour;