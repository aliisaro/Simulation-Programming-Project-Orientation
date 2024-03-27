package Orientation_tasks1;

public class Task1_3_Customer {
    private int id;
    private static int _id = 1;
    private long startTime;
    private long endTime;

    public Task1_3_Customer() {
        id = _id++;
    }

    public void tulosta() {
        System.out.println("Asiakasnumero on " + id);
    }

    void setStartTime(long time) {
        if (time > 0) {
            startTime = time;
        }
    }

    long getStartTime() {
        return startTime;
    }

    void setEndTime(long time) {
        if (time > 0) {
            endTime = time;
        }
    }

    long getEndTime() {
        return endTime;
    }

    long duration() {
        return endTime - startTime;
    }

    public static void main(String[] args) {
        Task1_3_Customer asiakas1 = new Task1_3_Customer();
        Task1_3_Customer asiakas2 = new Task1_3_Customer();
        Task1_3_Customer asiakas3 = new Task1_3_Customer();

        asiakas1.tulosta(); asiakas2.tulosta(); asiakas3.tulosta();
    }
}
