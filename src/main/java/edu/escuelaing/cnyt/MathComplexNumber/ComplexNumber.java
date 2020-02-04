package edu.escuelaing.cnyt.MathComplexNumber;

public class ComplexNumber {

    private double real;
    private double imaginario;

    /**
     * Constructor vacio de la clase ComplexNumber. Crea un numero complejo como si
     * fuera 0, es decir, tanto la parte real como la parte imaginaria son 0.
     */
    public ComplexNumber() {
        this.real = (double) 0;
        this.imaginario = (double) 0;
    }

    /**
     * Constructor con parametros de la clase ComplexNumber.
     *
     * @param real       parte real del numero complejo.
     * @param imaginario parte imaginaria del numero complejo.
     */
    public ComplexNumber(double real, double imaginario) {
        this.real = real;
        this.imaginario = imaginario;
    }

    /**
     * Este metodo retorna el modulo de este numero complejo. El modulo representa
     * la magnitud del numero complejo si lo representamos de manera gráfica en
     * coordenadas polares. Si c = (a, b), entonces el modulo p = (a^2+b^2)^(1/2)
     *
     * @return double: el modulo del numero complejo.
     */
    public double modulo() {
        return Math.sqrt(Math.pow(real, 2) + Math.pow(imaginario, 2));
    }

    /**
     * Este metodo retorna la fase de este numero complejo. La fase representa el
     * recorrido que realiza el numero complejo en el plano cartesiano si lo
     * representamos en coordenadas polares. Si c = (a, b), entonces la fase theta =
     * arctan(b / a)
     *
     * @return double : la fase del numero complejo.
     */
    public double phase() {
        return Math.atan2(imaginario, real);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.real) ^ (Double.doubleToLongBits(this.real) >>> 32));
        hash = 67 * hash
                + (int) (Double.doubleToLongBits(this.imaginario) ^ (Double.doubleToLongBits(this.imaginario) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ComplexNumber other = (ComplexNumber) obj;
        if (Double.doubleToLongBits(this.real) != Double.doubleToLongBits(other.real)) {
            return false;
        }
        if (Double.doubleToLongBits(this.imaginario) != Double.doubleToLongBits(other.imaginario)) {
            return false;
        }
        return true;
    }

    /**
     * Este metodo retorna el conjugado de este numero complejo. El conjugado de un
     * numero complejo es cambiar su parte imaginaria por el inverso aditivo del
     * imaginario.
     *
     * @return ComplexNumber : el conjugado de este numero complejo.
     */
    public ComplexNumber Conjugado() {
        return new ComplexNumber(real, -(imaginario));
    }

    /**
     * Este metodo retorna el inverso aditivo del este numero complejo.
     *
     * @return ComplexNumber : el inverso aditivo de este numero complejo.
     */
    public ComplexNumber inversoAditivo() {
        return new ComplexNumber(-(real), -(imaginario));
    }

    /**
     * Este metodo obtiene el numero real de este numero complejo.
     *
     * @return double : la parte real de este numero complejo.
     */
    public double getReal() {
        return real;
    }

    /**
     * Este metodo establece a este número complejo el real dado.
     *
     * @param real parte real de un número complejo.
     */
    public void setReal(double real) {
        this.real = real;
    }

    /**
     * Este metodo obtiene el número imaginario de este número complejo.
     *
     * @return double : la parte imaginaria de este número complejo.
     */
    public double getImaginario() {
        return imaginario;
    }

    /**
     * Este metodo establece a este número complejo el imaginario dado.
     *
     * @param imaginario parte imaginaria de un número complejo.
     */
    public void setImaginario(double imaginario) {
        this.imaginario = imaginario;
    }

    /**
     * Este metodo retorna como string este número complejo.
     *
     * @return String : cadena de la forma a+bi del numero complejo.
     */
    public String prettyPrintFormaNormalNumeroComplejo() {
        String numeroComplejo = "";
        if (imaginario >= 0) {
            numeroComplejo = real + " + " + imaginario + "i";
        } else {
            numeroComplejo = real + "" + imaginario + "i";
        }
        return numeroComplejo;
    }
}
