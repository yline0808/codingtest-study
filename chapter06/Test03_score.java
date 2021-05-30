package chapter06;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Student implements Comparable<Student> {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String toString() {
        return this.name + " " + this.score;
    }

    @Override
    public int compareTo(Student o) {
        // TODO Auto-generated method stub
        if (this.score < o.score) {
            return -1;
        }
        return 1;
    }
}

public class Test03_score {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("input length : ");
        int n = sc.nextInt();
        List<Student> sList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            int score = sc.nextInt();
            sList.add(new Student(name, score));
        }
        sc.close();
        Collections.sort(sList);

        for (int i = 0; i < sList.size(); i++) {
            System.out.println(sList.get(i).toString());
        }
    }
}
