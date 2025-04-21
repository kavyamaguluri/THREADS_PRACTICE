# Problem Statement
## Title: Prime Number Checker

### Objective: Implement a program to determine the primality of numbers in a list using multiple threads.

Develop a program that accepts a list of numbers and creates a thread for each number to check if it is prime. Each thread will determine the primality of its assigned number, and the main thread will collect and print the results.

### Output
```bash
2 is prime
3 is prime
4 is not prime
5 is prime
29 is prime
77 is not prime
```

# Implementation

1. Ensure you know what a prime number is: a number greater than 1 that has no positive divisors other than 1 and itself.

2. Implement `PrimeChecker` Class:
   - Implements `Runnable`: Represents a task that checks if a number is prime.
   - Fields: `number` to store the number to be checked, and a boolean `isPrime` to store the result.
   - Constructor: Accepts the number to be checked.
   - run Method: Implements the primality check and stores the result in `isPrime`.

3. Implement `main` method in `App` Class:
   - Creates and starts a thread for each number, passing the number to `PrimeChecker`.
   - Collects results from each `PrimeChecker` instance and prints whether each number is prime.