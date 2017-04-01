package nsk.academit.feller.matrix.main;


import nsk.academit.feller.matrix.Matrix;
import nsk.academit.feller.vector.Vector;

public class Main {
    public static void main(String[] args) {
        double[][] array = new double[3][5];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = i + j;
            }
        }
        double[] array2 = new double[]{1, 2, 3, 4};
        double[] array3 = new double[]{1, 2, 3};
        Vector vector1 = new Vector(array2);
        Vector vector2 = new Vector(array3);
        Vector[] vectors = new Vector[]{vector1,vector2};
        Matrix matrix = new Matrix(5, 6);
        Matrix matrix1 = new Matrix(matrix);
        Matrix matrix2 = new Matrix(array);
        Matrix matrix3 = new Matrix(vectors);


    }
}
