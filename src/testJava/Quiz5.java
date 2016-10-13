package testJava;

import java.util.Scanner;

public class Quiz5 {

    static void drawTriangle(int lineNumber) {
        int num = 0;
        space(lineNumber - 1);
        System.out.println(0);
        ++num;

        for (int i = 1; i < lineNumber - 1; ++i) {
            num = num % 10;
            space(lineNumber - 1 - i);
            System.out.print(num);
            ++num;
            num = num % 10;
            space(2 * i - 1);
            System.out.println(num);
            ++num;
        }
        for (int i = 0; i < (2 * lineNumber) - 1; ++i) {
            num = num % 10;
            System.out.print(num);
            ++num;            
        }
    }

    static void space(int count) {
        for (int i = 0; i < count; ++i)
            System.out.print(' ');
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        int lineNumber = scan.nextInt();
        drawTriangle(lineNumber);
    }

}