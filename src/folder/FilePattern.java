package folder;

import java.io.File;

public class FilePattern {

    static void test0(String[] args) {
        if (args.length != 1) {
            System.out.println("Command Line Param: d:/temp/.+.png");
            return;
        }

        int index = args[0].lastIndexOf('/');
        String folder = args[0].substring(0, index+1);
        String pattern = args[0].substring(index+1);

        System.out.println(folder);
        System.out.println(pattern);
    }

    static void test1(String[] args) {
        if (args.length != 1) {
            System.out.println("Command Line Param: d:/temp/.+.png");
            return;
        }

        int index = args[0].lastIndexOf('/');
        String folder = args[0].substring(0, index+1);
        String pattern = args[0].substring(index+1);

        File root = new File(folder);
        File[] files = root.listFiles();
        for (File f : files) {
            String name = f.getName();
            System.out.printf("%s %s\n", name, name.matches(pattern));
        }
    }

    static void test2(String[] args) {
        if (args.length != 1) {
            System.out.println("Command Line Param: d:/temp/.+.png");
            return;
        }

        int index = args[0].lastIndexOf('/');
        String folder = args[0].substring(0, index+1);
        String pattern = args[0].substring(index+1);

        File root = new File(folder);
        File[] files = root.listFiles((dir, name) -> name.matches(pattern) );
        for (File f : files) {
            String name = f.getName();
            System.out.printf("%s true\n", name);
        }
    }

    public static void main(String[] args) {
        test2(args);

    }


}
