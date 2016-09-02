package testJava;

import java.util.Arrays;

class Solution { 
    public int solution(int[] a) {
        Arrays.sort(a);
        for (int i=1; i < a.length - 1; ++i) {
            if (a[i - 1] > a[i + 1] - a[i] )
                return 1;
        }
        return 0;
    }
}

public class Triangular {
    
    public static void main(String[] args) {
        int[] a1 = { 10, 2, 5, 1, 8, 20 };
        int[] a2 = { 10, 50, 5, 1 };
        
        Solution sol = new Solution();
        
        System.out.println(sol.solution(a1));
        System.out.println(sol.solution(a2));
        
        System.out.printf("%d\n", Integer.MAX_VALUE);
        System.out.printf("%d\n", Integer.MAX_VALUE + 1);
        System.out.printf("%d\n", Integer.MIN_VALUE);
        System.out.printf("%d\n", Integer.MIN_VALUE - 1);
    }

}
