package com.desarrollo.servicio;

import java.sql.SQLException;
import java.util.List;

import com.desarrollo.dominio.ReparacionItemDto;

public interface ReparacionItemServicio {

	public List<ReparacionItemDto> listar(ReparacionItemDto prmLis) throws Exception;

	public ReparacionItemDto ver(Integer id) throws SQLException;

	public int insertar(ReparacionItemDto prmIns) throws SQLException;

	public int actualizar(ReparacionItemDto prmAct) throws SQLException;

	public int eliminar(ReparacionItemDto prmEli) throws SQLException;

}
