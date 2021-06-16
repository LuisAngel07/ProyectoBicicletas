package com.desarrollo.bean;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;

import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import com.desarrollo.bean.base.BaseBean;
import com.desarrollo.dominio.ClienteDto;
import com.desarrollo.dominio.MarcaDto;
import com.desarrollo.dominio.ModeloDto;
import com.desarrollo.dominio.ReparacionDto;
import com.desarrollo.dominio.ReparacionItemDto;
import com.desarrollo.dominio.SolicitudReparacionDto;
import com.desarrollo.dominio.UbigeoDto;
import com.desarrollo.enumerador.BaseEnum.accion_solicitada;
import com.desarrollo.framework.controller.MensajeControllerGenerico;
import com.desarrollo.framework.interfaces.IMantenimientoController;
import com.desarrollo.util.UFile;

@ManagedBean
@SessionScoped
public class SolicitudReparacionBean extends BaseBean implements IMantenimientoController {

	private List<MarcaDto> lstMarca;
	private List<ModeloDto> lstModelo;
	private ReparacionDto reparacionDto;
	private ReparacionItemDto reparacionItemDto;
	private UploadedFile fileItem;
	private Integer tabactive;
	private String opcionDescarga;
	private boolean blEditarItem;
	private String archivonombreitem;
	private byte[] archivoitem;
	private List<UbigeoDto> lstDepartamentos;
	private List<UbigeoDto> lstProvincias;
	private List<UbigeoDto> lstDistritos;
	private SolicitudReparacionDto solicitudReparacionDto;

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
		reparacionDto = new ReparacionDto();
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
		reparacionDto = new ReparacionDto();

		cargarDepartamentos();
		reparacionDto.getUbigeoDto().setCodigodepartamento(reparacionDto.getUbigeoDto().getCodigodepartamento());
		cargarProvincias(reparacionDto.getUbigeoDto().getCodigodepartamento());
		cargarDistritos(reparacionDto.getUbigeoDto().getCodigodepartamento(),
				reparacionDto.getUbigeoDto().getCodigoprovincia());

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
		reparacionDto.setEstado("P"); // pendiente
		// obtenemos el id ubigeo para guardarlo en la reparacion
		List<UbigeoDto> lstUbigeo = getUbigeoServicio().listar(reparacionDto.getUbigeoDto());
		if (lstUbigeo != null) {
			reparacionDto.setIdubigeo(lstUbigeo.get(0).getId());
		}
		// seteamos el cliente
		if (reparacionDto.getClienteDto() != null) {
			reparacionDto.setIdcliente(reparacionDto.getClienteDto().getId());
		}

		// seteamos los datos del tecnico
		if (reparacionDto.getTecnicoDto() != null) {
			reparacionDto.setIdtecnico(reparacionDto.getTecnicoDto().getId());
		}

		reparacionDto.setFechasolicitud(new Date());

		int rspta = getReparacionServicio().insertar(reparacionDto);
		// llamamos al servicio de envio de mensaje de texro
		if (rspta > 0) {

			// setMessageSuccess("Se envió su solicitud correctamente, lo
			// mantendremos informado");
			RequestContext.getCurrentInstance().update("dgConfirmacion");
			RequestContext.getCurrentInstance().execute("PF('popConfirmacion').show()");

			return null;
		} else {
			setMessageError("Ocurrió un error al enviar la solicitud");
			return null;
		}
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
	public String mensaje(MensajeControllerGenerico mensajeControllerGenerico) throws Exception {
		// TODO Auto-generated method stub
		if (mensajeControllerGenerico.getAccionTag().equals("obtenerCliente")) {
			reparacionDto.setClienteDto((ClienteDto) mensajeControllerGenerico.getValor());
			if (reparacionDto.getClienteDto().getId() == null) {
				reparacionDto.setClienteDto(getClienteServicio().listar(reparacionDto.getClienteDto()).get(0));
			}
		}
		return null;
	}

	@Override
	public String inicializarFiltrosListado() throws Exception {
		// TODO Auto-generated method stub
		reparacionDto = new ReparacionDto();
		reparacionDto.setIdtecnico(getSessionDto().getPersonaDto().getId());
		return null;
	}

	@Override
	public String inicializarDatosMantenimiento() throws Exception {
		// TODO Auto-generated method stub
		reparacionItemDto = new ReparacionItemDto();
		cargarMarca();
		cargarModelo();
		return null;
	}

	public void cargarMarca() throws SQLException {
		lstMarca = getMarcaServicio().listar(new MarcaDto());
	}

