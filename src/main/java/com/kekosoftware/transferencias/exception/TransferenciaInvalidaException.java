package com.kekosoftware.transferencias.exception;

public class TransferenciaInvalidaException extends RuntimeException {
    public TransferenciaInvalidaException(String mensaje) {
        super(mensaje);
    }
}