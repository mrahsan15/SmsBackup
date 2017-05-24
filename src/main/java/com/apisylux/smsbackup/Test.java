package com.apisylux.smsbackup;
import java.io.*;
import java.sql.Connection;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;

public class Test {
    public Test(){
        
//        Connection con = new CreateConnection().ConnectMysql();
//            
//        File file = new File("/home/ahsan/Desktop/sms-20150811225751.xml");
//        
//        System.out.println(file.isFile());
//        file = new File("/home/ahsan/Desktop/");
//        System.out.println(file.isDirectory());
        
        try{
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc  = dBuilder.newDocument();
        doc.createAttribute("DBUserName").setValue("username");
        doc.createElement("DB").setAttribute("username", "username");
        
        doc.normalizeDocument();
        
	
//        doc.getDocumentElement().normalize();
//        System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
//	NodeList nList = doc.getElementsByTagName("sms");
//	
//        for(int i =0;i < nList.getLength(); i++){
//            Node nNode = nList.item(i);
//            System.out.println(i + ": " +nNode.getAttributes().getNamedItem("address").toString().trim());
//        }
//        
        }catch(Exception ex){
            System.out.println(ex);
        }
        
        
    }
    
}
