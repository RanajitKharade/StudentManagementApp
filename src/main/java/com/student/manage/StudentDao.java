package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentDao {

    public static boolean insertStudentToDb(Student st) {
        boolean f = false;
        try {
//        jdbc code...
            Connection con = ConnectionProvider.createConnection();
            String q = "insert into students(sname, sphone, scity) values(?,?,?)";

//          prepared statement
            PreparedStatement preparedStatement = con.prepareStatement(q);

            preparedStatement.setString(1, st.getStudentName());
            preparedStatement.setString(2, st.getStudentPhone());
            preparedStatement.setString(3, st.getStudentCity());

//            Execute..
            preparedStatement.executeUpdate();
            f = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }

    public static boolean deleteStudent(int userId) {

        boolean f = false;
        try {
//        jdbc code...
            Connection con = ConnectionProvider.createConnection();
            String q = "delete from students where sid = ?";

//          prepared statement
            PreparedStatement preparedStatement = con.prepareStatement(q);

            preparedStatement.setInt(1, userId);

//            Execute..
            preparedStatement.executeUpdate();
            f = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;

    }

    public static boolean showAllStudents() {

        boolean f = false;
        try {
//        jdbc code...
            Connection con = ConnectionProvider.createConnection();
            String q = "select * from students";

//          prepared statement
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(q);

            while (resultSet.next()) {
                int sId = resultSet.getInt(1);
                String sName = resultSet.getString(2);
                String sPhone = resultSet.getString(3);
                String sCity = resultSet.getString(4);

                System.out.println("Id :" + sId);
                System.out.println("Name :" + sName);
                System.out.println("Phone :" + sPhone);
                System.out.println("City :" + sCity);

                System.out.println("+++++++++++++++++++++++++++++++++++++++");
            }


            f = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;

    }

    public static boolean updateStudent(int id, String name, String phone, String city) {

        boolean f = false;
        try {
//        jdbc code...
            Connection con = ConnectionProvider.createConnection();
            String q = "update students set sname = ?, sphone = ?, scity = ? where sid = ?";

            PreparedStatement preparedStatement = con.prepareStatement(q);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, phone);
            preparedStatement.setString(3, city);
            preparedStatement.setInt(4, id);
            preparedStatement.executeUpdate();

            System.out.println("Student updated successfully");

            f = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;

    }
}
