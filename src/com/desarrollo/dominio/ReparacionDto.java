package com.desarrollo.dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReparacionDto extends BaseDto {

	private Integer id;
	private Integer idcliente;
	private Integer idtecnico;
	private Integer idubigeo;
	private String direccion;
	private String comentario;
	private Date fechasolicitud;
	private List<ReparacionItemDto> lstItems;
	private UbigeoDto ubigeoDto;
	private TecnicoDto tecnicoDto;
	private ClienteDto clienteDto;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdcliente() {
		return idcliente;
	}

	public void setIdcliente(Integer idcliente) {
		this.idcliente = idcliente;
	}

	public Integer getIdtecnico() {
		return idtecnico;
	}

	public void setIdtecnico(Integer idtecnico) {
		this.idtecnico = idtecnico;
	}

	public Integer getIdubigeo() {
		return idubigeo;
	}

	public void setIdubigeo(Integer idubigeo) {
		this.idubigeo = idubigeo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Date getFechasolicitud() {
		return fechasolicitud;
	}

	public void setFechasolicitud(Date fechasolicitud) {
		this.fechasolicitud = fechasolicitud;
	}

	public List<ReparacionItemDto> getLstItems() {
		if (lstItems == null) {
			lstItems = new ArrayList<>();
		}
		return lstItems;
	}

	public void setLstItems(List<ReparacionItemDto> lstItems) {
		this.lstItems = lstItems;
	}

	public UbigeoDto getUbigeoDto() {
		if (ubigeoDto == null) {
			ubigeoDto = new UbigeoDto();
		}
		return ubigeoDto;
	}

	public void setUbigeoDto(UbigeoDto ubigeoDto) {
		this.ubigeoDto = ubigeoDto;
	}

	public TecnicoDto getTecnicoDto() {
		if (tecnicoDto == null) {
			tecnicoDto = new TecnicoDto();
		}
		return tecnicoDto;
	}

	public void setTecnicoDto(TecnicoDto tecnicoDto) {
		this.tecnicoDto = tecnicoDto;
	}

	public ClienteDto getClienteDto() {
		return clienteDto;
	}

	public void setClienteDto(ClienteDto clienteDto) {
		this.clienteDto = clienteDto;
	}

}
