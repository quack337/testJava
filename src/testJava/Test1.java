package testJava;

import java.util.Arrays;


class StringSet {
    String[] s = new String[20];
    int n=0;
    
    public void add(String s) {
        for(int i=0; i<this.s.length; i++)
            if(this.s[i] == null) {
                if(contains(s) == false) {
                    this.s[i] = s;
                    n++;
                    break;
                }
            }
    }
    public void remove(String s) {
        for(int i=0; i<this.s.length; i++)
            if(this.s[i] == s) {
                this.s[i] = null;
                n--;
            }
    }
    public int getCount() {
        return n;
    }
    public boolean contains(String s) {
        for(int i=0; i<this.s.length; i++)
            if(this.s[i] == s) 
                return true;
        
        return false;
    }
    public StringSet union(StringSet set) {
        StringSet unionResult = new StringSet();
        
        for(int i=0; i<this.s.length; i++) {
            unionResult.add(this.s[i]);
            unionResult.n++;
        }
        
        for(int j=0; j<set.s.length; j++)
            if(unionResult.contains(set.s[j]) == false) {
                    unionResult.add(s[j]);
                    unionResult.n++;
            }
                    
        return unionResult;
    }
    
    public StringSet intersection(StringSet set) {
        StringSet interResult = new StringSet();
        
        for(int i=0; i<this.s.length; i++)
            for(int j=0; j<set.s.length; j++)
                if(this.s[i] == set.s[j]) {
                    interResult.add(s[i]);
                    interResult.n++;
                }
        
        return interResult;
    }
    
    public StringSet difference(StringSet set) {
        StringSet difResult = new StringSet();
        
        for(int i=0; i<this.s.length; i++) {
            if(set.contains(this.s[i]) == false) {
                difResult.add(this.s[i]);
                difResult.n++;
            }
        }
        
        return difResult;
    }
    
    public boolean equals(Object set) {
        if (this == set)
            return true;
        else
            return false;
    }
    
    public String[] toArray() {
        return this.s;
    }
} 


public class Test1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        StringSet sa = new StringSet();
        StringSet sb = new StringSet();

        for (int i = 0; i < 20; ++i)
            sa.add(String.valueOf(i));
        System.out.println(Arrays.toString(sa.toArray()));

        for (int i = 0; i < 20; i += 2)
            sb.add(String.valueOf(i));
        System.out.println(Arrays.toString(sb.toArray()));

        StringSet sc = sa.intersection(sb);
        System.out.println(Arrays.toString(sc.toArray()));

        StringSet sd = sa.union(sb);
        System.out.println(Arrays.toString(sd.toArray()));

        StringSet se = sa.difference(sb);
        System.out.println(Arrays.toString(se.toArray()));

        System.out.println(sb.equals(sc));

    }

}
