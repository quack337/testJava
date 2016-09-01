package testJava;

import java.util.HashMap;
import java.util.Map;

public class TestArray {

    static int solution1(int[] A) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>(); 

        for (int i : A) {
            Integer count = map.get(i);
            if (count == null) map.put(i, 1);
            else map.put(i, count + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            if (entry.getValue() % 2 == 1) return entry.getKey();
        return 0;    
    }
    
    public static void main(String[] args) {
        int[] a = new int[] { 9, 3, 9, 3, 9, 7, 9 };
        //for (int i : a)
            //System.out.println(i);
        
        System.out.println(solution1(a));
         
    }

}
