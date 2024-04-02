package Orientation_tasks1;
import java.util.LinkedList;
import java.util.Scanner;

public class Task4_Queue {
    private LinkedList<Customer> queue = new LinkedList<>();
    private static int nextCustomerId = 1;

    private static class Customer {
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

        public void printInfo() {
            System.out.println("Asiakasnumero on " + id + ", aloitusaika: " + startTime + ", lopetusaika: " + endTime);
            System.out.println("Jonotusaika: " + getDuration() + " seconds.");

        }
    }

    public void enqueue(long startTime) {
        queue.addLast(new Customer(startTime, nextCustomerId));
        System.out.println("\nJonoon lisätty asiakas ID: " + nextCustomerId);
        nextCustomerId++;
    }

    public void dequeue() {
        if (!queue.isEmpty()) {
            Customer customer = queue.removeFirst();
            customer.setEndTime(System.currentTimeMillis());
            System.out.println("\nSeuraava asiakas poistettu jonosta:");
            customer.printInfo();
        } else {
            System.out.println("\nJono on tyhjä.");
        }
    }

    private static void viive(long aika) {
        try {
            Thread.sleep(aika * 1000); //1000ms = 1s
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Task4_Queue queue = new Task4_Queue();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n****************************************************************");
            System.out.println("1. Lisää asiakas jonoon");
            System.out.println("2. Poista asiakas jonosta");
            System.out.println("3. Poistu");
            System.out.print("\nSyötä vaihtoehto: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    queue.enqueue(System.nanoTime());
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    System.out.println("\nPoistutaan ohjelmasta...");
                    scanner.close();
                    return;
            }
        }
    }
}

