package testJava;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestJava {
    static void test1() {
        List<String> list = new ArrayList<String>();
        list.add(null);
        list.add("hello");
        list.add(null);
        list.add("world");

        for (int i=0; i < list.size(); ++i) {
            String s = list.get(i);
            System.out.println(s);
        }

        for (String s : list) {
            System.out.println(s);
            if (s.equals("hello"))
                list.remove(s);
        }

        Collection<String> c = list;
        for (String s : c) {
            System.out.println(s);
        }

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            System.out.println(s);
        }
    }

    static void test2() {
        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();
        list1.add(null);
        list1.add("hello");
        list2.add(null);
        list2.add("hello");
        System.out.println(list1.equals(list2));
    }

    static void test3() {
        Set<String> set1 = new HashSet<String>();
        Set<String> set2 = new HashSet<String>();
        Set<String> set3 = new HashSet<String>();
        set1.add("one");
        set1.add("two");
        System.out.println(set1.add("three"));
        System.out.println(set1.add("one"));

        set2.add("one");
        set2.add("four");
        System.out.println(set1.addAll(set2));
        System.out.println(set1.addAll(set3));

        for (String s : set1)
            System.out.println(s);
    }

    static void test4() {
        Map<String,String> map = new HashMap<String,String>();
        map.put("c", "C");
        map.put("a", "A");
        map.put("b", "B");
        // for (String s : map) System.out.println(s); error
    }

    static void test5() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=0; i < 10; ++i)
            list.add(i);

        for (int i : list)
            System.out.println(i);

        for (int i : list)
            if (i % 2 == 0) list.add(i);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int i = iterator.next();
            if (i % 2 == 0) iterator.remove();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        test5();
        
        new SimpleDateFormat("yyyy-MM-dd").format(new java.util.Date());
    }

}