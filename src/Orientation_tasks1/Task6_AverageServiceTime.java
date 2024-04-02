package Orientation_tasks1;
import java.util.LinkedList;
import java.util.Scanner;

public class Task6_AverageServiceTime {
    private LinkedList<Task6_AverageServiceTime.Customer> queue = new LinkedList<>();
    private static int nextCustomerId = 1;

    private static class Customer {
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
    }

    private static void printInfo(Task6_AverageServiceTime.Customer customer) {
        System.out.println("Valmis: asiakasnumero " + customer.id + ", jonotusaika: " + customer.getResponseTime() + ", palveluaika: " + customer.getServiceTime());
    }

    public static class CustomerGenerator {
        public static void generateCustomers(Task6_AverageServiceTime.ServicePoint servicePoint, int numCustomers) {
            System.out.println("Luodaan " + numCustomers + " asiakasta ja laitetaan jonoon.");
            for (int i = 0; i < numCustomers; i++) {
                servicePoint.addToQueue(new Task6_AverageServiceTime.Customer(System.currentTimeMillis(), nextCustomerId));
                nextCustomerId++;
            }
        }
    }

    public static class ServicePoint {
        private LinkedList<Task6_AverageServiceTime.Customer> queue = new LinkedList<>();
        private int totalServiceTime;
        private int totalCustomers;

        public void addToQueue(Task6_AverageServiceTime.Customer customer) {
            queue.addLast(customer);
        }

        public Task6_AverageServiceTime.Customer removeFromQueue() {
            if (!queue.isEmpty()) {
                Task6_AverageServiceTime.Customer customer = queue.removeFirst();
                System.out.println("\nAsiakas " + customer.id + " poistettu jonosta. ");
                return customer;
            }
            System.out.println("\nJono on tyhjä.");
            return null;
        }

        public void serve() {
            while (!queue.isEmpty()) {
                Task6_AverageServiceTime.Customer customer = removeFromQueue();
                if (customer != null) {
                    System.out.println("Palvellaan asiakasta: " + customer.id);
                    customer.setStartTime(System.currentTimeMillis());
                    // Simulate service time
                    long serviceTime = (long) (Math.random() * 5000) + 1000; // Random service time between 1 and 5 seconds
                    try {
                        Thread.sleep(serviceTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    customer.setEndTime(System.currentTimeMillis());
                    printInfo(customer);
                    totalServiceTime += serviceTime;
                    totalCustomers += 1;
                }
            }
        }

        public int calculateAverageServiceTime() {
            if (totalCustomers == 0) {
                return 0;
            }
            return totalServiceTime / totalCustomers;
        }
    }

    public static void main(String[] args) {
        Task6_AverageServiceTime.ServicePoint servicePoint = new Task6_AverageServiceTime.ServicePoint();
        Scanner scanner = new Scanner(System.in);

        Task6_AverageServiceTime.CustomerGenerator.generateCustomers(servicePoint, 5);

        System.out.println("Aloitetaan palvelu...");
        servicePoint.serve();

        int averageServingTime = servicePoint.calculateAverageServiceTime();
        System.out.println("\nKeskimääräinen palveluaika: " + averageServingTime);

        scanner.close();
    }
}
