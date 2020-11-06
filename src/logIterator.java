import java.util.Iterator;


public class logIterator<E> implements Iterator<E> {
    private logElement<E> Current;

    public logIterator(OptimizedLog log)
    {
        Current = log.getFirstItem();
    }


    public boolean hasNext() {
        return Current != null;
    }


    public E next() {
        E data = Current.getData();
        Current = Current.getNext();
        return data;
    }
}
