package Orientation_tasks3.Task5_Clock;

public class Clock {
    private static Clock instance;
    private long currentTimeMillis;

    private Clock() {
        currentTimeMillis = System.currentTimeMillis();
    }

    // Get the Singleton instance of Clock
    public static Clock getInstance() {
        if (instance == null) {
            instance = new Clock();
        }
        return instance;
    }

    public long getCurrentTimeMillis() {
        return currentTimeMillis;
    }

    public void setCurrentTimeMillis(long timeMillis) {
        this.currentTimeMillis = timeMillis;
    }
}
