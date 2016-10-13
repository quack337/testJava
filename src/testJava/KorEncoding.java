package testJava;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class KorEncoding {

    static String convert(String str, String encoding) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        out.write(str.getBytes(encoding));
        return out.toString(encoding);
    }

    static void testEncoding(String str, String encoding) throws IOException {
        byte[] bytes = str.getBytes(encoding);
        String s = convert(str, encoding);      
        boolean b = str.equals(s);
        System.out.printf("%s %b %d %s\n", encoding, b, bytes.length, Arrays.toString(bytes));
    }

    public static void main(String args[]) throws Exception {
        String aa = "한글 테스트 abc";
        testEncoding(aa, "MS949");
        testEncoding(aa, "UTF-8");
        testEncoding(aa, "CP933");
        testEncoding(aa, "EUC-KR");
        testEncoding(aa, "Cp1252"); // ansi
    }
}