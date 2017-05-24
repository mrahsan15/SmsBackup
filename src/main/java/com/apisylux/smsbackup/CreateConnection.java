package com.apisylux.smsbackup;

import com.mongodb.MongoClient;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateConnection {
    MongoClient mongo = null;
    Connection connection = null;
    public CreateConnection(){
        File file = new File("DBCredentials");
        try {
            PrintWriter writer = new PrintWriter(file);
            writer.println();
            writer.flush();
            FileOutputStream ofs = new FileOutputStream(file);
            
        } catch (FileNotFoundException ex) {
            
        }
    }
    public Connection ConnectMysql(){
        String dbName = "SmsBackup";
        try{
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/"+dbName;
            connection = DriverManager.getConnection(url,"root","root");
            
            try{
                String query = "CREATE DATABASE "+dbName;
                connection.createStatement().executeQuery(query);
            }catch(Exception ex){
                
            }
            
            
        }catch(Exception ex){
            System.out.println(ex);
        }
        return connection;
    }
    public MongoClient ConnectMongo(){
        try {
            mongo = new MongoClient("127.0.0.1", 27017);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return mongo;
    }
}
