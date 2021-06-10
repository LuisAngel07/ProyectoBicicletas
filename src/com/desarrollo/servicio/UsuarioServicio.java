package com.desarrollo.servicio;

import java.sql.SQLException;
import java.util.List;

import com.desarrollo.dominio.UsuarioDto;

public interface UsuarioServicio {

	public List<UsuarioDto> listar(UsuarioDto prmLis) throws SQLException;

	public UsuarioDto obtener(UsuarioDto prmObj) throws SQLException;

	public UsuarioDto ver(Integer id) throws SQLException;

	public int insertar(UsuarioDto prmIns) throws SQLException;

	public int actualizar(UsuarioDto prmAct) throws SQLException;

	public int eliminar(UsuarioDto prmEli) throws SQLException;

}
