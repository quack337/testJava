package testJava;

class Student {

    int id;
    String name;
    String number;
    
    public Student(int id, String name, String number) {
        this.id = id;
        this.name = name;
        this.number = number;
    }
    
    @Override
    public boolean equals(Object obj) {
        if ((obj instanceof Student) == false) return false;
  
        Student s = (Student)obj;
        if (this.id != s.id) return false;
        if ((this.name == null ? s.name == null : name.equals(s.name)) == false) return false;
        if ((this.number == null ? s.number == null : number.equals(s.number)) == false) return false;
        return true;        
    }        
}


public class TestEquals {
    
    public static void main(String[] args) {
        Student[] s1 = new Student[] { new Student(1, "홍길동", "333"),
            null,
            new Student(2, "홍길동", "333"),
            new Student(1, "홍동", "333"),
            new Student(1, "홍길동", "444"),
            new Student(1, null, "333"),
            new Student(1, "홍길동", null),
            new Student(1, "홍길동", "333") };
        

        for (Student s : s1)
            System.out.println(s1[0].equals(s));        
    }

}
