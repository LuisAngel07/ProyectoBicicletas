package com.desarrollo.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.desarrollo.dao.ReparacionItemDao;
import com.desarrollo.dominio.ReparacionItemDto;

public class ReparacionItemDaoImpl extends BaseDaoImpl implements ReparacionItemDao {

	public static ReparacionItemDaoImpl ins;

	public static ReparacionItemDaoImpl getInstance() {
		if (ins == null) {
			ins = new ReparacionItemDaoImpl();
		}
		return ins;
	}

	@Override
	public List<ReparacionItemDto> listar(ReparacionItemDto prmLis) throws Exception {
		// TODO Auto-generated method stub
		List<ReparacionItemDto> retorno = new ArrayList<>();
		String query = "SELECT id, id_reparacion, id_marca, id_modelo, descripcion, archivo, archivo_nombre, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion FROM bicicletasbd.tb_reparacion_item where 1=1";

		if (prmLis.getIdreparacion() != null) {
			query = query + " and id_reparacion = '" + prmLis.getIdreparacion() + "'";
		}
		if (prmLis.getIdmarca() != null) {
			query = query + " and id_marca = '" + prmLis.getIdmarca() + "'";
		}
		if (prmLis.getIdmodelo() != null) {
			query = query + " and id_modelo = '" + prmLis.getIdmodelo() + "'";
		}

		ResultSet rs = super.listar(query);

		while (rs.next()) {
			ReparacionItemDto objNew = new ReparacionItemDto();
			objNew.setId(rs.getInt("id"));
			objNew.setIdreparacion(rs.getInt("id_reparacion"));
			objNew.setIdmarca(rs.getInt("id_marca"));
			objNew.setIdmodelo(rs.getInt("id_modelo"));
			objNew.setDescripcion(rs.getString("descripcion"));
			objNew.setArchivo(rs.getBytes("archivo"));
			objNew.setArchivonombre(rs.getString("archivo_nombre"));
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
	public ReparacionItemDto ver(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertar(ReparacionItemDto prmIns) throws SQLException {
		// TODO Auto-generated method stub
		int retorno;
		PreparedStatement ps = preparar(
				"INSERT INTO tb_reparacion_item ( id_reparacion, id_marca, id_modelo, descripcion, archivo, archivo_nombre, estado, usuario_creacion, fecha_creacion) values(?,?,?,?,?,?,?,?,sysdate())");
		ps.setInt(1, prmIns.getIdreparacion());
		ps.setInt(2, prmIns.getIdmarca());
		ps.setInt(3, prmIns.getIdmodelo());
		ps.setString(4, prmIns.getDescripcion());
		ps.setBytes(5, prmIns.getArchivo());
		ps.setString(6, prmIns.getArchivonombre());
		ps.setString(7, prmIns.getEstado());
		ps.setString(8, prmIns.getUsuario_creacion());

		retorno = ps.executeUpdate();
		return retorno;

	}

	@Override
	public int actualizar(ReparacionItemDto prmAct) throws SQLException {
		// TODO Auto-generated method stub
		int retorno = 0;
		return retorno;
	}

	@Override
	public int eliminar(ReparacionItemDto prmEli) throws SQLException {
		// TODO Auto-generated method stub
		int retorno;
		PreparedStatement ps = preparar("delete from tb_reparacion_item where id = ?");
		ps.setInt(1, prmEli.getId());

		retorno = ps.executeUpdate();
		return retorno;
	}

}
