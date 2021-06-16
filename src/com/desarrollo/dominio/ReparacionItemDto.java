package com.desarrollo.dominio;

public class ReparacionItemDto extends BaseDto {

	private Integer id;
	private Integer idreparacion;
	private Integer idmarca;
	private Integer idmodelo;
	private String descripcion;
	private String archivonombre;
	private byte[] archivo;

	// auxiliares
	private String marcanombre;
	private String modelonombre;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdreparacion() {
		return idreparacion;
	}

	public void setIdreparacion(Integer idreparacion) {
		this.idreparacion = idreparacion;
	}

	public Integer getIdmarca() {
		return idmarca;
	}

	public void setIdmarca(Integer idmarca) {
		this.idmarca = idmarca;
	}

	public Integer getIdmodelo() {
		return idmodelo;
	}

	public void setIdmodelo(Integer idmodelo) {
		this.idmodelo = idmodelo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getArchivonombre() {
		return archivonombre;
	}

	public void setArchivonombre(String archivonombre) {
		this.archivonombre = archivonombre;
	}

	public byte[] getArchivo() {
		return archivo;
	}

	public void setArchivo(byte[] archivo) {
		this.archivo = archivo;
	}

	public String getMarcanombre() {
		return marcanombre;
	}

	public void setMarcanombre(String marcanombre) {
		this.marcanombre = marcanombre;
	}

	public String getModelonombre() {
		return modelonombre;
	}

	public void setModelonombre(String modelonombre) {
		this.modelonombre = modelonombre;
	}

}
