package electricityboard.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public  class DbConnectivity {



    public static Connection getConnection() {


        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/payout", "root", "0000");
        } catch (Exception e) {
            System.out.println(e);


        }
return conn;

    }









}


