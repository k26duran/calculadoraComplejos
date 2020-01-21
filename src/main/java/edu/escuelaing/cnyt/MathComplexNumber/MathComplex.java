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
    
    /**
     * Este método compara dos números complejos para saber si son iguales o no
     * @param tupla1 número complejo a comparar
     * @param tupla2 número complejo a comparar
     * @return un boolean que indica si son iguales o no son iguales
     */

    public static boolean igualdadComplejos(ComplexNumber tupla1, ComplexNumber tupla2) {
        double valorA1 = tupla1.getReal();
        double valorB1 = tupla1.getImaginario();
        double valorA2 = tupla2.getReal();
        double valorB2 = tupla2.getImaginario();
        return valorA2 == valorA1 && valorB1 == valorB2;
    }
    
    /**
     * Este método realiza la suma entre dos vectores dados y devuelve un nuevo
     * vector de complejos. Para sumar dos vectores, se suma cada componente de un
     * vector con el respectivo componente del otro vector.
     *
     * @param v1 vector de complejos.
     * @param v2 vector de complejos.
     * @return ComplexNumber[] : el vector de complejos resultante de la suma.
     * @throws MathComplexException : si la longitud de los vectores es diferente,
     *                              la suma vectorial no esta definida en los
     *                              números complejos.
     */
    public static ComplexNumber[] sumarVectores(ComplexNumber[] v1, ComplexNumber[] v2) throws MathComplexException {
        if (v1.length != v2.length) {
            throw new MathComplexException(MathComplexException.LONGITUD_VECTORES_DIFERENTE);
        }
        ComplexNumber[] sumaVectores = new ComplexNumber[v1.length];
        for (int i = 0; i < v1.length; i++) {
            sumaVectores[i] = add(v1[i], v2[i]);
        }
        return sumaVectores;
    }
    
    /**
     * Este método calcula el inverso aditivo de un vector dado, el inverso aditivo de un vector
     * es el inverso aditivo de cada uno de sus componentes, los cuales son un número complejo
     * @param v vector de complejos
     * @return ComplexNumber[] : el vector inverso de complejos
     *  
     */
    public static ComplexNumber[] inversoVector(ComplexNumber[] v) {
        ComplexNumber[] inversoVector = new ComplexNumber[v.length];
        for (int i = 0; i < v.length; i++) {
            inversoVector[i] = v[i].inversoAditivo();
        }
        return inversoVector;
    }
    
    /**
     * Este método calcula el conjugado de un vector de complejos. El conjugado de un vector de complejos es 
     * el conjugado de cada uno de sus componentes que son números complejos 
     * @param v vector de complejos
     * @return ComplexNumber[] : el conjugado del vector de complejos
     */
    public static ComplexNumber[] conjugadoVector(ComplexNumber[] v) {
        ComplexNumber[] conjugadoVector = new ComplexNumber[v.length];
        for (int i = 0; i < v.length; i++) {
            conjugadoVector[i] = v[i].Conjugado();
        }
        return conjugadoVector;
    }
    
    /**
     * Este método calcula la multiplicación entre un vector de números complejos y un número complejo.
     * La multiplicación escalar se hace multiplicando el número complejo con cada uno de los 
     * elementos del vector de números complejos.
     * @param c número complejo
     * @param v vector de complejos
     * @return ComplexNumber[] : el vector resultado de la multiplicación escalar
     */
    public static ComplexNumber[] multiplicacionEscalarConVectores(ComplexNumber c, ComplexNumber[] v) {
        ComplexNumber[] multiplicacionEscalarVectores = new ComplexNumber[v.length];
        for (int i = 0; i < v.length; i++) {
            multiplicacionEscalarVectores[i] = mult(c, v[i]);
        }
        return multiplicacionEscalarVectores;
    }
    
    /**
     * Este método calcula el producto interno entre dos vectores, también conocido
     * como producto punto. Esta operación se calcula obteniendo el conjugado del
     * primer vector, multiplicarlo por el segundo vector y por último sumar todos 
     * los elementos del vector resultante.
     * @param v1 vector de números complejos
     * @param v2 vector de números complejos
     * @return ComplexNumber[] : vector resultante del producto interno entre 
     * dos vectores
     * @throws MathComplexException si la longitud de los vectores es diferente,
     *                              el producto interno no esta definido para los
     *                              numeros complejos.
     */
    public static ComplexNumber productoInternoVectores(ComplexNumber[] v1, ComplexNumber[] v2)
            throws MathComplexException {
        if (v1.length != v2.length) {
            throw new MathComplexException(MathComplexException.LONGITUD_VECTORES_DIFERENTE);
        }
        ComplexNumber productoInternoVector = new ComplexNumber();
        ComplexNumber[] vC = conjugadoVector(v1);
        for (int i = 0; i < v1.length; i++) {
            productoInternoVector = add(productoInternoVector, mult(vC[i], v2[i]));
        }
        return productoInternoVector;
    }
    
    /**
     * Este método calcula la distancia entre dos vectores de números complejos.
     * La distancia se halla de la siguiente manera: d = (productoInterno(v1-v2, v1-v2))^(1/2)
     * @param v1 vector de números complejos
     * @param v2 vector de números complejos
     * @return Un double que es el resultado de la distancia entre dos vectores de números complejos
     * @throws MathComplexException si la longitud de los vectores es diferente, entonces no se puede hallar 
     * 								la distancia entre estos.
     */
    public static double distanciaEntreVectores(ComplexNumber[] v1, ComplexNumber[] v2) throws MathComplexException {
        ComplexNumber[] resta = sumarVectores(v1, inversoVector(v2));
        return Math.sqrt(productoInternoVectores(resta, resta).getReal());
    }
    
    /**
    * Este método calcula la norma o longitud de un vector de complejos.
    * @param v vector complejo
    * @return double : un numero real que representa la norma o longitud del vector v de complejos
    * @throws MathComplexException : si la longitud de los vectores es diferente,
    *                              el producto interno no esta definido para los
    *                              numeros complejos.
    */
   public static double normaVector(ComplexNumber[] v) throws MathComplexException {
       return Math.sqrt(productoInternoVectores(v, v).getReal());
   }
   
   /**
    * Este método compara dos vectores complejos. Para esto, verifica que cada uno
    * de los componentes del primer vector sean iguales a los del segundo vector.
    *
    * @param v1 vector de complejos.
    * @param v2 vector de complejos.
    * @return boolean : true si son iguales, false si no lo son.
    */
   public static boolean equalsVector(ComplexNumber[] v1, ComplexNumber[] v2) {
       boolean equals = true;
       if (v1.length != v2.length) {
           equals = false;
       } else {
           for (int i = 0; i < v1.length && equals; i++) {
               if (!v1[i].equals(v2[i])) {
                   equals = false;
               }
           }
       }
       return equals;
   }

    

}
