package Orientation_tasks1;

public class Task1_3_Customer {
    private int id;
    private static int _id = 1;
    private long startTime;
    private long endTime;

    public Task1_3_Customer() {
        id = _id++;
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

    double getDuration() {
        return (endTime - startTime) / 1000.0;
    }

    private static void viive(int aika) {
        try {
            Thread.sleep(aika*1000); //1000ms = 1s
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void tulosta() {
        System.out.println("Asiakasnumero on " + id + ", aloitusaika " + startTime + ", lopetusaika " + endTime);
    }

    public static void main(String[] args) {

        //Customer 1
        Task1_3_Customer asiakas1 = new Task1_3_Customer();
        asiakas1.setStartTime(System.currentTimeMillis());
        viive(3);
        asiakas1.setEndTime(System.currentTimeMillis());

        //Customer 2
        Task1_3_Customer asiakas2 = new Task1_3_Customer();
        asiakas2.setStartTime(System.currentTimeMillis());
        viive(3);
        asiakas2.setEndTime(System.currentTimeMillis());

        asiakas1.tulosta();
        System.out.println("Palveluaika oli " + asiakas1.getDuration());
        asiakas2.tulosta();
        System.out.println("Palveluaika oli " + asiakas2.getDuration());
    }
}
