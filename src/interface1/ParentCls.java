package interface1;

public class ParentCls implements MyInterface {

    public void parentMethod() {
        System.out.println("parent method");
    }
    
    @Override
    public void myMethod() {
        System.out.println("parent");
    }

}
