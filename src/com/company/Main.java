package com.company;


/**
 * The type Main.
 */
public class Main {

    public static void main(String[] args) {
        hanoiRecursion(3, 'A', 'B', 'C');
        System.out.println("This was Tower of Hanoi using recursion, runtime complexity is Big O(2^N) - 1");
        hanoiIterate(3, 'A', 'B', 'C');
        System.out.println("This was Tower of Hanoi using iteration, runtime complexity is Big O(2^N) - 1");
    }

    private static void hanoiRecursion(int n, char rodFrom, char rodMiddle, char rodTo) {
        // This is base case scenario
        if (n == 1) {
            System.out.println("Disk 1 moved from " + rodFrom + " to " + rodTo);
            return;
        }
        //Move top n-1 disks from A to B using C as middle
        hanoiRecursion(n - 1, rodFrom, rodTo, rodMiddle);
        //Move last disk from A to C
        System.out.println("Disk " + n + " moved from " + rodFrom + " to " + rodTo);
        //Move n-1 disks from B to C using A as middle
        hanoiRecursion(n - 1, rodMiddle, rodFrom, rodTo);
    }

    public static void hanoiIterate(int numOfDisks, char origin, char destination, char aux) {

        int src, dest, moveNo;
        // Declaring array of chars that we will watch as bars or poles
        char[] bar = {origin, aux, destination};

        // If there is no remainder after numOfDisks modulo of 2, we set second array pole as destination
        // and third array pole as auxiliary
        if (numOfDisks % 2 == 0) {
            bar[1] = destination;
            bar[2] = aux;
        }

        // moveNo is set to 1, while moveNo is less than 2 to the power of number of disks, increment number of moves
        for (moveNo = 1; moveNo < (Math.pow(2,(numOfDisks))); moveNo++) {
            //We set destination to be moveNo OR moveNo minus 1 plus 1 modulo of 3,
            //that will determine at what pole in array it should be set
            dest = ((moveNo | (moveNo - 1)) + 1) % 3;
            // We set source similar to destination but moveNo AND moveNo - 1 modulo of 3 will determine at what pole it should be set
            src = (moveNo & (moveNo - 1)) % 3;

            System.out.println("Moving a disk from bar " + bar[src] + " to bar " + bar[dest] + ". Moves did: " + moveNo);
        }
    }
}

