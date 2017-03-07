package testJava;

public class Example1 {

    static int sum(int n) {
        if (n == 1) return 1;
        return n + sum(n - 1);
    }

    public static void main(String[] args) {
        for (int i = 3; i <= 10; ++i)
            System.out.printf("%d %d\n", i, sum(i));
    }

}
