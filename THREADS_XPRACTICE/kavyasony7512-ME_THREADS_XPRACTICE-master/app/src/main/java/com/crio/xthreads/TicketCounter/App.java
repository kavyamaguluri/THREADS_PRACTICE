// package com.crio.xthreads.TicketCounter;

// public class App {
//     public static void main(String[] args) {

//         // TODO: Initialize the TicketCounter and Simulate Concurrent Ticket Booking.
//         // 1. Initialize the TicketCounter object with a specific number of available tickets (e.g., 10 tickets).
//         // 2. Create multiple customer threads using the CustomerThread class, each representing a customer
//         //    attempting to book a certain number of tickets.
//         // 3. Start all the customer threads to simulate concurrent ticket booking, allowing them to run in parallel.

//     }
// }

package com.crio.xthreads.TicketCounter;

// App Class to Simulate the System
public class App {
    public static void main(String[] args) {
        // Initialize the TicketCounter with 10 tickets
        TicketCounter ticketCounter = new TicketCounter(10);

        // Create customer threads
        Thread customer1 = new Thread(new CustomerThread(ticketCounter, "Customer 1", 3));
        Thread customer2 = new Thread(new CustomerThread(ticketCounter, "Customer 2", 5));
        Thread customer3 = new Thread(new CustomerThread(ticketCounter, "Customer 3", 2));
        Thread customer4 = new Thread(new CustomerThread(ticketCounter, "Customer 4", 3));

        // Start customer threads
        customer1.start();
        customer2.start();
        customer3.start();
        customer4.start();

        // Ensure all threads complete before program ends
        try {
            customer1.join();
            customer2.join();
            customer3.join();
            customer4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print remaining tickets
        System.out.println("Tickets remaining: " + ticketCounter.getAvailableTickets());
    }
}

