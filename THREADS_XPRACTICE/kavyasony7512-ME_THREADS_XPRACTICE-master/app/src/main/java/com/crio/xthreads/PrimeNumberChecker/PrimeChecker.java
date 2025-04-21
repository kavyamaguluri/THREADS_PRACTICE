// package com.crio.xthreads.PrimeNumberChecker;

// // PrimeChecker class that implements Runnable
// class PrimeChecker implements Runnable {
//     private final int number;
//     private boolean isPrime;

//     public PrimeChecker(int number) {
//         this.number = number;
//     }

//     // TODO: Implement the run method to perform prime number checking
//     // 1. Call the checkPrime method to determine if the number is prime.
//     // 2. Store the result in the isPrime field.
//     @Override
//     public void run() {
//     }

//     // Method to check if a number is prime
//     private boolean checkPrime(int num) {
//         if (num <= 1) return false;
//         for (int i = 2; i <= Math.sqrt(num); i++) {
//             if (num % i == 0) return false;
//         }
//         return true;
//     }

//     // Getter for isPrime
//     public boolean isPrime() {
//         return isPrime;
//     }
// }

package com.crio.xthreads.PrimeNumberChecker;

// PrimeChecker class that implements Runnable
class PrimeChecker implements Runnable {
    private final int number; // The number to be checked
    private boolean isPrime;  // To store the result of the primality check

    public PrimeChecker(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        // Perform the prime check and store the result
        this.isPrime = checkPrime(number);
    }

    // Method to check if a number is prime
    private boolean checkPrime(int num) {
        if (num <= 1) return false; // 1 or lower is not prime
        for (int i = 2; i <= Math.sqrt(num); i++) { // Check divisors up to sqrt(num)
            if (num % i == 0) return false; // If divisible, not prime
        }
        return true; // No divisors found, number is prime
    }

    // Getter for isPrime
    public boolean isPrime() {
        return isPrime;
    }

    // Getter for number
    public int getNumber() {
        return number;
    }
}