	public void cargarModelo() throws SQLException {
		lstModelo = getModeloServicio().listar(new ModeloDto());
	}

	public void cargarDepartamentos() throws SQLException {
		lstDepartamentos = getUbigeoServicio().listarDepartamentos(new UbigeoDto());
	}

	public void cargarProvincias(String codigodepartamento) throws SQLException {
		UbigeoDto ubigeoDto = new UbigeoDto();
		ubigeoDto.setCodigodepartamento(codigodepartamento);
		lstProvincias = getUbigeoServicio().listarProvincias(ubigeoDto);
	}

	public void cargarDistritos(String codigodepartamento, String codigoprovincia) throws SQLException {
		UbigeoDto ubigeoDto = new UbigeoDto();
		ubigeoDto.setCodigodepartamento(codigodepartamento);
		ubigeoDto.setCodigoprovincia(codigoprovincia);
		lstDistritos = getUbigeoServicio().listarDistritos(ubigeoDto);
	}

	public void valueChangeDepartamento(ValueChangeEvent event) throws Exception {
		String idevento = (String) event.getNewValue();
		if (idevento != null && idevento != "") {
			reparacionDto.getUbigeoDto().setCodigodepartamento(idevento);
			cargarProvincias(reparacionDto.getUbigeoDto().getCodigodepartamento());
		}
	}

	public void valueChangeProvincia(ValueChangeEvent event) throws Exception {
		String idevento = (String) event.getNewValue();
		if (idevento != null && idevento != "") {
			reparacionDto.getUbigeoDto().setCodigoprovincia(idevento);
			cargarDistritos(reparacionDto.getUbigeoDto().getCodigodepartamento(),
					reparacionDto.getUbigeoDto().getCodigoprovincia());
		}
	}

	public void handleFileUpload(FileUploadEvent event) throws Exception {

		fileItem = event.getFile();
		reparacionItemDto.setArchivonombre(fileItem.getFileName());
		reparacionItemDto.setArchivo(fileItem.getContents());

		System.out.println("nombre " + reparacionItemDto.getArchivonombre());

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
		// if (reparacionDto.getLstItems().size() == 0) {
		// setMessageError("Debe agregar al menos un item");
		// return null;
		// }

		cargarDepartamentos();
		if (reparacionDto == null) {
			reparacionDto = new ReparacionDto();
		}
		reparacionDto.getUbigeoDto().setCodigodepartamento("15"); // solo Lima
																	// por
																	// defecto
		cargarProvincias(reparacionDto.getUbigeoDto().getCodigodepartamento());
		tabactive = 1;
		RequestContext.getCurrentInstance().update("frmSolicitudReparacion:tvReparacion");
		return null;
	}

	public String paso3() throws Exception {
		if (reparacionDto.getUbigeoDto().getCodigodepartamento() == null
				|| reparacionDto.getUbigeoDto().getCodigodepartamento() == "") {
			setMessageError("Debe seleccionar el departamento");
			return null;
		}
		if (reparacionDto.getUbigeoDto().getCodigoprovincia() == null
				|| reparacionDto.getUbigeoDto().getCodigoprovincia() == "") {
			setMessageError("Debe seleccionar la provincia");
			return null;
		}
		if (reparacionDto.getUbigeoDto().getCodigodistrito() == null
				|| reparacionDto.getUbigeoDto().getCodigodistrito() == "") {
			setMessageError("Debe seleccionar el distrito");
			return null;
		}
		if (reparacionDto.getDireccion() == null || "" == reparacionDto.getDireccion()) {
			setMessageError("Debe seleccionar la dirección");
			return null;
		}

		 reparacionDto.setTecnicoDto(getTecnicoServicio().obtenerParaReparacion(reparacionDto));
		
		 if (reparacionDto.getTecnicoDto().getId() == null) {
		 setMessageError("No se han encontrado técnicos para ser asignados");
		 return null;
		 }

		tabactive = 2;
		RequestContext.getCurrentInstance().update("frmSolicitudReparacion:tvReparacion");
		return null;
	}

	public String editarItem() {
		if (blEditarItem) {
			setMessageError("Debe de terminar de editar el registro actual");
			return null;
		}

		blEditarItem = true;

		return null;
	}

