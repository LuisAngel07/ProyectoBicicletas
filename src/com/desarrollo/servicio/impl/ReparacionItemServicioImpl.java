package com.desarrollo.servicio.impl;

import java.sql.SQLException;
import java.util.List;

import com.desarrollo.dao.impl.ReparacionItemDaoImpl;
import com.desarrollo.dominio.ReparacionItemDto;
import com.desarrollo.servicio.ReparacionItemServicio;

public class ReparacionItemServicioImpl implements ReparacionItemServicio {

	public static ReparacionItemServicioImpl ins;

	public static ReparacionItemServicioImpl getInstance() {
		if (ins == null) {
			ins = new ReparacionItemServicioImpl();
		}
		return ins;
	}

	@Override
	public List<ReparacionItemDto> listar(ReparacionItemDto prmLis) throws Exception {
		// TODO Auto-generated method stub
		List<ReparacionItemDto> retorno;
		retorno = ReparacionItemDaoImpl.getInstance().listar(prmLis);
		return retorno;
	}

	@Override
	public ReparacionItemDto ver(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertar(ReparacionItemDto prmIns) throws SQLException {
		// TODO Auto-generated method stub
		return ReparacionItemDaoImpl.getInstance().insertar(prmIns);
	}

	@Override
	public int actualizar(ReparacionItemDto prmAct) throws SQLException {
		// TODO Auto-generated method stub
		return ReparacionItemDaoImpl.getInstance().insertar(prmAct);
	}

	@Override
	public int eliminar(ReparacionItemDto prmEli) throws SQLException {
		// TODO Auto-generated method stub
		return ReparacionItemDaoImpl.getInstance().eliminar(prmEli);
	}

}
