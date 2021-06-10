package com.desarrollo.servicio.impl;

import java.sql.SQLException;
import java.util.List;

import com.desarrollo.dao.impl.UsuarioPersonaDaoImpl;
import com.desarrollo.dominio.UsuarioDto;
import com.desarrollo.dominio.UsuarioPersonaDto;
import com.desarrollo.servicio.UsuarioPersonaServicio;

public class UsuarioPersonaServicioImpl implements UsuarioPersonaServicio {

	public static UsuarioPersonaServicioImpl ins;

	public static UsuarioPersonaServicioImpl getInstance() {
		if (ins == null) {
			ins = new UsuarioPersonaServicioImpl();
		}
		return ins;
	}

	@Override
	public List<UsuarioPersonaDto> listar(UsuarioPersonaDto prmLis) throws SQLException {
		// TODO Auto-generated method stub
		List<UsuarioPersonaDto> retorno;
		retorno = UsuarioPersonaDaoImpl.getInstance().listar(prmLis);
		return retorno;
	}

	@Override
	public UsuarioPersonaDto ver(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertar(UsuarioPersonaDto prmIns) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int actualizar(UsuarioPersonaDto prmAct) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminar(UsuarioPersonaDto prmEli) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UsuarioPersonaDto obtenerPorUsuario(UsuarioDto prmObj) throws SQLException {
		// TODO Auto-generated method stub
		UsuarioPersonaDto retorno;
		retorno = UsuarioPersonaDaoImpl.getInstance().obtenerPorUsuario(prmObj);
		return retorno;
	}

}
