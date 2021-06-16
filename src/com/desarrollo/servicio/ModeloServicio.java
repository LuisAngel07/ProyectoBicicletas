package com.desarrollo.servicio;

import java.sql.SQLException;
import java.util.List;

import com.desarrollo.dominio.ModeloDto;

public interface ModeloServicio {

	public List<ModeloDto> listar(ModeloDto prmLis) throws SQLException;

	public ModeloDto ver(Integer id) throws SQLException;

	public int insertar(ModeloDto prmIns) throws SQLException;

	public int actualizar(ModeloDto prmAct) throws SQLException;

	public int eliminar(ModeloDto prmEli) throws SQLException;

}
