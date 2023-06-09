package D20230608;

import D20230607.MyArrays;

public class Student {
    int number;
    int grade;
    public int score;

    @Override
    public String toString() {
        return "Student{" +
                "number=" + number +
                ", grade=" + grade +
                ", score=" + score +
                '}';
    }

    public static void main(String[] args) {
        Student[] students = new Student[20];
        for (int i = 0; i < students.length; i++) {
            Student student = new Student();
            student.grade = (int) (Math.random() * 6 + 1);
            student.score = (int) (Math.random() * 100 + 1);
            student.number = i + 1;
            students[i] = student;
        }
        //问题一r
        for (int i = 0; i < students.length; i++) {
            if (students[i].grade == 3) {
                System.out.println(students);
            }
        }
        //问题二
        MyArrays.shuZuPaiXu(students);
        for (int i = 0; i < students.length; i++) {
            System.out.println(students[i]);
        }
    }
}
