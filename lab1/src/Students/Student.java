package Students;
import java.util.Arrays;
import java.util.Date;

public class Student {
    private String surname;
    private String name;
    private int group;
    private int[] marks;

    Student(){ }
    Student(String surname, String name, int group, int[] marks) {
        this.surname = surname;
        this.name = name;
        this.group = group;
        this.marks = marks;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getGroup() {
        return group;
    }
    public int[] getMarks() {
        return marks;
    }
    public String toString(){
        return "Студент: " + this.surname + " "+this.name + ", группа: "+this.group+". Оценки: "+ Arrays.toString(this.marks);
    }

}
