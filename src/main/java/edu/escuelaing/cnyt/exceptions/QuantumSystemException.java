package edu.escuelaing.cnyt.exceptions;

public class QuantumSystemException extends Exception {

    public static final String MATRIZ_NO_HERMITIANA = "La matriz dada no es hermitiana.";

    public QuantumSystemException(String mensaje) {
        super(mensaje);
    }
}
