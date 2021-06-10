package com.desarrollo.dao;

import java.sql.SQLException;
import java.util.List;

import com.desarrollo.dominio.UsuarioDto;
import com.desarrollo.dominio.UsuarioPersonaDto;

public interface UsuarioPersonaDao {

	public List<UsuarioPersonaDto> listar(UsuarioPersonaDto prmLis) throws SQLException;

	public UsuarioPersonaDto ver(Integer codigo) throws SQLException;

	public UsuarioPersonaDto obtenerPorUsuario(UsuarioDto prmObj) throws SQLException;

	public int insertar(UsuarioPersonaDto prmIns) throws SQLException;

	public int actualizar(UsuarioPersonaDto prmAct) throws SQLException;

	public int eliminar(UsuarioPersonaDto prmEli) throws SQLException;

}
