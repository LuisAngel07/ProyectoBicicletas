package com.desarrollo.servicio;

import java.sql.SQLException;
import java.util.List;

import com.desarrollo.dominio.ReparacionDto;
import com.desarrollo.dominio.SolicitudReparacionDto;

public interface ReparacionServicio {

	public List<ReparacionDto> listar(ReparacionDto prmLis) throws Exception;

	public List<SolicitudReparacionDto> listarSolicitudes(ReparacionDto prmLis) throws Exception;

	public ReparacionDto ver(Integer id) throws Exception;

	public int insertar(ReparacionDto prmIns) throws SQLException;

	public int actualizar(ReparacionDto prmAct) throws SQLException;

	public int eliminar(ReparacionDto prmEli) throws SQLException;

}
