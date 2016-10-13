package testJava;

public class Quiz4 {
    
    static int sumOfSequence(int n) {
        if (n % 2 == 0)
            return n / 2 * (1 + n);
        else
            return (1 + n) / 2 * n;
    }
    
    // 등차 수열의 합이 x보다 큰 최소 n 값을 구한다. x >= 0
    static int findN1(int x, int min, int max) {
        if (max == min + 1) return max;
        int middle = (min + max) / 2;
        int sum = sumOfSequence(middle);
        if (sum == x) return middle;
        else if (sum > x) max = middle;
        else min = middle;        
        return findN1(x, min, max);
    }
    
    static int findN2(int x, int n) {
        int sum = sumOfSequence(n);
        if ((x % 2) == (sum % 2)) return n;
        return (n % 2) == 0 ? n + 1 : n + 2;        
    }
    
    static int solution(int x) {        
        int min = 0, max = x;
        if (max > 65535) max = 65535; // overflow 방지
        if (x < 0) x = -x;
        int n1 = findN1(x, min, max);                
        if (sumOfSequence(n1) == x) return n1;
        return findN2(x, n1);
    }
    
    public static void main(String[] args) {
        int[] a = { 3646397, 1000000000};
        
        for (int n = 0; n <= 37; ++n)
            System.out.printf("%d %d\n", n, solution(n));
        
        for (int n : a)
            System.out.printf("%d %d\n", n, solution(n));
    }

}
