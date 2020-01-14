package edu.escuelaing.cnyt.exceptions;

/**
 * Esta clase representa a las excepciones definidas para las operaciones entre
 * numero complejos.
 *
 */
public class MathComplexException extends Exception {

    public static final String DIVISION_COMPLEJA_CERO = "La division por 0 en los numeros complejos no esta definida.";
    public static final String LONGITUD_VECTORES_DIFERENTE = "Los vectores deben tener la misma longitud.";
    public static final String SUMA_DIMENSION_MATRICES_DIFERENTE = "Las matrices deben tener la misma dimension para sumarlas.";
    public static final String MULTIPLICACION_DIMENSION_MATRICES_DIFERENTE = "La dimension de las columnas de la matriz m1 debe ser igual a la dimension de las filas de la matriz m2 para multiplicarlas.";
    public static final String ACCION_DIMENSION_MATRIZ_VECTOR_DIFERENTE = "La dimension de las columnas de la matriz m1 debe ser igual a la dimension de las filas del vector para realizar la accion.";
    public static final String MATRIZ_NO_ES_CUADRADA = "La matriz debe ser cuadrada para realizar esta operacion";

    public MathComplexException(String mensaje) {
        super(mensaje);
    }
}
