package com.valchkou.demo.service;


import com.valchkou.demo.model.FibonacciResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FibonacciService {

    public enum CalcMode {
        ITERATIONAL,
        RECURSIVE,
        SCIENTIFIC
    }


    public FibonacciResult calcNthNumber(long nth, CalcMode mode) {
        long t = System.currentTimeMillis();
        long result = 0;
        switch(mode) {
            case ITERATIONAL:
                result = iterational(nth);
            case RECURSIVE:
                result = recursive(nth);
            case SCIENTIFIC:
                result = scientific(nth);
            default:
                result = scientific(nth);
        }
        return new FibonacciResult(result, System.currentTimeMillis() - t);
    }

    private long iterational(long n) {
        if (n==0) return 0;
        if (n<3) return 1;

        long prev = 1;
        long next = 1;
        long fib = 0;
        for (long i=3; i<=n; i++) {
            fib = prev + next;
            prev = next;
            next = fib;
        }
        return fib;
    }

    private long recursive(long n) {
        if (n==0) return 0;
        if (n<3) return 1;
        return recursive(n-1)+ recursive(n-2);
    }

    private long scientific(long n) {
        if (n==0) return 0;
        if (n<3) return 1;
        double root5 = Math.sqrt(5);
        double fib = 1/root5*( Math.pow((1+root5)/2, n) - Math.pow((1-root5)/2, n));
        return (long)Math.round(fib);
    }

}
