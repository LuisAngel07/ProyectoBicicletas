package com.desarrollo.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.desarrollo.bean.base.BaseBean;
import com.desarrollo.enumerador.BaseEnum.accion_solicitada;
import com.desarrollo.framework.interfaces.IMantenimientoController;

@ManagedBean
@SessionScoped
public class SolicitudReparacionBean extends BaseBean implements IMantenimientoController {

	private UploadedFile fileItem;
	private Integer tabactive;
	private String opcionDescarga;
	private boolean blEditarItem;
	private String archivonombreitem;
	private byte[] archivoitem;

	@Override
	public String iniciarControladora() throws Exception {
		// TODO Auto-generated method stub
		PANTALLA_LISTADO = "solicitudReparacionListado";
		inicializarFiltrosListado();
		buscar();

		return PANTALLA_LISTADO;
	}

	@Override
	public String buscar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String nuevo() throws Exception {
		// TODO Auto-generated method stub
		PANTALLA_MANTENIMIENTO = "solicitudReparacion";
		setAccionPantalla(accion_solicitada.NUEVO);
		blEditarItem = false;
		paso1();

		return PANTALLA_MANTENIMIENTO;
	}

	@Override
	public String editar() throws Exception {
		// TODO Auto-generated method stub
		setAccionPantalla(accion_solicitada.EDITAR);
		return null;
	}

	@Override
	public String ver() throws Exception {
		// TODO Auto-generated method stub
		setAccionPantalla(accion_solicitada.VER);

		RequestContext.getCurrentInstance().update("dgSolicitudReparaionDet");
		RequestContext.getCurrentInstance().execute("PF('popSolicitudReparaionDet').show()");

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

	public String atender() throws Exception {

		return iniciarControladora();
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
		return null;
	}

	@Override
	public String inicializarDatosMantenimiento() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}


	public void valueChangeDepartamento(ValueChangeEvent event) throws Exception {
	}

	public void valueChangeProvincia(ValueChangeEvent event) throws Exception {
	}

	public void handleFileUpload(FileUploadEvent event) throws Exception {


	}

	public void handleFileUploadReparacionItem(FileUploadEvent event) throws Exception {

		fileItem = event.getFile();
		archivonombreitem = fileItem.getFileName();
		archivoitem = fileItem.getContents();

	}

	public String paso1() throws Exception {
		inicializarDatosMantenimiento();
		tabactive = 0;
		RequestContext.getCurrentInstance().update("frmSolicitudReparacion:tvReparacion");
		return null;
	}

	public String paso2() throws Exception {

																	// defecto
		tabactive = 1;
		RequestContext.getCurrentInstance().update("frmSolicitudReparacion:tvReparacion");
		return null;
	}

	public String paso3() throws Exception {
		

		tabactive = 2;
		RequestContext.getCurrentInstance().update("frmSolicitudReparacion:tvReparacion");
		return null;
	}

	public String obtenerMarca(Integer id) {
		return null;
	}

	public String obtenerModelo(Integer id) {
		return null;
	}


	public UploadedFile getFileItem() {
		return fileItem;
	}

	public void setFileItem(UploadedFile fileItem) {
		this.fileItem = fileItem;
	}

	public Integer getTabactive() {
		return tabactive;
	}

	public void setTabactive(Integer tabactive) {
		this.tabactive = tabactive;
	}

	
	@Override
	public String descargar() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public String getOpcionDescarga() {
		return opcionDescarga;
	}

	public void setOpcionDescarga(String opcionDescarga) {
		this.opcionDescarga = opcionDescarga;
	}

	public boolean isBlEditarItem() {
		return blEditarItem;
	}

	public void setBlEditarItem(boolean blEditarItem) {
		this.blEditarItem = blEditarItem;
	}



}
