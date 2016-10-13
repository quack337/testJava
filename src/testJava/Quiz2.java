package testJava;

import java.util.Arrays;

class Solution6 {
    
    public int solution(int[] A) {
        if (A.length == 0) return 0;
        
        Arrays.sort(A);
        int total = 0;        
        int count = 1;
        int currentValue = A[0];
        
        for (int i = 1;i < A.length; ++i) {
            if (A[i] == currentValue) {
                count++;
            } else {
                currentValue = A[i];
                total = total + numberOfFair(count);
                if (total >= 1000000000) return 1000000000;
                count = 1;
            }
        }
        total = total + numberOfFair(count);
        if (total >= 1000000000) total = 1000000000;
        return total;
        
    }
    
    public int numberOfFair(int count){
        int total = 0;
        if (count == 1) return 0;
        total = ((1 + (count - 1)) * (count - 1)) / 2;        
        return total;
    }
}

public class Quiz2 {
    public static void main(String[] args) {
        Solution6 sol = new Solution6();
        int[] A={3,5,7,1,3,3,1,5};
    
        System.out.println(sol.solution(A));
    }
}