	public String agregarItem() {
		ReparacionItemDto objAdd = new ReparacionItemDto();
		objAdd.setSec(reparacionDto.getLstItems().size() == 0 ? 1
				: reparacionDto.getLstItems().get(reparacionDto.getLstItems().size() - 1).getSec() + 1);
		objAdd.setDescripcion(reparacionItemDto.getDescripcion());
		objAdd.setIdmarca(reparacionItemDto.getIdmarca());
		objAdd.setIdmodelo(reparacionItemDto.getIdmodelo());
		objAdd.setArchivo(reparacionItemDto.getArchivo());
		objAdd.setArchivonombre(reparacionItemDto.getArchivonombre());
		objAdd.setModelonombre(obtenerModelo(objAdd.getIdmodelo()));
		objAdd.setMarcanombre(obtenerMarca(objAdd.getIdmarca()));

		reparacionDto.getLstItems().add(objAdd);
		reparacionItemDto = new ReparacionItemDto();
		return null;
	}

	public String actualizarItem() {

		if (reparacionDto.getLstItems() != null) {
			for (ReparacionItemDto obj : reparacionDto.getLstItems()) {
				if (reparacionItemDto.getSec() == obj.getSec()) {
					obj.setIdmarca(reparacionItemDto.getIdmarca());
					obj.setIdmodelo(reparacionItemDto.getIdmodelo());
					obj.setDescripcion(reparacionItemDto.getDescripcion());
					obj.setArchivo(archivoitem != null ? archivoitem : reparacionItemDto.getArchivo());
					obj.setArchivonombre(
							archivonombreitem != null ? archivonombreitem : reparacionItemDto.getArchivonombre());
					obj.setMarcanombre(obtenerMarca(obj.getIdmarca()));
					obj.setModelonombre(obtenerModelo(obj.getIdmodelo()));
					break;
				}
			}
		}

		reparacionItemDto = new ReparacionItemDto();

		return null;
	}

	public String eliminarItem() {

		if (reparacionDto.getLstItems() != null) {
			for (ReparacionItemDto obj : reparacionDto.getLstItems()) {
				if (reparacionItemDto.getSec() == obj.getSec()) {
					reparacionDto.getLstItems().remove(obj);
					break;
				}
			}
		}

		reparacionItemDto = new ReparacionItemDto();

		return null;
	}

	public String obtenerMarca(Integer id) {
		if (lstMarca != null) {
			for (MarcaDto obj : lstMarca) {
				if (id == obj.getId()) {
					return obj.getNombre();
				}
			}
		}
		return null;
	}

	public String obtenerModelo(Integer id) {
		if (lstModelo != null) {
			for (ModeloDto obj : lstModelo) {
				if (id == obj.getId()) {
					return obj.getNombre();
				}
			}
		}
		return null;
	}

	public List<MarcaDto> getLstMarca() {
		return lstMarca;
	}

	public void setLstMarca(List<MarcaDto> lstMarca) {
		this.lstMarca = lstMarca;
	}

	public List<ModeloDto> getLstModelo() {
		return lstModelo;
	}

	public void setLstModelo(List<ModeloDto> lstModelo) {
		this.lstModelo = lstModelo;
	}

	public ReparacionItemDto getReparacionItemDto() {
		return reparacionItemDto;
	}

	public void setReparacionItemDto(ReparacionItemDto reparacionItemDto) {
		this.reparacionItemDto = reparacionItemDto;
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

	public ReparacionDto getReparacionDto() {
		return reparacionDto;
	}

	public void setReparacionDto(ReparacionDto reparacionDto) {
		this.reparacionDto = reparacionDto;
	}

	@Override
	public String descargar() throws Exception {
		// TODO Auto-generated method stub
		if ("REPARACION_ITEM".equals(opcionDescarga)) {
			UFile.descargarArchivo(reparacionItemDto.getArchivo(), reparacionItemDto.getArchivonombre());
		}
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

	public List<UbigeoDto> getLstDepartamentos() {
		return lstDepartamentos;
	}

	public void setLstDepartamentos(List<UbigeoDto> lstDepartamentos) {
		this.lstDepartamentos = lstDepartamentos;
	}

	public List<UbigeoDto> getLstProvincias() {
		return lstProvincias;
	}

	public void setLstProvincias(List<UbigeoDto> lstProvincias) {
		this.lstProvincias = lstProvincias;
	}

	public List<UbigeoDto> getLstDistritos() {
		return lstDistritos;
	}

	public void setLstDistritos(List<UbigeoDto> lstDistritos) {
		this.lstDistritos = lstDistritos;
	}

	public SolicitudReparacionDto getSolicitudReparacionDto() {
		return solicitudReparacionDto;
	}

	public void setSolicitudReparacionDto(SolicitudReparacionDto solicitudReparacionDto) {
		this.solicitudReparacionDto = solicitudReparacionDto;
	}

}
