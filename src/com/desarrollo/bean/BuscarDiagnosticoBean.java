package com.desarrollo.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.desarrollo.bean.base.BaseBean;
import com.desarrollo.dominio.DiagnosticoDto;
import com.desarrollo.framework.interfaces.IMantenimientoController;

@ManagedBean
@SessionScoped
public class BuscarDiagnosticoBean extends BaseBean implements IMantenimientoController {

	private DiagnosticoDto diagnosticoDto;
	private DiagnosticoDto filtroDto;
	private List<DiagnosticoDto> lstDiagnostico;
	private Boolean verDiagnostico;

	@Override
	public String iniciarControladora() throws Exception {
		// TODO Auto-generated method stub
		PANTALLA_MANTENIMIENTO = "diagnosticar";
		inicializarFiltrosListado();
		lstDiagnostico = new ArrayList<>();
		diagnosticoDto = new DiagnosticoDto();
		verDiagnostico = false;
		return PANTALLA_MANTENIMIENTO;
	}

	@Override
	public String buscar() throws Exception {
		// TODO Auto-generated method stub
		verDiagnostico = false;
		lstDiagnostico = getDiagnosticoServicio().coincidir(filtroDto.getDescripcion(), true, true);
		if (lstDiagnostico.size() > 0) {
			// obtenemos el principal
			for (int i = 0; i < lstDiagnostico.size(); i++) {
				DiagnosticoDto obj = lstDiagnostico.get(i);
				if (obj.getFlgprincipal() == 1) {
					diagnosticoDto = obj;
					lstDiagnostico.remove(i);
					i--;
					break;
				}
			}
			if (lstDiagnostico.size() > 0) {
				verDiagnostico = true;
			}
		} else {
			setMessageError("No se encontraron resultados para la búsqueda");
		}
		return null;
	}

	@Override
	public String nuevo() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String editar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String ver() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String eliminar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String inactivar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String ejecutar(String accion) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String guardar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String salir() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean validar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public String inicializarFiltrosListado() throws Exception {
		// TODO Auto-generated method stub
		filtroDto = new DiagnosticoDto();
		return null;
	}

	@Override
	public String inicializarDatosMantenimiento() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public DiagnosticoDto getDiagnosticoDto() {
		return diagnosticoDto;
	}

	public void setDiagnosticoDto(DiagnosticoDto diagnosticoDto) {
		this.diagnosticoDto = diagnosticoDto;
	}

	public List<DiagnosticoDto> getLstDiagnostico() {
		return lstDiagnostico;
	}

	public void setLstDiagnostico(List<DiagnosticoDto> lstDiagnostico) {
		this.lstDiagnostico = lstDiagnostico;
	}

	public Boolean getVerDiagnostico() {
		return verDiagnostico;
	}

	public void setVerDiagnostico(Boolean verDiagnostico) {
		this.verDiagnostico = verDiagnostico;
	}

	public DiagnosticoDto getFiltroDto() {
		return filtroDto;
	}

	public void setFiltroDto(DiagnosticoDto filtroDto) {
		this.filtroDto = filtroDto;
	}

	@Override
	public String descargar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
