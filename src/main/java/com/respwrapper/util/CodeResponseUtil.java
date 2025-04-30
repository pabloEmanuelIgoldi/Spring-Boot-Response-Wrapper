package com.respwrapper.util;

public class CodeResponseUtil {

	// Peticion exitosa
	public static final int SUCCESS = 1100;
	public static final int CREATED = 1101;

	// Errores de cliente
	public static final int ENTITY_NOT_FOUND = 1200;
	public static final int ENTITY_ALREADY_EXISTS = 1201;
	public static final int VALIDATION_ERROR = 1203;

	// Errores de auth
	public static final int UNAUTHORIZED = 1300;

	// Errores del servidor
	public static final int INTERNAL_ERROR = 1400;

}
