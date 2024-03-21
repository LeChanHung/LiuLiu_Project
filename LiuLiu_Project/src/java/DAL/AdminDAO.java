/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import Model.Levels;
import Model.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author lecha
 */
public class AdminDAO extends DBContext{
     Connection cnn;//ket noi data
    PreparedStatement stm;//thuc hien cau lenh sql
    ResultSet rs;//luu tru va xu ly du lieu duoc lay ve tu select

    public AdminDAO() {
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

        public ArrayList<Users> getUser() {
        ArrayList<Users> data = new ArrayList<Users>();
        try {
            String query = "select * from Users\n"
                    + "where role = 1";
            stm = cnn.prepareStatement(query);
            rs = stm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String pass = rs.getString(3);
                String mail = rs.getString(4);
                String phone = rs.getString(5);
                String role = rs.getString(6);
                Users u = new Users(id, name, pass, mail, phone, role);
                data.add(u);
            }
        } catch (Exception e) {
            System.out.println("Get Products:" + e.getMessage());
        }
        return data;
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
        
        public ArrayList<Levels> getLevel() {
        ArrayList<Levels> data = new ArrayList<Levels>();
        try {
            String query = "select * from Levels";
            stm = cnn.prepareStatement(query);
            rs = stm.executeQuery();
            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                Levels l = new Levels(id, name);
                data.add(l);
            }
        } catch (Exception e) {
            System.out.println("Get Products:" + e.getMessage());
        }
        return data;
    }
        
        


    public void delete(String id) {
        try {
            String query = "delete from Users where UserID=?";
            stm = cnn.prepareStatement(query);
            stm.setString(1, id);
            stm.execute();
        } catch (Exception e) {
            System.out.println("Insert" + e.getMessage());
        }
    }

    public void beadmin(String id) {
        try {
            String query = "UPDATE Users SET Role = '2' WHERE UserID = ?;";
            stm = cnn.prepareStatement(query);
            stm.setString(1, id);
            stm.execute();
        } catch (Exception e) {
            System.out.println("Insert" + e.getMessage());
        }
    }

    public Levels getDetail(String id) {
        try {
            String query = "select * from Levels  where [LevelID]=?";
            stm = cnn.prepareStatement(query);
            stm.setString(1, id);
            rs = stm.executeQuery();
            while (rs.next()) {
                String name = rs.getString(2);
                Levels l = new Levels(id, name);
               return l;
            }
            
        } catch (Exception e) {
            System.out.println("Get Products:" + e.getMessage());
        }
        return null;
    }
    
    public static void main(String[] args) {
        AdminDAO a = new AdminDAO();
        String id = "1";
            System.out.println(a.getDetail(id));
    }
}
