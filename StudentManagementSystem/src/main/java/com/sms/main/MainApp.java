

package com.sms.main;

import java.util.Scanner;
import com.sms.dao.StudentDAO;
import com.sms.entity.Student;

public class MainApp {

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Fetch Student by ID");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();
                    System.out.print("Course: ");
                    String course = sc.nextLine();

                    dao.saveStudent(new Student(name, email, course));
                    break;

                case 2:
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    Student student = dao.getStudentById(id);
                    System.out.println(student != null ? student : "Student not found");
                    break;

                case 3:
                    System.out.print("Enter Student ID: ");
                    int uid = sc.nextInt();
                    sc.nextLine();
                    Student s = dao.getStudentById(uid);
                    if (s != null) {
                        System.out.print("New Name: ");
                        s.setName(sc.nextLine());
                        System.out.print("New Email: ");
                        s.setEmail(sc.nextLine());
                        System.out.print("New Course: ");
                        s.setCourse(sc.nextLine());
                        dao.updateStudent(s);
                    } else {
                        System.out.println("Student not found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Student ID: ");
                    dao.deleteStudent(sc.nextInt());
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
