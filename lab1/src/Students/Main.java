package Students;
import Students.Search;
import Students.Student;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static void selection(Search StudentList) {

        
        Scanner in = new Scanner(System.in);
        System.out.println("Выберите пункт: 1)Найти средний балл студента. 2)Найти средний балл группы.");
        int p = in.nextInt();
        switch (p) {
            case 1:
                StudentList.searchAvgScoreStud();
                break;
            case 2:
                List<Student> searchGroup = StudentList.searchAvgScoreGroup();
                for (Student d : searchGroup) {
                    System.out.println(d);
                }
                System.out.println();
                break;
        }
    }
    public static void main(String[] args) {
            Search List = new Search("StudentList");
            List.addStudentToStudentList(new Student("Булгак", "Виктория", 2, new int[]{7, 8, 8, 9, 7}));
            List.addStudentToStudentList(new Student("Чикова", "Екатерина", 2,new int[]{9, 7, 8, 9, 8} ));
            List.addStudentToStudentList(new Student("Петров", "Андрей", 1, new int[]{7, 6, 5, 8}));
            List.addStudentToStudentList(new Student("Лиханова", "Ксения", 3, new int[]{6, 8, 9, 9, 8, 6}));
            List.addStudentToStudentList(new Student("Агеенко", "Ирина",1, new int[]{8, 8, 10, 9, }));
            List.addStudentToStudentList(new Student("Иванов", "Александр", 3, new int[]{7, 6, 8, 7, 5, 4}));
            selection(List);

    }
}