package Orientation_tasks1.Task4_Queue;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    private LinkedList<Customer> queue = new LinkedList<>();
    private static int nextCustomerId = 1;

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


    public static void main(String[] args) {
        Main queue = new Main();
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

