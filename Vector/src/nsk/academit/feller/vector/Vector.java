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
        elements = new double[vector.elements.length];
        System.arraycopy(vector.elements, 0, this.elements, 0, vector.elements.length);

    }

    public Vector(double[] array) {
        elements = new double[array.length];
        System.arraycopy(array, 0, elements, 0, array.length);
    }

    public Vector(int size, double[] array) {
        if (size <= 0) {
            throw new IllegalArgumentException("size can't be negative");
        }
        if (size <= array.length) {
            elements = new double[array.length];
            System.arraycopy(array, 0, elements, 0, array.length);
        } else {
            elements = new double[size];
            System.arraycopy(array, 0, elements, 0, array.length);
        }
    }

    public double[] getSum(Vector vector) {
        for (int i = 0; i < this.elements.length; i++) {
            elements[i] = (elements[i] + vector.elements[i]);
        }
        return elements;
    }

    public double[] getDifference(Vector vector) {
        for (int i = 0; i < this.elements.length; i++) {
            elements[i] = (elements[i] - vector.elements[i]);
        }
        return elements;
    }

    public double[] calcScalar(double number) {
        for (int i = 0; i < this.elements.length; i++) {
            elements[i] = (elements[i] * number);
        }
        return elements;
    }

    public Vector reverse() {
        for (int i = 0; i < this.elements.length; i++) {
            this.elements[i] = this.elements[i] * (-1);
        }
        return new Vector(this.elements);
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
        if (vector1.elements.length == vector2.elements.length) {
            double[] result = new double[vector1.elements.length];
            for (int i = 0; i < result.length; i++) {
                result[i] = (vector1.elements[i] + vector2.elements[i]);

            }
            return new Vector(result);
        } else {
            double[] result = new double[vector1.elements.length > vector2.elements.length ? vector1.elements.length : vector2.elements.length];
            double[] newElements = new double[vector1.elements.length > vector2.elements.length ? vector1.elements.length : vector2.elements.length];
            System.arraycopy(vector1.elements.length < vector2.elements.length ? vector1.elements : vector2.elements, 0, newElements, 0,
                    vector1.elements.length < vector2.elements.length ? vector1.elements.length : vector2.elements.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = (newElements[i] + vector2.elements[i]);
            }
            return new Vector(result);
        }
    }

    public static Vector getDifference(Vector vector1, Vector vector2) {
        if (vector1.elements.length == vector2.elements.length) {
            double[] result = new double[vector1.elements.length];
            for (int i = 0; i < result.length; i++) {
                result[i] = (vector1.elements[i] - vector2.elements[i]);

            }
            return new Vector(result);
        } else {
            double[] result = new double[vector1.elements.length > vector2.elements.length ? vector1.elements.length : vector2.elements.length];
            double[] newElements = new double[vector1.elements.length > vector2.elements.length ? vector1.elements.length : vector2.elements.length];
            System.arraycopy(vector1.elements.length < vector2.elements.length ? vector1.elements : vector2.elements, 0, newElements, 0,
                    vector1.elements.length < vector2.elements.length ? vector1.elements.length : vector2.elements.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = (newElements[i] - vector2.elements[i]);
            }
            return new Vector(result);
        }
    }

    public static Vector getScalarMultiplication(Vector vector1, Vector vector2) {
        if (vector1.elements.length == vector2.elements.length) {
            double[] result = new double[vector1.elements.length];
            for (int i = 0; i < result.length; i++) {
                result[i] = (vector1.elements[i] * vector2.elements[i]);

            }
            return new Vector(result);
        } else {
            double[] result = new double[vector1.elements.length > vector2.elements.length ? vector1.elements.length : vector2.elements.length];
            double[] newElements = new double[vector1.elements.length > vector2.elements.length ? vector1.elements.length : vector2.elements.length];
            System.arraycopy(vector1.elements.length < vector2.elements.length ? vector1.elements : vector2.elements, 0, newElements, 0,
                    vector1.elements.length < vector2.elements.length ? vector1.elements.length : vector2.elements.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = (newElements[i] * vector2.elements[i]);
            }
            return new Vector(result);
        }
    }

    @Override
    public String toString() {

        return "{" + Arrays.toString(elements) + "}";
    }

    @Override
    public boolean equals(Object obj) {
        final double EPSILON = 0.0001;
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
            for (double x : getDifference(other)) {
                if (Math.abs(x) > EPSILON) {
                    return false;
                }

            }
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {

        final int prime = 37;
        int result = 1;
        for (double x : elements) {
            result = prime * result + (int) x;
        }
        return result;
    }
}
