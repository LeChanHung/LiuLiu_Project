/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
Order by NEWID()
 */
package DAL;

import Model.Levels;
import Model.Questions;
import Model.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lecha
 */
public class UserDAO extends DBContext {

    Connection cnn;//ket noi data
    PreparedStatement stm;//thuc hien cau lenh sql
    ResultSet rs;//luu tru va xu ly du lieu duoc lay ve tu select

    public UserDAO() {
        connect();
    }

    private void connect() {
        try {
            cnn = connection;
            if (cnn != null) {
                System.out.println("Connect success");
            } else {
                System.out.println("Connect Fail");
            }
        } catch (Exception e) {
            System.out.println("Connect error" + e.getMessage());
        }
    }

    public boolean checkUser(String mail, String pass) {
        try {
            String query = "select * from Users where Email = ? and Password = ?";
            stm = cnn.prepareStatement(query);
            stm.setString(1, mail);
            stm.setString(2, pass);
            rs = stm.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Check User" + e.getMessage());
        }
        return false;
    }

    public String getNameByMail(String mail) {
         try {
            String query = "select * from Users where Email=?";
            stm = cnn.prepareStatement(query);
            stm.setString(1, mail);
            rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getString(2);
            }
        } catch (Exception e) {
            System.out.println("Get name by mail" + e.getMessage());
        }
        return null;
    }
    
     public String getRoleByMail(String mail) {
         try {
            String query = "select * from Users where Email=?";
            stm = cnn.prepareStatement(query);
            stm.setString(1, mail);
            rs = stm.executeQuery();
            while (rs.next()) {
                return rs.getString(6);
            }
        } catch (Exception e) {
            System.out.println("Get role by mail" + e.getMessage());
        }
        return null;
    }

    public Users getUserProfile(String mail) {
        try {
            String query = "select * from Users  where Email=?";
            stm = cnn.prepareStatement(query);
            stm.setString(1, mail);
            rs = stm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String pass = rs.getString(3);
                String phone = rs.getString(5);
                String role = rs.getString(6);
                Users u = new Users(id, name, pass, mail, phone, role);
                return u;
            }
            
        } catch (Exception e) {
            System.out.println("Get Products:" + e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        UserDAO d = new UserDAO();
    String mail = "1";
    ArrayList<Questions> question = d.getQuestion(mail);
    int viTri = 2;
    if (viTri >= 0 && viTri < question.size()) {
        Questions questionAtIndex = question.get(viTri);
        System.out.println("Phần tử ở vị trí " + viTri + " là: " + questionAtIndex.getId());
        System.out.println("Text: " + questionAtIndex.getText());
        System.out.println("Answer: " + questionAtIndex.getAnswer());
        System.out.println("Option 1: " + questionAtIndex.getOp1());
        System.out.println("Option 2: " + questionAtIndex.getOp2());
        System.out.println("Option 3: " + questionAtIndex.getOp3());
        System.out.println("Option 4: " + questionAtIndex.getOp4());
    } else {
        System.out.println("Vị trí không hợp lệ!");
    }
        
    }

    public ArrayList<Questions> getQuestion(String quizid) {
        ArrayList<Questions> data = new ArrayList<Questions>();
        try {
            String query = "select * from Questions where QuizID=? Order by NEWID()";
            stm = cnn.prepareStatement(query);
            stm.setString(1, quizid);
            rs = stm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String text = rs.getString(2);
                String answer = rs.getString(3);
                String op1 = rs.getString(4);
                String op2 = rs.getString(5);
                String op3 = rs.getString(6);
                String op4 = rs.getString(7);
                Questions q = new Questions(id, text, answer, op1, op2, op3, op4, quizid);
                data.add(q);
            }
        } catch (Exception e) {
            System.out.println("Get Products:" + e.getMessage());
        }
        return data;
    }

    

}

