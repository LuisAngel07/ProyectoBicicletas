package com.desarrollo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.desarrollo.dao.UsuarioPersonaDao;
import com.desarrollo.dominio.UsuarioDto;
import com.desarrollo.dominio.UsuarioPersonaDto;

public class UsuarioPersonaDaoImpl extends BaseDaoImpl implements UsuarioPersonaDao {

	public static UsuarioPersonaDaoImpl ins;

	public static UsuarioPersonaDaoImpl getInstance() {
		if (ins == null) {
			ins = new UsuarioPersonaDaoImpl();
		}
		return ins;
	}

	@Override
	public List<UsuarioPersonaDto> listar(UsuarioPersonaDto prmLis) throws SQLException {
		// TODO Auto-generated method stub
		List<UsuarioPersonaDto> retorno = new ArrayList<>();
		String query = "select id, id_persona, id_usuario, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion from tb_usuario_persona where 1=1";

		if (prmLis.getIdpersona() != null) {
			query = query + " and id_persona = " + prmLis.getIdpersona() + "";
		}
		if (prmLis.getIdusuario() != null) {
			query = query + " and id_usuario = " + prmLis.getIdusuario() + "";
		}
		if (prmLis.getIdusuario() != null) {
			query = query + " and estado = '" + prmLis.getEstado() + "'";
		}

		ResultSet rs = super.listar(query);

		while (rs.next()) {
			UsuarioPersonaDto objNew = new UsuarioPersonaDto();
			objNew.setId(rs.getInt("id"));
			objNew.setIdpersona(rs.getInt("id_persona"));
			objNew.setIdusuario(rs.getInt("id_usuario"));
			objNew.setEstado(rs.getString("estado"));
			objNew.setUsuario_creacion(rs.getString("usuario_creacion"));
			objNew.setFecha_creacion(rs.getDate("fecha_creacion"));
			objNew.setUsuario_modificacion(rs.getString("usuario_modificacion"));
			objNew.setFecha_modificacion(rs.getDate("fecha_modificacion"));
			retorno.add(objNew);
		}

		return retorno;
	}

	@Override
	public UsuarioPersonaDto ver(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertar(UsuarioPersonaDto prmIns) throws SQLException {
		// TODO Auto-generated method stub
		return 0;

	}

	@Override
	public int actualizar(UsuarioPersonaDto prmAct) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminar(UsuarioPersonaDto prmEli) throws SQLException {
		// TODO Auto-generated method stub
		int retorno = 0;
		return retorno;
	}

	@Override
	public UsuarioPersonaDto obtenerPorUsuario(UsuarioDto prmObj) throws SQLException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		UsuarioPersonaDto retorno = null;
		String query = "select id, id_persona, id_usuario, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion from tb_usuario_persona where 1=1";

		if (prmObj.getId() != null) {
			query = query + " and id_usuario = " + prmObj.getId() + "";
		}

		ResultSet rs = super.listar(query);

		while (rs.next()) {
			UsuarioPersonaDto objNew = new UsuarioPersonaDto();
			objNew.setId(rs.getInt("id"));
			objNew.setIdpersona(rs.getInt("id_persona"));
			objNew.setIdusuario(rs.getInt("id_usuario"));
			objNew.setEstado(rs.getString("estado"));
			objNew.setUsuario_creacion(rs.getString("usuario_creacion"));
			objNew.setFecha_creacion(rs.getDate("fecha_creacion"));
			objNew.setUsuario_modificacion(rs.getString("usuario_modificacion"));
			objNew.setFecha_modificacion(rs.getDate("fecha_modificacion"));
			retorno = objNew;
		}

		return retorno;
	}

}
