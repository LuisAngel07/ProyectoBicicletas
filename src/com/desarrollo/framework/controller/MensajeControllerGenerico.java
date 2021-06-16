package com.desarrollo.framework.controller;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.desarrollo.framework.interfaces.IMantenimientoController;

/**
 * Mensaje Controller Generico. Clase del tipo Dominio que sirve como parametro
 * unico para el mensaje entre dos objetos.
 * 
 * Ejemplo. para la implementacion de mensajes entre controladoras de la Vista
 * 
 * @version 1.0
 */
public class MensajeControllerGenerico implements Serializable {

	@SuppressWarnings("rawtypes")
	private IMantenimientoController clazzParent;
	private List<Object> valores;
	private Object valor;
	private String accionTag;

	@SuppressWarnings("rawtypes")
	public MensajeControllerGenerico() {
		super();
	}

	@SuppressWarnings("rawtypes")
	public MensajeControllerGenerico(IMantenimientoController clazzParent, String accionTag, List<Object> valores,
			Object valor) {
		super();
		this.clazzParent = clazzParent;
		this.valores = valores;
		this.accionTag = accionTag;
		this.valor = valor;
	}

	/**
	 * devuelve la controladora que envio el mensaje o realiza el llamado
	 * 
	 * @return objeto tipo <strong>IMantenimientoController</strong>
	 */
	@SuppressWarnings("rawtypes")
	public IMantenimientoController getClazzParent() {
		return clazzParent;
	}

	/**
	 * asigna la controladora que realiza el llamado al metodo
	 * 
	 * @param accionTag
	 *            tipo <strong>IMantenimientoController</strong>
	 */
	@SuppressWarnings("rawtypes")
	public void setClazzParent(IMantenimientoController clazzParent) {
		this.clazzParent = clazzParent;
	}

	/**
	 * devuelve la accion o identificador a realizarse
	 * 
	 * @return accionTag tipo String que identifica la accion a realizarse
	 */
	public String getAccionTag() {
		return accionTag;
	}

	/**
	 * asigna la accion o identificador unico que identifica al proceso
	 * 
	 * @param accionTag
	 *            tipo String que identifica la accion a realizarse
	 */
	public void setAccionTag(String accionTag) {
		this.accionTag = accionTag;
	}

	/**
	 * Devuelve un conjunto de parametros enviado como parte del mensaje Si
	 * desea devolver un solo parametro ver <strong>getValor</strong>
	 * 
	 * @return devuelve un List<Object>
	 */
	public List<Object> getValores() {
		return valores;
	}

	/**
	 * Asignacion de parametros que se envia como parte del mensaje. Si desea
	 * enviar un solo parametro ver <strong>setValor</strong>
	 * 
	 * @param parametro
	 *            del tipo List<Object>
	 */
	public void setValores(List<Object> valores) {
		this.valores = valores;
	}

	/**
	 * Devuelve un unico parametro enviado como parte del mensaje Si desea
	 * devolver mas de un parametro ver <strong>getValores</strong>
	 * 
	 * @return devuelve un Object
	 */
	public Object getValor() {
		return valor;
	}

	/**
	 * Asignacion de parametro que se envia como parte del mensaje. Si desea
	 * enviar mas de un parametro ver <strong>setValores</strong>
	 * 
	 * @param parametro
	 *            del tipo Object
	 */
	public void setValor(Object valor) {
		this.valor = valor;
	}

}
