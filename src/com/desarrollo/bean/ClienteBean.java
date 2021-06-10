package com.desarrollo.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.context.RequestContext;

import com.desarrollo.bean.base.BaseBean;
import com.desarrollo.enumerador.BaseEnum.accion_solicitada;
import com.desarrollo.framework.interfaces.IMantenimientoController;

@ManagedBean
@SessionScoped
public class ClienteBean extends BaseBean implements IMantenimientoController {

	private Boolean habilitarDatos;
	private Boolean mostrarCliente;

	@Override
	public String iniciarControladora() throws Exception {
		// TODO Auto-generated method stub
		habilitarDatos = false;
		RequestContext.getCurrentInstance().execute("PF('popDatosPersona').show();");
		RequestContext.getCurrentInstance().update("dgDatosPersona");
		return null;
	}

	@Override
	public String buscar() throws Exception {
		// TODO Auto-generated method stub
		habilitarDatos = true;
		return null;
	}

	@Override
	public String nuevo() throws Exception {
		// TODO Auto-generated method stub
		setAccionPantalla(accion_solicitada.NUEVO);
		return null;
	}

	@Override
	public String editar() throws Exception {
		// TODO Auto-generated method stub
		setAccionPantalla(accion_solicitada.EDITAR);
		return null;
	}

	@Override
	public String ver() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String eliminar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String inactivar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String ejecutar(String accion) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String guardar() throws Exception {

		RequestContext.getCurrentInstance().execute("PF('popDatosPersona').hide();");
		return null;
	}

	@Override
	public String salir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean validar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String inicializarFiltrosListado() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String inicializarDatosMantenimiento() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean getHabilitarDatos() {
		return habilitarDatos;
	}

	public void setHabilitarDatos(Boolean habilitarDatos) {
		this.habilitarDatos = habilitarDatos;
	}

	public Boolean getMostrarCliente() {
		return mostrarCliente;
	}

	public void setMostrarCliente(Boolean mostrarCliente) {
		this.mostrarCliente = mostrarCliente;
	}

	@Override
	public String descargar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
