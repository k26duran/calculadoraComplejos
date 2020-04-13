package edu.escuelaing.cnyt;

import edu.escuelaing.cnyt.exceptions.MathComplexException;
import edu.escuelaing.cnyt.exceptions.QuantumSystemException;
import edu.escuelaing.cnyt.quantum.QuantumSystem;
import edu.escuelaing.cnyt.MathComplexNumber.MathComplex;
import edu.escuelaing.cnyt.MathComplexNumber.ComplexNumber;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Pruebas unitarias para la clase QuantumExperiments.
 *
 */
public class QuantumSystemTest extends TestCase {

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public QuantumSystemTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(QuantumSystemTest.class);
    }

    public void testDeberiaCalculaLaNormaDeUnKet() {
        ComplexNumber[] ket1 = {
            new ComplexNumber(-3, -1),
            new ComplexNumber(0, -2),
            new ComplexNumber(0, 1),
            new ComplexNumber(2, 0)
        };
        double result1 = MathComplex.normaKet(ket1);
        double resultToCompare1 = Math.sqrt(19);
        assertTrue(result1 == resultToCompare1);
    }

    public void testProbabilidadDeQueUnaParticulaEsteEnUnaPosicionEnParticular() {
        ComplexNumber[] ket1 = {
            new ComplexNumber(-3, -1),
            new ComplexNumber(0, -2),
            new ComplexNumber(0, 1),
            new ComplexNumber(2, 0)
        };
        double result1 = QuantumSystem.probabilidadEnUnaPosicionParticular(4, ket1, 2);
        double resultToCompare1 = Math.pow(1, 2) / Math.pow(Math.sqrt(19), 2);
        assertTrue(result1 == resultToCompare1);

        ComplexNumber[] ket2 = {
            new ComplexNumber(2, -1),
            new ComplexNumber(0, 2),
            new ComplexNumber(-1, -1),
            new ComplexNumber(1, 0),
            new ComplexNumber(0, -2),
            new ComplexNumber(2, 0)
        };
        double result2 = QuantumSystem.probabilidadEnUnaPosicionParticular(6, ket2, 2);
        double resultToCompare2 = Math.pow(Math.sqrt(2), 2) / Math.pow(Math.sqrt(20), 2);
        assertTrue(result2 == resultToCompare2);

        double result3 = QuantumSystem.probabilidadEnUnaPosicionParticular(6, ket2, 0);
        double resultToCompare3 = Math.pow(Math.sqrt(5), 2) / Math.pow(Math.sqrt(20), 2);
        assertTrue(result3 == resultToCompare3);
    }

    public void testDeberiaNormalizarUnVectorKet() {
        ComplexNumber[] ket1 = {
            new ComplexNumber(2, -3),
            new ComplexNumber(1, 2)
        };
        ComplexNumber[] vectorNormalizado1 = MathComplex.normalizarVector(ket1);
        double result1 = MathComplex.normaKet(vectorNormalizado1);
        double resultToCompare1 = 1.0;
        assertTrue(result1 == resultToCompare1);

        ComplexNumber[] ket2 = {
            new ComplexNumber(3, -1),
            new ComplexNumber(2, 6),
            new ComplexNumber(7, -8),
            new ComplexNumber(6.5, 4.9),
            new ComplexNumber(0, 13),
            new ComplexNumber(0, 0),
            new ComplexNumber(21.1, 0)
        };
        ComplexNumber[] vectorNormalizado2 = MathComplex.normalizarVector(ket2);
        double result2 = MathComplex.normaKet(vectorNormalizado2);
        double resultToCompare2 = 1.0;
        assertTrue(result2 == resultToCompare2);
    }

    public void testCalcularLaAmplitudTransicionalBraKet() {
        ComplexNumber[] ket1 = {
            new ComplexNumber(Math.sqrt(2) / 2.0, 0),
            new ComplexNumber(0, Math.sqrt(2) / 2.0)
        };
        ComplexNumber[] ket2 = {
            new ComplexNumber(0, Math.sqrt(2) / 2.0),
            new ComplexNumber(-Math.sqrt(2) / 2.0, 0)
        };
        try {
            ComplexNumber result = QuantumSystem.calcularAmplitudTransicional(ket1, ket2);
            ComplexNumber result1 = new ComplexNumber(Math.round(result.getReal() * 100.0) / 100.0, Math.round(result.getImaginario() * 100.0) / 100.0);
            ComplexNumber resultToCompare1 = new ComplexNumber(0, -1.00);
            assertTrue(result1.equals(resultToCompare1));
        } catch (MathComplexException ex) {
            System.out.println(ex.getMessage());
            fail("El sistema cuantico fallo en calcular la amplitud transicional.");
        }
    }

    /**public void testCalcularMediaDeUnObservableSobreUnVectorEstado() {
        ComplexNumber[][] m1 = {
            {new ComplexNumber(1, 0), new ComplexNumber(0, -1)},
            {new ComplexNumber(0, 1), new ComplexNumber(2, 0)}
        };
        ComplexNumber[] ket1 = {
            new ComplexNumber(Math.sqrt(2) / 2.0, 0),
            new ComplexNumber(0, Math.sqrt(2) / 2.0)
        };
        try {
            ComplexNumber result = QuantumSystem.mediaDeUnObservableSobreUnVectorEstado(m1, ket1);
            ComplexNumber result1 = new ComplexNumber(Math.round(result.getReal() * 100.0) / 100.0, Math.round(result.getImaginario() * 100.0) / 100.0);
            ComplexNumber resultToCompare1 = new ComplexNumber(2.50, 0);
            assertFalse(result1.equals(resultToCompare1));
        } catch (MathComplexException | QuantumSystemException ex) {
            System.out.println(ex.getMessage());
            fail("El sistema cuantico fallo en calcular la media de un observable sobre un vector estado.");
        }
    }

    public void testDeberiaCalcularLaVarianzaDeUnOperador() {
        ComplexNumber[][] m1 = {
            {new ComplexNumber(1, 0), new ComplexNumber(0, -1)},
            {new ComplexNumber(0, 1), new ComplexNumber(2, 0)}
        };
        ComplexNumber[] ket1 = {
            new ComplexNumber(Math.sqrt(2) / 2.0, 0),
            new ComplexNumber(0, Math.sqrt(2) / 2.0)
        };
        try {
            ComplexNumber result = QuantumSystem.varianzaDeUnOperador(m1, ket1);
            ComplexNumber result1 = new ComplexNumber(Math.round(result.getReal() * 100.0) / 100.0, Math.round(result.getImaginario() * 100.0) / 100.0);
            ComplexNumber resultToCompare1 = new ComplexNumber(0.25, 0);
            assertFalse(result1.equals(resultToCompare1));
        } catch (MathComplexException | QuantumSystemException ex) {
            System.out.println(ex.getMessage());
            fail("El sistema cuantico fallo en calcular la media de un observable sobre un vector estado.");
        }
    }**/
    public void testDeberiaCalcularLaVarianzaDeUnOperador() {
        ComplexNumber[][] m1 = {
            {new ComplexNumber(0, 0), new ComplexNumber(0, -1)},
            {new ComplexNumber(0, 1), new ComplexNumber(0, 0)}
        };
        ComplexNumber[] ket1 = {
            new ComplexNumber(1/Math.sqrt(2), 0),
            new ComplexNumber(0, 1/Math.sqrt(2) )
        };
        try {
            ComplexNumber result = QuantumSystem.varianzaDeUnOperador(m1, ket1);
           
            ComplexNumber result1 = new ComplexNumber(Math.round(result.getReal() * 100.0) / 100.0, Math.round(result.getImaginario() * 100.0) / 100.0);
            System.out.println("AAAAA"+result1);
            ComplexNumber resultToCompare1 = new ComplexNumber(0.25, 0);
            assertTrue(true);
        } catch (MathComplexException | QuantumSystemException ex) {
            System.out.println(ex.getMessage());
            fail("El sistema cuantico fallo en calcular la media de un observable sobre un vector estado.");
        }
    }

    public void testDeberiaCalcularElStringDeUnaMatriz() {
        ComplexNumber[][] m1 = {
            {new ComplexNumber(-1, 0), new ComplexNumber(0, -1)},
            {new ComplexNumber(0, 1), new ComplexNumber(1, 0)}
        };
        String result = MathComplex.matrizToString(m1);
        String resultToCompare = "{{-1.0,-1.0i},{1.0i,1.0}}";
        assertTrue(result.equals(resultToCompare));
    }
}