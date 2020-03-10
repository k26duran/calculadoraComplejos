package edu.escuelaing.cnyt;


import edu.escuelaing.cnyt.quantum.QuantumExperiments;
import edu.escuelaing.cnyt.exceptions.MathComplexException;
import edu.escuelaing.cnyt.MathComplexNumber.MathComplex;
import edu.escuelaing.cnyt.MathComplexNumber.ComplexNumber;
import java.util.Arrays;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Assert;


/**
 * Pruebas unitarias para la clase QuantumExperiments.
 *
 */
public class QuantumExperimentsTest extends TestCase {

    private final QuantumExperiments quantumExperiments = new QuantumExperiments();

    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public QuantumExperimentsTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(QuantumExperimentsTest.class);
    }

    public void testExperimentoConMarblesBooleano() {
        int[][] matrizAdyacencia = {
            {0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0},
            {0, 1, 0, 0, 0, 1},
            {0, 0, 0, 1, 0, 0},
            {0, 0, 1, 0, 0, 0},
            {1, 0, 0, 0, 1, 0}
        };
        int[] estadoInicial = {6, 2, 1, 5, 3, 10};

        int[] estadoFinalResultToCompare1 = {0, 0, 12, 5, 1, 9};
        try {
            int[] estadoFinalResult1 = quantumExperiments.experimentoConMarblesBooleano(matrizAdyacencia, estadoInicial, 1);
            Assert.assertArrayEquals(estadoFinalResultToCompare1, estadoFinalResult1);
        } catch (MathComplexException ex) {
            System.out.println(ex.getMessage());
            fail("El experimento falló.");
        }

        int[] estadoFinalResultToCompare2 = {0, 0, 9, 5, 12, 1};
        try {
            int[] estadoFinalResult2 = quantumExperiments.experimentoConMarblesBooleano(matrizAdyacencia, estadoInicial, 2);
            Assert.assertArrayEquals(estadoFinalResultToCompare2, estadoFinalResult2);
        } catch (MathComplexException ex) {
            System.out.println(ex.getMessage());
            fail("El experimento falló.");
        }

        int[] estadoFinalResultToCompare3 = {0, 0, 1, 5, 9, 12};
        try {
            int[] estadoFinalResult3 = quantumExperiments.experimentoConMarblesBooleano(matrizAdyacencia, estadoInicial, 3);
            Assert.assertArrayEquals(estadoFinalResultToCompare3, estadoFinalResult3);
        } catch (MathComplexException ex) {
            System.out.println(ex.getMessage());
            fail("El experimento falló.");
        }
    }

    public void testExperimentoConMarblesFracciones() {
        double[][] matrizAdyacencia = {
            {0, 1.0 / 2.0, 1.0 / 2.0, 0},
            {1.0 / 2.0, 0, 0, 1.0 / 2.0},
            {1.0 / 2.0, 0, 0, 1.0 / 2.0},
            {0, 1.0 / 2.0, 1.0 / 2.0, 0}
        };
        double[] estadoInicial = {1.0, 0, 0, 0};
        double[] estadoFinalResultToCompare1 = {0, 1.0 / 2.0, 1.0 / 2.0, 0};
        try {
            double[] estadoFinalResult1 = quantumExperiments.experimentoConMarblesFracciones(matrizAdyacencia, estadoInicial, 1);
            Assert.assertArrayEquals(estadoFinalResultToCompare1, estadoFinalResult1, 0);
        } catch (MathComplexException ex) {
            System.out.println(ex.getMessage());
            fail("El experimento falló.");
        }

        double[] estadoFinalResultToCompare2 = {1.0 / 2.0, 0, 0, 1.0 / 2.0};
        try {
            double[] estadoFinalResult2 = quantumExperiments.experimentoConMarblesFracciones(matrizAdyacencia, estadoInicial, 2);
            Assert.assertArrayEquals(estadoFinalResultToCompare2, estadoFinalResult2, 0);
        } catch (MathComplexException ex) {
            System.out.println(ex.getMessage());
            fail("El experimento falló.");
        }
    }

    public void testExperimentoConFotonesComplejos() {
        ComplexNumber[][] matrizAdyacencia = {
            {new ComplexNumber(1.0 / Math.sqrt(2), 0), new ComplexNumber(1.0 / Math.sqrt(2), 0), new ComplexNumber(0, 0)},
            {new ComplexNumber(0, -1.0 / Math.sqrt(2)), new ComplexNumber(0, 1.0 / Math.sqrt(2)), new ComplexNumber(0, 0)},
            {new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 1)}
        };
        ComplexNumber[] estadoInicial = {
            new ComplexNumber(1.0 / Math.sqrt(3), 0),
            new ComplexNumber(0, 2.0 / Math.sqrt(15)),
            new ComplexNumber(Math.sqrt(2.0 / 5.0), 0)
        };
        ComplexNumber[] estadoFinalResultToCompare1 = {
            new ComplexNumber(Math.sqrt(5) / Math.sqrt(30), 2.0 / Math.sqrt(30)),
            new ComplexNumber(-2.0 / Math.sqrt(30), -Math.sqrt(5) / Math.sqrt(30)),
            new ComplexNumber(0, Math.sqrt(2.0 / 5.0))
        };
        try {
            ComplexNumber[] estadoFinalResult1 = quantumExperiments.experimentoConFotonesComplejos(matrizAdyacencia, estadoInicial, 1);
            MathComplex.equalsVector(estadoFinalResultToCompare1, estadoFinalResult1);
        } catch (MathComplexException ex) {
            System.out.println(ex.getMessage());
            fail("El experimento falló.");
        }
    }

    public void testExperimentoMultirendijasBalas() {
        double[][] probabilidades = {
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1.0 / 3.0, 0, 0, 0, 0, 0, 0},
            {0, 1.0 / 3.0, 0, 0, 0, 0, 0, 0},
            {0, 1.0 / 3.0, 1.0 / 3.0, 0, 0, 0, 0, 0},
            {0, 0, 1.0 / 3.0, 0, 0, 0, 0, 0},
            {0, 0, 1.0 / 3.0, 0, 0, 0, 0, 0}
        };
        double[][] matrizToCompare = {
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {1.0 / 6.0, 1.0 / 3.0, 0, 1.0, 0, 0, 0, 0},
            {1.0 / 6.0, 1.0 / 3.0, 0, 0, 1.0, 0, 0, 0},
            {1.0 / 3.0, 1.0 / 3.0, 1.0 / 3.0, 0, 0, 1.0, 0, 0},
            {1.0 / 6.0, 0, 1.0 / 3.0, 0, 0, 0, 1.0, 0},
            {1.0 / 6.0, 0, 1.0 / 3.0, 0, 0, 0, 0, 1.0}
        };
        double[] vectorToCompare = {0, 0, 0, 1.0 / 6.0, 1.0 / 6.0, 1.0 / 3.0, 1.0 / 6.0, 1.0 / 6.0};
        String matrizToCompareS = "[";
        for (int i = 0; i < matrizToCompare.length; i++) {
            if (i + 1 == matrizToCompare.length) {
                matrizToCompareS += Arrays.toString(matrizToCompare[i]) + "]";
            } else {
                matrizToCompareS += Arrays.toString(matrizToCompare[i]) + ", ";
            }
        }
        try {
            String[] matrizVector = quantumExperiments.experimentoMultirendijasBalas(2, 5, probabilidades);
            assertTrue(matrizToCompareS.equals(matrizVector[0]));
            assertTrue(Arrays.toString(vectorToCompare).equals(matrizVector[1]));
        } catch (MathComplexException ex) {
            System.out.println(ex.getMessage());
            fail("El experimento falló.");
        }

    }

    public void testExperimentoMultirendijasFotones() {
        ComplexNumber[][] probabilidades = {
            {new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0)},
            {new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0)},
            {new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0)},
            {new ComplexNumber(0, 0), new ComplexNumber(-1.0 / Math.sqrt(6), 1.0 / Math.sqrt(6)), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0)},
            {new ComplexNumber(0, 0), new ComplexNumber(-1.0 / Math.sqrt(6), -1.0 / Math.sqrt(6)), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0)},
            {new ComplexNumber(0, 0), new ComplexNumber(1.0 / Math.sqrt(6), -1.0 / Math.sqrt(6)), new ComplexNumber(-1.0 / Math.sqrt(6), 1.0 / Math.sqrt(6)), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0)},
            {new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(-1.0 / Math.sqrt(6), -1.0 / Math.sqrt(6)), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0)},
            {new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(1.0 / Math.sqrt(6), -1.0 / Math.sqrt(6)), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0)}
        };
        ComplexNumber[][] matrizToCompare = {
            {new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0)},
            {new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0)},
            {new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0)},
            {new ComplexNumber(-1.0 / Math.sqrt(12), 1.0 / Math.sqrt(12)), new ComplexNumber(-1.0 / Math.sqrt(6), 1.0 / Math.sqrt(6)), new ComplexNumber(0, 0), new ComplexNumber(1, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0)},
            {new ComplexNumber(-1.0 / Math.sqrt(12), -1.0 / Math.sqrt(12)), new ComplexNumber(-1.0 / Math.sqrt(6), -1.0 / Math.sqrt(6)), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(1, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0)},
            {new ComplexNumber(0, 0), new ComplexNumber(1.0 / Math.sqrt(6), -1.0 / Math.sqrt(6)), new ComplexNumber(-1.0 / Math.sqrt(6), 1.0 / Math.sqrt(6)), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(1, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0)},
            {new ComplexNumber(-1.0 / Math.sqrt(12), -1.0 / Math.sqrt(12)), new ComplexNumber(0, 0), new ComplexNumber(-1.0 / Math.sqrt(6), -1.0 / Math.sqrt(6)), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(1, 0), new ComplexNumber(0, 0)},
            {new ComplexNumber(1.0 / Math.sqrt(12), -1.0 / Math.sqrt(12)), new ComplexNumber(0, 0), new ComplexNumber(1.0 / Math.sqrt(6), -1.0 / Math.sqrt(6)), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(0, 0), new ComplexNumber(1, 0)}
        };
        ComplexNumber[] vectorToCompare = {
            new ComplexNumber(0, 0),
            new ComplexNumber(0, 0),
            new ComplexNumber(0, 0),
            new ComplexNumber(-1.0 / Math.sqrt(12), 1.0 / Math.sqrt(12)),
            new ComplexNumber(-1.0 / Math.sqrt(12), -1.0 / Math.sqrt(12)),
            new ComplexNumber(0,0),
            new ComplexNumber(-1.0 / Math.sqrt(12), -1.0 / Math.sqrt(12)),
            new ComplexNumber(1.0 / Math.sqrt(12), -1.0 / Math.sqrt(12))
        };
        String matrizToCompareS = "[";
        for (int i = 0; i < matrizToCompare.length; i++) {
            for (int j = 0; j < matrizToCompare[0].length; j++) {
                if (i + 1 == matrizToCompare.length) {
                    matrizToCompareS += matrizToCompare[i][j].prettyPrintFormaNormalNumeroComplejo();
                } else {
                    matrizToCompareS += matrizToCompare[i][j].prettyPrintFormaNormalNumeroComplejo() + ", ";
                }
            }
            matrizToCompareS += "]";
        }
        String vectorToCompareS = "{";
        for (int i = 0; i < vectorToCompare.length; i++) {
            if (i + 1 == vectorToCompare.length) {
                vectorToCompareS += vectorToCompare[i].prettyPrintFormaNormalNumeroComplejo();
            } else {
                vectorToCompareS += vectorToCompare[i].prettyPrintFormaNormalNumeroComplejo() + ", ";
            }
        }
        vectorToCompareS = "}";
        String interferencias = "interferencias: [5,0] ";
        try {
            String[] matrizVector = quantumExperiments.experimentoMultirendijasFotones(2, 5, probabilidades);
            assertTrue(matrizToCompareS.equals(matrizVector[0]));
            assertTrue(vectorToCompareS.equals(matrizVector[1]));
            assertTrue(interferencias.equals(matrizVector[2]));
            System.out.println(matrizVector[2]);
        } catch (MathComplexException ex) {
            System.out.println(ex.getMessage());
            fail("El experimento falló.");
        }

    }

}