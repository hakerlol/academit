package nsk.academit.feller.arraylist;

public class ArrayList<T> {
    private T[] elementData;

    public ArrayList() {
        elementData = (T[]) new Object[10];
    }


    public void ensureCapasity(int size) {
        if (size >= this.getSize()) {
            T[]  oldData = elementData;
            elementData = (T[]) new Object[this.getSize() * 3 / 2 + 1];
            System.arraycopy(oldData, 0, elementData, 0, elementData.length);
        }
    }

    public void trimToSize() {

    }

    public void add(T element) {
        ensureCapasity(getSize() + 1);
        elementData[getSize() + 1] = element;

    }

    public void remove(int value) {

    }

    public int getSize() {
        return elementData.length;
    }


}
