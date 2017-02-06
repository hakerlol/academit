package nsk.academit.feller.vector;


import java.util.Arrays;

public class Vector {
    private double[] vectorArray;

    public Vector(int size) {
        if (size <= 0) throw new IllegalArgumentException("size can't be negative");
        vectorArray = new double[size];
    }

    public Vector(Vector vector) {
        vectorArray = new double[vector.vectorArray.length];
        System.arraycopy(vector.vectorArray, 0, this.vectorArray, 0, vector.vectorArray.length);

    }

    public Vector(double[] array) {
        vectorArray = new double[array.length];
        System.arraycopy(array, 0, vectorArray, 0, array.length);
    }

    public Vector(int size, double[] array) {
        if (size <= 0) {
            throw new IllegalArgumentException("size can't be negative");
        }
        vectorArray = new double[size];
        System.arraycopy(array, 0, vectorArray, 0, array.length);
    }

    public Vector getSum(Vector vector) {
        if (this.vectorArray.length == vector.vectorArray.length) {
            double[] result = new double[vector.vectorArray.length];
            for (int i = 0; i < result.length; i++) {
                result[i] = (this.vectorArray[i] + vector.vectorArray[i]);

            }
            return new Vector(result);
        } else {
            double[] result = new double[this.vectorArray.length > vector.vectorArray.length ? this.vectorArray.length : vector.vectorArray.length];
            double[] newVectorArray = new double[this.vectorArray.length > vector.vectorArray.length ? this.vectorArray.length : vector.vectorArray.length];
            System.arraycopy(this.vectorArray.length < vector.vectorArray.length ? this.vectorArray : vector.vectorArray, 0, newVectorArray, 0,
                    this.vectorArray.length < vector.vectorArray.length ? this.vectorArray.length : vector.vectorArray.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = (newVectorArray[i] + vector.vectorArray[i]);
            }
            return new Vector(result);
        }
    }

    public Vector getDifference(Vector vector) {
        if (this.vectorArray.length == vector.vectorArray.length) {
            double[] result = new double[vector.vectorArray.length];
            for (int i = 0; i < result.length; i++) {
                result[i] = (this.vectorArray[i] - vector.vectorArray[i]);

            }
            return new Vector(result);
        } else {
            double[] result = new double[this.vectorArray.length > vector.vectorArray.length ? this.vectorArray.length : vector.vectorArray.length];
            double[] newVectorArray = new double[this.vectorArray.length > vector.vectorArray.length ? this.vectorArray.length : vector.vectorArray.length];
            System.arraycopy(this.vectorArray.length < vector.vectorArray.length ? this.vectorArray : vector.vectorArray, 0, newVectorArray, 0,
                    this.vectorArray.length < vector.vectorArray.length ? this.vectorArray.length : vector.vectorArray.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = (newVectorArray[i] - vector.vectorArray[i]);
            }
            return new Vector(result);
        }
    }

    public Vector calcVectorOnNumber(double number) {
        for (int i = 0; i < this.vectorArray.length; i++) {
            this.vectorArray[i] = this.vectorArray[i] * number;
        }
        return new Vector(this.vectorArray);
    }

    public Vector Reverse() {
        for (int i = 0; i < this.vectorArray.length; i++) {
            this.vectorArray[i] = this.vectorArray[i] * (-1);
        }
        return new Vector(this.vectorArray);
    }

    public double getVectorLength() {
        int size = 0;
        for (int i = 0; i < this.vectorArray.length; i++) {
            size += Math.pow(vectorArray[i], 2);
        }
        return Math.sqrt(size);
    }

    public int getSize() {
        return vectorArray.length;
    }

    @Override
    public String toString() {

        return "{" + Arrays.toString(vectorArray) + "}";
    }

}
