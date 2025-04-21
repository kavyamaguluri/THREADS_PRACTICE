# Problem Statement
## Title: Odd-Even Printer

### Objective: Implement a program to print odd and even numbers alternately using two threads.

The program needs to print numbers in sequence, with one thread printing odd numbers and another printing even numbers. Thread coordination ensures the numbers are printed in the correct sequence.

### Output
```bash
OddThread printed: 1
EvenThread printed: 2
OddThread printed: 3
EvenThread printed: 4
OddThread printed: 5
EvenThread printed: 6
OddThread printed: 7
EvenThread printed: 8
OddThread printed: 9
EvenThread printed: 10
```

# Implementation

1. Implement `OddEvenPrinter` Class
   - Fields: 
      - `limit`: Stores the maximum number to be printed.
      - `isOdd`: A flag that indicates whether the odd thread should print or the even thread should print.
   - Constructor: Accepts an integer `limit` which specifies the maximum number to print.
   - `printOdd` Method:
       - This method prints odd numbers from 1 up to limit.
       - It waits for the even thread to finish its task before proceeding, using the wait() and notify() methods for coordination.
   - `printEven` Method:
       - This method prints even numbers from 2 up to limit.
       - It waits for the odd thread to finish its task before proceeding, using the wait() and notify() methods for coordination.

2. Implement `main` Method in `App` Class:
   - Takes an integer n as input, which defines the maximum number to print.
   - Creates two threads:
      - One for printing odd numbers using the printOdd method of the OddEvenPrinter class.
      - One for printing even numbers using the printEven method of the OddEvenPrinter class.
   - Starts both threads and ensures they complete by calling join() on each thread.
