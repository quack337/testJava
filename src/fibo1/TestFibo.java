package fibo1;

class Fibonacci {
    public long calc(int n) {
        if (n <= 1) return n;
        return calc(n - 1) + calc(n - 2);
    }
}

public class TestFibo {
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        for (int i = 0; i < 40; ++i)
            System.out.printf("%d: %d\n", i, fibonacci.calc(i));
    }
}
