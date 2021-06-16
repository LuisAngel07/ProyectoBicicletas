package com.desarrollo.dao.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.desarrollo.dao.ReparacionDao;
import com.desarrollo.dominio.ReparacionDto;
import com.desarrollo.dominio.SolicitudReparacionDto;
import com.desarrollo.util.Utilitario;

public class ReparacionDaoImpl extends BaseDaoImpl implements ReparacionDao {

	public static ReparacionDaoImpl ins;

	public static ReparacionDaoImpl getInstance() {
		if (ins == null) {
			ins = new ReparacionDaoImpl();
		}
		return ins;
	}

	@Override
	public List<ReparacionDto> listar(ReparacionDto prmLis) throws Exception {
		// TODO Auto-generated method stub
		List<ReparacionDto> retorno = new ArrayList<>();
		String query = "select id, id_cliente, id_tecnico, id_ubigeo, direccion, comentario, estado, fecha_solicitud, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion from tb_reparacion where 1=1";

		if (prmLis.getIdcliente() != null) {
			query = query + " and id_cliente = '" + prmLis.getIdcliente() + "'";
		}
		if (prmLis.getIdtecnico() != null) {
			query = query + " and id_tecnico = '" + prmLis.getIdtecnico() + "'";
		}
		if (prmLis.getFechasolicitud() != null) {
			query = query + " and  date_format(fecha_solicitud,'%Y%m%d') = '"
					+ Utilitario.convertirFechaCadena(prmLis.getFechasolicitud(), "yyyyMMdd") + "'";
		}

		ResultSet rs = super.listar(query);

		while (rs.next()) {
			ReparacionDto objNew = new ReparacionDto();
			objNew.setId(rs.getInt("id"));
			objNew.setIdcliente(rs.getInt("id_cliente"));
			objNew.setIdtecnico(rs.getInt("id_tecnico"));
			objNew.setIdubigeo(rs.getInt("id_ubigeo"));
			objNew.setDireccion(rs.getString("direccion"));
			objNew.setComentario(rs.getString("comentario"));
			objNew.setFechasolicitud(rs.getDate("fecha_solicitud"));
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
	public ReparacionDto ver(Integer id) throws SQLException {
		// TODO Auto-generated method stub
		ReparacionDto retorno = new ReparacionDto();
		String query = "select id, id_cliente, id_tecnico, id_ubigeo, direccion, comentario, estado, fecha_solicitud, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion from tb_reparacion where 1=1";

		if (id != null) {
			query = query + " and id = " + id + "";
		}

		ResultSet rs = super.listar(query);

		while (rs.next()) {
			ReparacionDto objNew = new ReparacionDto();
			objNew.setId(rs.getInt("id"));
			objNew.setIdcliente(rs.getInt("id_cliente"));
			objNew.setIdtecnico(rs.getInt("id_tecnico"));
			objNew.setIdubigeo(rs.getInt("id_ubigeo"));
			objNew.setDireccion(rs.getString("direccion"));
			objNew.setComentario(rs.getString("comentario"));
			objNew.setFechasolicitud(rs.getDate("fecha_solicitud"));
			objNew.setEstado(rs.getString("estado"));
			objNew.setUsuario_creacion(rs.getString("usuario_creacion"));
			objNew.setFecha_creacion(rs.getDate("fecha_creacion"));
			objNew.setUsuario_modificacion(rs.getString("usuario_modificacion"));
			objNew.setFecha_modificacion(rs.getDate("fecha_modificacion"));
			retorno = objNew;
		}

		return retorno;
	}

	@Override
	public int insertar(ReparacionDto prmIns) throws SQLException {
		// TODO Auto-generated method stub
		int id = 0;
		String query = "SELECT ifnull(MAX(id),0) +1 AS sec FROM tb_reparacion";
		ResultSet rs = super.listar(query);

		while (rs.next()) {
			id = rs.getInt("sec");
		}

		PreparedStatement ps = preparar(
				"INSERT INTO tb_reparacion ( id, id_cliente, id_tecnico, id_ubigeo, direccion, comentario, fecha_solicitud, estado, usuario_creacion, fecha_creacion) values(?,?,?,?,?,?,?,?,?,sysdate())");
		ps.setInt(1, id);
		ps.setInt(2, prmIns.getIdcliente());
		ps.setInt(3, prmIns.getIdtecnico());
		ps.setInt(4, prmIns.getIdubigeo());
		ps.setString(5, prmIns.getDireccion());
		ps.setString(6, prmIns.getComentario());
		ps.setDate(7, new Date(prmIns.getFechasolicitud().getTime()));
		ps.setString(8, prmIns.getEstado());
		ps.setString(9, prmIns.getUsuario_creacion());

		int retorno = ps.executeUpdate();
		if (retorno > 0) {
			retorno = id;
		}

		return retorno;

	}

	@Override
	public int actualizar(ReparacionDto prmAct) throws SQLException {
		// TODO Auto-generated method stub
		int retorno;
		PreparedStatement ps = preparar(
				"update tb_reparacion set estado=?, usuario_modificacion=?, fecha_modificacion=sysdate() where id=?");
		ps.setString(1, prmAct.getEstado());
		ps.setString(2, prmAct.getUsuario_modificacion());
		ps.setInt(3, prmAct.getId());

		retorno = ps.executeUpdate();
		return retorno;
	}

	@Override
	public int eliminar(ReparacionDto prmEli) throws SQLException {
		// TODO Auto-generated method stub
		int retorno = 0;
		return retorno;
	}

	@Override
	public List<SolicitudReparacionDto> listarSolicitudes(ReparacionDto prmLis) throws Exception {
		// TODO Auto-generated method stub
		List<SolicitudReparacionDto> retorno = new ArrayList<>();
		String query = "SELECT r.id, CONCAT(c.nombres,' ',c.apellido_paterno,' ',c.apellido_materno) as cliente, r.fecha_solicitud, CONCAT(r.direccion,' (',u.nombredistrito,' - ',u.nombreprovincia,' - ',u.nombredepartamento,')') as direccion, r.estado, r.usuario_creacion, r.fecha_creacion, r.usuario_modificacion, r.fecha_modificacion FROM tb_reparacion r join tb_cliente c on r.id_cliente = c.id join tb_tecnico t on r.id_tecnico = t.id join tb_ubigeo u on r.id_ubigeo = u.id where 1=1";

		if (prmLis.getIdcliente() != null) {
			query = query + " and c.id = '" + prmLis.getIdcliente() + "'";
		}
		if (prmLis.getIdtecnico() != null) {
			query = query + " and t.id = '" + prmLis.getIdtecnico() + "'";
		}
		if (prmLis.getFechasolicitud() != null) {
			query = query + " and  date_format(r.fecha_solicitud,'%Y%m%d') = '"
					+ Utilitario.convertirFechaCadena(prmLis.getFechasolicitud(), "yyyyMMdd") + "'";
		}

		ResultSet rs = super.listar(query);

		while (rs.next()) {
			SolicitudReparacionDto objNew = new SolicitudReparacionDto();
			objNew.setId(rs.getInt("id"));
			objNew.setCliente(rs.getString("cliente"));
			objNew.setFechasolicitud(rs.getDate("fecha_solicitud"));
			objNew.setDireccion(rs.getString("direccion"));
			objNew.setEstado(rs.getString("estado"));
			objNew.setUsuario_creacion(rs.getString("usuario_creacion"));
			objNew.setFecha_creacion(rs.getDate("fecha_creacion"));
			objNew.setUsuario_modificacion(rs.getString("usuario_modificacion"));
			objNew.setFecha_modificacion(rs.getDate("fecha_modificacion"));
			retorno.add(objNew);
		}

		return retorno;

	}

}
