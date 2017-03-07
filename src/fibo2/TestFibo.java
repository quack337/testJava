package fibo2;

import java.util.HashMap;
import java.util.Map;

class Fibonacci {
    private Map<Integer,Long> cache = new HashMap<>();

    public long calc(int n) {
        if (n <= 1) return n;
        if (cache.containsKey(n)) return cache.get(n);
        long value = calc(n - 1) + calc(n - 2);
        cache.put(n, value);
        return value;
    }
}

public class TestFibo {
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        for (int i = 0; i < 100; ++i)
            System.out.printf("%d: %d\n", i, fibonacci.calc(i));
    }
}
