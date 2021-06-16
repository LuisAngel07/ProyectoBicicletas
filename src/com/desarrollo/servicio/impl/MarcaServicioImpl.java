package com.desarrollo.servicio.impl;

import java.sql.SQLException;
import java.util.List;

import com.desarrollo.dao.impl.MarcaDaoImpl;
import com.desarrollo.dominio.MarcaDto;
import com.desarrollo.servicio.MarcaServicio;

public class MarcaServicioImpl implements MarcaServicio {

	public static MarcaServicioImpl ins;

	public static MarcaServicioImpl getInstance() {
		if (ins == null) {
			ins = new MarcaServicioImpl();
		}
		return ins;
	}

	@Override
	public List<MarcaDto> listar(MarcaDto prmLis) throws SQLException {
		// TODO Auto-generated method stub
		List<MarcaDto> retorno;
		retorno = MarcaDaoImpl.getInstance().listar(prmLis);
		return retorno;
	}

	@Override
	public MarcaDto ver(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertar(MarcaDto prmIns) throws SQLException {
		// TODO Auto-generated method stub
		return MarcaDaoImpl.getInstance().insertar(prmIns);
	}

	@Override
	public int actualizar(MarcaDto prmAct) throws SQLException {
		// TODO Auto-generated method stub
		return MarcaDaoImpl.getInstance().actualizar(prmAct);
	}

	@Override
	public int eliminar(MarcaDto prmEli) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
