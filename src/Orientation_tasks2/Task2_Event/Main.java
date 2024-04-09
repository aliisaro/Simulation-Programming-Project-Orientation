package Orientation_tasks2.Task2_Event;
import Orientation_tasks1.Task5_ServiceSystem.CustomerGenerator;

public class Main {
    public static void main (String[] args ) {
        EventList eventlist = new EventList();

        EventList.addEvent(new Event(5, "A"));
        EventList.addEvent(new Event(12, "B"));
        EventList.addEvent(new Event(7, "C"));

        while (!eventlist.isEmpty()) {
            Event nextEvent = eventlist.getNextEvent();
            System.out.println("Next event: Event: " + nextEvent.getId() + ", time: " + nextEvent.getEventTime() + " minutes.");
        }
    }
}
