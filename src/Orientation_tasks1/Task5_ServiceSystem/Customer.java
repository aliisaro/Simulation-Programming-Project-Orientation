package Orientation_tasks1.Task5_ServiceSystem;

public class Customer {
    private long arrivalTime;
    private long startTime;
    private long endTime;
    private int id;

    public Customer(long arrivalTime, int id) {
        this.arrivalTime = arrivalTime;
        this.id = id;
    }

    public long getArrivalTime() {
        return arrivalTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
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

    public long getServiceTime() {
        return endTime - startTime;
    }

    public long getResponseTime() {
        return getServiceTime() + (startTime - arrivalTime);
    }

    public int getId() {
        return id;
    }
}
