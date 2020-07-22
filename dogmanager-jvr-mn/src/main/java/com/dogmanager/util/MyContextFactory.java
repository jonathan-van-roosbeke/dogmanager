package com.dogmanager.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MyContextFactory {

	private static ApplicationContext applicationContext = null;

	private static final String PATH = "spring/";
	private static final String APPLICATION_CONTEXT_XML = "applicationContext.xml";

	/**
	 * Permet de charger le contexte selon le type fourni
	 * 
	 * @param typeConfig : le type de configuration initialiser
	 * @return ApplicationContext initialise
	 */
	public static ApplicationContext getContext(final ContextConfigurationType typeConfig) {
		synchronized (MyContextFactory.class) {

			if (applicationContext == null) {
				if (ContextConfigurationType.CLASSPATH.equals(typeConfig)) {
					applicationContext = new ClassPathXmlApplicationContext(PATH + APPLICATION_CONTEXT_XML);
				} else if (ContextConfigurationType.FILE_SYSTEM.equals(typeConfig)) {
					applicationContext = new FileSystemXmlApplicationContext(PATH + APPLICATION_CONTEXT_XML);
				} else {
					System.err.println("Localisation non definie");
				}
			}
		}
		return applicationContext;
	}

}
