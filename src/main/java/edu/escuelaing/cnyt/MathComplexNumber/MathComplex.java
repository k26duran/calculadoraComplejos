package edu.escuelaing.cnyt.MathComplexNumber;

import edu.escuelaing.cnyt.exceptions.MathComplexException;

/**
 * Esta clase contiene las operaciones que se pueden realizar con los numeros
 * complejos.
 *
 */
public class MathComplex {

    /**
     * Este metodo realiza la suma de dos numero complejos y devuelve el nuevo
     * numero complejo. Para la suma, debe sumar las partes reales de cada numero y
     * aparte las partes imaginarias de cada numero.
     *
     * @param c1 numero complejo.
     * @param c2 numero complejo.
     * @return ComplexNumber : el nuevo numero complejo resultado de la suma.
     */
    public static ComplexNumber add(ComplexNumber c1, ComplexNumber c2) {
        double real = c1.getReal() + c2.getReal();
        double imaginario = c1.getImaginario() + c2.getImaginario();
        return new ComplexNumber(real, imaginario);
    }

    /**
     * Este metodo realiza la multiplicacion de dos numero complejos y devuelve el
     * nuevo numero complejo. Segun la definicion se pueden multiplicar numero
     * complejos como: c1 = (a1, b1) y c2 = (a2, b2), entonces c1 x c2 es (a1,
     * b1)x(a2, b2) = (a1xa2-b1xb2, a1xb2+a2xb1)
     *
     * @param c1 numero complejo.
     * @param c2 numero complejo.
     * @return ComplexNumber : el nuevo numero complejo resultado de la
     *         multiplicacion.
     */
    public static ComplexNumber mult(ComplexNumber c1, ComplexNumber c2) {
        double real = (c1.getReal() * c2.getReal()) - (c1.getImaginario() * c2.getImaginario());
        double imaginario = (c1.getReal() * c2.getImaginario()) + (c1.getImaginario() * c2.getReal());
        return new ComplexNumber(real, imaginario);
    }

    /**
     * Este metodo realiza la resta de dos numero complejos y devuelve el nuevo
     * numero complejo. Para la resta, debe restar las partes reales de cada numero
     * y aparte las partes imaginarias de cada numero.
     *
     * @param c1 numero complejo.
     * @param c2 numero complejo.
     * @return ComplexNumber : el nuevo numero complejo resultado de la resta.
     */
    public static ComplexNumber sub(ComplexNumber c1, ComplexNumber c2) {
        return add(c1, c2.inversoAditivo());
    }

    /**
     * Este metodo realiza la division de dos numero complejos y devuelve el nuevo
     * numero complejo. Para la division se pueden dividir dos numero complejos
     * como: c1 = (a1, b1) y c2 = (a2, b2), entonces c1/c2 es (x, y) donde x =
     * (a1xa2+b1xb2)/(a2^2+b2^2), y = (a2xb1-a1xb2)/(a2^2+b2^2)
     *
     * @param c1 numero complejo.
     * @param c2 numero complejo.
     * @return ComplexNumber : el nuevo numero complejo resultado de la division.
     * @throws MathComplexException : si el denominador de la division es 0, la
     *                              division compleja no se encuentra definida.
     */
    public static ComplexNumber div(ComplexNumber c1, ComplexNumber c2) throws MathComplexException {
        if ((c2.getReal() == (double) 0) && (c2.getImaginario() == (double) 0)) {
            throw new MathComplexException(MathComplexException.DIVISION_COMPLEJA_CERO);
        }
        double denominador = Math.pow(c2.getReal(), 2) + Math.pow(c2.getImaginario(), 2);
        double real = ((c1.getReal() * c2.getReal()) + (c1.getImaginario() * c2.getImaginario())) / denominador;
        double imaginario = ((c2.getReal() * c1.getImaginario()) - (c1.getReal() * c2.getImaginario())) / denominador;
        return new ComplexNumber(real, imaginario);
    }

    /**
     * Este metodo convierte un numero complejo de coordenadas cartesianas a
     * coordenadas polares.
     *
     * @param c numero complejo.
     * @return ComplexNumber : el numero complejo con las coordenadas polares.
     */
    public static ComplexNumber cartesianoAPolar(ComplexNumber c) {
        return new ComplexNumber(c.modulo(), c.phase());
    }

    /**
     * Este metodo convierte un numero complejo de coordenadas polares a coordenadas
     * cartesianas.
     *
     * @param c numero complejo.
     * @return ComplexNumber : el numero complejo con las coordenadas cartesianas.
     */
    public static ComplexNumber polarACartesiano(ComplexNumber c) {
        return new ComplexNumber(c.getReal() * Math.cos(c.getImaginario()), c.getReal() * Math.sin(c.getImaginario()));
    }

    public static boolean igualdadComplejos(ComplexNumber tupla1, ComplexNumber tupla2) {
        double valorA1 = tupla1.getReal();
        double valorB1 = tupla1.getImaginario();
        double valorA2 = tupla2.getReal();
        double valorB2 = tupla2.getImaginario();
        return valorA2 == valorA1 && valorB1 == valorB2;
    }


    

}
