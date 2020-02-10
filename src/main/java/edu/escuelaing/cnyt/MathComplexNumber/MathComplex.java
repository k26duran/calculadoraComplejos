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
   /**
    * Este metodo realiza la suma entre matrices de complejos. Para sumar matrices
    * se suman cada uno de los componentes de una matriz con los respectivos de la
    * otra.
    *
    * @param m1 matriz de complejos.
    * @param m2 matriz de complejos.
    * @return ComplexNumber[][] : una matriz de complejos resultado de la suma.
    * @throws MathComplexException : si las matrices a sumar tienen una dimension
    *                              diferente, la suma matricial no esta definida en
    *                              los numeros complejos.
    */
   public static ComplexNumber[][] sumarMatrices(ComplexNumber[][] m1, ComplexNumber[][] m2)
           throws MathComplexException {
       if (m1.length != m2.length || m1[0].length != m2[0].length) {
           throw new MathComplexException(MathComplexException.SUMA_DIMENSION_MATRICES_DIFERENTE);
       }
       ComplexNumber[][] sumaMatrices = new ComplexNumber[m1.length][m1[0].length];
       for (int i = 0; i < m1.length; i++) {
           sumaMatrices[i] = sumarVectores(m1[i], m2[i]);
       }
       return sumaMatrices;
   }
   /**
    * Este metodo retorna el inverso aditivo de una matriz de complejos. El inverso
    * aditivo de una matriz es calcular el inverso aditivo de cada uno de sus
    * componentes.
    *
    * @param m matriz de complejos.
    * @return ComplexNumber[][] : el inverso de la matriz de complejos.
    */
   public static ComplexNumber[][] inversoMatriz(ComplexNumber[][] m) {
       ComplexNumber[][] inversoMatriz = new ComplexNumber[m.length][m[0].length];
       for (int i = 0; i < m.length; i++) {
           inversoMatriz[i] = inversoVector(m[i]);
       }
       return inversoMatriz;
   }

   /**
    * Este metodo realiza la multiplicacion escalar entre un complejo y una matriz
    * de complejos. La multiplicacion escalar es multiplicar un numero complejo
    * dado con cada componente de la matriz.
    *
    * @param c el complejo escalar a multiplicar.
    * @param m la matriz de complejos al que se le va a multiplicar el escalar.
    * @return ComplexNumber[][] : una matriz de complejos resultado de la
    *         multiplicacion escalar.
    */
   public static ComplexNumber[][] multiplicacionEscalarConMatrices(ComplexNumber c, ComplexNumber[][] m) {
       ComplexNumber[][] multiplicacionEscalarMatrices = new ComplexNumber[m.length][m[0].length];
       for (int i = 0; i < m.length; i++) {
           multiplicacionEscalarMatrices[i] = multiplicacionEscalarConVectores(c, m[i]);
       }
       return multiplicacionEscalarMatrices;
   }

   /**
    * Este metodo calcula el conjugado de una matriz de complejos. El conjugado de
    * una matriz es calcular el conjugado de cada uno de sus componentes.
    *
    * @param m matriz de complejos.
    * @return ComplexNumber[][] : el conjugado de la matriz de complejos.
    */
   public static ComplexNumber[][] conjugadoMatriz(ComplexNumber[][] m) {
       ComplexNumber[][] conjugadoMatriz = new ComplexNumber[m.length][m[0].length];
       for (int i = 0; i < m.length; i++) {
           conjugadoMatriz[i] = conjugadoVector(m[i]);
       }
       return conjugadoMatriz;
   }

   /**
    * Este metodo calcula la transpuesta de una matriz de complejos. La transpuesta
    * de una matriz es cambiar las filas de la matriz por sus columnas y las
    * columnas por las filas.
    *
    * @param m matriz de complejos.
    * @return ComplexNumber[][] : la transpuesta de la matriz de complejos.
    */
   public static ComplexNumber[][] transpuestaMatriz(ComplexNumber[][] m) {
       ComplexNumber[][] transpuestaMatriz = new ComplexNumber[m[0].length][m.length];
       for (int i = 0; i < m[0].length; i++) {
           for (int j = 0; j < m.length; j++) {
               transpuestaMatriz[i][j] = m[j][i];
           }
       }
       return transpuestaMatriz;
   }

   /**
    * Este metodo calcula la adjunta de la matriz de complejos dada, es decir que
    * la transpone y luego la conjuga.
    *
    * @param m matriz de complejos.
    * @return ComplexNumber[][] : la adjunta de la matriz de complejos.
    */
   public static ComplexNumber[][] adjuntaMatriz(ComplexNumber[][] m) {
       return conjugadoMatriz(transpuestaMatriz(m));
   }

   /**
    * Este metodo realiza la multiplicacion entre matrices complejas. La
    * multiplicacion entre matrices se realiza multiplicando los componentes de las
    * filas de la primera matriz con las columnas de la segunda matriz, para
    * finalmente sumar el resultado e ir formando la nueva matriz.
    *
    * @param m1 matriz compleja.
    * @param m2 matriz compleja.
    * @return ComplexNumber[][] : una matriz compleja resultado de la
    *         multiplicacion de las matrices.
    * @throws MathComplexException : si la dimension de las columnas de m1 son
    *                              distintas a las filas de m2, la multiplicacion
    *                              entre matrices no esta definida en los numeros
    *                              complejos.
    */
   public static ComplexNumber[][] multiplicarMatrices(ComplexNumber[][] m1, ComplexNumber[][] m2)
           throws MathComplexException {
       if (m1[0].length != m2.length) {
           throw new MathComplexException(MathComplexException.MULTIPLICACION_DIMENSION_MATRICES_DIFERENTE);
       }
       ComplexNumber[][] multiplicacionMatrices = new ComplexNumber[m1.length][m2[0].length];
       ComplexNumber result;
       int i;
       int j;
       for (int i_f = 0; i_f < m1.length; i_f++) {
           for (int j_f = 0; j_f < m2[0].length; j_f++) {
               result = new ComplexNumber();
               i = 0;
               j = 0;
               while (j < m1[0].length && i < m2.length) {
                   result = add(result, mult(m1[i_f][j], m2[i][j_f]));
                   j++;
                   i++;
               }
               multiplicacionMatrices[i_f][j_f] = result;
           }
       }
       return multiplicacionMatrices;
   }

   /**
    * Este metodo calcula y retorna la traza de una matriz de complejos. La traza
    * de una matriz es la suma de los elementos de su diagonal principal.
    *
    * @param m matriz compleja.
    * @return ComplexNumber : un numero complejo, como resultado de calcular la
    *         traza de la matriz m.
    */
   public static ComplexNumber trace(ComplexNumber[][] m) {
       ComplexNumber trace = new ComplexNumber();
       for (int i = 0; i < m.length; i++) {
           if (i < m[0].length) {
               trace = add(trace, m[i][i]);
           }
       }
       return trace;
   }

   /**
    * Este metodo calcula el producto interno entre dos matrices complejas. El
    * producto interno entre matrices se define como la traza de la matriz
    * resultante de multiplicar la adjunta de la primera matriz con la segunda
    * matriz.
    *
    * @param m1 matriz compleja.
    * @param m2 matriz compleja.
    * @return ComplexNumber : un numero complejo resultado del producto interno
    *         entre las matrices complejas m1 y m2.
    * @throws MathComplexException : si la dimension de las columnas de m1 son
    *                              distintas a las filas de m2, la multiplicacion
    *                              entre matrices no esta definida en los numeros
    *                              complejos.
    */
   public static ComplexNumber productoInternoMatrices(ComplexNumber[][] m1, ComplexNumber[][] m2)
           throws MathComplexException {
       return trace(multiplicarMatrices(adjuntaMatriz(m1), m2));
   }

   /**
    * Este metodo calcula la accion retornando un vector de complejos, resultado de
    * operar una matriz y un vector ambos de complejos.
    *
    * @param m matriz compleja.
    * @param v vector compejo.
    * @return ComplexNumber[] : el resultado de la accion entre la matriz y el
    *         vector de complejos.
    * @throws MathComplexException : si el numero de columnas de la matriz m es
    *                              diferente a la cantidad de filas del vector v es
    *                              diferente, la accion no esta definida en los
    *                              numeros complejos.
    */
   public static ComplexNumber[] accion(ComplexNumber[][] m, ComplexNumber[] v) throws MathComplexException {
       if (m[0].length != v.length) {
           throw new MathComplexException(MathComplexException.ACCION_DIMENSION_MATRIZ_VECTOR_DIFERENTE);
       }
       ComplexNumber[] accion = new ComplexNumber[v.length];
       ComplexNumber result;
       for (int i = 0; i < v.length; i++) {
           result = new ComplexNumber();
           for (int j = 0; j < m[0].length; j++) {
               result = add(result, mult(m[i][j], v[j]));
           }
           accion[i] = result;
       }
       return accion;
   }

   /**
    * Este metodo determina si una matriz cuadrada es hermitiana, es decir, si la
    * adjunta de la matriz compleja es igual a la matriz original.
    *
    * @param m matriz compleja.
    * @return boolean : true si la matriz dada es hermitiana. En caso contrario,
    *         false.
    * @throws MathComplexException : si la matriz m no es cuadrada, la definicion
    *                              de hermitiana no esta definida en los numeros
    *                              complejos.
    */
   public static boolean esHermitiana(ComplexNumber[][] m) throws MathComplexException {
       if (m.length != m[0].length) {
           throw new MathComplexException(MathComplexException.MATRIZ_NO_ES_CUADRADA);
       }
       boolean esHermitana;
       ComplexNumber[][] adjuntaM = adjuntaMatriz(m);
       esHermitana = equalsMatriz(adjuntaM, m);
       return esHermitana;
   }

   /**
    * Este metodo determina cual es la matriz unitaria para n filas y n columnas.
    *
    * @param n es el numero de filas y columnas.
    * @return ComplexNumber[][] : la matriz unitaria respectiva.
    */
   public static ComplexNumber[][] matrizIdentidad(int n) {
       ComplexNumber[][] in = new ComplexNumber[n][n];
       for (int i = 0; i < n; i++) {
           for (int j = 0; j < n; j++) {
               if (i == j) {
                   in[i][j] = new ComplexNumber(1, 0);
               } else {
                   in[i][j] = new ComplexNumber(0, 0);
               }
           }
       }
       return in;
   }

   /**
    * Este metodo determina si una matriz es unitaria, es decir, si el prodcuto
    * entre la matriz compleja con su adjunta da como resultado la matriz
    * identidad.
    *
    * @param m matriz compleja.
    * @return boolean : true si la matriz dada es unitaria. En caso contrario
    *         false.
    * @throws MathComplexException : si la matriz m no es cuadrada, la definicion
    *                              de unitario no esta definida en los numeros
    *                              complejos.
    */
   public static boolean esUnitaria(ComplexNumber[][] m) throws MathComplexException {
       if (m.length != m[0].length) {
           throw new MathComplexException(MathComplexException.MATRIZ_NO_ES_CUADRADA);
       }
       boolean esUnitaria;
       ComplexNumber[][] in = matrizIdentidad(m.length);
       ComplexNumber[][] productoMatAdj = multiplicarMatrices(m, adjuntaMatriz(m));
       esUnitaria = equalsMatriz(productoMatAdj, in);
       return esUnitaria;
   }

   private static ComplexNumber[][] anadirComplejo(ComplexNumber complejoAnadir, int filas, int columnas,
           ComplexNumber[][] pTensor, ComplexNumber[][] m2) {
       ComplexNumber[][] nTensor = pTensor;
       for (int i = 0; i < m2.length; i++) {
           for (int a = 0; a < m2[0].length; a++) {
               nTensor[i + filas][a + columnas] = mult(complejoAnadir, m2[i][a]);
           }
       }
       return nTensor;
   }

   /**
    * Este metodo calcula el producto tensor entre dos matrices. El producto tensor
    * es multiplicar cada componente de la primera matriz con toda la segunda
    * matriz, realizando la multiplicacion escalar por cada componente.
    *
    * @param m1 matriz de complejos
    * @param m2 matriz de complejos
    * @return ComplexNumber[][] : matriz con dimension igual a la dimension de m1
    *         veces la dimension de m2.
    */
   public static ComplexNumber[][] productoTensorMatrices(ComplexNumber[][] m1, ComplexNumber[][] m2) {
       ComplexNumber[][] productotensor = new ComplexNumber[m1.length * m2.length][m1[0].length * m2[0].length];
       int f = 0;
       int c = 0;
       for (int i = 0; i < m1.length; i++) {
           for (int a = 0; a < m1[0].length; a++) {
               productotensor = anadirComplejo(m1[i][a], f, c, productotensor, m2);
               c += (m2[0].length);
           }
           c = 0;
           f += m2.length;
       }
       return productotensor;
   }

   /**
    * Este metodo calcula la norma de un vector estado de complejos. Obtiene la
    * raiz cuadrada de la suma del modulo cuadrado de cada elemento.
    *
    * @param k vector estado ket con entradas complejas.
    * @return double : un numero real que representa la norma de un vector estado
    *         ket.
    */
   public static double normaKet(ComplexNumber[] k) {
       double norma = 0;
       for (int i = 0; i < k.length; i++) {
           norma += Math.pow(k[i].modulo(), 2);
       }
       norma = Math.sqrt(norma);
       return norma;
   }

   /**
    * Este metodo normaliza un vector ket. La representacion del ket no cambia,
    * pero un ket normalizado se encuentra dentro del circulo unitario. La norma de
    * este vector es igual a 1.
    *
    * @param k representa el vector ket a normalizar.
    * @return ComplexNumber[] : el nuevo vector normalizado.
    */
   public static ComplexNumber[] normalizarVector(ComplexNumber[] k) {
       ComplexNumber[] vectorNormalizado = new ComplexNumber[k.length];
       double norma = normaKet(k);
       for (int i = 0; i < k.length; i++) {
           vectorNormalizado[i] = new ComplexNumber((k[i].getReal()) / norma, (k[i].getImaginario()) / norma);
       }
       return vectorNormalizado;
   }
   /**
    * Este metodo compara dos matrices complejas. Para esto, verifica que cada uno
    * de los componentes de la primera matriz sean iguales a los de la segunda
    * matriz.
    *
    * @param m1 matriz de complejos.
    * @param m2 matriz de complejos.
    * @return boolean : true si son iguales, false si no lo son.
    */
   public static boolean equalsMatriz(ComplexNumber[][] m1, ComplexNumber[][] m2) {
       boolean equals = true;
       if (m1.length != m2.length && m1[0].length != m2[0].length) {
           equals = false;
       } else {
           for (int i = 0; i < m1.length && equals; i++) {
               if (!equalsVector(m1[i], m2[i])) {
                   equals = false;
               }
           }
       }
       return equals;
   }

   /**
    * Este metodo convierte una matriz de complejos a un string de la forma
    * {{a,b+ci},{d+ei,f}}
    *
    * @param m representa la matriz a convertir a String.
    * @return String : representa la cadena de la matriz de complejos entrante.
    */
   public static String matrizToString(ComplexNumber[][] m) {
       String matrizString = "{";
       for (int i = 0; i < m.length; i++) {
           matrizString += "{";
           for (int j = 0; j < m[0].length; j++) {
               if (j + 1 == m[0].length) {
                   if (m[i][j].getReal() == 0) {
                       matrizString += m[i][j].getImaginario() + "i";
                   } else if (m[i][j].getImaginario() == 0) {
                       matrizString += m[i][j].getReal();
                   } else {
                       matrizString += m[i][j].getReal() + "" + m[i][j].getImaginario() + "i";
                   }
               } else {
                   if (m[i][j].getReal() == 0) {
                       matrizString += m[i][j].getImaginario() + "i,";
                   } else if (m[i][j].getImaginario() == 0) {
                       matrizString += m[i][j].getReal() + ",";
                   } else {
                       matrizString += m[i][j].getReal() + "" + m[i][j].getImaginario() + "i,";
                   }
               }
           }
           if (i + 1 == m.length) {
               matrizString += "}";
           } else {
               matrizString += "},";
           }
       }
       matrizString += "}";
       return matrizString;
   }


}
