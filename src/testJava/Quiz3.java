package testJava;

import java.util.ArrayList;
import java.util.TreeSet;

class Tree {
    public int x;
    public Tree l;
    public Tree r;
}

class Solution8 {
    ArrayList<Integer> list;
    int max;

    public int solution(Tree T) {
        list = new ArrayList<Integer>();
        max = 0;
        preorder(T);
        return max;

    }

    public void preorder(Tree T) {
        list.add(T.x);
        if (T.l != null) {
            preorder(T.l);
        }
        if (T.r != null) {
            preorder(T.r);
        }
        if (T.l == null && T.r == null) {
            TreeSet<Integer> set = new TreeSet<>();
            set.addAll(list);
            int size = set.size();
            if (size > max)
                max = size;
        }
        list.remove(list.size() - 1);
    }
}

public class Quiz3 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Solution8 sol = new Solution8();
        Tree a = new Tree();
        Tree b = new Tree();
        Tree c = new Tree();
        Tree d = new Tree();
        Tree e = new Tree();
        Tree f = new Tree();
        Tree g = new Tree();
        a.x = 4;
        a.l = b;
        a.r = c;
        b.x = 5;
        b.l = d;
        c.x = 6;
        c.l = e;
        c.r = f;
        d.x = 4;
        d.l = g;
        e.x = 1;
        f.x = 6;
        g.x = 5;

        System.out.println(sol.solution(a));
    }

}