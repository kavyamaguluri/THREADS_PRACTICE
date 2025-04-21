// package com.crio.xthreads.TicketCounter;

// public class TicketCounter {
//     private int availableTickets;

//     public TicketCounter(int tickets) {
//         this.availableTickets = tickets;
//     }

//     /* 
//    TODO: Modify the code to synchronize the `bookTicket` and `getAvailableTickets` methods.

//    1. **Add Synchronization to `bookTicket` Method**:
//       - The `bookTicket` method must be made thread-safe to avoid race conditions when multiple threads try to book tickets simultaneously.
//       - Use the `synchronized` keyword to ensure that only one thread can execute this method at a time.
//       - Add `synchronized` before the method declaration to prevent multiple threads from accessing the ticket booking logic at the same time.

//    2. **Add Synchronization to `getAvailableTickets` Method**:
//       - The `getAvailableTickets` method should also be synchronized to ensure consistent access to the `availableTickets` variable.
//       - Synchronizing this method will prevent other threads from making booking decisions based on stale or incorrect data.

//       **Why Synchronization is Important**:
//       - Without synchronization, multiple threads can simultaneously read and modify the `availableTickets` variable, leading to incorrect results (e.g., overselling tickets).
//       - Synchronization ensures that each thread completes its operation on the shared resource (`availableTickets`) before another thread can modify it.
//     */
//      public boolean bookTicket(String customerName, int numberOfTickets) {
//          if (availableTickets >= numberOfTickets) {
//              System.out.println(customerName + " successfully booked " + numberOfTickets + " tickets.");
//              availableTickets -= numberOfTickets;
//              return true;
//          } else {
//              System.out.println(customerName + " failed to book tickets. Not enough tickets available.");
//              return false;
//          }
//      }

//      public int getAvailableTickets() {
//          return availableTickets;
//      }

// }

package com.crio.xthreads.TicketCounter;

// TicketCounter Class
public class TicketCounter {
    private int availableTickets;

    public TicketCounter(int tickets) {
        this.availableTickets = tickets;
    }

    // Synchronized method to book tickets
    public synchronized boolean bookTicket(String customerName, int numberOfTickets) {
        if (availableTickets >= numberOfTickets) {
            System.out.println(customerName + " successfully booked " + numberOfTickets + " tickets.");
            availableTickets -= numberOfTickets;
            return true;
        } else {
            System.out.println(customerName + " failed to book tickets. Not enough tickets available.");
            return false;
        }
    }

    // Synchronized method to get available tickets
    public synchronized int getAvailableTickets() {
        return availableTickets;
    }
}
