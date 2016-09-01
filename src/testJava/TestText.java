package testJava;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;

class Data {
    int field1;
    String field2;
    Date field3;
    
    public Data(int f1, String f2, Date f3) {
        field1 = f1;
        field2 = f2;
        field3 = f3;
    }

    public int getField1() {
        return field1;
    }

    public void setField1(int field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public Date getField3() {
        return field3;
    }

    public void setField3(Date field3) {
        this.field3 = field3;
    }
    
}

public class TestText {
    
    static final String fileName = "d:/out.txt";
    static final SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
    
    static ArrayList<Data> getDataList() {
        ArrayList<Data> list = new ArrayList<Data>();
        for (int i=10; i < 20; ++i) {
            Date dt = new GregorianCalendar(2016, 1, 1 + i).getTime();
            list.add(new Data(i, "value"+i, dt));
        }
        return list;
    }
    
    static void writeData(ArrayList<Data> list) throws FileNotFoundException {
        PrintStream out = new PrintStream(new File (fileName));
        
        for (Data d : list) {
            out.printf("%10d", d.getField1()); // 10칸으로 출력
            out.printf("%010d", d.getField1()); // 앞에 0을 채워서 10칸으로 출력
            out.printf("%10s", d.getField2()); // 10칸에 오른쪽정렬,
            out.printf("%-10s", d.getField2()); // 10칸에 왼쪽정렬,
            out.printf("%s", format.format(d.getField3()));            
        }
    }
    
    static ArrayList<Data> readData() throws IOException, ParseException {
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        char[] buffer = new char[48];
        int count;
        ArrayList<Data> list = new ArrayList<Data>(); 
        
        while ((count = in.read(buffer)) > 0) {
            String s = String.valueOf(buffer);
            System.out.printf("%d %s %s %s %s\n", count, s, s.substring(0,10), s.substring(20,30), s.substring(40,48));
            int field1 = Integer.parseInt(s.substring(0,10).trim());
            String field2 = s.substring(20,30).trim();
            Date field3 = format.parse(s.substring(40,48));
            list.add(new Data(field1, field2, field3));
        }
        in.close();
        return list;
    }
    
    static boolean compare(ArrayList<Data> list1, ArrayList<Data> list2) {
        if (list1.size() != list2.size()) return false;
        
        for (int i=0; i < list1.size(); ++i) {
            Data d1 = list1.get(i);
            Data d2 = list2.get(i);
            if (d1.getField1() != d2.getField1()) return false;
            if (d1.getField2().equals(d2.getField2()) == false) return false;
            if (d1.getField3().equals(d2.getField3()) == false) return false;
        }
        return true;        
    }
    
    
    public static void main(String[] args) throws IOException, ParseException {
        ArrayList<Data> list1 = getDataList();
        writeData(list1);
        ArrayList<Data> list2 = readData();
        System.out.println(compare(list1, list2));
    }

}
