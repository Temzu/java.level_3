package com.geekbrains.lesson_2.db_requests;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class Main {
    private static Connection conn;
    private static Statement stmt;
    private static PreparedStatement pstmt;
    public static void main(String[] args) {
        connect();

        try {
            createTable();
            addSomeEntries();
            //deleteSomeEntries();
            changeFirstEntry();
            //add1000Entries();
            //add1000EntriesPrepareStatement();
            //addEntriesFromFile();
            selectFromTable();
            //dropTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        disconnect();
    }

    
    private static void add1000EntriesPrepareStatement() throws SQLException {
        pstmt = conn.prepareStatement("INSERT INTO students (name, score) VALUES (?, ?);");
        conn.setAutoCommit(false);
        for (int i = 0; i < 1000; i++) {
            pstmt.setString(1, "Anatoliy" + i);
            pstmt.setInt(2, i + 100);
            pstmt.addBatch();
        }
        pstmt.executeBatch();
        conn.setAutoCommit(true);
    }

    private static void add1000Entries() throws SQLException {
        conn.setAutoCommit(false);
        for (int i = 0; i < 1000; i++) {
            stmt.executeUpdate("INSERT INTO students (name, score) VALUES ('Vasya', 123);");
        }
        conn.commit();
    }

    private static void dropTable() throws SQLException {
        stmt.executeUpdate("DROP TABLE IF EXISTS students;");
    }

    private static void changeFirstEntry() throws SQLException {
        stmt.executeUpdate("UPDATE students " +
                "SET name = 'Nikita' " +
                "WHERE id = 1;");
    }

    private static void deleteSomeEntries() throws SQLException {
        stmt.executeUpdate("DELETE FROM students WHERE id > 3;");
    }

    private static void addSomeEntries() {
        try {
            stmt.executeUpdate("INSERT INTO students (name, score) VALUES ('Vasya', 123), ('Egor', 321), ('Artem', 231);");
            System.out.println("Entries have been added to the table");
        } catch (SQLException e) {
            System.out.println("Entries were not added to the table");
            e.printStackTrace();
        }
    }

    private static void selectFromTable() throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT * FROM students;");
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString("name") + " " + rs.getInt(3));
        }
    }



    public static void createTable() throws SQLException {
        stmt.executeUpdate("CREATE TABLE IF NOT EXISTS students(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT," +
                "score INTEGER);");
        System.out.println("Table was created");
    }

    public static void connect() {
        try {
            String url = "jdbc:sqlite:db_hw2.db";
            conn = DriverManager.getConnection(url);
            stmt = conn.createStatement();
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void disconnect() {
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
