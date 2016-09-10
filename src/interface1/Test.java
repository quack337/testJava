package interface1;

import java.io.IOException;

public class Test {
    
    public static void main(String[] args) throws IOException {
        MyInterface obj = new ChildCls();
        obj.myMethod();
        
        new ChildCls().childMethod();
    }

}
