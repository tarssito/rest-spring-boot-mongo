package com.tarssito.restmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Classe utilizada para decodificar parametros de url concatenada no JS
 * @author tarssito
 *
 */
public class URL {

	public static String decodeParam(String text) {
		try {
			return URLDecoder.decode(text, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
	}
}
