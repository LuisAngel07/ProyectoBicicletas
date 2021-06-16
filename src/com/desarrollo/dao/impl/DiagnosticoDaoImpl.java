package com.desarrollo.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.desarrollo.dao.DiagnosticoDao;
import com.desarrollo.dominio.DiagnosticoDto;
import com.desarrollo.util.Utilitario;

public class DiagnosticoDaoImpl extends BaseDaoImpl implements DiagnosticoDao {

	public static DiagnosticoDaoImpl ins;

	public static DiagnosticoDaoImpl getInstance() {
		if (ins == null) {
			ins = new DiagnosticoDaoImpl();
		}
		return ins;
	}

	@Override
	public List<DiagnosticoDto> listar(DiagnosticoDto prmLis) throws SQLException {
		// TODO Auto-generated method stub
		List<DiagnosticoDto> retorno = new ArrayList<>();
		String query = "select id, descripcion, indicaciones, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion from tb_diagnostico where 1=1";

		if (prmLis.getDescripcion() != null) {
			query = query + " and MATCH(descripcion) AGAINST ('" + prmLis.getDescripcion() + "' IN BOOLEAN MODE)";
		}
		if (prmLis.getIndicaciones() != null) {
			query = query + " and MATCH(indicaciones) AGAINST ('" + prmLis.getIndicaciones() + "' IN BOOLEAN MODE)";
		}
		if (prmLis.getEstado() != null) {
			query = query + " and estado = '" + prmLis.getEstado() + "'";
		}

		ResultSet rs = super.listar(query);

		while (rs.next()) {
			DiagnosticoDto objNew = new DiagnosticoDto();
			objNew.setId(rs.getInt("id"));
			objNew.setDescripcion(rs.getString("descripcion"));
			objNew.setIndicaciones(rs.getString("indicaciones"));
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
	public DiagnosticoDto ver(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertar(DiagnosticoDto prmIns) throws SQLException {
		// TODO Auto-generated method stub
		int retorno = 0;
		return retorno;

	}

	@Override
	public int actualizar(DiagnosticoDto prmAct) throws SQLException {
		// TODO Auto-generated method stub
		int retorno = 0;
		return retorno;
	}

	@Override
	public int eliminar(DiagnosticoDto prmEli) throws SQLException {
		// TODO Auto-generated method stub
		int retorno = 0;
		return retorno;
	}

	@Override
	public List<DiagnosticoDto> coincidir(String prmBus) throws SQLException {
		// TODO Auto-generated method stub
		List<DiagnosticoDto> retorno = new ArrayList<>();
		String query = "select id, descripcion, indicaciones, estado, usuario_creacion, fecha_creacion, usuario_modificacion, fecha_modificacion from tb_diagnostico";

		if (prmBus != null) {
			prmBus = Utilitario.soloPalabras(prmBus);

			if (prmBus.length() > 0) {
				String[] arrayBus = prmBus.split(" ");
				for (int i = 0; i < arrayBus.length; i++) {
					if (arrayBus[i].length() > 0) {
						if (i == 0) {
							query = query + " where fn_coincidir('" + arrayBus[i] + "',descripcion) > 0";
							query = query + " OR fn_coincidir('" + arrayBus[i] + "',indicaciones) > 0";
						} else {
							query = query + " OR fn_coincidir('" + arrayBus[i] + "',descripcion) > 0";
							query = query + " OR fn_coincidir('" + arrayBus[i] + "',indicaciones) > 0";
						}
					}
				}

				ResultSet rs = super.listar(query);

				while (rs.next()) {
					DiagnosticoDto objNew = new DiagnosticoDto();
					objNew.setId(rs.getInt("id"));
					objNew.setDescripcion(rs.getString("descripcion"));
					objNew.setIndicaciones(rs.getString("indicaciones"));
					objNew.setEstado(rs.getString("estado"));
					objNew.setUsuario_creacion(rs.getString("usuario_creacion"));
					objNew.setFecha_creacion(rs.getDate("fecha_creacion"));
					objNew.setUsuario_modificacion(rs.getString("usuario_modificacion"));
					objNew.setFecha_modificacion(rs.getDate("fecha_modificacion"));
					retorno.add(objNew);
				}
			}
		}

		return retorno;
	}

}
