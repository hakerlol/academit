package nsk.academit.feller.vector;

import java.util.Arrays;

public class Vector {
    private double[] elements;

    public Vector(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("size can't be negative");
        }
        elements = new double[size];
    }

    public Vector(Vector vector) {
        this(vector.elements);
        System.arraycopy(vector.elements, 0, this.elements, 0, vector.elements.length);
    }

    public Vector(double[] array) {
        this(array.length, array);
    }

    public Vector(int size, double[] array) {
        if (size <= 0) {
            throw new IllegalArgumentException("size can't be negative");
        }
        if (size <= array.length) {
            elements = new double[size];
            System.arraycopy(array, 0, elements, 0, size);
        } else {
            elements = new double[size];
            System.arraycopy(array, 0, elements, 0, array.length);
        }
    }

    public Vector getSum(Vector vector) {
        if (elements.length >= vector.elements.length) {
            for (int i = 0; i < vector.elements.length; i++) {
                elements[i] = (elements[i] + vector.elements[i]);
            }
            return this;
        } else {
            double[] newArray = new double[vector.elements.length];
            System.arraycopy(elements, 0, newArray, 0, elements.length);
            elements = newArray;
            for (int i = 0; i < vector.elements.length; i++) {
                elements[i] = (elements[i] + vector.elements[i]);
            }
        }
        return this;

    }

    public Vector getDifference(Vector vector) {
        if (elements.length >= vector.elements.length) {
            for (int i = 0; i < vector.elements.length; i++) {
                elements[i] = (elements[i] - vector.elements[i]);
            }
            return this;
        } else {
            double[] newArray = new double[vector.elements.length];
            System.arraycopy(elements, 0, newArray, 0, elements.length);
            elements = newArray;
            for (int i = 0; i < vector.elements.length; i++) {
                elements[i] = (elements[i] - vector.elements[i]);
            }
        }
        return this;
    }

    public Vector calcScalar(double number) {
        for (int i = 0; i < this.elements.length; i++) {
            elements[i] = (elements[i] * number);
        }
        return this;
    }

    public Vector reverse() {
        calcScalar(-1);
        return this;
    }

    public double getLength() {
        int size = 0;
        for (double x : elements) {
            size += Math.pow(x, 2);
        }
        return Math.sqrt(size);
    }

    public int getSize() {
        return elements.length;
    }


    public static Vector getSum(Vector vector1, Vector vector2) {
        return new Vector(vector1).getSum(vector2);
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        return new Vector(vector1).getDifference(vector2);
    }

    public static double getScalarMultiplication(Vector vector1, Vector vector2) {
        int minLength = Math.min(vector1.elements.length, vector2.elements.length);
        double result = 0;
        for (int i = 0; i < minLength; i++) {
            result += (vector1.elements[i] * vector2.elements[i]);
        }
        return result;
    }

    public double getElement(int index) {
        if (index < 0 || index >= elements.length) {
            throw new IllegalArgumentException("Such index doesn't exist;");
        }
        return elements[index];
    }

    public void setElement(int index, double element) {
        if (index < 0 || index >= elements.length) {
            throw new IllegalArgumentException("Such index doesn't exist;");
        }
        elements[index] = element;
    }

    @Override
    public String toString() {

        return "{" + Arrays.toString(elements) + "}";
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
        Vector other = (Vector) obj;

        if (this.getSize() == other.getSize()) {
            for (int i = 0; i < elements.length; i++) {
                if (elements[i] != other.elements[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {

        return Arrays.hashCode(elements);
    }
}
