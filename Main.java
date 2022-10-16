package com.PPlabs.lr2;


import com.PPlabs.lr2.student.Student;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Student[] students = entering();

        Arrays.sort(students);

        Scanner enter = new Scanner(System.in);

        System.out.println("\n------------------------------------");

        try {
            System.out.print("Enter student's faculty : ");
            listOfFaculty(students, enter.nextLine());

            System.out.println("\n------------------------------------");

            System.out.print("Enter student's year : ");
            listOfAfterYear(students, Integer.parseInt(enter.nextLine()));

            System.out.println("\n------------------------------------");

            System.out.print("Enter student's group : ");
            listOfGroup(students, enter.nextLine());

            System.out.println("\n------------------------------------");
        }
        catch(Exception error){
            System.out.println("Incorrectly entered data! Error - "+error.toString());
        }

    }
    public static Student[] entering(){
        int id;
        String name;
        String dateBirth;
        String address;
        String phoneNum;
        String faculty;
        byte course;
        String group;

        boolean isExcept = false;

        int kstStudents = 0, kst = 0;

        Scanner enter = new Scanner(System.in);

        System.out.print("Enter count of students : ");
        try {
            kstStudents = Integer.parseInt(enter.nextLine());

        }
        catch (Exception error){
            System.out.println("Incorrectly entered data! Error - "+error.toString());

        }

        Student[] students = new Student[kstStudents];
        while (isExcept || kst<kstStudents) {
            try {
                isExcept = false;

                System.out.println("\n-----------------"+(kst+1)+"----------------");

                System.out.print("Enter student's id : ");
                id = Integer.parseInt(enter.nextLine());
                System.out.print("Enter student's last name, first name, middle name : ");
                name = enter.nextLine();
                System.out.print("Enter student's date of birthday (dd/mm/yyyy) : ");
                dateBirth = enter.nextLine();
                System.out.print("Enter student's address : ");
                address = enter.nextLine();
                System.out.print("Enter student's phone number : ");
                phoneNum = enter.nextLine();
                System.out.print("Enter student's faculty : ");
                faculty = enter.nextLine();
                System.out.print("Enter student's course : ");
                course = Byte.parseByte(enter.nextLine());
                System.out.print("Enter student's group : ");
                group = enter.nextLine();

                students[kst] = new Student(id, name, dateBirth, address, phoneNum, faculty, course, group);

                kst++;

            }
            catch (Exception error){
                System.out.println("Incorrectly entered data! Error - "+error.toString());
                isExcept = true;
            }
        }

        return students;
    }

    public static void listOfFaculty(Student[] students, String faculty){

        boolean isStud = false;

        System.out.println("Students, whose faculty - "+faculty+" : \n");

        for(Student student:students){
            if(student.getFaculty().equals(faculty)){
                System.out.print(student);
                isStud = true;
            }
        }

        if (!isStud){
            System.out.println("There are no students for the specified request!");
        }
    }

    public static void listOfAfterYear(Student[] students, int year){

        boolean isStud = false;

        System.out.println("Students, who were born after "+year+" year : \n");

        for(Student student:students){
            if(student.getYearBirth()>year){
                System.out.print(student);
                isStud = true;
            }
        }

        if (!isStud){
            System.out.println("There are no students for the specified request!");
        }
    }

    public static void listOfGroup(Student[] students, String group){

        boolean isStud = false;

        System.out.println("Students of "+group+" groups : \n");

        for(Student student:students){
            if(student.getGroup().equals(group)){
                System.out.print(student);
                isStud = true;
            }
        }

        if (!isStud){
            System.out.println("There are no students for the specified request!");
        }
    }
}