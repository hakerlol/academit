package nsk.academit.feller.vector.nsk.academit.feller.vector.main;

import nsk.academit.feller.vector.Vector;

public class Main {
    public static void main(String[] args) {
        Vector vector = new Vector(5);
        double[] array = new double[]{1, 2, 3, 4};
        double[] array2 = new double[]{1, 2, 3, 4, 10, 15};
        Vector vector1 = new Vector(array);
        Vector vector2 = new Vector(array2);
        Vector vector3 = new Vector(10, array);
        Vector vector4 = new Vector(vector1);

        System.out.println(vector1.getSum(vector2));
        System.out.println(vector1.getDifference(vector2));
        System.out.println(vector1.calcVectorOnNumber(5));
        System.out.println(vector1.Reverse());
        System.out.println(vector3);
        System.out.println(vector4);
        System.out.println(vector4.getSize());
        System.out.println(vector4.getVectorLength());
    }
}
