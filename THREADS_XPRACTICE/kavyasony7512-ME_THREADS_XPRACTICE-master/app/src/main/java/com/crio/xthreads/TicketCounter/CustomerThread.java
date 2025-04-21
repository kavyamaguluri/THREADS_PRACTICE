// package com.crio.xthreads.TicketCounter;

// public class CustomerThread implements Runnable {
//     private final TicketCounter ticketCounter;
//     private final String customerName;
//     private final int numberOfTickets;

//     public CustomerThread(TicketCounter ticketCounter, String customerName, int numberOfTickets) {
//         this.ticketCounter = ticketCounter;
//         this.customerName = customerName;
//         this.numberOfTickets = numberOfTickets;
//     }

//     /* TODO: Implement the run method to handle the ticket booking process.

//         1. **Invoke the `bookTicket` Method**:
//             - Inside the `run` method, call the `bookTicket` method of the `TicketCounter` instance.
//             - This will simulate the customer attempting to book the specified number of tickets.
//     */

//     @Override
//     public void run() {
//     }
// }

package com.crio.xthreads.TicketCounter;

// CustomerThread Class
public class CustomerThread implements Runnable {
    private final TicketCounter ticketCounter;
    private final String customerName;
    private final int numberOfTickets;

    public CustomerThread(TicketCounter ticketCounter, String customerName, int numberOfTickets) {
        this.ticketCounter = ticketCounter;
        this.customerName = customerName;
        this.numberOfTickets = numberOfTickets;
    }

    @Override
    public void run() {
        ticketCounter.bookTicket(customerName, numberOfTickets);
    }
}
