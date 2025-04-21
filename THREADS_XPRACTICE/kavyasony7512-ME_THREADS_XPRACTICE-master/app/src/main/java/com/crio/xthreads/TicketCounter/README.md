# Problem Statement
## Title: Ticket Counter

### Objective: Implement a program to simulate a ticket booking system where multiple customers (threads) attempt to book tickets concurrently.

Multiple customers are trying to book tickets at the same time. The program needs to manage the available tickets and ensure that no race conditions occur when multiple threads (customers) attempt to book tickets simultaneously. The booking process should be synchronized to prevent overselling.

### Output
```bash
Customer 1 successfully booked 3 tickets.
Customer 3 successfully booked 2 tickets.
Customer 4 successfully booked 3 tickets.
Customer 2 failed to book tickets. Not enough tickets available.
```

# Implementation

1. Implement `TicketCounter` Class
   - This class represents the ticket counter responsible for handling ticket booking requests.
   - Fields: 
      - `availableTickets`: Stores the total number of available tickets
   - Constructor: Accepts an integer `tickets`, representing the initial number of available tickets.
   - `bookTicket` Method:
      - Synchronized to ensure that only one thread can book tickets at a time.
      - Accepts the `customerName` and the `numberOfTickets` the customer wants to book.
      - Checks if there are enough available tickets. If so, it books the tickets and reduces the ticket count. If not, it prints a failure message.
      - Returns `true` if the booking was successful, `false` otherwise.
   - `getAvailableTickets` Method:
      - Returns the number of tickets still available.

2. Implement `CustomerThread` Class:
   - Implements the `Runnable` interface to represent each customer's booking request as a separate thread.
   - Fields:
     - `ticketCounter`: A reference to the `TicketCounter` object, representing the ticket booking system.
     - `customerName`: The name of the customer trying to book tickets.
     - `numberOfTickets`: The number of tickets the customer wants to book.
   - Constructor: Accepts the `TicketCounter` instance, the customer's name, and the number of tickets to book.
   - `run` Method:
     - Calls the `bookTicket` method of the `TicketCounter` class with the `customerName` and `numberOfTickets`.

2. Implement `main` Method in `App` Class:
   - Creates a `TicketCounter` object initialized with a certain number of available tickets.
   - Creates multiple `CustomerThread` objects representing different customers trying to book tickets simultaneously.
   - Starts each thread, representing a customer attempting to book tickets.
   - Threads will execute in parallel, and ticket booking will happen concurrently, with the booking logic ensuring thread safety.
