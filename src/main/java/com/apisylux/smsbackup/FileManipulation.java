package com.apisylux.smsbackup;
import java.io.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class FileManipulation {
    
    
    public FileManipulation(){
//        ArrayList al = getMessages(getFile());
//        DuplicationFileCheck dfc = new DuplicationFileCheck(al);
    }
    
    
    public File[] getFile(){
    File[] file=null;
    try{
        
        JFileChooser select = new JFileChooser();
        
        select.setMultiSelectionEnabled(true);
        select.setFileFilter(new FileNameExtensionFilter("XML Documents", "xml"));
        select.showOpenDialog(select);
        
        file = select.getSelectedFiles();
        
        
        
    }catch(Exception ex){
        System.out.println(ex);
    }
    return file;
}
    public ArrayList getMessages(File[] file){
        
        ArrayList al = new ArrayList();
        MessageStructure ms; 
        for(int i = 0; i < file.length; i++){
        try{
            
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc= dBuilder.parse(file[i]);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("sms");
            
            for(int j =0; j < nList.getLength(); j++){
                Node nNode = nList.item(j);
            
                int read,status,locked,protocol,type;
                String address,date;
                String subject,body,toa,sc_toa,service_center;
                String date_sent,contact_name;
                
                protocol = Integer.parseInt(nNode.getAttributes().getNamedItem("protocol").toString().replace("\"", "").replace("protocol=", ""));
                address = nNode.getAttributes().getNamedItem("address").toString().replace("\"", "").replace("address=", "");
                date = nNode.getAttributes().getNamedItem("date").toString().replace("\"", "").replace("date=", "");
                type = Integer.parseInt(nNode.getAttributes().getNamedItem("type").toString().replace("\"", "").replace("type=", ""));
                subject = nNode.getAttributes().getNamedItem("subject").toString().replace("\"", "").replace("subject=", "");
                body = nNode.getAttributes().getNamedItem("body").toString().replace("\"", "").replace("\\", "\\ ").replace("body=", "").replace("\'", "\\\'").replace("&#10;", " ").replace("&#13;", " ").replace("☺", "").replace("♥", "<3").replace("♡", "<3").replace(":\\", ": \\").replace(":'(", ":\'(");
                toa = nNode.getAttributes().getNamedItem("toa").toString().replace("\"", "").replace("toa=", "");
                sc_toa = nNode.getAttributes().getNamedItem("sc_toa").toString().replace("\"", "").replace("sc_toa=", "");
                service_center = nNode.getAttributes().getNamedItem("service_center").toString().replace("\"", "").replace("service_center=", "");
                read = Integer.parseInt(nNode.getAttributes().getNamedItem("read").toString().replace("\"", "").replace("read=", ""));
                status = Integer.parseInt(nNode.getAttributes().getNamedItem("status").toString().replace("\"", "").replace("status=", ""));
                locked = Integer.parseInt(nNode.getAttributes().getNamedItem("locked").toString().replace("\"", "").replace("locked=", ""));
                date_sent = nNode.getAttributes().getNamedItem("date_sent").toString().replace("\"", "").replace("date_sent=", "");
                contact_name = nNode.getAttributes().getNamedItem("contact_name").toString().replace("\"", "").replace("contact_name=", "");
                
                ms = new MessageStructure();
                ms.setValues(protocol,address,date,type,subject,body,toa,
                        sc_toa,service_center,read,status,
                        locked,date_sent,contact_name);
                
                al.add(ms);
                //System.out.println("ArrayList Prepared!");
                //System.out.println(j+": "+body+"\n");
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
    }
        return al;
    }
}