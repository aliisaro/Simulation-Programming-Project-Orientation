package Orientation_tasks2.Task3_EventType;

import java.util.PriorityQueue;

public class EventList {
    private static PriorityQueue<Event> queue = new PriorityQueue<>();

    public static void addEvent(Event event) {
        queue.add(event);
    }

    public Event getNextEvent() {
        System.out.println("\nRetrieving next event...");
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public static void printEventList() {
        System.out.println("\nEvent List:");
        for (Event event : queue) {
            System.out.println("Event: " + event.getId() + ", Type: " + event.getEventType() + ", Time: " + event.getEventTime());
        }
    }
}
