package com.desarrollo.servicio.impl;

import java.sql.SQLException;
import java.util.List;

import com.desarrollo.dao.impl.ClienteDaoImpl;
import com.desarrollo.dao.impl.MarcaDaoImpl;
import com.desarrollo.dao.impl.ModeloDaoImpl;
import com.desarrollo.dao.impl.ReparacionDaoImpl;
import com.desarrollo.dao.impl.ReparacionItemDaoImpl;
import com.desarrollo.dao.impl.TecnicoDaoImpl;
import com.desarrollo.dao.impl.UbigeoDaoImpl;
import com.desarrollo.dominio.MarcaDto;
import com.desarrollo.dominio.ModeloDto;
import com.desarrollo.dominio.ReparacionDto;
import com.desarrollo.dominio.ReparacionItemDto;
import com.desarrollo.dominio.SolicitudReparacionDto;
import com.desarrollo.dominio.UbigeoDto;
import com.desarrollo.servicio.ReparacionServicio;

public class ReparacionServicioImpl implements ReparacionServicio {

	public static ReparacionServicioImpl ins;

	public static ReparacionServicioImpl getInstance() {
		if (ins == null) {
			ins = new ReparacionServicioImpl();
		}
		return ins;
	}

	@Override
	public List<ReparacionDto> listar(ReparacionDto prmLis) throws Exception {
		// TODO Auto-generated method stub
		List<ReparacionDto> retorno;
		retorno = ReparacionDaoImpl.getInstance().listar(prmLis);
		return retorno;
	}

	@Override
	public ReparacionDto ver(Integer id) throws Exception {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public int insertar(ReparacionDto prmIns) throws SQLException {
		// TODO Auto-generated method stub
		int retorno = ReparacionDaoImpl.getInstance().insertar(prmIns);

		// registramos los items de la reparacion
		if (prmIns.getLstItems() != null) {
			for (ReparacionItemDto obj : prmIns.getLstItems()) {
				obj.setIdreparacion(retorno);
				retorno = ReparacionItemDaoImpl.getInstance().insertar(obj);
			}
		}

		return retorno;
	}

	@Override
	public int actualizar(ReparacionDto prmAct) throws SQLException {
		// TODO Auto-generated method stub
		return ReparacionDaoImpl.getInstance().actualizar(prmAct);
	}

	@Override
	public int eliminar(ReparacionDto prmEli) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<SolicitudReparacionDto> listarSolicitudes(ReparacionDto prmLis) throws Exception {
		// TODO Auto-generated method stub
		List<SolicitudReparacionDto> retorno;
		retorno = ReparacionDaoImpl.getInstance().listarSolicitudes(prmLis);
		return retorno;
	}

}
