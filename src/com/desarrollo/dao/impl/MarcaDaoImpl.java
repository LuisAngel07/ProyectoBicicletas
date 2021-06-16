package com.desarrollo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.desarrollo.dao.MarcaDao;
import com.desarrollo.dominio.MarcaDto;

public class MarcaDaoImpl extends BaseDaoImpl implements MarcaDao {

	public static MarcaDaoImpl ins;

	public static MarcaDaoImpl getInstance() {
		if (ins == null) {
			ins = new MarcaDaoImpl();
		}
		return ins;
	}

	@Override
	public List<MarcaDto> listar(MarcaDto prmLis) throws SQLException {
		// TODO Auto-generated method stub
		List<MarcaDto> retorno = new ArrayList<>();
		String query = "select id, nombre, descripcion, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion from tb_marca where 1=1";

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
			MarcaDto objNew = new MarcaDto();
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
	public MarcaDto ver(Integer id) throws SQLException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertar(MarcaDto prmIns) throws SQLException {
		// TODO Auto-generated method stub
		return 0;

	}

	@Override
	public int actualizar(MarcaDto prmAct) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminar(MarcaDto prmEli) throws SQLException {
		// TODO Auto-generated method stub
		int retorno = 0;
		return retorno;
	}

}
