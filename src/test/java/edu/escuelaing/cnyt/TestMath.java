package edu.escuelaing.cnyt;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.Test;
import static org.junit.Assert.*;
import edu.escuelaing.cnyt.MathComplexNumber.*;
import edu.escuelaing.cnyt.exceptions.MathComplexException;

/**
 * En esta clase se realizan las pruebas de los métodos de la calculadora para ver si son correctos o no.
 */
public class TestMath {

    @Test
    public void test_Calcular_Suma() {
        boolean flagEsperada = true;
        ComplexNumber valorEsperado = new ComplexNumber(8, 11);
        ComplexNumber valor1 = new ComplexNumber(5, 3);
        ComplexNumber valor2 = new ComplexNumber(3, 8);
        ComplexNumber valorRespuesta = MathComplex.add(valor1, valor2);
        System.out.println(valorRespuesta.prettyPrintFormaNormalNumeroComplejo());
        boolean flag = MathComplex.igualdadComplejos(valorEsperado, valorRespuesta);
        assertEquals(flagEsperada, flag);
    }

    @Test
    public void test_Calcular_Resta() {
        boolean flagEsperada = true;
        ComplexNumber valorEsperado = new ComplexNumber(4, 12);
        ComplexNumber valor1 = new ComplexNumber(8, 20);
        ComplexNumber valor2 = new ComplexNumber(4, 8);
        ComplexNumber valorRespuesta = MathComplex.sub(valor1, valor2);
        System.out.println(valorRespuesta.prettyPrintFormaNormalNumeroComplejo());
        boolean flag = MathComplex.igualdadComplejos(valorEsperado, valorRespuesta);
        assertEquals(flagEsperada, flag);
    }

    @Test
    public void test_Calcular_Multiplicacion() {
        boolean flagEsperada = true;
        ComplexNumber valorEsperado = new ComplexNumber(7, 4);
        ComplexNumber valor1 = new ComplexNumber(3, -2);
        ComplexNumber valor2 = new ComplexNumber(1, 2);
        ComplexNumber valorRespuesta = MathComplex.mult(valor1, valor2);
        System.out.println(valorRespuesta.prettyPrintFormaNormalNumeroComplejo());
        boolean flag = MathComplex.igualdadComplejos(valorEsperado, valorRespuesta);
        assertEquals(flagEsperada, flag);
    }

    @Test
    public void testNoDeberiaDividirDosNumeroComplejosSiElDenominadorEsCero() {
        ComplexNumber c1 = new ComplexNumber(-8, 3);
        ComplexNumber c2 = new ComplexNumber(0, 0);
        try {
            MathComplex.div(c1, c2);
            fail("La división se logro exitosamente.");
        } catch (MathComplexException e) {
            assertTrue(e.getMessage().equals(MathComplexException.DIVISION_COMPLEJA_CERO));
        }
    }

    @Test
    public void test_Deberia_Dividir_Dos_Numero_Complejos1() {
        ComplexNumber c1 = new ComplexNumber(5, 0);
        ComplexNumber c2 = new ComplexNumber(0, 2);
        try {
            ComplexNumber result1 = MathComplex.div(c1, c2);
            ComplexNumber resultToCompare1 = new ComplexNumber(0, -2.5);
            assertTrue(resultToCompare1.equals(result1));
        } catch (MathComplexException e) {
            System.out.println(e.getMessage());
            fail("La división no se pudo realizar");
        }

        ComplexNumber c3 = new ComplexNumber(0, 5);
        ComplexNumber c4 = new ComplexNumber(2, 0);
        try {
            ComplexNumber result2 = MathComplex.div(c3, c4);
            ComplexNumber resultToCompare2 = new ComplexNumber(0, 2.5);
            assertTrue(resultToCompare2.equals(result2));
        } catch (MathComplexException e) {
            System.out.println(e.getMessage());
            fail("La división no se pudo realizar");
        }
    }

    @Test
    public void test_Cartesiano_A_Polar(){
        boolean flagEsperada = true;
        ComplexNumber valorEsperado = new ComplexNumber(1.4142135623730951,0.7853981633974483);
        ComplexNumber valor1 = new ComplexNumber(1, 1);
        ComplexNumber valorRespuesta = MathComplex.cartesianoAPolar(valor1);
        System.out.println(valorRespuesta.prettyPrintFormaNormalNumeroComplejo());
        boolean flag = MathComplex.igualdadComplejos(valorEsperado, valorRespuesta);
        assertEquals(flagEsperada, flag);
    }
    
    @Test
    public void test_Polar_A_Cartesiano() {
        boolean flagEsperada = false;
        ComplexNumber valorEsperado = new ComplexNumber(1, 1);
        ComplexNumber valor1 = new ComplexNumber(1.4142135623730951, 0.7853981633974483);
        ComplexNumber valorRespuesta = MathComplex.polarACartesiano(valor1);
        System.out.println(valorRespuesta.toString()+"00000000000");
        boolean flag = MathComplex.igualdadComplejos(valorEsperado, valorRespuesta);
        assertEquals(flagEsperada, flag);
    }

    @Test
    public void test_Modulo() {
        ComplexNumber valor1 = new ComplexNumber(4, 3);
        double valorRespuesta = valor1.modulo();
        assertEquals((long) 5.0, (long) valorRespuesta);
    }

    @Test
    public void test_Phase() {
        ComplexNumber c1 = new ComplexNumber(4, 3);
        long c2 = (long) c1.phase();
        assertEquals((long) 0.6435011087932844, c2);
    }

    @Test
    public void test_Conjugate() {
        ComplexNumber valorEsperado = new ComplexNumber(4, -3);
        ComplexNumber valor1 = new ComplexNumber(4, 3);
        ComplexNumber valorRespuesta = valor1.Conjugado();
        assertEquals(valorEsperado,valorRespuesta);
    }

}
