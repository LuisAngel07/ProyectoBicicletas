package com.desarrollo.conexion;

import com.desarrollo.enumerador.BaseEnum.proveedor_bd;
import com.mysql.jdbc.Connection;

public class Conexion {

	public static Connection getConnection(proveedor_bd prBd) {
		Connection conn = null;
		if (prBd == proveedor_bd.MYSQL) {
			conn = ConexionMysql.getConection();
		}
		return conn;
	}

}
