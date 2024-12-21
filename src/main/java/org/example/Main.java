package org.example;

import com.student.manage.Student;
import com.student.manage.StudentDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("Welcome to Student Management App");
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(inputStreamReader);


        while(true){
            System.out.println("Press 1 to ADD student");
            System.out.println("Press 2 to DELETE student");
            System.out.println("Press 3 to DISPLAY student");
            System.out.println("Press 4 to UPDATE student");
            System.out.println("Press 5 to exit app");

            int c = Integer.valueOf(br.readLine());

            if(c == 1){
//                ADD student
                System.out.println("Enter user name :");
                String name = br.readLine();
                System.out.println("Enter user phone :");
                String phone = br.readLine();
                System.out.println("Enter user city :");
                String city = br.readLine();

                Student st = new Student(name,phone,city);
                boolean answer = StudentDao.insertStudentToDb(st);

                if(answer){
                    System.out.println("Student is added successfully....");
                }else {
                    System.out.println("Something went wrong please try again....");
                }


            } else if (c == 2) {
//                DELETE student

                System.out.println("Please enter user id to delete: ");
                int userId = Integer.valueOf(br.readLine());
                boolean b = StudentDao.deleteStudent(userId);
                if(b){
                    System.out.println("Student is deleted successfully....");
                }else {
                    System.out.println("Something went wrong please try again....");
                }
            } else if (c == 3) {
//                DISPLAY student
                StudentDao.showAllStudents();

            } else if (c == 4) {
//                  UPDATE student
                System.out.println("Please enter student Id that you want to update : ");
                int id = Integer.valueOf(br.readLine());
                System.out.println("Please enter new name : ");
                String name = br.readLine();
                System.out.println("Please enter new Phone no. : ");
                String phone = br.readLine();
                System.out.println("Please enter new city : ");
                String city = br.readLine();
                StudentDao.updateStudent(id, name, phone, city);

            }else if(c == 5) {
//                EXIT
                break;
            }else{

            }

        }
        System.out.println("Thank you for using my application....");
        System.out.println("See you soon..... Bye Bye....");


    }
}