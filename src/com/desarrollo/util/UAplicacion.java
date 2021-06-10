package com.desarrollo.util;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

public class UAplicacion {

	private static ServletContextEvent servletContextEvent = null;
	private static ServletContext servletContext;

	/**
	 * Retorna el servletContext de JSF
	 * 
	 * @return servletContext de JSF, tipo ServletContext
	 */
	public static ServletContext getServletContext() {
		if (servletContext != null)
			return servletContext;

		if (FacesContext.getCurrentInstance() != null) {
			servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
			return servletContext;
		}

		if (servletContextEvent != null) {
			servletContext = servletContextEvent.getServletContext();
			return (ServletContext) servletContextEvent.getServletContext();
		}

		return null;
	}



	/**
	 * Agrega al sessionMap de JSF el objecto enviado como parametro. La llave
	 * sera el texto enviado como primer parametro
	 * 
	 * @param key
	 *            id para identificar el objeto en sesion, tipo String
	 * @param value
	 *            valor que se podra en sesion, tipo Object
	 */
	public static void setSessionValue(String key, Object value) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(key, value);
	}

	/**
	 * Retorna el objeto (identificado con la llave enviada como parametro) que
	 * se encuentra en el sessionMap de JSF
	 * 
	 * @param key
	 *            id que identifica al objeto en sesion, tipo String
	 * @return objeto en sesion, tipo Object
	 */
	public static Object getSessionValue(String key) {
		return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(key);
	}

	
}
