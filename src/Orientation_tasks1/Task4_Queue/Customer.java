package Orientation_tasks1.Task4_Queue;

public class Customer {
    private long startTime;
    private long endTime;
    private int id;

    public Customer(long startTime, int id) {
        this.startTime = startTime;
        this.id = id;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public double getDuration() {
        return (endTime - startTime) / 1000000000.0;
    }
    public int getId() {
        return id;
    }

    private static void viive(long aika) {
        try {
            Thread.sleep(aika * 1000); //1000ms = 1s
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printInfo() {
        System.out.println("Asiakasnumero on " + getId() + ", aloitusaika: " + getStartTime() + ", lopetusaika: " + getEndTime());
        System.out.println("Jonotusaika: " + getDuration() + ".");

    }
}
