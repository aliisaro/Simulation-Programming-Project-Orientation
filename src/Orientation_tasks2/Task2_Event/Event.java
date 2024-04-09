package Orientation_tasks2.Task2_Event;

public class Event implements Comparable<Event> {
    private long eventTime;
    private String id;

    public long getEventTime() {
        return eventTime;
    }
    public String getId() {
        return id;
    }

    public Event(long eventTime, String id) {
        this.eventTime = eventTime;
        this.id = id;
    }

    @Override
    public int compareTo(Event other) {
        return Long.compare(this.eventTime, other.eventTime);
    }
}
