package com.worldpopulation;

import java.sql.*;
import java.util.ArrayList;

/**
 * Class Name : Main
 * Author: aaa
 * Date: asf
 * Description: Collection Test
 */

    // fetch lok p yin pull swl if there are files in github
    //commit lok dh failed b error tt yin thu pyy htr dk sentence 2 kyg gko terminal htl mhr htae
    //commit p yin push -> login pho lo yin authorized lok pyy lyk
    //branch kwl p yin push

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

    protected ArrayList<Country> read_DB(Connection conn) {
        ArrayList<Country> countrylist = new ArrayList<>();
        try {
            PreparedStatement stat = conn.prepareStatement("SELECT country_name, capital_name," +
                    "region_name, sub_region_name FROM population");
            ResultSet rs = stat.executeQuery();
            while (rs.next()) { //record dwy gko pointer htuk p dk true pyn dk function
                countrylist.add(new Country(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4)));
            }
            rs.close();
            stat.close();

        } catch (Exception e){
            e.printStackTrace();
        }

        return countrylist;
    }



    public static void main(String[] args) {
        Main m = new Main();
        Connection conn = m.getConnection("localhost", 3306, "world_population", "root", "");
        ArrayList<Country> countrylist = m.read_DB(conn);
        System.out.println(countrylist.getLast());

        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}