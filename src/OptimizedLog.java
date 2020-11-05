import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;


import static java.time.format.DateTimeFormatter.RFC_1123_DATE_TIME;

public class OptimizedLog<E> implements Collection<E>{
    private int size;
    private logElement firstItem;

    public OptimizedLog()
    {
        firstItem = null;
    }

    public int size() { //complete
        return size;
    } //Complete

    public boolean isEmpty() { //complete
        return size == 0;
    } //Complete

    public boolean contains(Object o) { //Complete
        logElement e = firstItem;
        while(e != null)
        {
            if(e.getData()==  o)
            {
                return true;
            }
            e = e.getNext();
        }
        return false;
    }

    public Iterator<E> iterator() { //Complete
        return new logIterator<>(this);
    }

    public Object[] toArray() { //Complete
        Object[] array = new Object[size];
        logElement<E> e = firstItem;
        int i = 0;
        while(e != null)
        {
            array[i] = e.getData();
            i++;
            e = e.getNext();
        }
        return array;
    }

    public <T> T[] toArray(T[] a) {

        if(a.length < size)
        {
            a = Arrays.copyOf(a, size);
        }
        logElement e = firstItem;
        int i = 0;
        Object[] array = a;
        while(e != null)
        {
            array[i] = e.getData();
            i++;
            e = e.getNext();
        }
        if(a.length > size) {
            a[size] = null;
        }
        return a;
    }

    public boolean add(E data) { //complete
        logElement<E> newLogElement = new logElement<>(data);
        logElement temp = firstItem;
        if (firstItem == null) {
            firstItem = newLogElement;
            size++;
            return true;
        } else {
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
        }
        if (temp.getData() == data) {
            temp.setCount(temp.getCount() + 1);
            temp.setFinalTime(ZonedDateTime.now().format(RFC_1123_DATE_TIME));
            return true;
        }
        temp.setNext(newLogElement);
        size++;
        return true;
    }

    public boolean remove(Object o) { //complete
        System.out.println("Error: Cannot remove from OptimizedLog");
        return false;
    }

    public boolean containsAll(Collection<?> c) { //Complete
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }
        return true;
    }

    public boolean addAll(Collection<? extends E> c) { //Complete
        Object[] x = c.toArray();

        for (Object o : x) {
            this.add((E) o);
        }
        return true;
    }

    public String toString() { //Complete
        StringBuilder s = new StringBuilder();
        logElement e = this.getFirstItem();
        while (e != null) {
            if (e.getCount() == 0) {
                s.append('[').append(e.getTime()).append("] ").append(e.toString()).append("\n");
                 }
            else {
                      s.append('[').append(e.getTime()).append(" - ").append(e.getFinalTime()).append(']').append('[').append(e.getCount() + 1).append(" TIMES] ").append(e.toString()).append("\n");
                   }
                e = e.getNext();
            }
            return s.toString();
        }

    /**
     * returns the first item in the log
     * @return First item in log
     */
    public logElement getFirstItem() {
        return firstItem;
    }
  public int hashCode() {
      int hashCode = 1;
      for (E e : this)
      {
          hashCode = 31*hashCode + (e==null ? 0 : e.hashCode());
      }
      return hashCode;
  }
    public boolean equals(Object o)
    {
        logElement current1 = getFirstItem();
        if (o == this)
        {
            return true;
        }
        if(o instanceof OptimizedLog)
        {
            OptimizedLog other = (OptimizedLog) o;
            logElement current2 = other.getFirstItem();
            System.out.println(current1.toString());
            System.out.println(current2.toString());
            if(this.size() != other.size())
            {
                return false;
            }
            while(current1 != null)
            {
                if(current1.getData() != current2.getData()){
                    return false;
                }
                current1 = current1.getNext();
                current2 = current2.getNext();
            }
        }
        return true;
    }


    public boolean removeAll(Collection<?> c) { //Not relevant to spec
        return false;
    }

    public boolean retainAll(Collection<?> c) { //Not relevant to spec
        return false;
    }

    public void clear() {} //Not relevant to spec


}
