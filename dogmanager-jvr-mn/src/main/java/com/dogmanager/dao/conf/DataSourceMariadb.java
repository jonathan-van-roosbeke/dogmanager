package com.dogmanager.dao.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DataSourceMariadb {

	@Value("${database.mariadb.url}")
	private String url;
	@Value("${database.mariadb.driver}")
	private String driver;
	@Value("${database.mariadb.user}")
	private String utilisateur;
	@Value("${database.mariadb.password}")
	private String motDePasse;
}
