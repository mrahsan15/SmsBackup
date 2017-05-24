package com.apisylux.smsbackup;

import com.mongodb.MongoClient;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
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
        File file = new File("dbconnect.txt");
        String Url = "";
        String Username = "";
        String Password = "";
        String dbName = "";
        try{
            FileReader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);

            while(br.ready()){
                Url = br.readLine();
                dbName = br.readLine();
                Username = br.readLine();
                Password = br.readLine();
            }
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(Url+dbName,"root","root");
            
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
