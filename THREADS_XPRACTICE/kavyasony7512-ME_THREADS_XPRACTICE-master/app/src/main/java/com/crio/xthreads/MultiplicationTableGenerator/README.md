# Problem Statement
## Title: Multiplication Table Generator

### Objective: Print multiplication tables using multiple threads.

Develop a program that accepts an integer `n` as input and creates a thread for each number from 1 to `n` (inclusive). Each thread will be responsible for printing the multiplication table from 1 to 10 for its assigned number. The output should follow the format: "2 times 6 is 12". 

### Output
```bash
1 times 1 is 1
1 times 2 is 2
1 times 3 is 3
1 times 4 is 4
1 times 5 is 5
1 times 6 is 6
1 times 7 is 7
1 times 8 is 8
1 times 9 is 9
1 times 10 is 10
2 times 1 is 2
2 times 2 is 4
2 times 3 is 6
2 times 4 is 8
2 times 5 is 10
2 times 6 is 12
2 times 7 is 14
2 times 8 is 16
2 times 9 is 18
2 times 10 is 20
3 times 1 is 3
3 times 2 is 6
3 times 3 is 9
3 times 4 is 12
3 times 5 is 15
3 times 6 is 18
3 times 7 is 21
3 times 8 is 24
3 times 9 is 27
3 times 10 is 30
4 times 1 is 4
4 times 2 is 8
4 times 3 is 12
4 times 4 is 16
4 times 5 is 20
4 times 6 is 24
4 times 7 is 28
4 times 8 is 32
4 times 9 is 36
4 times 10 is 40
5 times 1 is 5
5 times 2 is 10
5 times 3 is 15
5 times 4 is 20
5 times 5 is 25
5 times 6 is 30
5 times 7 is 35
5 times 8 is 40
5 times 9 is 45
5 times 10 is 50
```

# Implementation

1. Implement `TableCreator` Class:
   - Implements `Runnable`: Represents a task that prints a multiplication table.
   - Fields: `number` to store the number for which the table is printed
   - Constructor: Accept a number as an argument.
   - `run` Method: Prints the multiplication table from 1 to 10 for the given number.

3. Implement `main` method in `App` Class:
   - Takes an integer `n` as input.
   - Creates and starts a thread for each number from 1 to `n`, passing the number to `TableCreator`.
   - Ensures all threads complete.


