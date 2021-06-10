package com.desarrollo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.desarrollo.conexion.Conexion;
import com.desarrollo.dao.BaseDao;
import com.desarrollo.enumerador.BaseEnum.proveedor_bd;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class BaseDaoImpl implements BaseDao{

	@Override
	public ResultSet listar(String sentencia) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = Conexion.getConnection(proveedor_bd.MYSQL);
		PreparedStatement ps;
		ResultSet rs;
		ps = (PreparedStatement) conn.prepareStatement(sentencia);
		rs = ps.executeQuery();
		return rs;
	}

	@Override
	public PreparedStatement preparar(String sentencia) throws SQLException {
		// TODO Auto-generated method stub
		Connection conn = Conexion.getConnection(proveedor_bd.MYSQL);
		PreparedStatement ps = (PreparedStatement) conn.prepareStatement(sentencia);
		return ps;
	}

}
