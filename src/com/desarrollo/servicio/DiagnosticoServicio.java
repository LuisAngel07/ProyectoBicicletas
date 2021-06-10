package com.desarrollo.servicio;

import java.sql.SQLException;
import java.util.List;

import com.desarrollo.dominio.DiagnosticoDto;

public interface DiagnosticoServicio {

	public List<DiagnosticoDto> listar(DiagnosticoDto prmLis) throws SQLException;

	public List<DiagnosticoDto> coincidir(String prmBus, Boolean incluirPrincipal, Boolean pintarCoincidencias)
			throws SQLException;

	public DiagnosticoDto ver(Integer id) throws SQLException;

	public int insertar(DiagnosticoDto prmIns) throws SQLException;

	public int actualizar(DiagnosticoDto prmAct) throws SQLException;

	public int eliminar(DiagnosticoDto prmEli) throws SQLException;

}
