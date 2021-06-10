package com.desarrollo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

public class UFile {

	public static String getSeparador() {
		return File.separator;
	}

	public static String archivoUnico() {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd-HHmmssSSS");
		String nombreCarpetaSession = df.format(new Date());
		return nombreCarpetaSession;
	}

	public static String verArchivo(byte data[], String nombreArchivo, HttpServletResponse response) throws Exception {

		response.setHeader("Content-Disposition", "attachment;filename=" + nombreArchivo);
		ServletOutputStream ouputStream = response.getOutputStream();
		ouputStream.write(data);
		ouputStream.flush();
		ouputStream.close();

		return null;
	}

	public static String descargarArchivo(byte data[], String nombre) throws IOException {

		// firefox
		if (nombre != null && nombre != "") {
			nombre = nombre.replaceAll(" ", "_");
		}

		FacesContext facesContext = FacesContext.getCurrentInstance();
		HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
		response.setHeader("Content-Disposition", "attachment;filename=" + nombre);
		FileInputStream input = null;
		try {
			int i = 0;
			response.getOutputStream().write(data);
			response.getOutputStream().flush();
			facesContext.responseComplete();
			facesContext.renderResponse();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (input != null) {
					input.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		response.flushBuffer();

		return null;

	}

	public static String remplazarTildes(String archivo) {
		String retorno = archivo;
		retorno = retorno.replaceAll("á", "a");
		retorno = retorno.replaceAll("é", "e");
		retorno = retorno.replaceAll("í", "i");
		retorno = retorno.replaceAll("ó", "o");
		retorno = retorno.replaceAll("ú", "u");
		retorno = retorno.replaceAll("Á", "A");
		retorno = retorno.replaceAll("É", "E");
		retorno = retorno.replaceAll("Í", "I");
		retorno = retorno.replaceAll("Ó", "O");
		retorno = retorno.replaceAll("Ú", "U");

		return retorno;
	}
}
