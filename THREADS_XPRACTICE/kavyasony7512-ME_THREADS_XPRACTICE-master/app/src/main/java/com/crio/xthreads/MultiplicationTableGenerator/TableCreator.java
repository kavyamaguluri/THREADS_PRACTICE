// package com.crio.xthreads.MultiplicationTableGenerator;

// public class TableCreator implements Runnable{
//     private final int number;

//     public TableCreator(int number) {
//         this.number = number;
//     }

//     // TODO: Implement the run method to generate multiplication table.
//     // 1. Iterate from 1 to 10 to generate the multiplication table:
//     //    - Use a for-loop to iterate from 1 to 10.

//     // 2. For each value of i in the loop:
//     //    - Calculate the product of the current number and i.
//     //    - Print the multiplication result in the format: "number times i is product".
//     //      Example format: "5 times 3 is 15".
//     @Override
//     public void run() {
//     }
// }
package com.crio.xthreads.MultiplicationTableGenerator;

public class TableCreator implements Runnable {
    private final int number;

    public TableCreator(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            int product = number * i;
            System.out.println(number + " times " + i + " is " + product);
        }
    }
}
