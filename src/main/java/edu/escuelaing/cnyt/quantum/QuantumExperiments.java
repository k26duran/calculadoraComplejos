package edu.escuelaing.cnyt.quantum;

import java.util.Arrays;

import edu.escuelaing.cnyt.MathComplexNumber.ComplexNumber;
import edu.escuelaing.cnyt.MathComplexNumber.MathComplex;
import edu.escuelaing.cnyt.exceptions.MathComplexException;

/**
 * Esta clase representa experimentos cuánticos realizados como el de las
 * canicas (número reales) y los fotones (número complejos), esto para poder
 * entender y pasar de la física clásica a la cuántica.
 *
 */
public class QuantumExperiments {

    private int[] cambioEstadoBooleanos(int[][] m, int[] v) throws MathComplexException {
        if (m[0].length != v.length) {
            throw new MathComplexException(MathComplexException.ACCION_DIMENSION_MATRIZ_VECTOR_DIFERENTE);
        }
        int[] accion = new int[v.length];
        int result = 0;
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                result = result + (m[i][j] * v[j]);
            }
            accion[i] = result;
            result = 0;
        }
        return accion;
    }

    private double[] cambioEstadoFracciones(double[][] m, double[] v) throws MathComplexException {
        if (m[0].length != v.length) {
            throw new MathComplexException(MathComplexException.ACCION_DIMENSION_MATRIZ_VECTOR_DIFERENTE);
        }
        double[] accion = new double[v.length];
        double result = 0;
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                result = result + (m[i][j] * v[j]);
            }
            accion[i] = result;
            result = 0;
        }
        return accion;
    }

    /**
     * Este metodo calcula y muestra el estado del sistema despues de ciertos
     * cambios de estado, dada una matriz de booleanos que describe como se
     * mueven las marbles, un estado inicial y la cantidad de cambios de estados
     * a realizar. Es decir devuelve cuantas canicas hay en cada vertice.
     *
     * @param matrizAdyacencia representa como se mueven las marbles en el
     * sistema.
     * @param estadoInicial es el estado inicial del sistema, es decir la
     * ubicacion inicial de las marbles.
     * @param cantidadCambios es la cantidad de "clicks" o cambios de estados a
     * realizar.
     * @return int[] - el estado del sistema despues de ciertos cambios de
     * estado.
     * @throws MathComplexException : si el numero de columnas de la matriz m es
     * diferente a la cantidad de filas del vector v es diferente, la accion no
     * esta definida.
     */
    public int[] experimentoConMarblesBooleano(int[][] matrizAdyacencia, int[] estadoInicial, int cantidadCambios) throws MathComplexException {
        int[] estadoFinal = estadoInicial;
        for (int i = 0; i < cantidadCambios; i++) {
            estadoFinal = cambioEstadoBooleanos(matrizAdyacencia, estadoFinal);
        }
        return estadoFinal;
    }

    /**
     * Este metodo calcula y muestra el estado del sistema despues de ciertos
     * cambios de estado, dada una matriz de adyacencia con fracciones que
     * describe como se mueven las marbles y al mismo tiempo el peso de ir de un
     * vertice a otro, un estado inicial y la cantidad de cambios de estados a
     * realizar. Es decir devuelve el costo de que una marble cambie de
     * posicion, lo que representa tambien la probabilidad de que cambie a un
     * estado.
     *
     * @param matrizAdyacencia representa como se mueven las marbles en el
     * sistema y el peso de ir de un vertice a otro.
     * @param estadoInicial es el estado inicial del sistema que en este caso es
     * una indeterminacion de la ubicacion de una marble.
     * @param cantidadCambios es la cantidad de "clicks" o cambios de estados a
     * realizar.
     * @return double[] - el estado del sistema con las probabilidades de que
     * una marble se haya dirigido a un vertice u a otro.
     * @throws MathComplexException : si el numero de columnas de la matriz m es
     * diferente a la cantidad de filas del vector v es diferente, la accion no
     * esta definida en los numeros complejos.
     */
    public double[] experimentoConMarblesFracciones(double[][] matrizAdyacencia, double[] estadoInicial, int cantidadCambios) throws MathComplexException {
        double[] estadoFinal = estadoInicial;
        for (int i = 0; i < cantidadCambios; i++) {
            estadoFinal = cambioEstadoFracciones(matrizAdyacencia, estadoFinal);
        }
        return estadoFinal;
    }

    /**
     * Este metodo calcula y muestra el estado del sistema despues de ciertos
     * cambios de estado, dada una matriz de adyacencia de numeros complejos que
     * describe la probabilidad de que un foton cambie de un estado a otro, un
     * estado inicial y la cantidad de cambios de estados a realizar. Es decir
     * devuelve la probabilidad de que un foton cambie a cualquier estado.
     *
     * @param matrizAdyacencia representala probabilidad de que un foton cambie
     * de un estado a otro.
     * @param estadoInicial es el estado inicial del sistema que en este caso es
     * una indeterminacion de la ubicacion de una marble.
     * @param cantidadCambios es la cantidad de "clicks" o cambios de estados a
     * realizar.
     * @return ComplexNumber[] - el estado del sistema con las probabilidades de
     * que una marble se haya dirigido a un vertice u a otro.
     * @throws MathComplexException : si el numero de columnas de la matriz m es
     * diferente a la cantidad de filas del vector v es diferente, la accion no
     * esta definida en los numeros complejos.
     */
    public ComplexNumber[] experimentoConFotonesComplejos(ComplexNumber[][] matrizAdyacencia, ComplexNumber[] estadoInicial, int cantidadCambios) throws MathComplexException {
        ComplexNumber[] estadoFinal = estadoInicial;
        for (int i = 0; i < cantidadCambios; i++) {
            estadoFinal = MathComplex.accion(matrizAdyacencia, estadoFinal);
        }
        return estadoFinal;
    }

    private double[][] multiplicarMatrices(double[][] m1, double[][] m2) {
        double[][] multiplicacionMatrices = new double[m1.length][m2[0].length];
        if (m1[0].length != m2.length) {
            System.out.println("No se pueden multiplicar matrices con dimensiones diferentes.");
        }
        double result;
        int i;
        int j;
        for (int i_f = 0; i_f < m1.length; i_f++) {
            for (int j_f = 0; j_f < m2[0].length; j_f++) {
                result = 0;
                i = 0;
                j = 0;
                while (j < m1[0].length && i < m2.length) {
                    result = result + (m1[i_f][j] * m2[i][j_f]);
                    j++;
                    i++;
                }
                multiplicacionMatrices[i_f][j_f] = result;
            }
        }
        return multiplicacionMatrices;
    }

    private void mostrarMatrizAdyacencia(double[][] m) {
        System.out.println("MatrizBala:");
        for (int i = 0; i < m.length; i++) {
            System.out.print("|");
            for (int j = 0; j < m[0].length; j++) {
                System.out.printf("%.3f", m[i][j]);
                System.out.print("|");
            }
            System.out.println("");
        }
    }

    private void mostrarVectorCambioEstado(double[] y) {
        System.out.println("VectorBala:");
        System.out.print("|");
        for (int i = 0; i < y.length; i++) {
            System.out.printf("%.3f", y[i]);
            System.out.print("|");
        }
        System.out.println("");
    }

    private String matrizAString(double[][] m) {
        String matrizString = "[";
        for (int i = 0; i < m.length; i++) {
            if (i + 1 == m.length) {
                matrizString += Arrays.toString(m[i]) + "]";
            } else {
                matrizString += Arrays.toString(m[i]) + ", ";
            }
        }
        return matrizString;
    }

    /**
     * Este metodo representa el experimento probabilístico de las dobles
     * rendijas (en este caso con 2 o más rendijas). Con este experimento se
     * logro demostrar que al lanzar una bala (o un electron) por las rendijas,
     * existe cierta posibilidad que tome cualquier camino, por lo que puede
     * pasar por cualquier rendija. En este experimento clásico se establece que
     * al lanzar las particulas (balas o canicas) se forma un patron con forma
     * de franja en el lugar donde se esta recibiendo los disparos. Muestra la
     * matriz que se forma de las probabilidades de que las balas lleguen a
     * distintos objetivos y el vector estado despues de realizar dos cambios de
     * estado.
     *
     * @param numeroSlits representa la cantidad de rendijas a usar.
     * @param numeroTargets representa la cantidad de objetivos despues de las
     * rendijas.
     * @param probabilidades es una matriz con la probabilidades de que una
     * particula vaya de una rendija a un objetivo.
     * @return String[] : retorna la matriz multiplicada por si misma y el
     * vector estado despues de realizar dos clicks.
     * @throws MathComplexException : si la dimension de las columnas de m1 son
     * distintas a las filas de m2, la multiplicacion entre matrices no esta
     * definida.
     */
    public String[] experimentoMultirendijasBalas(int numeroSlits, int numeroTargets, double[][] probabilidades) throws MathComplexException {
        int n = numeroSlits + numeroTargets + 1;
        double[][] matrizAdyacencia = probabilidades;
        for (int i = 1; i < numeroSlits + 1; i++) {
            matrizAdyacencia[i][0] = 1.0 / ((double) numeroSlits);
        }
        for (int i = numeroSlits + 1; i < probabilidades.length; i++) {
            matrizAdyacencia[i][i] = 1.0;
        }
        double[] x = new double[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                x[i] = 1.0;
            } else {
                x[i] = 0.0;
            }
        }
        double[][] matrizAdyacencia2 = multiplicarMatrices(matrizAdyacencia, matrizAdyacencia);
        double[] y = cambioEstadoFracciones(matrizAdyacencia2, x);
        mostrarMatrizAdyacencia(matrizAdyacencia2);
        mostrarVectorCambioEstado(y);
        String[] matrizVector = {matrizAString(matrizAdyacencia2), Arrays.toString(y)};
        return matrizVector;
    }

    private String verificarInterferencias(ComplexNumber[][] m, int numeroSlits) {
        ComplexNumber cero = new ComplexNumber(0, 0);
        String interferencias = "interferencias: ";
        for (int i = numeroSlits + 1; i < m.length; i++) {
            if (m[i][0].equals(cero)) {
                interferencias += "[" + i + "," + 0 + "] ";
            }
        }
        return interferencias;
    }

    private void mostrarMatrizFoton(ComplexNumber[][] m) {
        System.out.println("MatrizFoton:");
        for (int i = 0; i < m.length; i++) {
            System.out.print("|");
            for (int j = 0; j < m[0].length; j++) {
                System.out.printf(m[i][j].prettyPrintFormaNormalNumeroComplejo());
                System.out.print("|");
            }
            System.out.println("");
        }
    }

    private void mostrarVectorFoton(ComplexNumber[] y) {
        System.out.println("VectorFoton:");
        System.out.print("|");
        for (int i = 0; i < y.length; i++) {
            System.out.printf(y[i].prettyPrintFormaNormalNumeroComplejo());
            System.out.print("|");
        }
        System.out.println("");
    }

    private String matrizAStringFoton(ComplexNumber[][] m) {
        String matrizString = "[";
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                if (i + 1 == m.length) {
                    matrizString += m[i][j].prettyPrintFormaNormalNumeroComplejo();
                } else {
                    matrizString += m[i][j].prettyPrintFormaNormalNumeroComplejo() + ", ";
                }
            }
            matrizString += "]";
        }
        return matrizString;
    }

    private String vectorAStringFoton(ComplexNumber[] y) {
        String vectorS = "{";
        for (int i = 0; i < y.length; i++) {
            if (i + 1 == y.length) {
                vectorS += y[i].prettyPrintFormaNormalNumeroComplejo();
            } else {
                vectorS += y[i].prettyPrintFormaNormalNumeroComplejo() + ", ";
            }
        }
        vectorS = "}";
        return vectorS;
    }

    /**
     * Este metodo representa el experimento probabilístico de las dobles
     * rendijas (en este caso con 2 o más rendijas). Con este experimento se
     * logro demostrar que al lanzar un foton por las rendijas, este toma varios
     * caminos simultaneamente cuando no es medido, formando un patron llamado
     * interferencia, que se refiere al choque de varias ondas al mismo tiempo.
     * Este experimento es el paso de lo clasico a lo cuantico. Muestra la
     * matriz de complejos que se forma de las probabilidades de que los fotones
     * lleguen a distintos objetivos y el vector estado de complejos despues de
     * realizar dos clicks. Aqui tambien se verifican si existen interferencias,
     * es decir,existen dos caminos para llegar a un mismo objetivo, por lo que
     * se cancelan los numeros complejos cuando son sumados.
     *
     * @param numeroSlits representa la cantidad de rendijas a usar.
     * @param numeroTargets representa la cantidad de objetivos despues de las
     * rendijas.
     * @param probabilidades es una matriz con la probabilidades de que un foton
     * vaya de una rendija a un objetivo.
     * @return String[] : retorna la matriz multiplicada por si misma y el
     * vector estado despues de realizar dos clicks.
     * @throws MathComplexException : si la dimension de las columnas de m1 son
     * distintas a las filas de m2, la multiplicacion entre matrices no esta
     * definida en los numeros complejos.
     */
    public String[] experimentoMultirendijasFotones(int numeroSlits, int numeroTargets, ComplexNumber[][] probabilidades) throws MathComplexException {
        int n = numeroSlits + numeroTargets + 1;
        ComplexNumber[][] matrizAdyacencia = probabilidades;
        for (int i = 1; i < numeroSlits + 1; i++) {
            matrizAdyacencia[i][0] = new ComplexNumber(Math.sqrt(1.0 / ((double) numeroSlits)), 0);
        }
        for (int i = numeroSlits + 1; i < probabilidades.length; i++) {
            matrizAdyacencia[i][i] = new ComplexNumber(1.0, 0);
        }
        ComplexNumber[] x = new ComplexNumber[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                x[i] = new ComplexNumber(1.0, 0);
            } else {
                x[i] = new ComplexNumber(0.0, 0);
            }
        }
        ComplexNumber[][] matrizAdyacencia2 = MathComplex.multiplicarMatrices(matrizAdyacencia, matrizAdyacencia);
        ComplexNumber[] y = MathComplex.accion(matrizAdyacencia2, x);
        mostrarMatrizFoton(matrizAdyacencia2);
        mostrarVectorFoton(y);
        String[] matrizVector = {matrizAStringFoton(matrizAdyacencia2), vectorAStringFoton(y), verificarInterferencias(matrizAdyacencia2, numeroSlits)};
        return matrizVector;
    }

}
