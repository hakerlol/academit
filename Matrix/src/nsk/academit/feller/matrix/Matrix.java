package nsk.academit.feller.matrix;

import nsk.academit.feller.vector.Vector;

import java.util.Arrays;


public class Matrix {
    private Vector[] vectors;


    public Matrix(int n, int m) {
        if (n <= 0 || m <= 0) {
            throw new IllegalArgumentException("size can't be negative");
        }
        vectors = new Vector[n];
        for (int i = 0; i < vectors.length; i++) {
            vectors[i] = new Vector(m);
        }
    }

    public Matrix(Matrix matrix) {
        this(matrix.vectors);
    }

    public Matrix(double[][] array) {
        vectors = new Vector[array.length];
        for (int i = 0; i < vectors.length; i++) {
            vectors[i] = new Vector(array[0].length);
            for (int j = 0; j < array[0].length; j++) {
                vectors[i].setElement(j, array[i][j]);
            }
        }
    }

    public Matrix(Vector[] vectors) {
        for (int i = 0; i < vectors.length; i++) {
            if (i != vectors.length - 1 && vectors[i].getSize() != vectors[i + 1].getSize()) {
                throw new IllegalArgumentException("all vectors have to be the same size");
            }
        }
        this.vectors = vectors;
    }

    public int getColumnLength() {
        return (vectors.length);
    }

    public int getRowLength() {
        return (vectors[0].getSize());
    }

    public double getElement(int xIndex, int yIndex) {
        if ((xIndex < 0 || xIndex >= vectors.length) || (yIndex < 0 || yIndex >= vectors[0].getSize())) {
            throw new IllegalArgumentException("Such index doesn't exist;");
        }

        return vectors[xIndex].getElement(yIndex);
    }

    public void setElement(int xIndex, int yIndex, double element) {
        if ((xIndex < 0 || xIndex >= vectors.length) || (yIndex < 0 || yIndex >= vectors[0].getSize())) {
            throw new IllegalArgumentException("Such index doesn't exist;");
        }
        vectors[xIndex].setElement(yIndex, element);
    }

    public Vector getColumn(int yIndex) {
        if (yIndex < 0 || yIndex >= vectors[0].getSize()) {
            throw new IllegalArgumentException("Such index doesn't exist;");
        }

        double[] array = new double[vectors.length];
        for (int i = 0; i < vectors.length; i++) {
            array[i] = getElement(i, yIndex);
        }

        return new Vector(vectors.length, array);
    }

    public Matrix getTransposition() {
        Matrix matrix = new Matrix(getRowLength(), getColumnLength());
       for(int i = 0; i < getColumnLength(); i++){
           for(int j = 0; j < getRowLength(); j++){
               matrix.setElement(j,i, this.getElement(i,j));

           }
       }
        return matrix;
    }

    public Matrix calcScalar(double number) {
        for (int i = 0; i < this.vectors.length; i++) {
            for (int j = 0; j < this.vectors[0].getSize(); j++) {
                vectors[i].setElement(j, vectors[i].getElement(j) * number);
            }
        }
        return this;
    }
    public Matrix getShortMatrix(int rowIndex, int columnIndex){
        if(rowIndex > getRowLength() || columnIndex > getColumnLength()){
            throw new IllegalArgumentException("Such index doesn't exist;");
        }
        if(getColumnLength() != getRowLength()){
            throw new IllegalArgumentException("impossible find det");
        }
        int offRow = 0;
        int offColumn = 0;
        Matrix matrix = new Matrix(getColumnLength() - 1, getRowLength() - 1);
        for(int i = 0; i < getColumnLength(); i++) {
            offColumn=0;
            for (int j = 0; j < getRowLength(); j++) {
                if (i == rowIndex){
                    offRow = 1;
                    break;
                }if(j == columnIndex){
                    offColumn = 1;
                }else {
                    matrix.setElement(i - offRow,j-offColumn,getElement(i,j));
                }
            }
        }
        return matrix;
}
    public double getMinor(Matrix matrix){
        double Minor = 0;



        return Minor;
    }

   /* public double getAddition(){

        double Addition;
        for(int i = 0; i < getColumnLength(); i++){
            for(int j = 0; j < getRowLength(); j++){
                Addition = Math.pow(-1,i+j)*;

            }
        return 0;
    }


   public double getDet() {
       double Det;
       for (int i = 0; i < getColumnLength(); i++) {
           for (int j = 0; j < getRowLength(); j++) {
               Det += getElement(i, j) ;

           }
           return Det;
       }
   }*/

    public Matrix getSum(Matrix matrix) {
        if (vectors.length < matrix.vectors.length || vectors[0].getSize() < matrix.vectors[0].getSize()) {
            throw new IllegalArgumentException("Matrix are not equals");
        }
        for (int i = 0; i < matrix.vectors.length; i++) {
            for (int j = 0; j < matrix.vectors[0].getSize(); j++) {

                vectors[i].setElement(j, vectors[i].getElement(j) + matrix.vectors[i].getElement(j));
            }
        }
        return this;

    }

    public Matrix getDifference(Matrix matrix) {
        if (vectors.length < matrix.vectors.length || vectors[0].getSize() < matrix.vectors[0].getSize()) {
            throw new IllegalArgumentException("Matrix are not equals");
        }
        for (int i = 0; i < matrix.vectors.length; i++) {
            for (int j = 0; j < matrix.vectors[0].getSize(); j++) {

                vectors[i].setElement(j, vectors[i].getElement(j) - matrix.vectors[i].getElement(j));
            }
        }
        return this;
    }

    public Matrix vectorMultiplication(Vector vector) {
        if (vectors[0].getSize() != 1) {
            throw new IllegalArgumentException("Can't multiply");
        }


        for (int i = 0; i < vectors.length; i++) {
            for (int j = 0; j < vectors.length; j++) {
                // elements[i][j] = elements[i][j] * vector.getElement(i);
                vectors[i].setElement(j, vectors[i].getElement(0) * vector.getElement(i));
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

    public static Matrix getMultiplication(Matrix matrix1, Matrix matrix2) {
        if (matrix1.vectors[0].getSize() != matrix2.vectors.length) {
            throw new IllegalArgumentException("Can't multiply");
        }
        Matrix matrix = new Matrix(matrix1.vectors.length, matrix2.vectors[0].getSize());

        for (int i = 0; i < matrix1.vectors.length; i++) {
            for (int j = 0; j < matrix2.vectors[0].getSize(); j++) {
                if (i != matrix1.vectors.length - 1) {
                    matrix.setElement(i, j, matrix1.vectors[i].getElement(i) * matrix2.vectors[i].getElement(j) +
                            matrix1.vectors[i + 1].getElement(i + 1) * matrix2.vectors[i + 1].getElement(j));
                } else {
                    matrix.setElement(i, j, matrix1.vectors[i - 1].getElement(i - 1) * matrix2.vectors[i - 1].getElement(j) +
                            matrix1.vectors[i].getElement(i) * matrix2.vectors[i].getElement(j));
                }
            }
        }
        return matrix;
    }

    @Override
    public String toString() {

        return "{" + Arrays.toString(vectors) + "}";
    }


}
