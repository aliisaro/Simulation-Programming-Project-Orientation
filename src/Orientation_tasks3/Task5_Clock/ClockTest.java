package Orientation_tasks3.Task5_Clock;

public class ClockTest {
    public static void main(String[] args) {
        // Get the Singleton instance of Clock
        Clock clock = Clock.getInstance();

        // Get the current time
        long currentTimeMillis = clock.getCurrentTimeMillis();
        System.out.println("Current time: " + currentTimeMillis);

        // Change the time to a specific value
        long newTimeMillis = 1618536000000L; // 2021-04-16T00:00:00Z
        clock.setCurrentTimeMillis(newTimeMillis);

        // Get the updated current time
        long updatedTimeMillis = clock.getCurrentTimeMillis();
        System.out.println("Updated time: " + updatedTimeMillis);
    }
}
