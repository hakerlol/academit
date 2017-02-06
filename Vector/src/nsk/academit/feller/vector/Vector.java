package nsk.academit.feller.vector;


public class Vector {
    private double[] mass;

    public Vector(int size) {
        if (size <= 0) throw new IllegalArgumentException("size can't be negative");
        double array[] = new double[size];
    }

    public Vector(Vector vector) {
        Vector newVector = vector;
    }

    public Vector(double[] array) {
        mass = new double[array.length];
        System.arraycopy(array,0, mass, 0, array.length - 1);
    }

    public Vector(int size, double[] array) {
        if (size <= 0) throw new IllegalArgumentException("size can't be negative");
        mass = new double[array.length];
        if(array.length < size){
            for (int i = 0; i < array.length;i++){
                mass[i] = array[i];
            }
            for (int i = array.length; i < size; i++){
                mass[i] = 0;
            }
        } else{
            for (int i = 0; i < array.length; i++) {
                mass[i] = array[i];
            }
        }

    }

    public int getSize() {
        return mass.length;
    }

    @Override
    public String toString() {

        return null;
    }
}
