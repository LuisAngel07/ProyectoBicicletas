package com.desarrollo.conexion;

import java.sql.DriverManager;

import com.mysql.jdbc.Connection;

public class ConexionMysql {

	private static Connection conn;
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String user = "root";
	private static final String password = "mysql";
	private static final String url = "jdbc:mysql://localhost:3306/bicicletasbd?characterEncoding=utf8&useConfigs=maxPerformance";

	public static void conectar() {
		conn = null;
		try {
			Class.forName(driver);
			conn = (Connection) DriverManager.getConnection(url, user, password);
			if (conn != null) {
				System.out.println("Conexión Mysql establecida");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConection() {
		if(conn==null){
			conectar();
		}
		return conn;
	}

	public void desconectar() {
		conn = null;
	}
}
