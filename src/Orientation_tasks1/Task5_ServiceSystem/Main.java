package Orientation_tasks1.Task5_ServiceSystem;
import Orientation_tasks1.Task6_AverageServiceTime.ServicePoint;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ServicePoint servicePoint = new ServicePoint();
        Scanner scanner = new Scanner(System.in);

        CustomerGenerator.generateCustomers(servicePoint, 5);

        System.out.println("Starting service...");
        servicePoint.serve();

        scanner.close();
    }
}

