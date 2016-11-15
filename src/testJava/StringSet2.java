package testJava;

import java.util.TreeSet;

public class StringSet2 {
    TreeSet<String> list;
    
    public void add(String s) {
        list.add(s);
    }
    
    public void remove(String s) {
        list.remove(s);
    }
    
    public boolean contains(String s) {
        return list.contains(s);
    }
    
    public StringSet2 union(StringSet2 set) {
        StringSet2 newSet = new StringSet2();
        newSet.list.addAll(this.list);
        for (String s : set.list)
            if (newSet.contains(s) == false)
                newSet.add(s);
        return newSet;
    }

    public StringSet2 intersection(StringSet2 set) {
        StringSet2 newSet = new StringSet2();
        for (String s : list)
            if (set.contains(s))
                newSet.add(s);
        return newSet;
    }

    public StringSet2 difference(StringSet2 set) {
        StringSet2 newSet = new StringSet2();
        for (String s : list)
            if (set.contains(s) == false)
                newSet.add(s);
        return newSet;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof StringSet2 == false) return false;
        StringSet2 set = (StringSet2)obj;
        return this.list.equals(set.list);
    }

    public String[] toArray() {
        return list.toArray(new String[0]);
    }

}
