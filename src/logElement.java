import java.time.ZonedDateTime;


import static java.time.format.DateTimeFormatter.RFC_1123_DATE_TIME;

/**
 * This class represents a node of the OptimizedLog data structure
 * @param <E> Generic type E
 */

public class logElement<E> {
    private logElement<E> next;
    private final E data;
    private int count; //Amount of duplicate /consecutive elements
    private final String time = ZonedDateTime.now().format(RFC_1123_DATE_TIME); //Get current time
    private String finalTime; //Time of final element of same value

    public logElement(E data)
    {
        next = null;
        this.data = data;
    }
//relevant setters and getters
    public String getFinalTime() {
        return finalTime;
    }

    public String toString()
    {
        return data.toString();
    }

    public E getData() {
        return data;
    }
    public int getCount() {
        return count;
    }

    public void setFinalTime(String finalTime) {
        this.finalTime = finalTime;
    }

    public void setCount(int count) {
        this.count = count;
    }
    public logElement<E> getNext() {
        return next;
    }
    public String getTime()
    {
        return time;
    }
    public void setNext(logElement<E> next) {
        this.next = next;
    }
}
