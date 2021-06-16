package com.desarrollo.servicio.impl;

import java.sql.SQLException;
import java.util.List;

import com.desarrollo.dao.impl.ClienteDaoImpl;
import com.desarrollo.dominio.ClienteDto;
import com.desarrollo.servicio.ClienteServicio;

public class ClienteServicioImpl implements ClienteServicio {

	public static ClienteServicioImpl ins;

	public static ClienteServicioImpl getInstance() {
		if (ins == null) {
			ins = new ClienteServicioImpl();
		}
		return ins;
	}

	@Override
	public List<ClienteDto> listar(ClienteDto prmLis) throws SQLException {
		// TODO Auto-generated method stub
		List<ClienteDto> retorno;
		retorno = ClienteDaoImpl.getInstance().listar(prmLis);
		return retorno;
	}

	@Override
	public ClienteDto ver(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertar(ClienteDto prmIns) throws SQLException {
		// TODO Auto-generated method stub
		return ClienteDaoImpl.getInstance().insertar(prmIns);
	}

	@Override
	public int actualizar(ClienteDto prmAct) throws SQLException {
		// TODO Auto-generated method stub
		return ClienteDaoImpl.getInstance().actualizar(prmAct);
	}

	@Override
	public int eliminar(ClienteDto prmEli) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
