package com.desarrollo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.desarrollo.dao.ModeloDao;
import com.desarrollo.dominio.ModeloDto;

public class ModeloDaoImpl extends BaseDaoImpl implements ModeloDao {

	public static ModeloDaoImpl ins;

	public static ModeloDaoImpl getInstance() {
		if (ins == null) {
			ins = new ModeloDaoImpl();
		}
		return ins;
	}

	@Override
	public List<ModeloDto> listar(ModeloDto prmLis) throws SQLException {
		// TODO Auto-generated method stub
		List<ModeloDto> retorno = new ArrayList<>();
		String query = "select id, nombre, descripcion, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion from tb_modelo where 1=1";

		if (prmLis.getNombre() != null) {
			query = query + " and MATCH(nombre) AGAINST ('" + prmLis.getNombre() + "' IN BOOLEAN MODE)";
		}
		if (prmLis.getDescripcion() != null) {
			query = query + " and MATCH(descripcion) AGAINST ('" + prmLis.getDescripcion() + "' IN BOOLEAN MODE)";
		}
		if (prmLis.getEstado() != null) {
			query = query + " and estado = '" + prmLis.getEstado() + "'";
		}

		ResultSet rs = super.listar(query);

		while (rs.next()) {
			ModeloDto objNew = new ModeloDto();
			objNew.setId(rs.getInt("id"));
			objNew.setNombre(rs.getString("nombre"));
			objNew.setDescripcion(rs.getString("descripcion"));
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
	public ModeloDto ver(Integer id)throws SQLException {
		return null;

	}

	@Override
	public int insertar(ModeloDto prmIns) throws SQLException {
		// TODO Auto-generated method stub
		return 0;

	}

	@Override
	public int actualizar(ModeloDto prmAct) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminar(ModeloDto prmEli) throws SQLException {
		// TODO Auto-generated method stub
		int retorno = 0;
		return retorno;
	}

}
