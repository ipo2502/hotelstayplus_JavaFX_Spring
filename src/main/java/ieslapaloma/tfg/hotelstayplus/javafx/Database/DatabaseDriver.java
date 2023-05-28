package ieslapaloma.tfg.hotelstayplus.javafx.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseDriver {
    private Connection conn;
    String databaseName = "hotelstaydb";
    String user = "root";
    String pass = "root";
    private final String URL ="jdbc:mysql://localhost:3306/"+ databaseName;

    public DatabaseDriver() {
        try {
            //this.conn = DriverManager.getConnection(URL);
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.conn = DriverManager.getConnection(URL, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     *  Client Section
     */ 

        public ResultSet getClientData(String pAddress, String password) {
            
            Statement statement;
            ResultSet resultSet = null;
            try {
                statement = this.conn.createStatement();
                resultSet = statement.executeQuery("SELECT * FROM clients WHERE username = '"+pAddress+"' AND password = '"+password+"';");
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return resultSet;
        }


     /*
      * Admin Selection
      */



      /*
       * Utility Methods
       */
}

