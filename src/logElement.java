import java.time.ZonedDateTime;


import static java.time.format.DateTimeFormatter.RFC_1123_DATE_TIME;

public class logElement<E> {
    private logElement<E> next;
    private final E data;
    private int count;
    private final String time = ZonedDateTime.now().format(RFC_1123_DATE_TIME);
    private String finalTime;

    public logElement(E data)
    {
        next = null;
        this.data = data;
    }

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
