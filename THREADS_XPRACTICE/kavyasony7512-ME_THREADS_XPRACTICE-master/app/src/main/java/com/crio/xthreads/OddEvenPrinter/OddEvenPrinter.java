// package com.crio.xthreads.OddEvenPrinter;

// public class OddEvenPrinter {
//     private final int limit;
//     private boolean isOdd = true;

//     public OddEvenPrinter(int limit) {
//         this.limit = limit;
//     }

//     /**
//      * TODO: Implement the method to print odd numbers.
//      * - Synchronize the method/block to ensure thread-safe access.
//      * - Use a flag (`isOdd`) to determine if it is the correct time to print odd numbers.
//      * - Use `lock.wait()` to pause the thread if it's not the right turn.
//      * - Print the odd number and the thread name.
//      * - Update the `isOdd` flag to indicate that the next number to print should be even.
//      * - Use `lock.notify()` to wake up the waiting thread (for even numbers).
//      */
//      public void printOdd() {
//          for (int i = 1; i <= limit; i += 2) {
//              System.out.println(Thread.currentThread().getName() + " printed: " + i);

//              try {
//                  Thread.sleep(500);
//              } catch (InterruptedException e) {
//                  Thread.currentThread().interrupt();
//              }
//          }
//      }
    
//     /**
//      * TODO: Implement the method to print even numbers.
//      * - Synchronize the method/block to ensure thread-safe access.
//      * - Use a flag (`isOdd`) to determine if it is the correct time to print even numbers.
//      * - Use `lock.wait()` to pause the thread if it's not the right turn.
//      * - Print the even number and the thread name.
//      * - Update the `isOdd` flag to indicate that the next number to print should be odd.
//      * - Use `lock.notify()` to wake up the waiting thread (for odd numbers).
//      */
//      public void printEven() {
//          for (int i = 2; i <= limit; i += 2) {
//              System.out.println(Thread.currentThread().getName() + " printed: " + i);

//              try {
//                  Thread.sleep(500);
//              } catch (InterruptedException e) {
//                  Thread.currentThread().interrupt();
//              }
//          }
//      }

// }

package com.crio.xthreads.OddEvenPrinter;

public class OddEvenPrinter {
    private final int limit;
    private boolean isOdd = true;
    private final Object lock = new Object(); // Shared lock object for coordination

    public OddEvenPrinter(int limit) {
        this.limit = limit;
    }

    // Method to print odd numbers
    public void printOdd() {
        synchronized (lock) {
            for (int i = 1; i <= limit; i += 2) {
                while (!isOdd) {
                    try {
                        lock.wait();  // Wait if it's not the turn for odd numbers
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " printed: " + i);
                isOdd = false; // Set flag to false for the next even number to be printed
                lock.notify(); // Wake up the even thread
            }
        }
    }

    // Method to print even numbers
    public void printEven() {
        synchronized (lock) {
            for (int i = 2; i <= limit; i += 2) {
                while (isOdd) {
                    try {
                        lock.wait();  // Wait if it's not the turn for even numbers
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " printed: " + i);
                isOdd = true; // Set flag to true for the next odd number to be printed
                lock.notify(); // Wake up the odd thread
            }
        }
    }
}
