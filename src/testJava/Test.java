package testJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

public class Test {
    
    static Random random = new Random();
    
    static String[] createRadomStringArray(int size) {
        String[] a = new String[size];
        for (int i = 0; i < size; ++i) {
            int value = random.nextInt(10);
            String s = String.format("%02d", value);
            a[i] = s;
        }
        return a;        
    }

    public static void main(String[] args) {
        String[] a1 = createRadomStringArray(12);
        String[] a2 = createRadomStringArray(5);
        String[] a3 = createRadomStringArray(3);
        
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(a2));
        System.out.println(Arrays.toString(a3));
        
        Collection<String> set = new ArrayList<String>();
        Collection<String> A1 = Arrays.asList(a1);
        Collection<String> A2 = Arrays.asList(a2);
        Collection<String> A3 = Arrays.asList(a3);
        set.addAll(A2);
        if(set.retainAll(A1)==false){
        	set.clear();
        	set.addAll(A3);
        	if(set.retainAll(A1)==true)
        		System.out.println("true");
        	else
        		System.out.println("false");
        }
        else
        	System.out.println("false");

        
        Collection<String> list1 = Arrays.asList(a1);
        Collection<String> list2 = Arrays.asList(a2);
        Collection<String> list3 = Arrays.asList(a3);
        
        boolean result = (list1.containsAll(list2) && !list1.containsAll(list3));
        System.out.println(result);
        
    }
}

