// package com.crio.xthreads.LineCounter;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.concurrent.Callable;
// import java.util.concurrent.ExecutionException;
// import java.util.concurrent.ExecutorService;
// import java.util.concurrent.Executors;
// import java.util.concurrent.Future;

// public class App {
//     public static void main(String[] args) {
//         // Define the file names located in the resources folder
//         List<String> fileNames = List.of(
//             "file1.txt",
//             "file2.txt",
//             "file3.txt"
//         );

//         // TODO: Create an ExecutorService with a fixed thread pool
//         // 1. Initialize the ExecutorService with a fixed thread pool.
//         // 2. Set the number of threads in the pool to match the number of files.
//         // 3. This will allow each file to be processed concurrently.

//         // TODO: Submit Callable tasks to the ExecutorService
//         // 1. Create a list to hold Future objects that represent the results of the tasks.
//         // 2. Iterate over the list of file names.
//         // 3. For each file, create a Callable task (FileLineCountTask) to count the number of lines in the file.
//         // 4. Submit each Callable task to the ExecutorService and obtain a Future object.
//         // 5. Add each Future object to the list of futures.

//         // TODO: Aggregate results
//         // 1. Initialize a variable to keep track of the total line count.
//         // 2. Iterate over the list of Future objects.
//         // 3. For each Future, retrieve the result (line count for the corresponding file) and add it to the total line count.
//         // 4. Handle any potential exceptions that might occur during the retrieval of results.
    
//         // TODO: Shutdown the ExecutorService
//         // 1. Call shutdown() on the ExecutorService to prevent new tasks from being submitted.
//         // 2. This will also help release any resources associated with the ExecutorService.

//         // TODO: Output the total line count
//         // 1. Print out the total number of lines counted across all files.

//     } 
// }

package com.crio.xthreads.LineCounter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App {
    public static void main(String[] args) {
        // Define the file names located in the resources folder
        List<String> fileNames = List.of(
            "file1.txt",
            "file2.txt",
            "file3.txt"
        );

        // Create an ExecutorService with a fixed thread pool
        // The number of threads in the pool is equal to the number of files
        ExecutorService executorService = Executors.newFixedThreadPool(fileNames.size());

        // List to hold Future objects that represent the results of the tasks
        List<Future<Integer>> futures = new ArrayList<>();

        // Submit Callable tasks to the ExecutorService for each file
        for (String fileName : fileNames) {
            FileLineCountTask task = new FileLineCountTask(fileName);
            futures.add(executorService.submit(task));
        }

        // Variable to keep track of the total line count
        int totalLineCount = 0;

        // Aggregate the results
        for (Future<Integer> future : futures) {
            try {
                totalLineCount += future.get();  // Retrieve the result of each task
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        // Shutdown the ExecutorService to release resources
        executorService.shutdown();

        // Output the total line count
        System.out.println("Total number of lines: " + totalLineCount);
    }
}
