package Orientation_tasks1.Task6_AverageServiceTime;

import java.util.LinkedList;

public class ServicePoint {
    private LinkedList<Customer> queue = new LinkedList<>();
    private int totalServiceTime;
    private int totalCustomers;

    public int calculateAverageServiceTime() {
        if (totalCustomers == 0) {
            return 0;
        }
        return totalServiceTime / totalCustomers;
    }

    private void printInfo(Customer customer) {
        System.out.println("Completed: Customer ID " + customer.getId() + ", wait time: " + customer.getResponseTime() + ", service time: " + customer.getServiceTime());
    }
    public void addToQueue(Customer customer) {
        queue.addLast(customer);
    }

    public Customer removeFromQueue() {
        if (!queue.isEmpty()) {
            Customer customer = queue.removeFirst();
            System.out.println("\nCustomer " + customer.getId() + " removed from the queue.");
            return customer;
        }
        System.out.println("\nThe queue is empty.");
        return null;
    }

    public void serve() {
        while (!queue.isEmpty()) {
            Customer customer = removeFromQueue();
            if (customer != null) {
                System.out.println("Serving customer: " + customer.getId());
                customer.setStartTime(System.currentTimeMillis());
                long serviceTime = (long) (Math.random() * 5000) + 1000;
                try {
                    Thread.sleep(serviceTime);
                } catch (InterruptedException e) {
                    System.err.println("Service interrupted: " + e.getMessage());
                }
                customer.setEndTime(System.currentTimeMillis());
                printInfo(customer);
                totalServiceTime += serviceTime;
                totalCustomers += 1;
            }
        }
    }
}
