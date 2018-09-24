package Students;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Search {
    private Scanner in = new Scanner(System.in);
    private ArrayList<Students.Student> studentList = new ArrayList<>();
    Search(String Name) { }
    void addStudentToStudentList(Students.Student st) {
        studentList.add(st);
    }

    List<Students.Student> searchAvgScoreGroup() {
        List<Students.Student> list = new ArrayList<>();
        double allAvg=0;
        double allSum=0;
        double countStudOfGroup=0;
        System.out.println("Введите номер группы(1-3): ");
        int group = in.nextInt();
        System.out.println();
        for (Students.Student i : studentList) {
            if (i.getGroup() == group){
                list.add(i);
            }
        }
        for(Students.Student k:list) {
            double avg = 0;
            double sum =0;
            double count=0;
            for (int m = 0; m < k.getMarks().length; m++) {
                sum += k.getMarks()[m];
                count++;
            }
            avg = sum / count;
            countStudOfGroup++;
            allSum+=avg;
        }
        allAvg = allSum/countStudOfGroup;
        System.out.println("Средний балл группы " + group +" составляет: " + allAvg);
        return list;
    }

    void searchAvgScoreStud() {
        System.out.println("Введите фамилию студента");
        String surname = in.next();
        System.out.println("Введите имя студента");
        String name = in.next();
        double avg = 0;
        double sum =0;
        double count=0;
        for (Students.Student i : studentList) {
            if (i.getSurname().equals(surname) && i.getName().equals(name)) {
                for (int m = 0; m < i.getMarks().length; m++) {
                    sum += i.getMarks()[m];
                    count++;
                }
                avg = sum / count;
                System.out.println("Средний балл студента " + surname + " " + name + " составляет:" + avg);
            }
        }
    }

}