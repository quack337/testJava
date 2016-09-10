package interface1;

public class ChildCls extends ParentCls implements MyInterface {
    
    @Override
    public void myMethod() {  // throws를 적지 않아도 됨.
        System.out.println("child");
    }
    
    public void childMethod() {
        parentMethod();
    }
    
    static volatile int i = 0; 

}
