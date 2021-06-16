package com.desarrollo.dao;

import java.sql.SQLException;
import java.util.List;

import com.desarrollo.dominio.MarcaDto;

public interface MarcaDao {

	public List<MarcaDto> listar(MarcaDto prmLis) throws SQLException;

	public MarcaDto ver(Integer codigo) throws SQLException;

	public int insertar(MarcaDto prmIns) throws SQLException;

	public int actualizar(MarcaDto prmAct) throws SQLException;

	public int eliminar(MarcaDto prmEli) throws SQLException;

}
