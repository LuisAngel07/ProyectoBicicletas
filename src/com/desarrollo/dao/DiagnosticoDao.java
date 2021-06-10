package com.desarrollo.dao;

import java.sql.SQLException;
import java.util.List;

import com.desarrollo.dominio.DiagnosticoDto;

public interface DiagnosticoDao {

	public List<DiagnosticoDto> listar(DiagnosticoDto prmLis) throws SQLException;

	public DiagnosticoDto ver(Integer codigo) throws SQLException;

	public int insertar(DiagnosticoDto prmIns) throws SQLException;

	public int actualizar(DiagnosticoDto prmAct) throws SQLException;

	public int eliminar(DiagnosticoDto prmEli) throws SQLException;
	
	public List<DiagnosticoDto> coincidir(String prmBus) throws SQLException;

}
