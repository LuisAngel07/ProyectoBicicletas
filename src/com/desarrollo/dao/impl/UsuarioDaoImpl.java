package com.desarrollo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.desarrollo.dao.UsuarioDao;
import com.desarrollo.dominio.UsuarioDto;

public class UsuarioDaoImpl extends BaseDaoImpl implements UsuarioDao {

	public static UsuarioDaoImpl ins;

	public static UsuarioDaoImpl getInstance() {
		if (ins == null) {
			ins = new UsuarioDaoImpl();
		}
		return ins;
	}

	@Override
	public List<UsuarioDto> listar(UsuarioDto prmLis) throws SQLException {
		// TODO Auto-generated method stub
		List<UsuarioDto> retorno = new ArrayList<>();
		String query = "select id, usuario, clave, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion from tb_Cliente where 1=1";

		if (prmLis.getUsuario() != null) {
			query = query + " and usuario = '" + prmLis.getUsuario() + "'";
		}
		if (prmLis.getEstado() != null) {
			query = query + " and estado = '" + prmLis.getEstado() + "'";
		}

		ResultSet rs = super.listar(query);

		while (rs.next()) {
			UsuarioDto objNew = new UsuarioDto();
			objNew.setId(rs.getInt("id"));
			objNew.setUsuario(rs.getString("usuario"));
			objNew.setClave(rs.getString("clave"));
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
	public UsuarioDto ver(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertar(UsuarioDto prmIns) throws SQLException {
		// TODO Auto-generated method stub
		return 0;

	}

	@Override
	public int actualizar(UsuarioDto prmAct) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminar(UsuarioDto prmEli) throws SQLException {
		// TODO Auto-generated method stub
		int retorno = 0;
		return retorno;
	}

	@Override
	public UsuarioDto obtener(UsuarioDto prmObj) throws SQLException {
		// TODO Auto-generated method stub
		UsuarioDto retorno = null;
		String query = "select id, usuario, clave, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion from tb_usuario where 1=1";

		if (prmObj.getUsuario() != null) {
			query = query + " and usuario = '" + prmObj.getUsuario() + "'";
		}
		if (prmObj.getClave() != null) {
			query = query + " and clave = '" + prmObj.getClave() + "'";
		}
		if (prmObj.getEstado() != null) {
			query = query + " and estado = '" + prmObj.getEstado() + "'";
		}

		ResultSet rs = super.listar(query);

		while (rs.next()) {
			UsuarioDto objNew = new UsuarioDto();
			objNew.setId(rs.getInt("id"));
			objNew.setUsuario(rs.getString("usuario"));
			objNew.setClave(rs.getString("clave"));
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
