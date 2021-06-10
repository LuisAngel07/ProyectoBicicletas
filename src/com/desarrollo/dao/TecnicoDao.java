package com.desarrollo.dao;

import java.sql.SQLException;
import java.util.List;

import com.desarrollo.dominio.TecnicoDto;

public interface TecnicoDao {

	public List<TecnicoDto> listar(TecnicoDto prmLis) throws SQLException;

	public TecnicoDto ver(Integer codigo) throws SQLException;

	public int insertar(TecnicoDto prmIns) throws SQLException;

	public int actualizar(TecnicoDto prmAct) throws SQLException;

	public int eliminar(TecnicoDto prmEli) throws SQLException;
	
}
