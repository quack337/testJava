package testJava;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;

public class TestCollection {

    static void printAll(Collection<Integer> c) {
        for (Integer i : c)
            System.out.printf("%d ", i);
        System.out.println();
    }

    public static void main(String[] args) {
        Collection<Integer> evenNumbers = new ArrayList<Integer>();
        Collection<Integer> oddNumbers = new LinkedList<Integer>();
        Collection<Integer> numbers = new ArrayDeque<Integer>();

        for (int i = 0; i < 50; ++i) {
            numbers.add(i);
            if (i % 2 == 0)
                evenNumbers.add(i);
            else
                oddNumbers.add(i);
        }

        numbers.removeAll(evenNumbers);
        System.out.println(numbers.size() == oddNumbers.size() && numbers.containsAll(oddNumbers));

        numbers.addAll(evenNumbers);
        numbers.retainAll(oddNumbers);
        System.out.println(numbers.size() == oddNumbers.size() && numbers.containsAll(oddNumbers));

        Integer[] emptyArray = new Integer[0];
        Integer[] a1 = numbers.toArray(emptyArray);
        Integer[] a2 = oddNumbers.toArray(emptyArray);
        System.out.println(Arrays.equals(a1, a2));
        System.out.println(a1.equals(a2));
        System.out.println(numbers.equals(oddNumbers));

        printAll(numbers);
        printAll(oddNumbers);
        printAll(evenNumbers);
    }

}
