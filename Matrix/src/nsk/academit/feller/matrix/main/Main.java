package nsk.academit.feller.matrix.main;


import nsk.academit.feller.matrix.Matrix;
import nsk.academit.feller.vector.Vector;

import static nsk.academit.feller.matrix.Matrix.getMultiplication;

public class Main {
    public static void main(String[] args) {
        double[][] array = new double[5][1];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = i + j;
            }
        }
        double[] array2 = new double[]{1, 2};
        double[] array3 = new double[]{1, 2};
        double[] array4 = new double[]{-1, -2, 3, 5};
        double[] array5 = new double[]{0, 0, 3, 5};
        double[] array6 = new double[]{1, 8, 4, 2};
        double[] array7 = new double[]{3, 7, 5, 4};
        Vector vector1 = new Vector(array2);
        Vector vector2 = new Vector(array3);
        Vector vector3 = new Vector(array4);
        Vector vector4 = new Vector(array5);
        Vector vector5 = new Vector(array6);
        Vector vector6 = new Vector(array7);
        Vector[] vectors = new Vector[]{vector1,vector2};
        Vector[] vectors2 = new Vector[]{vector3,vector4, vector5, vector6};
        Matrix matrix = new Matrix(3, 4);
        Matrix matrix1 = new Matrix(matrix);
        Matrix matrix2 = new Matrix(array);
        Matrix matrix3 = new Matrix(vectors);
        Matrix matrix4 = new Matrix(vectors2);

      //  System.out.println(matrix);
      //  System.out.println(matrix2);
        System.out.println(matrix4);
       // System.out.println(matrix3.getDifference(matrix4));
      // System.out.println(matrix2.vectorMultiplication(vector1));
      //  System.out.println(getMultiplication(matrix3, matrix4));
      //  System.out.println(matrix4.toString());
       // System.out.println(matrix4.getTransposition());
        System.out.println(matrix4.getMinor(1,2));


    }
}
