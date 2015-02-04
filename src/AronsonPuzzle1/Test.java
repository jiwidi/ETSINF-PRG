package AronsonPuzzle1;

/**
 * AronsonPuzzle1.Test - Tests the AronsonPuzzle1.Test methods.
 * Tests the general cases against known working examples from 'trusty' online education sources.
 * Tests the trivial cases against their definitions.
 *
 * Created by jevepa on 2/4/15.
 * TODO: raise exceptions instead of S.o.p errors
 * TODO: and maybe add more debugging output?
 *
 */
public class Test {

    public static void main(String[] args) {
        // TODO: take args from random source
        int a = 13371337;
        int b = 42;

        testFib(b);         // input a small number as it is limited by int
        System.out.println();
        testSumf(a);
        System.out.println();
        testGcd(a,b);
        System.out.println();
    }

    private static void testFib(int index){
        System.out.println("Testing Fibonacci sequence implementation against trusted one...");

        if (index<0) {
            System.out.println("> Input was a negative integer! Inversing...");
            index=-index; // make sure the index is positive
        }

        // test fib general case against literateprograms.org implementation
        System.out.print("> Testing for the general case. Calculating Fibonacci number index " + index + ". - ");
        int fib1a = Exercise.fib(index);
        int fib1g = fib(index);
        boolean fibg = fib1a == fib1g;
        printif(fibg);

        // output debug info if mismatch
        if (!fibg){
            System.out.println(">> ARONSON: " + fib1a);
            System.out.println(">> TRUSTED: " + fib1g);
        }

        // test trivial cases
        System.out.print("> Testing for the trivial cases of 1st and 2nd Fibonacci number (both should equal 1). - ");
        boolean fibt = Exercise.fib(1) == 1 && Exercise.fib(2) == 1;
        printif(fibt);

        // test out-of-bounds case
        System.out.print("> Testing error output when a negative integer is fed. Expected -1. - ");
        boolean fibn = Exercise.fib(-index) == -1;
        printif(fibn);

        System.out.print("Result of the Fibonacci sequence implementation: ");
        printif(fibn && fibt && fibg);
    }

    private static void testSumf(int number){
        int trivial = 4; // lesser than 10 -> this should be random

        System.out.println("Testing sum of figures of an integer implementation against trusted one...");
        // test sum of figures general case against javaforstudents.co.uk implementation
        System.out.print("> Testing for the general case. Calculating sum of the figures of " + number + ". - ");
        int sum1a = Exercise.sumf(number);
        int sum1g = sumf(number);
        boolean sumg = sum1a == sum1g;
        printif(sumg);

        // output debug info if mismatch
        if (!sumg){
            System.out.println(">> ARONSON: " + sum1a);
            System.out.println(">> TRUSTED: " + sum1g);
        }

        System.out.print("> Testing for the trivial case. - ");
        boolean sumt = Exercise.sumf(trivial) == trivial;
        printif(sumt);

        System.out.print("> Testing for negative input. - ");
        boolean sumn =       Exercise.sumf(-number) == sumf(number);
        printif(sumn);

        System.out.print("Result of the sum of figures implementation: ");
        printif(sumg && sumt && sumn);
    }

    private static void testGcd(int a, int b){

        System.out.println("Testing Euclidean GCD implementation against trusted one...");
        // test sum of figures general case against javaforstudents.co.uk implementation
        System.out.print("> Testing for the general case. Calculating GCD of (" + a + "," + b +"). - ");
        int gcd1a = Exercise.gcd(a, b);
        int gcd1g = gcd(a,b);
        boolean gcd1 = gcd1a == gcd1g;
        printif(gcd1);

        System.out.print("> Testing for the general case. Calculating GCD of (" + b + "," + a +"). - ");
        int gcd2a = Exercise.gcd(b, a);
        int gcd2g = gcd(b,a);
        boolean gcd2 = gcd2a == gcd2g;
        printif(gcd2);

        System.out.print("> Testing for the trivial case of equal numbers. - ");
        boolean gcdeq = Exercise.gcd(a, a) == a && Exercise.gcd(b, b) == b;
        printif(gcdeq);

        System.out.print("> Testing for the trivial case of a member being zero. - ");
        boolean gcdzero = Exercise.gcd(a, 0) == a && Exercise.gcd(0, b) == b;
        printif(gcdzero);

        System.out.print("> Testing for negative input. - ");
        boolean gcdneg = Exercise.gcd(-a, b) == gcd(a,b) && Exercise.gcd(a, -b) == gcd(a,b);
        printif(gcdneg);

        System.out.print("Result of the Euclidean GCD implementation: ");
        printif(gcd1 && gcd2 && gcdeq && gcdzero && gcdneg);

    }


    // supposing these implementations to be correct as they are sourced from 'trusty' websites

    private static int gcd(int K, int M) {
        // http://people.cis.ksu.edu/~schmidt/301s12/Exercises/euclid_alg.html

        int k = K;   // In order to state a simple, elegant loop invariant,
        int m = M;   // we keep the formal arguments constant and use
        // local variables to do the calculations.
        // loop invariant: GCD(K,M) = GCD(k,m)
        while (k != m) {
            if (k > m)
            { k = k-m; }
            else
            { m = m-k; }
        }
        // At this point, GCD(K,M) = GCD(k,m) = GCD(k,k) = k
        return k;
    }


    private static int fib(int n) {
        // http://en.literateprograms.org/Fibonacci_numbers_%28Java%29

        int prev1=0, prev2=1;
        for(int i=0; i<n; i++) {
            int savePrev1 = prev1;
            prev1 = prev2;
            prev2 = savePrev1 + prev2;
        }
        return prev1;
    }

    private static int sumf(int n) {
        // http://www.javaforstudents.co.uk/Code_snippets/Sum_of_digits_of_a_number

        int sum = 0;
        // algorithm step by step
        // base:  sum = 0, n = 123
        // step1: n % 10 = 3, n / 10 = 12
        //        sum = 3, n = 12
        // step2: n % 10 = 2, n / 10 = 1
        //        sum = 5, n = 1
        // step3: n % 10 = 1, n / 10 = 0
        //        sum = 6, n = 0
        // stop:  (n != 0) is false
        while (n != 0) {
            // add last digit to the sum
            sum += n % 10;
            // cut last digit
            n /= 10;
        }
        return sum;
    }

    // UTILITY STUFF

    private static void printif(boolean b){
        if (b) {
            System.out.println("SUCCESS!");
        } else {
            System.out.println("ERROR!");
        }
    }

}
