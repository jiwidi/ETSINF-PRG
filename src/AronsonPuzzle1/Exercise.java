package AronsonPuzzle1;

/**
 * AronsonPuzzle1.Exercise - First Aronson puzzle
 * Recursive implementation of Fibonacci algorithm, sum of figures of an integer and Euclides gcd.
 * <p/>
 * Created by jevepa on 2/4/15.
 * PRG Workgroup "Eratostenes" of ARA group 1E1 of UPV ETSINF GII 2014/2015.
 * <p/>
 * TODO: raise exception on error on fib() instead of returning -1
 */

public class Exercise {
    public static int fib(int n) {
        if (n < 1) return -1;                   // Fibonacci is not defined for negative integers
        if (n <= 2) return 1;                   // trivial case: first and second Fibonacci numbers are 1
        return fib(n - 1) + fib(n - 2);         // general case
    }

    public static int sumf(int n) {
        if (n < 0) n = -n;                      // fix for negative input
        if (n < 10) return n;                   // trivial case: number only has one figure
        return n % 10 + sumf(n / 10);           // general case
    }

    public static int gcd(int a, int b) {
        // trivial case; both are equal
        if (a == b) return a;
        // finish condition: one of them is zero
        if (a == 0) return b;
        if (b == 0) return a;
        // make positive: avoid stack overflow
        if (a < 0) a = -a;
        if (b < 0) b = -b;
        // swap vars if b>a21
        if (b > a) {a+=b; b=a-b; a-=b;}

        return gcd(b, a % b);
    }
}
