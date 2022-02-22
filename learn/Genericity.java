package learn;

public class Genericity {
    public static void main(String[] args) {
        ArrayList<String> strList = new ArrayList<String>();
        ArrayList<Float> floatList = new ArrayList<Float>();


        
    }

    
}

class ArrayList<T> {
    private T[] array;
    private int size;
    public void add(T e) {}
    public void remove(int index) {}
    public T get(int index) {
        return null;
    }
}
