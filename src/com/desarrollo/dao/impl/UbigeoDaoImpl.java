package com.desarrollo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.desarrollo.dao.UbigeoDao;
import com.desarrollo.dominio.UbigeoDto;

public class UbigeoDaoImpl extends BaseDaoImpl implements UbigeoDao {

	public static UbigeoDaoImpl ins;

	public static UbigeoDaoImpl getInstance() {
		if (ins == null) {
			ins = new UbigeoDaoImpl();
		}
		return ins;
	}

	@Override
	public List<UbigeoDto> listar(UbigeoDto prmLis) throws SQLException {
		// TODO Auto-generated method stub
		List<UbigeoDto> retorno = new ArrayList<>();
		String query = "select id, codigodepartamento, codigoprovincia, codigodistrito, nombredepartamento, nombreprovincia, nombredistrito, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion from tb_ubigeo where 1=1";

		if (prmLis.getId() != null) {
			query = query + " and id = " + prmLis.getId() + "";
		}
		
		if (prmLis.getCodigodepartamento() != null) {
			query = query + " and codigodepartamento = '" + prmLis.getCodigodepartamento() + "'";
		}
		if (prmLis.getCodigoprovincia() != null) {
			query = query + " and codigoprovincia = '" + prmLis.getCodigoprovincia() + "'";
		}
		if (prmLis.getCodigodistrito() != null) {
			query = query + " and codigodistrito = '" + prmLis.getCodigodistrito() + "'";
		}
		if (prmLis.getEstado() != null) {
			query = query + " and estado = '" + prmLis.getEstado() + "'";
		}

		ResultSet rs = super.listar(query);

		while (rs.next()) {
			UbigeoDto objNew = new UbigeoDto();
			objNew.setId(rs.getInt("id"));
			objNew.setCodigodepartamento(rs.getString("codigodepartamento"));
			objNew.setCodigoprovincia(rs.getString("codigoprovincia"));
			objNew.setCodigodistrito(rs.getString("codigodistrito"));
			objNew.setNombredepartamento(rs.getString("nombredepartamento"));
			objNew.setNombreprovincia(rs.getString("nombreprovincia"));
			objNew.setNombredistrito(rs.getString("nombredistrito"));
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
	public UbigeoDto ver(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertar(UbigeoDto prmIns) throws SQLException {
		// TODO Auto-generated method stub
		return 0;

	}

	@Override
	public int actualizar(UbigeoDto prmAct) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminar(UbigeoDto prmEli) throws SQLException {
		// TODO Auto-generated method stub
		int retorno = 0;
		return retorno;
	}

	@Override
	public List<UbigeoDto> listarDepartamentos(UbigeoDto prmLis) throws SQLException {
		// TODO Auto-generated method stub
		List<UbigeoDto> retorno = new ArrayList<>();
		String query = "select codigodepartamento, nombredepartamento from tb_ubigeo group by codigodepartamento, nombredepartamento";

		if (prmLis.getEstado() != null) {
			query = query + " and estado = '" + prmLis.getEstado() + "'";
		}

		ResultSet rs = super.listar(query);

		while (rs.next()) {
			UbigeoDto objNew = new UbigeoDto();
			objNew.setCodigodepartamento(rs.getString("codigodepartamento"));
			objNew.setNombredepartamento(rs.getString("nombredepartamento"));
			retorno.add(objNew);
		}

		return retorno;
	}

	@Override
	public List<UbigeoDto> listarProvincias(UbigeoDto prmLis) throws SQLException {
		// TODO Auto-generated method stub
		List<UbigeoDto> retorno = new ArrayList<>();
		String query = "select codigoprovincia, nombreprovincia from tb_ubigeo where 1=1";

		if (prmLis.getCodigodepartamento() != null) {
			query = query + " and codigodepartamento = '" + prmLis.getCodigodepartamento() + "'";
		}
		if (prmLis.getEstado() != null) {
			query = query + " and estado = '" + prmLis.getEstado() + "'";
		}

		query = query + " group by codigoprovincia, nombreprovincia";

		ResultSet rs = super.listar(query);

		while (rs.next()) {
			UbigeoDto objNew = new UbigeoDto();
			objNew.setCodigoprovincia(rs.getString("codigoprovincia"));
			objNew.setNombreprovincia(rs.getString("nombreprovincia"));
			retorno.add(objNew);
		}

		return retorno;
	}

	@Override
	public List<UbigeoDto> listarDistritos(UbigeoDto prmLis) throws SQLException {
		// TODO Auto-generated method stub
		List<UbigeoDto> retorno = new ArrayList<>();
		String query = "select codigodistrito, nombredistrito from tb_ubigeo where 1=1";

		if (prmLis.getCodigodepartamento() != null) {
			query = query + " and codigodepartamento = '" + prmLis.getCodigodepartamento() + "'";
		}
		if (prmLis.getCodigoprovincia() != null) {
			query = query + " and codigoprovincia = '" + prmLis.getCodigoprovincia() + "'";
		}
		if (prmLis.getEstado() != null) {
			query = query + " and estado = '" + prmLis.getEstado() + "'";
		}

		query = query + " group by codigodistrito, nombredistrito";

		ResultSet rs = super.listar(query);

		while (rs.next()) {
			UbigeoDto objNew = new UbigeoDto();
			objNew.setCodigodistrito(rs.getString("codigodistrito"));
			objNew.setNombredistrito(rs.getString("nombredistrito"));
			retorno.add(objNew);
		}

		return retorno;
	}

}
