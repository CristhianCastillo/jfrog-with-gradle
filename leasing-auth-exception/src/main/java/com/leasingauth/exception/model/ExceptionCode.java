package com.leasingauth.exception.model;

public enum ExceptionCode {

    ERROR_CLIENT("99", "Error de cliente."),
    ERROR_UNKNOWN("98", "Error, consulte al administrador del sistema."),
    ERROR_RECORD_NOT_FOUND("97", "Error, el registro no se ha encontrado."),
    ERROR_INVALID_DATA("96", "Error, datos invalidos."),
    ERROR_SEND_EMAIL("95", "Error, no fue posible enviar el email."),
    ERROR_REGISTER_LOG("94", "Error, no fue posible registrar el log de seguridad."),
    ERROR_AUTHENTICATION("93", "Error en la autenticaci\u00f3n."),
    ERROR_TOKEN_COMPANY("92", "Error, Token de seguridad invalido."),
    ERROR_PARAMETER_SECURITY_NOT_FOUND("91", "Error, no se ha encontrado el par\u00e1metro con nombre: "),
    ERROR_CONVERT_DATE("90", "Error, no se ha podido convertir la fecha.");

    private final String code;
    private final String description;

    ExceptionCode(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
