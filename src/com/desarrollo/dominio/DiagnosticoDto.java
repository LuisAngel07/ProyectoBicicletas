package com.desarrollo.dominio;

import java.util.List;

import com.desarrollo.util.Utilitario;

public class DiagnosticoDto extends BaseDto {

	private Integer id;
	private String descripcion;
	private String indicaciones;
	private String indicacioneshtml;
	private long flgprincipal;

	// auxiliares
	private Integer cantcoincide;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getIndicaciones() {
		return indicaciones;
	}

	public void setIndicaciones(String indicaciones) {
		this.indicaciones = indicaciones;
	}

	public long getFlgprincipal() {
		return flgprincipal;
	}

	public void setFlgprincipal(long flgprincipal) {
		this.flgprincipal = flgprincipal;
	}

	public Integer getCantcoincide() {
		return cantcoincide;
	}

	public void setCantcoincide(Integer cantcoincide) {
		this.cantcoincide = cantcoincide;
	}

	public static List<DiagnosticoDto> setPrincipal(List<DiagnosticoDto> retorno, String prmBus) {
		// TODO Auto-generated method stub
		int maxcantcoincide = 0;
		int indiceprincipal = -1;
		if (retorno != null) {
			for (int i = 0; i < retorno.size(); i++) {
				DiagnosticoDto obj = retorno.get(i);
				obj.setCantcoincide(Utilitario.contarCoincidencias(obj.getIndicaciones(), prmBus));
				if (obj.getCantcoincide() > maxcantcoincide) {
					maxcantcoincide = obj.getCantcoincide();
					indiceprincipal = i;
				}
			}
		}
		if (indiceprincipal >= 0) {
			retorno.get(indiceprincipal).setFlgprincipal(1);
		}

		return retorno;
	}

	public String getIndicacioneshtml() {
		// indicacioneshtml = "<div style='width:" + (4 * 7) + "px; height:15px;
		// background-color:yellow'>hola</div>";
		return indicacioneshtml;
	}

	public void setIndicacioneshtml(String indicacioneshtml) {
		this.indicacioneshtml = indicacioneshtml;
	}

	public static List<DiagnosticoDto> setHtml(List<DiagnosticoDto> retorno, String prmBus) {
		// TODO Auto-generated method stub
		if (retorno != null) {
			for (int i = 0; i < retorno.size(); i++) {
				DiagnosticoDto obj = retorno.get(i);
				obj.setIndicacioneshtml(Utilitario.pintarCoincidencias(obj.getIndicaciones(), prmBus));
			}
		}

		return retorno;
	}

}
