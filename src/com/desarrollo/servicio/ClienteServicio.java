package com.desarrollo.servicio;

import java.sql.SQLException;
import java.util.List;

import com.desarrollo.dominio.ClienteDto;

public interface ClienteServicio {

	public List<ClienteDto> listar(ClienteDto prmLis) throws SQLException;

	public ClienteDto ver(Integer id) throws SQLException;

	public int insertar(ClienteDto prmIns) throws SQLException;

	public int actualizar(ClienteDto prmAct) throws SQLException;

	public int eliminar(ClienteDto prmEli) throws SQLException;

}
