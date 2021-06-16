package com.desarrollo.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilitario {

	public static String[] arrayClaves = { "bicicleta", "bicicletas", "kilómetros", "pedales", "aro", "asiento",
			"llanta", "grasa", "aceite", "teflón", "lubricar", "desajuste", "tubo", "tuerca", "cadena", "diagnóstico",
			"frecuencia" };

	public static String soloPalabras(String busqueda) {

		String[] arrayBusqueda = busqueda.split(" ");
		int encontradosgen = 0;

		for (String bus : arrayBusqueda) {
			int encontrados = 0;
			for (String cla : arrayClaves) {
				if (bus.toLowerCase().contains(cla.toLowerCase())) {
					encontrados = 1;
					encontradosgen = encontradosgen + 1;
					break;
				}
			}
			if (encontrados == 0) {
				busqueda = busqueda.replaceAll(bus, "");
			}
		}

		// si no hay ninguna coincidencia enviamos un texto vacion
		if (encontradosgen == 0) {
			busqueda = "";
		}

		busqueda = busqueda.trim();
		return busqueda;
	}

	public static int contarCoincidencias(String texto, String busqueda) {

		int cantidad = 0;

		busqueda = soloPalabras(busqueda);

		String[] arrayBusqueda = busqueda.split(" ");
		String[] arrayTexto = texto.split(" ");

		for (String bus : arrayBusqueda) {
			for (String tex : arrayTexto) {
				if (tex.toLowerCase().contains(bus.toLowerCase())) {
					cantidad = cantidad + 1;
				}
			}
		}

		return cantidad;
	}

	public static String convertirFechaCadena(Date date, String formato) throws Exception {

		String cadena = null;
		if (date == null)
			return null;
		if (formato.isEmpty())
			return null;

		SimpleDateFormat formateador = new SimpleDateFormat(formato);
		cadena = formateador.format(date);

		return cadena;
	}

	public static String pintarCoincidencias(String texto, String busqueda) {

		String html1 = "<span style='width:";
		String html2 = "px; height:15px; background-color:yellow'>";
		String html3 = "</span>";

		busqueda = soloPalabras(busqueda);

		String[] arrayBusqueda = busqueda.split(" ");
		String[] arrayTexto = texto.split(" ");

		for (String tex : arrayTexto) {
			for (String bus : arrayBusqueda) {
				if (tex.toLowerCase().contains(bus.toLowerCase())) {
					// texto = texto.replace(tex, html1 + (bus.length() * 7) +
					// html2 + tex + html3);
					break;
				}
			}
		}

		return texto;
	}
}
