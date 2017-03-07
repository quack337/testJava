package testJava;

import java.util.Arrays;

class Person {
    String name;
    int age;
    
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public String toString() {
        return String.format("{%s, %d}", name, age);
    }
}

public class SortPerson {
    
    public static void main(String[] args) {
        Person[] a = new Person[] {
                new Person("홍길동", 18),
                new Person("임꺽정", 22),
                new Person("전우치", 20),
        };
        
        Arrays.sort(a, (p1, p2) -> p1.name.compareTo(p2.name));
        System.out.println(Arrays.toString(a));

        Arrays.sort(a, (p1, p2) -> p1.age - p2.age);
        System.out.println(Arrays.toString(a));
    }

}