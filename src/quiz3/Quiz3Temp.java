package quiz3;

class Tree {
    public int x;
    public Tree l;
    public Tree r;
}

class Solution8 {

    public void solution(Tree T) {
        System.out.println("\n=== preorder ===");
        preorder(T);
        System.out.println("\n=== inorder ===");
        inorder(T);
        System.out.println("\n=== postorder ===");
        postorder(T);
    }

    public void preorder(Tree T) {
        System.out.printf("%d ", T.x);
        if (T.l != null) preorder(T.l);
        if (T.r != null) preorder(T.r);
    }
    
    public void inorder(Tree T) {
        if (T.l != null) inorder(T.l);
        System.out.println(T.x);
        if (T.r != null) inorder(T.r);
    }

    public void postorder(Tree T) {
        if (T.l != null) postorder(T.l);
        if (T.r != null) postorder(T.r);
        System.out.println(T.x);
    }
}

public class Quiz3Temp {

    public static void main(String[] args) {

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

        sol.solution(a);
    }

}