package com.desarrollo.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.context.RequestContext;

import com.desarrollo.bean.base.BaseBean;
import com.desarrollo.dominio.ClienteDto;
import com.desarrollo.enumerador.BaseEnum.accion_solicitada;
import com.desarrollo.framework.controller.MensajeControllerGenerico;
import com.desarrollo.framework.interfaces.IMantenimientoController;

@ManagedBean
@SessionScoped
public class ClienteBean extends BaseBean implements IMantenimientoController {

	private ClienteDto clienteDto;
	private Boolean habilitarDatos;
	private Boolean mostrarCliente;

	@Override
	public String iniciarControladora() throws Exception {
		// TODO Auto-generated method stub
		clienteDto = new ClienteDto();
		habilitarDatos = false;
		RequestContext.getCurrentInstance().execute("PF('popDatosPersona').show();");
		RequestContext.getCurrentInstance().update("dgDatosPersona");
		return null;
	}

	@Override
	public String buscar() throws Exception {
		// TODO Auto-generated method stub
		if (clienteDto.getDocumento() == null || clienteDto.getDocumento() == "") {
			clienteDto = new ClienteDto();
			habilitarDatos = false;
			return null;
		}

		List<ClienteDto> lstCliente = getClienteServicio().listar(clienteDto);
		if (lstCliente != null) {
			if (lstCliente.size() > 0) {
				clienteDto = lstCliente.get(0);
				editar();
			} else {
				String documento = clienteDto.getDocumento();
				clienteDto = new ClienteDto();
				clienteDto.setDocumento(documento);
				nuevo();
			}
		} else {
			String documento = clienteDto.getDocumento();
			clienteDto = new ClienteDto();
			clienteDto.setDocumento(documento);
			nuevo();
		}
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
		// TODO Auto-generated method stub
		if (getAccionPantalla().equals(accion_solicitada.NUEVO)) {
			clienteDto.setEstado("A");
			clienteDto.setUsuario_creacion(clienteDto.getDocumento());
			getClienteServicio().insertar(clienteDto);
			mostrarCliente = false;
			setMessageSuccess("Se registraron sus datos correctamente");
		}
		if (getAccionPantalla().equals(accion_solicitada.EDITAR)) {
			clienteDto.setUsuario_modificacion(clienteDto.getDocumento());
			getClienteServicio().actualizar(clienteDto);
			mostrarCliente = false;
			setMessageSuccess("Se actualizaron sus datos correctamente");
		}

		// devolvemos el objeto al bean que invocador
		MensajeControllerGenerico mensajeGenerico = new MensajeControllerGenerico();
		mensajeGenerico.setAccionTag("obtenerCliente");
		mensajeGenerico.setValor(clienteDto);
		this.getBean().mensaje(mensajeGenerico);

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
	public String mensaje(MensajeControllerGenerico mensajeControllerGenerico) throws Exception {
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

	public ClienteDto getClienteDto() {
		return clienteDto;
	}

	public void setClienteDto(ClienteDto clienteDto) {
		this.clienteDto = clienteDto;
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
