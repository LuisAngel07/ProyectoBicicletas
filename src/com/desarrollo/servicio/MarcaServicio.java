package com.desarrollo.servicio;

import java.sql.SQLException;
import java.util.List;

import com.desarrollo.dominio.MarcaDto;

public interface MarcaServicio {

	public List<MarcaDto> listar(MarcaDto prmLis) throws SQLException;

	public MarcaDto ver(Integer id) throws SQLException;

	public int insertar(MarcaDto prmIns) throws SQLException;

	public int actualizar(MarcaDto prmAct) throws SQLException;

	public int eliminar(MarcaDto prmEli) throws SQLException;

}
