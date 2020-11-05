import java.util.Iterator;
import java.util.List;

public class logIterator<E> implements Iterator<E> {
    private logElement<E> Current;

    public logIterator(OptimizedLog log)
    {
        Current = log.getFirstItem();
    }

    @Override
    public boolean hasNext() {
        return Current != null;
    }

    @Override
    public E next() {
        E data = Current.getData();
        Current = Current.getNext();
        return data;
    }
}
