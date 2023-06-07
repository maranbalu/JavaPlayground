package com.manimaran.exercise.collections;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentRegistry {
    private ArrayList<String> students = new ArrayList<>();

    public void addStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name of the student to add:");
        String studentName = scanner.nextLine();
        students.add(studentName);
        System.out.println(studentName + " has been added to the registry.");
    }

    public void removeStudent() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name of the student to remove:");
        String studentName = scanner.nextLine();
        if (students.remove(studentName)) {
            System.out.println(studentName + " has been removed from the registry.");
        } else {
            System.out.println("No such student exists in the registry.");
        }
    }

    public void isStudentRegistered() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the name of the student to check:");
        String studentName = scanner.nextLine();
        if (students.contains(studentName)) {
            System.out.println(studentName + " is registered.");
        } else {
            System.out.println(studentName + " is not registered.");
        }
    }

    public void printAllStudents() {
        System.out.println("The following students are registered:");
        for (String student : students) {
            System.out.println(student);
        }
    }

    public static void main(String[] args) {
        StudentRegistry registry = new StudentRegistry();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("What would you like to do?");
            System.out.println("1. Add a student\n2. Remove a student\n3. Check if a student is registered\n4. Print all students\n5. Exit");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over
            switch (choice) {
                case 1:
                    registry.addStudent();
                    break;
                case 2:
                    registry.removeStudent();
                    break;
                case 3:
                    registry.isStudentRegistered();
                    break;
                case 4:
                    registry.printAllStudents();
                    break;
                case 5:
                    System.out.println("Thank you for using the Student Registry!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        } while (choice != 5);
    }
}