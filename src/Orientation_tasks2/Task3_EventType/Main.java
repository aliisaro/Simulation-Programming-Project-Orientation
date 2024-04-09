package Orientation_tasks2.Task3_EventType;

public class Main {
    public static void main (String[] args ) {
        EventList eventlist = new EventList();

        EventList.addEvent(new Event(12.12, "A", Event.Type.ARRIVAL));
        EventList.addEvent(new Event(12.30, "B", Event.Type.ARRIVAL));
        EventList.addEvent(new Event(12.48, "C", Event.Type.ARRIVAL));
        EventList.addEvent(new Event(12.45, "A", Event.Type.EXIT));
        EventList.addEvent(new Event(12.40, "B", Event.Type.EXIT));
        EventList.addEvent(new Event(13.10, "C", Event.Type.EXIT));

        EventList.printEventList();

        while (!eventlist.isEmpty()) {
            Event nextEvent = eventlist.getNextEvent();
            switch(nextEvent.getEventType()) {
                case ARRIVAL:
                    System.out.println("Arrival: ID " + nextEvent.getId() + ", time: " + String.format("%.2f", nextEvent.getEventTime()) + " a'clock.");
                    break;
                case EXIT:
                    System.out.println("Exit: ID: " + nextEvent.getId() + ", time: " + String.format("%.2f", nextEvent.getEventTime()) + " a'clock.");
                    break;
            }
        }
    }
}
