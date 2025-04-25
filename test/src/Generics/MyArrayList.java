package Generics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyArrayList<T> implements Iterable<T> {

    public static final int MAX_ELEMENTS = 10;
    List<T> constrainedList = new ArrayList<T>(MAX_ELEMENTS);

    public boolean addItem(T element) {
        if (constrainedList.size() < MAX_ELEMENTS) {
            return constrainedList.add(element);
        }
        return false;
    }

    public T removeItem(int index) {
        return constrainedList.remove(index);
    }

    public T getItem(int index){
        return constrainedList.get(index);
    }

    @Override
    public Iterator<T> iterator() {
        return constrainedList.iterator();
    }
}
