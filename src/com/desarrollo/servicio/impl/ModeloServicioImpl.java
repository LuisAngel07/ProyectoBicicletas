package com.desarrollo.servicio.impl;

import java.sql.SQLException;
import java.util.List;

import com.desarrollo.dao.impl.MarcaDaoImpl;
import com.desarrollo.dao.impl.ModeloDaoImpl;
import com.desarrollo.dominio.ModeloDto;
import com.desarrollo.servicio.ModeloServicio;

public class ModeloServicioImpl implements ModeloServicio {

	public static ModeloServicioImpl ins;

	public static ModeloServicioImpl getInstance() {
		if (ins == null) {
			ins = new ModeloServicioImpl();
		}
		return ins;
	}

	@Override
	public List<ModeloDto> listar(ModeloDto prmLis) throws SQLException {
		// TODO Auto-generated method stub
		List<ModeloDto> retorno;
		retorno = ModeloDaoImpl.getInstance().listar(prmLis);
		return retorno;
	}

	@Override
	public ModeloDto ver(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertar(ModeloDto prmIns) throws SQLException {
		// TODO Auto-generated method stub
		return ModeloDaoImpl.getInstance().insertar(prmIns);
	}

	@Override
	public int actualizar(ModeloDto prmAct) throws SQLException {
		// TODO Auto-generated method stub
		return ModeloDaoImpl.getInstance().actualizar(prmAct);
	}

	@Override
	public int eliminar(ModeloDto prmEli) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
