package com.desarrollo.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface BaseDao {

	public ResultSet listar(String sentencia) throws SQLException;

	public PreparedStatement preparar(String sentencia) throws SQLException;

}
