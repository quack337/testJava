package testJava;

class AgedP {
    AgedP() {}
    public AgedP(int x) {
    }
}

class Kinder extends AgedP {
    public Kinder(int x) {
    }
}

class Parent {
    private void method1() {
        System.out.println("method1");
    }
    
    private final void flipper() {
        System.out.println("Clidder");
    }
}

class Child extends Parent {
    private void method1() {
        System.out.println("method2");
    }

    public void flipper() {
        System.out.println("Clidlet");
    }
}

public class privateFinal1 {
    public static void main(String[] args) {
        new Child().flipper();
        new Kinder(1);
    }

}
