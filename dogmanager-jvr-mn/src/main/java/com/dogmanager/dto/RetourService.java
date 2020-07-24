package com.dogmanager.dto;

import lombok.Data;

@Data
public class RetourService<T> {

	private T contenu;
	private boolean reussi;
	private String msg;

}
