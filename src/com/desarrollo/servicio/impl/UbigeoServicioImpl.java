package com.desarrollo.servicio.impl;

import java.sql.SQLException;
import java.util.List;

import com.desarrollo.dao.impl.ClienteDaoImpl;
import com.desarrollo.dao.impl.UbigeoDaoImpl;
import com.desarrollo.dominio.UbigeoDto;
import com.desarrollo.servicio.UbigeoServicio;

public class UbigeoServicioImpl implements UbigeoServicio {

	public static UbigeoServicioImpl ins;

	public static UbigeoServicioImpl getInstance() {
		if (ins == null) {
			ins = new UbigeoServicioImpl();
		}
		return ins;
	}

	@Override
	public List<UbigeoDto> listar(UbigeoDto prmLis) throws SQLException {
		// TODO Auto-generated method stub
		List<UbigeoDto> retorno;
		retorno = UbigeoDaoImpl.getInstance().listar(prmLis);
		return retorno;
	}

	@Override
	public UbigeoDto ver(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertar(UbigeoDto prmIns) throws SQLException {
		// TODO Auto-generated method stub
		return UbigeoDaoImpl.getInstance().insertar(prmIns);
	}

	@Override
	public int actualizar(UbigeoDto prmAct) throws SQLException {
		// TODO Auto-generated method stub
		return UbigeoDaoImpl.getInstance().actualizar(prmAct);
	}

	@Override
	public int eliminar(UbigeoDto prmEli) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<UbigeoDto> listarDepartamentos(UbigeoDto prmLis) throws SQLException {
		// TODO Auto-generated method stub
		return UbigeoDaoImpl.getInstance().listarDepartamentos(prmLis);
	}

	@Override
	public List<UbigeoDto> listarProvincias(UbigeoDto prmLis) throws SQLException {
		// TODO Auto-generated method stub
		return UbigeoDaoImpl.getInstance().listarProvincias(prmLis);
	}

	@Override
	public List<UbigeoDto> listarDistritos(UbigeoDto prmLis) throws SQLException {
		// TODO Auto-generated method stub
		return UbigeoDaoImpl.getInstance().listarDistritos(prmLis);
	}

}
