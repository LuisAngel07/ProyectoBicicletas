package com.desarrollo.dominio;

public class SessionDto extends BaseDto {

	private UsuarioDto usuarioDto;
	private UsuarioPersonaDto usuarioPersonaDto;
	private PersonaDto personaDto;

	public UsuarioDto getUsuarioDto() {
		return usuarioDto;
	}

	public void setUsuarioDto(UsuarioDto usuarioDto) {
		this.usuarioDto = usuarioDto;
	}

	public UsuarioPersonaDto getUsuarioPersonaDto() {
		return usuarioPersonaDto;
	}

	public void setUsuarioPersonaDto(UsuarioPersonaDto usuarioPersonaDto) {
		this.usuarioPersonaDto = usuarioPersonaDto;
	}

	public PersonaDto getPersonaDto() {
		return personaDto;
	}

	public void setPersonaDto(PersonaDto personaDto) {
		this.personaDto = personaDto;
	}

}
