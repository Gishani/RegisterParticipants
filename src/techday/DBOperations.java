/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techday;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gishanir
 */
public class DBOperations {

    String url = "jdbc:mysql://localhost/company_day";
    String username = "root";
    String password;
    Connection con;
    PreparedStatement pst;
    //int count = 0;
    ResultSet rs;

    public boolean register(Employee em) {
        try {
            //System.out.println("registering person " + (++count));
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "UPDATE employee SET registration=TRUE WHERE emailID = '" + em.getEmailID() + "'";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            pst.executeUpdate();
            //System.out.println("registered person " + count);
            return true;
        } catch (SQLException ex) {
            System.out.println("error--> " + ex);
            return false;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }

                if (con != null) {
                    pst.close();
                }
            } catch (Exception e) {

            }
        }
    }

    ArrayList<Employee> getEmpoloyees() {
        try {
            ArrayList<Employee> employeeList = new ArrayList<>();

            //System.out.println("retrieving people");
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT * from employee";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            rs = pst.executeQuery();

            while (rs.next()) {
                Employee e = new Employee();
                e.setEmailID(rs.getString(1));
                e.setName(rs.getString(2));
                e.setProduct(rs.getString(3));
                e.setRegistration(rs.getBoolean(4));
                employeeList.add(e);
            }

            //System.out.println("retrieved people");
            return employeeList;

        } catch (SQLException ex) {
            System.out.println("error--> " + ex);
            return null;
            //return false;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }

                if (con != null) {
                    pst.close();
                }
            } catch (Exception e) {

            }
        }
    }

    int getRegisteredCount() {
        try {
            con = (Connection) DriverManager.getConnection(url, username, password);
            String query = "SELECT COUNT(*) FROM employee WHERE registration = 1";
            pst = (com.mysql.jdbc.PreparedStatement) con.prepareStatement(query);
            rs = pst.executeQuery();
            if(rs.next()){
                return rs.getInt(1);
            }
            else{
                return 0;
            }
            //return ((Number)rs.getObject(1)).intValue();
            //System.out.println("bla2");
        } catch (SQLException ex) {
            System.out.println("error--> " + ex);
            return 0;
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }

                if (con != null) {
                    pst.close();
                }
            } catch (Exception e) {

            }
        }
    }
}
