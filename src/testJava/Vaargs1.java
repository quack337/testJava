package testJava;

public class Vaargs1 {
    
    static void myMethod1(int... params) {
        System.out.print("myMethod1: [ ");
        for (int a : params)
            System.out.printf("%d ", a);            
        System.out.println("]");        
    }

    static void myMethod2(int f, int... params) { // 첫째 파라미터는 생략할 수 없음.
        System.out.printf("myMethod2: [ %d ", f);            
        for (int a : params)
            System.out.printf("%d ", a);            
        System.out.println("]");        
    }
    
    static void myMethod3(String... params) {
        System.out.print("myMethod3: [ ");            
        for (int i=0; i < params.length; ++i)
            System.out.printf("%s ", params[i]);
        System.out.println("]");        
    }

    public static void main(String[] args) {
        myMethod1(); // 파라미터가 없어도 됨.
        myMethod1(2);
        myMethod1(2, 3);
        myMethod1(2, 3, 4);

        myMethod2(5);
        myMethod2(5, 6);
        myMethod2(5, 6, 7);
        
        myMethod3();
        myMethod3("one");
        myMethod3("one", "two");
        myMethod3("one", "two", "three");
    }

}
