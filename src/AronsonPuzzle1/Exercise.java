package AronsonPuzzle1;

/**
 * AronsonPuzzle1.Exercise - First Aronson puzzle for ETSINF GII ARA PRG. 2014/15
 * Recursive implementation of Fibonacci algorithm, sum of figures of an integer and Euclides gcd.
 *
 * Created by jevepa on 2/4/15.
 */

public class Exercise {
    public static int fib(int n){
        // TODO: raise exception instead of int=-1

        if (n<1) return -1;
        if (n == 1 || n == 2){ return 1; }
        return fib(n-1)+fib(n-2);
    }

    public static int sumf(int n){
        if (n < 0) n=-n;
        if (n < 10) return n;
        return n%10+sumf(n/10);
    }

    public static int gcd(int a, int b){
        if (a==b) return a;                                 // trivial case; both are equal
        if (a==0) return b; if (b==0) return a;             // finish condition: one of them is zero
        if (a<0) a=-a; if (b<0) b=-b;                       // make positive -> avoid stack overflow
        if (b>a){ a+=b; b=a-b; a-=b; }                      // swap vars if b>a

        return gcd(b,a%b);
    }
}
