package com.desarrollo.dao;

import java.sql.SQLException;
import java.util.List;

import com.desarrollo.dominio.UbigeoDto;

public interface UbigeoDao {

	public List<UbigeoDto> listar(UbigeoDto prmLis) throws SQLException;

	public List<UbigeoDto> listarDepartamentos(UbigeoDto prmLis) throws SQLException;

	public List<UbigeoDto> listarProvincias(UbigeoDto prmLis) throws SQLException;

	public List<UbigeoDto> listarDistritos(UbigeoDto prmLis) throws SQLException;

	public UbigeoDto ver(Integer codigo) throws SQLException;

	public int insertar(UbigeoDto prmIns) throws SQLException;

	public int actualizar(UbigeoDto prmAct) throws SQLException;

	public int eliminar(UbigeoDto prmEli) throws SQLException;

}
