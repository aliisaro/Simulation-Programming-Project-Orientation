package Orientation_tasks2.Task2_Event;

import java.util.PriorityQueue;

public class EventList {
    private static PriorityQueue<Event> queue = new PriorityQueue<>();

    public static void addEvent(Event event) {
        queue.add(event);
        System.out.println("Event " + event.getId() + " added to the event list.");
    }

    public Event getNextEvent() {
        System.out.println("\nRetrieving next event.");
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
