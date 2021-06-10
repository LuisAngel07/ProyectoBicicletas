package com.desarrollo.servicio.impl;

import java.sql.SQLException;
import java.util.List;

import com.desarrollo.dao.impl.UsuarioDaoImpl;
import com.desarrollo.dominio.UsuarioDto;
import com.desarrollo.servicio.UsuarioServicio;

public class UsuarioServicioImpl implements UsuarioServicio {

	public static UsuarioServicioImpl ins;

	public static UsuarioServicioImpl getInstance() {
		if (ins == null) {
			ins = new UsuarioServicioImpl();
		}
		return ins;
	}

	@Override
	public List<UsuarioDto> listar(UsuarioDto prmLis) throws SQLException {
		// TODO Auto-generated method stub
		List<UsuarioDto> retorno;
		retorno = UsuarioDaoImpl.getInstance().listar(prmLis);
		return retorno;
	}

	@Override
	public UsuarioDto ver(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertar(UsuarioDto prmIns) throws SQLException {
		// TODO Auto-generated method stub
		return UsuarioDaoImpl.getInstance().insertar(prmIns);
	}

	@Override
	public int actualizar(UsuarioDto prmAct) throws SQLException {
		// TODO Auto-generated method stub
		return UsuarioDaoImpl.getInstance().actualizar(prmAct);
	}

	@Override
	public int eliminar(UsuarioDto prmEli) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UsuarioDto obtener(UsuarioDto prmObj) throws SQLException {
		// TODO Auto-generated method stub
		UsuarioDto retorno;
		retorno = UsuarioDaoImpl.getInstance().obtener(prmObj);
		return retorno;
	}

}
