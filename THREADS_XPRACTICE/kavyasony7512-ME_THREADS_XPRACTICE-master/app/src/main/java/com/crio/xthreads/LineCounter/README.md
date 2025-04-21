# Problem Statement
## Title: Concurrent Line Counter

### Objective: Implement a program that counts the number of lines in multiple text files concurrently.

You are given several text files located in the resources folder. Your task is to develop a multi-threaded application that counts the number of lines in each file concurrently and provides the total line count across all files.

The program should create a thread for each file, where each thread counts the lines in its assigned file and returns the count. The results from all threads should be aggregated to produce the total number of lines.

### Output
```bash
Total number of lines: 9
```

# Implementation

1. Implement `FileLineCountTask` Class:
   - Define a constructor that takes the file name as a parameter.
   - Implement the call method to:
     - Open the file from the resources folder.
     - Read the file line by line using BufferedReader.
     - Count the lines and return the count.
   - Handle any `IOException` that might occur during file operations.


2. Implement `main` Method in `App` Class:
   - Define a list of file names located in the `resources` folder.
   - Create an `ExecutorService` with a fixed thread pool, where the number of threads matches the number of files.
   - Submit `Callable` tasks to the `ExecutorService`, each responsible for counting lines in a specific file.
   - Aggregate the results from all `Callable` tasks to get the total number of lines.
   - Print the total line count.