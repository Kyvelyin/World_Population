package com.worldpopulation;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Class Name : Main
 * Author: aaa
 * Date: asf
 * Description: Collection Test
 */

// fetch lok p yin pull swl if there are files in git hub

public class Main {
    /*
    Main method
    */

    //Connection cls is for database connection
    //Statement/PrepareStatement -> more sure , these cls are for the db data manipulation
    //ResultSet -> db gka table structure ma pyt ag build htr dh (start from index 1)

    private Connection getConnection(String ipaddress,int portno, String dbname, String username, String password) {
        Connection conn = null;
        try {//this is for error handling
            //connection driver lok mk cls shi ma shi sik
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://" + ipaddress + ":" + portno+ "/" + dbname, username, password); //db yk parameter gko ek thy ma htr bl nk khw 3 dh
            System.out.println("Connected to database successfully");

        } catch(Exception e){
            e.printStackTrace();
        }
        return conn;
    }



    public static void main(String[] args) {
        Main m = new Main();
        Connection conn = m.getConnection("localhost", 3306, "world_population", "root", "");

    }
}