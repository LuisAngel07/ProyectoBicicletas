package com.desarrollo.dominio;

import java.util.Date;

public class BaseDto {

	private Integer sec;
	private String estado;
	private String usuario_creacion;
	private String usuario_modificacion;
	private Date fecha_creacion;
	private Date fecha_modificacion;

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getUsuario_creacion() {
		return usuario_creacion;
	}

	public void setUsuario_creacion(String usuario_creacion) {
		this.usuario_creacion = usuario_creacion;
	}

	public String getUsuario_modificacion() {
		return usuario_modificacion;
	}

	public void setUsuario_modificacion(String usuario_modificacion) {
		this.usuario_modificacion = usuario_modificacion;
	}

	public Date getFecha_creacion() {
		return fecha_creacion;
	}

	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}

	public Date getFecha_modificacion() {
		return fecha_modificacion;
	}

	public void setFecha_modificacion(Date fecha_modificacion) {
		this.fecha_modificacion = fecha_modificacion;
	}

	public Integer getSec() {
		if (sec == null) {
			sec = 0;
		}
		return sec;
	}

	public void setSec(Integer sec) {
		this.sec = sec;
	}

}
