// package com.crio.xthreads.OddEvenPrinter;

// public class App {
//     public static void main(String[] args) {
//         int n = 10; // Example: Set n to 10 to print numbers from 1 to 10

//         OddEvenPrinter printer = new OddEvenPrinter(n);

//         // TODO:
//         // 1. Create a thread for printing odd numbers:
//         //    - Use the `printOdd` method from the `OddEvenPrinter` class.
//         //    - Name the thread "OddThread" for identification.
        
//         // 2. Create a thread for printing even numbers:
//         //    - Use the `printEven` method from the `OddEvenPrinter` class.
//         //    - Name the thread "EvenThread" for identification.

//         // 3. Start both threads to begin execution:
//         //    - Call `start()` on both the odd and even threads.

//         // 4. Wait for both threads to finish:
//         //    - Use `join()` on each thread to ensure the main thread waits for their completion.
//         //    - Handle any `InterruptedException` by restoring the interrupted status of the main thread.

//     }
// }

package com.crio.xthreads.OddEvenPrinter;

public class App {
    public static void main(String[] args) {
        int n = 10; // Example: Set n to 10 to print numbers from 1 to 10

        OddEvenPrinter printer = new OddEvenPrinter(n);

        // Create a thread for printing odd numbers
        Thread oddThread = new Thread(() -> printer.printOdd(), "OddThread");

        // Create a thread for printing even numbers
        Thread evenThread = new Thread(() -> printer.printEven(), "EvenThread");

        // Start both threads
        oddThread.start();
        evenThread.start();

        // Wait for both threads to finish
        try {
            oddThread.join();
            evenThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
