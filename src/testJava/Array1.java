package testJava;

public class Array1 {
    
    static void setData(int[] a, int start) {
        for (int i=0; i < a.length; ++i)
            a[i] = start + i;
    }
    
    static void setData(int[][] a, int start) {
        for (int i=0; i < a.length; ++i)
            for (int j=0; j < a[i].length; ++j)
                a[i][j] = start++;
    }
    
    static void print(int[] a) {
        System.out.print("[ ");
        for (int i : a)
            System.out.printf("%d ", i);
        System.out.println("]");
    }

    static void print(int[][] a) {
        System.out.print("[ ");
        for (int i = 0; i < a.length; ++i) {
            System.out.print("[ ");
            for (int j = 0; j < a[i].length; ++j)
                System.out.printf("%d ", a[i][j]);
            System.out.print("] ");
        }
        System.out.println("]");        
    }

    public static void main(String[] args) {
        int[] a1 = new int[3];
        int a2[] = new int[3];
        int[][] a3 = new int[2][2];
        int[] a4[] = new int[2][2];
        int a5[][] = new int[2][2];
        
        setData(a1, 1);
        setData(a2, 4);
        setData(a3, 10);
        setData(a4, 14);
        setData(a5, 18);
        print(a1);
        print(a2);
        print(a3);
        print(a4);
        print(a5);        
    }

}
