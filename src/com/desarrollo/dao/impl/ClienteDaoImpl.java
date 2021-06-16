package com.desarrollo.dao.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.desarrollo.dao.ClienteDao;
import com.desarrollo.dominio.ClienteDto;

public class ClienteDaoImpl extends BaseDaoImpl implements ClienteDao {

	public static ClienteDaoImpl ins;

	public static ClienteDaoImpl getInstance() {
		if (ins == null) {
			ins = new ClienteDaoImpl();
		}
		return ins;
	}

	@Override
	public List<ClienteDto> listar(ClienteDto prmLis) throws SQLException {
		// TODO Auto-generated method stub
		List<ClienteDto> retorno = new ArrayList<>();
		String query = "select id, documento, nombres, apellido_paterno, apellido_materno, fecha_nacimiento, sexo, correo, celular, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion from tb_Cliente where 1=1";

		if (prmLis.getDocumento() != null) {
			query = query + " and documento = '" + prmLis.getDocumento() + "'";
		}
		if (prmLis.getEstado() != null) {
			query = query + " and estado = '" + prmLis.getEstado() + "'";
		}

		ResultSet rs = super.listar(query);

		while (rs.next()) {
			ClienteDto objNew = new ClienteDto();
			objNew.setId(rs.getInt("id"));
			objNew.setDocumento(rs.getString("documento"));
			objNew.setNombres(rs.getString("nombres"));
			objNew.setApellidopaterno(rs.getString("apellido_paterno"));
			objNew.setApellidomaterno(rs.getString("apellido_materno"));
			objNew.setFechanacimiento(rs.getDate("fecha_nacimiento"));
			objNew.setSexo(rs.getString("sexo"));
			objNew.setCorreo(rs.getString("correo"));
			objNew.setCelular(rs.getString("celular"));
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
	public ClienteDto ver(Integer id) throws SQLException {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public int insertar(ClienteDto prmIns) throws SQLException {
		// TODO Auto-generated method stub
		int retorno;
		PreparedStatement ps = preparar(
				"INSERT INTO tb_Cliente (documento, nombres, apellido_paterno, apellido_materno, fecha_nacimiento, sexo, correo, celular, estado, usuario_creacion, fecha_creacion) values(?,?,?,?,?,?,?,?,?,?,sysdate())");
		ps.setString(1, prmIns.getDocumento());
		ps.setString(2, prmIns.getNombres());
		ps.setString(3, prmIns.getApellidopaterno());
		ps.setString(4, prmIns.getApellidomaterno());
		ps.setDate(5, new Date(prmIns.getFechanacimiento().getTime()));
		ps.setString(6, prmIns.getSexo());
		ps.setString(7, prmIns.getCorreo());
		ps.setString(8, prmIns.getCelular());
		ps.setString(9, prmIns.getEstado());
		ps.setString(10, prmIns.getUsuario_creacion());

		retorno = ps.executeUpdate();
		return retorno;

	}

	@Override
	public int actualizar(ClienteDto prmAct) throws SQLException {
		// TODO Auto-generated method stub
		int retorno;
		PreparedStatement ps = preparar(
				"update tb_Cliente set nombres=?, apellido_paterno=?, apellido_materno=?, fecha_nacimiento=?, sexo=?, correo=?, celular=?, usuario_modificacion=?, fecha_modificacion=sysdate() where id=?");
		ps.setString(1, prmAct.getNombres());
		ps.setString(2, prmAct.getApellidopaterno());
		ps.setString(3, prmAct.getApellidomaterno());
		ps.setDate(4, new Date(prmAct.getFechanacimiento().getTime()));
		ps.setString(5, prmAct.getSexo());
		ps.setString(6, prmAct.getCorreo());
		ps.setString(7, prmAct.getCelular());
		ps.setString(8, prmAct.getUsuario_modificacion());
		ps.setInt(9, prmAct.getId());

		retorno = ps.executeUpdate();
		return retorno;
	}

	@Override
	public int eliminar(ClienteDto prmEli) throws SQLException {
		// TODO Auto-generated method stub
		int retorno = 0;
		return retorno;
	}

}
