package nsk.academit.feller.matrix;

import nsk.academit.feller.vector.Vector;


public class Matrix {
    private double[][] elements;


    public Matrix(int n, int m) {
        if (n <= 0 || m <= 0) {
            throw new IllegalArgumentException("size can't be negative");
        }
        elements = new double[n][m];
    }

    public Matrix(Matrix matrix) {
        this(matrix.elements);
    }

    public Matrix(double[][] array) {
        elements = new double[array.length][array[0].length];
        System.arraycopy(array, 0, elements, 0, array.length);
        System.arraycopy(array[0], 0, elements[0], 0, array[0].length);
    }

    public Matrix(Vector[] vectors) {
        elements = new double[vectors.length][vectors[0].getSize()];
    }

    public int getSize() {
        return (elements.length * elements[0].length);
    }

    public double getElement(int xIndex, int yIndex) {
        if ((xIndex < 0 || xIndex >= elements.length) || (yIndex < 0 || yIndex >= elements[0].length)) {
            throw new IllegalArgumentException("Such index doesn't exist;");
        }
        return elements[xIndex][yIndex];
    }

    public void setElement(int xIndex, int yIndex, double element) {
        if ((xIndex < 0 || xIndex >= elements.length) || (yIndex < 0 || yIndex >= elements[0].length)) {
            throw new IllegalArgumentException("Such index doesn't exist;");
        }
        elements[xIndex][yIndex] = element;
    }

    public double[] getColumn(int yIndex) {
        if (yIndex < 0 || yIndex >= elements[0].length) {
            throw new IllegalArgumentException("Such index doesn't exist;");
        }
        double[] array = new double[yIndex];
        for (int i = 0; i < elements.length; i++) {
            array[i] = elements[i][yIndex];
        }

        return array;
    }

    public double[][] getTransposition() {
        double[][] array = new double[elements[0].length][elements.length];

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = elements[j][i];
            }
        }

        return array;
    }

    public Matrix calcScalar(double number) {
        for (int i = 0; i < this.elements.length; i++) {
            for (int j = 0; j < this.elements[0].length; j++) {
                elements[i][j] = (elements[i][j] * number);
            }
        }
        return this;
    }

    public double getDet3() {
        if (elements.length != elements[0].length) {
            throw new IllegalArgumentException("Can't count det");
        }
        return elements[0][0] * elements[1][1] * elements[2][2] + elements[0][1] * elements[1][2] * elements[2][0] + elements[1][0] * elements[2][1] * elements[0][2] -
                elements[2][0] * elements[1][1] * elements[0][2] - elements[0][1] * elements[1][0] * elements[2][2] - elements[0][0] * elements[1][2] * elements[2][1];
    }

    public double getDet2() {
        if (elements.length != elements[0].length) {
            throw new IllegalArgumentException("Can't count det");
        }
        return elements[0][0] * elements[1][1] - elements[1][0] * elements[1][1];
    }

  /*  public double getDet() {
        if (elements.length != elements[0].length) {
            throw new IllegalArgumentException("Can't count det");
        } else if (elements.length == 3) {
            return getDet3();
        } else if (elements.length == 2) {
            return getDet2();
        } else if (elements.length == 1) {
            return elements[0][0];
        } else {
            double determine = 0;
            for(int i = elements.length - 1; i == 3; i--){
                for(int j = elements.length - 1; j == 3; j--){
                    determine = elements[i][j]*
                }
            }
        }
    }*/

    public Matrix getSum(Matrix matrix) {
        if (elements.length < matrix.elements.length || elements[0].length < matrix.elements[0].length) {
            double[][] newArray = new double[matrix.elements.length][matrix.elements[0].length];
            System.arraycopy(elements, 0, newArray, 0, elements.length);
            System.arraycopy(elements[0], 0, newArray[0], 0, elements[0].length);
            elements = newArray;
        }
        for (int i = 0; i < matrix.elements.length; i++) {
            for (int j = 0; j < matrix.elements[0].length; j++) {
                elements[i][j] = (elements[i][j] + matrix.elements[i][j]);
            }
        }
        return this;

    }

    public Matrix getDifference(Matrix matrix) {
        if (elements.length < matrix.elements.length || elements[0].length < matrix.elements[0].length) {
            double[][] newArray = new double[matrix.elements.length][matrix.elements[0].length];
            System.arraycopy(elements, 0, newArray, 0, elements.length);
            System.arraycopy(elements[0], 0, newArray[0], 0, elements[0].length);
            elements = newArray;
        }
        for (int i = 0; i < matrix.elements.length; i++) {
            for (int j = 0; j < matrix.elements[0].length; j++) {
                elements[i][j] = (elements[i][j] - matrix.elements[i][j]);
            }
        }
        return this;
    }

    public Matrix vectorMultiplication(Vector vector) {
        if (elements[0].length != 1) {
            throw new IllegalArgumentException("Can't multiply");
        }
        for (int i = 0; i < elements.length; i++) {
            for (int j = 0; j < elements.length; j++) {
                elements[i][j] = elements[i][j] * vector.getElement(i);
            }
        }
        return this;
    }


    public static Matrix getSum(Matrix matrix1, Matrix matrix2) {
        return new Matrix(matrix1).getSum(matrix2);
    }

    public static Matrix getDifference(Matrix matrix1, Matrix matrix2) {
        return new Matrix(matrix1).getDifference(matrix2);
    }

    public static double[][] getMultiplication(Matrix matrix1, Matrix matrix2) {
        if (matrix1.elements[0].length != matrix2.elements.length) {
            throw new IllegalArgumentException("Can't multiply");
        }

        double[][] result = new double[matrix1.elements.length][matrix2.elements[0].length];
        for (int i = 0; i < matrix1.elements.length; i++) {
            for (int j = 0; j < matrix2.elements[0].length; j++) {
                for (int k = 0; k < matrix2.elements.length; k++) {
                    result[i][j] = matrix1.elements[i][k] * matrix2.elements[k][j];
                }

            }
        }
        return result;
    }

   /* @Override
    public String toString() {

        return "{" + Arrays.toString(elements) + "}";
    }*/


}
