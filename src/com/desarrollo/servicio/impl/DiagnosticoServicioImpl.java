package com.desarrollo.servicio.impl;

import java.sql.SQLException;
import java.util.List;

import com.desarrollo.dao.impl.DiagnosticoDaoImpl;
import com.desarrollo.dominio.DiagnosticoDto;
import com.desarrollo.servicio.DiagnosticoServicio;

public class DiagnosticoServicioImpl implements DiagnosticoServicio {

	public static DiagnosticoServicioImpl ins;

	public static DiagnosticoServicioImpl getInstance() {
		if (ins == null) {
			ins = new DiagnosticoServicioImpl();
		}
		return ins;
	}

	@Override
	public List<DiagnosticoDto> listar(DiagnosticoDto prmLis) throws SQLException {
		// TODO Auto-generated method stub
		List<DiagnosticoDto> retorno;
		retorno = DiagnosticoDaoImpl.getInstance().listar(prmLis);
		return retorno;
	}

	@Override
	public DiagnosticoDto ver(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertar(DiagnosticoDto prmIns) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int actualizar(DiagnosticoDto prmAct) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminar(DiagnosticoDto prmEli) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<DiagnosticoDto> coincidir(String prmBus, Boolean incluirPrincipal, Boolean pintarCoincidencias)
			throws SQLException {
		// TODO Auto-generated method stub
		List<DiagnosticoDto> retorno;
		retorno = DiagnosticoDaoImpl.getInstance().coincidir(prmBus);

		// fijamos el diagnostico principal
		if (incluirPrincipal) {
			retorno = DiagnosticoDto.setPrincipal(retorno, prmBus);
		}
		if (pintarCoincidencias) {
			retorno = DiagnosticoDto.setHtml(retorno, prmBus);
		}

		return retorno;
	}

}
