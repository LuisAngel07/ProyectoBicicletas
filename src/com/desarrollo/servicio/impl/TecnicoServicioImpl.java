package com.desarrollo.servicio.impl;

import java.sql.SQLException;
import java.util.List;

import com.desarrollo.dao.impl.TecnicoDaoImpl;
import com.desarrollo.dominio.TecnicoDto;
import com.desarrollo.servicio.TecnicoServicio;

public class TecnicoServicioImpl implements TecnicoServicio {

	public static TecnicoServicioImpl ins;

	public static TecnicoServicioImpl getInstance() {
		if (ins == null) {
			ins = new TecnicoServicioImpl();
		}
		return ins;
	}

	@Override
	public List<TecnicoDto> listar(TecnicoDto prmLis) throws SQLException {
		// TODO Auto-generated method stub
		List<TecnicoDto> retorno;
		retorno = TecnicoDaoImpl.getInstance().listar(prmLis);
		return retorno;
	}

	@Override
	public TecnicoDto ver(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return TecnicoDaoImpl.getInstance().ver(id);
	}

	@Override
	public int insertar(TecnicoDto prmIns) throws SQLException {
		// TODO Auto-generated method stub
		return TecnicoDaoImpl.getInstance().insertar(prmIns);
	}

	@Override
	public int actualizar(TecnicoDto prmAct) throws SQLException {
		// TODO Auto-generated method stub
		return TecnicoDaoImpl.getInstance().actualizar(prmAct);
	}

	@Override
	public int eliminar(TecnicoDto prmEli) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
