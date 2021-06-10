package com.desarrollo.bean.base;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import com.desarrollo.enumerador.BaseEnum.accion_solicitada;
import com.desarrollo.framework.interfaces.IMantenimientoController;
import com.desarrollo.servicio.DiagnosticoServicio;
import com.desarrollo.servicio.TecnicoServicio;
import com.desarrollo.servicio.UsuarioPersonaServicio;
import com.desarrollo.servicio.UsuarioServicio;
import com.desarrollo.servicio.impl.DiagnosticoServicioImpl;
import com.desarrollo.servicio.impl.TecnicoServicioImpl;
import com.desarrollo.servicio.impl.UsuarioPersonaServicioImpl;
import com.desarrollo.servicio.impl.UsuarioServicioImpl;

public class BaseBean {

	private IMantenimientoController bean;

	/**
	 * The pantalla listado. tiene valores del faces-config.xml
	 * (navigation-case).
	 */
	public String PANTALLA_LISTADO = null;

	/**
	 * The pantalla mantenimiento. tiene valores del faces-config.xml
	 * (navigation-case).
	 */
	public String PANTALLA_MANTENIMIENTO = null;

	public String PANTALLA_BIENVENIDA = "bienvenida";

	/**
	 * Define el nombre de la accion en la pantalla de mantenimiento se define
	 * en la vista dado que se debe enviar mensaje a la propia controladora del
	 * proceso o mantenimiento y al BINDING para que se pinte a nivel de menu
	 * 
	 */
	private accion_solicitada accionPantalla;

	/**
	 * Define el nombre de la accion en la pantalla de mantenimiento se define
	 * en la vista dado que se debe enviar mensaje a la propia controladora del
	 * proceso o mantenimiento y al BINDING para que se pinte a nivel de menu
	 * 
	 */
	public accion_solicitada getAccionPantalla() {
		return accionPantalla;
	}

	public void setAccionPantalla(accion_solicitada accionPantalla) {
		this.accionPantalla = accionPantalla;
	}

	public void setMessageError(String error) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getFlash().setKeepMessages(true);
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, error, error));
	}

	/**
	 * Recibe un mensaje y se lo pasa a FaceMessage para que lo muestre en
	 * pantalla como error.
	 *
	 * @param error
	 *            mensaje de error a mostrar en la pagina, tipo String
	 */
	public void setMessageError(String titulo, String error) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, titulo, error));
	}

	/**
	 * Recibe un mensaje y se lo pasa a FaceMessage para que lo muestre en
	 * pantalla como mensaje de exito.
	 *
	 * @param msg
	 *            mensaje de exito a mostrar en la pagina, tipo String
	 */
	public void setMessageSuccess(String msg) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getFlash().setKeepMessages(true);
		context.addMessage(null, new FacesMessage(msg, msg));
	}

	public void setMessageSuccess(String msg, Boolean mantener) {
		if (mantener) {
			FacesContext context = FacesContext.getCurrentInstance();
			context.getExternalContext().getFlash().setKeepMessages(true);
			context.addMessage(null, new FacesMessage(msg));
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));
		}
	}

	public void setMessageInfo(String info) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, info, info));
	}

	public void setMessageInfo(String titulo, String info) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, titulo, info));
	}

	public void setMessageWarn(String warn) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, warn, warn));
	}

	public void setMessageWarn(String titulo, String info) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, titulo, info));
	}

	public IMantenimientoController getBean() {
		return bean;
	}

	public void setBean(IMantenimientoController bean) {
		this.bean = bean;
	}

	public DiagnosticoServicio getDiagnosticoServicio() {
		return DiagnosticoServicioImpl.getInstance();
	}
	
	public UsuarioServicio getUsuarioServicio() {
		return UsuarioServicioImpl.getInstance();
	}

	public UsuarioPersonaServicio getUsuarioPersonaServicio() {
		return UsuarioPersonaServicioImpl.getInstance();
	}
	
	public TecnicoServicio getTecnicoServicio() {
		return TecnicoServicioImpl.getInstance();
	}
}
