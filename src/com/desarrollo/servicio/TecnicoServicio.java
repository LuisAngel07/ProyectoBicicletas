package com.desarrollo.servicio;

import java.sql.SQLException;
import java.util.List;

import com.desarrollo.dominio.TecnicoDto;

public interface TecnicoServicio {

	public List<TecnicoDto> listar(TecnicoDto prmLis) throws SQLException;

	public TecnicoDto ver(Integer id) throws SQLException;

	public int insertar(TecnicoDto prmIns) throws SQLException;

	public int actualizar(TecnicoDto prmAct) throws SQLException;

	public int eliminar(TecnicoDto prmEli) throws SQLException;

}
