package Orientation_tasks2.Task3_EventType;

public class Event implements Comparable<Event> {
    private double eventTime;
    private String id;
    Type type;

    public double getEventTime() {
        return eventTime;
    }
    public String getId() {
        return id;
    }

    public Type getEventType() {
        return type;
    }
    public enum Type {
        ARRIVAL, EXIT
    }

    public Event(double eventTime, String id, Type type) {
        this.eventTime = eventTime;
        this.id = id;
        this.type = type;
    }
    @Override
    public int compareTo(Event other) {
        return Double.compare(this.eventTime, other.eventTime);
    }
}
