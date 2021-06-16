package com.desarrollo.bean.seguridad;

import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.desarrollo.bean.base.BaseBean;
import com.desarrollo.dominio.SessionDto;
import com.desarrollo.dominio.TecnicoDto;
import com.desarrollo.dominio.UsuarioDto;
import com.desarrollo.dominio.UsuarioPersonaDto;
import com.desarrollo.enumerador.BaseEnum.accion_solicitada;
import com.desarrollo.framework.controller.MensajeControllerGenerico;
import com.desarrollo.framework.interfaces.IMantenimientoController;
import com.desarrollo.util.UAplicacion;

@ManagedBean
@SessionScoped
public class LoginBean extends BaseBean implements IMantenimientoController {

	public String usuario;
	public String clave;
	public UsuarioDto usuarioDto;
	public UsuarioPersonaDto usuarioPersonaDto;
	public TecnicoDto tecnicoDto;

	@Override
	public String iniciarControladora() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String buscar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String nuevo() throws Exception {
		// TODO Auto-generated method stub
		setAccionPantalla(accion_solicitada.NUEVO);
		inicializarDatosMantenimiento();
		return PANTALLA_MANTENIMIENTO;
	}

	@Override
	public String editar() throws Exception {
		// TODO Auto-generated method stub
		setAccionPantalla(accion_solicitada.ACTUALIZAR);
		return PANTALLA_MANTENIMIENTO;
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
		return PANTALLA_LISTADO;
	}

	@Override
	public String salir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean validar() throws Exception {
		// TODO Auto-generated method stub
		return true;
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

	public String ingresar() throws SQLException {
		PANTALLA_BIENVENIDA = "bienvenida_interno";
		UsuarioDto obj = new UsuarioDto();
		obj.setUsuario(usuario);
		obj.setClave(clave);
		usuarioDto = getUsuarioServicio().obtener(obj);
		if (usuarioDto == null) {
			setMessageError("El usuario o la contraseña son inválidos");
			return null;
		}

		usuarioPersonaDto = getUsuarioPersonaServicio().obtenerPorUsuario(usuarioDto);
		if (usuarioPersonaDto == null) {
			setMessageError("El usuario no está relacionado a ninguna persona");
			return null;
		}

		tecnicoDto = getTecnicoServicio().ver(usuarioPersonaDto.getIdpersona());
		if (tecnicoDto == null) {
			setMessageError("No se encontraron datos de la persona");
			return null;
		}

		SessionDto sessionDto = new SessionDto();
		sessionDto.setUsuarioDto(usuarioDto);
		sessionDto.setUsuarioPersonaDto(usuarioPersonaDto);
		sessionDto.setPersonaDto(tecnicoDto);

		UAplicacion.setSessionValue("sessionDto", sessionDto);
		return PANTALLA_BIENVENIDA;
	}

	public String login() {
		return null;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	@Override
	public String descargar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
