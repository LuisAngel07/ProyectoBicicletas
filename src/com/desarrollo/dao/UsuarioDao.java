package com.desarrollo.dao;

import java.sql.SQLException;
import java.util.List;

import com.desarrollo.dominio.UsuarioDto;

public interface UsuarioDao {

	public List<UsuarioDto> listar(UsuarioDto prmLis) throws SQLException;

	public UsuarioDto ver(Integer codigo) throws SQLException;

	public UsuarioDto obtener(UsuarioDto prmObj) throws SQLException;

	public int insertar(UsuarioDto prmIns) throws SQLException;

	public int actualizar(UsuarioDto prmAct) throws SQLException;

	public int eliminar(UsuarioDto prmEli) throws SQLException;

}
