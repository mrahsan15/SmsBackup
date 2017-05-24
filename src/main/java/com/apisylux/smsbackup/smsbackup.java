package com.apisylux.smsbackup;

//import java.sql.Date;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class smsbackup {

    public static void main(String[] args) {
        //CreateDB cdb = new CreateDB();
        //FileManipulation file = new FileManipulation();
        //file.getFile();
        Test test = new Test();
        
        File file = new File("dbconnect.txt");
        System.out.println(file.canRead());
        try {
            file.createNewFile();
            System.out.println(file.canRead());
            FileWriter writer = new FileWriter(file);
            writer.append("My Name is Ahsan");
            writer.append("\n");
            writer.append("And i'm not a terrorist.");
            writer.flush();
            writer.close();
            System.out.println("Reading File");
            FileReader reader = new FileReader(file);
            BufferedReader br = new BufferedReader(reader);
            
            while(br.ready()){
                System.out.println(br.readLine());
            }
            
            
//        MainFrame main = new MainFrame();
        } catch (IOException ex) {
            Logger.getLogger(smsbackup.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
}
