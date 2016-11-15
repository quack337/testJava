package testJava;

import java.util.ArrayList;
import java.util.Arrays;

public class StringSet1 {
    ArrayList<String> list;
    
    public void add(String s) {
        list.add(s);
    }
    
    public void remove(String s) {
        list.remove(s);
    }

    public boolean contains(String s) {
        return list.contains(s);
    }
    
    public StringSet1 union(StringSet1 set) {
        StringSet1 newSet = new StringSet1();
        newSet.list.addAll(this.list);
        newSet.list.removeAll(set.list);
        newSet.list.addAll(set.list);
        return newSet;
    }

    public StringSet1 intersection(StringSet1 set) {
        StringSet1 newSet = new StringSet1();
        newSet.list.addAll(this.list);
        newSet.list.retainAll(set.list);
        return newSet;
    }

    public StringSet1 difference(StringSet1 set) {
        StringSet1 newSet = new StringSet1();
        newSet.list.addAll(this.list);
        newSet.list.removeAll(set.list);
        return newSet;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof StringSet1 == false) return false;
        StringSet1 set = (StringSet1)obj;
        return this.list.equals(set.list);
    }
    
    public String[] toArray() {
        return list.toArray(new String[0]);
    }
    
}
