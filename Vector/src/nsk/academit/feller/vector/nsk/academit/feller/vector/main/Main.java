package nsk.academit.feller.vector.nsk.academit.feller.vector.main;


import nsk.academit.feller.vector.Vector;

public class Main {
    public static void main(String[] args) {
        Vector vector = new Vector(1);
        double [] array = new double[]{1,2,3,4};
        Vector vector1 = new Vector(array);
        System.out.println(vector.getSize());
    }
}
