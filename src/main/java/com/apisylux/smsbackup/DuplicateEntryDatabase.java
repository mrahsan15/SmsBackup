package com.apisylux.smsbackup;

import java.sql.*;
import java.util.*;

public class DuplicateEntryDatabase {
    MessageStructure ms1;
    int read,status,locked,protocol,type;
    String address,date;
    String subject,body,toa,sc_toa,service_center;
    String date_sent,contact_name;
    //ResultSet rs;
    int count =0,duplicates = 0;
    ArrayList al1;
    public DuplicateEntryDatabase(ArrayList al){
        al1 = new ArrayList();
        try{
            Connection con = new CreateConnection().ConnectMysql();
            Statement st = con.createStatement();
            //System.out.println(al.size());
            for(int i = 0; i< al.size(); i++ ){
                
                ms1 = (MessageStructure)al.get(i);
                body = ms1.body;
                date = ms1.date;

                String query = "SELECT * FROM SmsChats WHERE date = '"+date+"' AND address ='"+ms1.address+"'" +
                        " AND body ='"+body+"'";
                ResultSet rs = st.executeQuery(query);
                int resultset = 0;
                while(rs.next()){
                    resultset++;
                    if(rs.getString("body").equals(body.replace("\\'", "'").replace("\\ ", "\\"))
                            ){
                        duplicates++;
                        //System.out.println(duplicates++ +" Duplicates Found!");
                        //al.remove(i);
                        break;
                    }else{
                        count++;
                        MessageStructure ms = new MessageStructure();
                        ms.setValues(ms1.protocol, ms1.address, ms1.date,
                                ms1.type, ms1.subject, ms1.body, ms1.toa,
                                ms1.sc_toa, ms1.service_center, ms1.read,
                                ms1.status, ms1.locked, ms1.date_sent, ms1.contact_name);
                 //       System.out.println(rs.getString("body") +"\t"+(body.replace("\\'", "'").replace("\\ ", "\\")));
                        al1.add(ms);
                    }
                }
                if(resultset == 0){
                    MessageStructure ms = new MessageStructure();
                        ms.setValues(ms1.protocol, ms1.address, ms1.date,
                                ms1.type, ms1.subject, ms1.body, ms1.toa,
                                ms1.sc_toa, ms1.service_center, ms1.read,
                                ms1.status, ms1.locked, ms1.date_sent, ms1.contact_name);
                 //       System.out.println((body.replace("\\'", "'").replace("\\ ", "\\")));
                        al1.add(ms);
                }
            }
            
            
            
            
            /*
            String query = "SELECT * from SmsChats";
            rs = st.executeQuery(query);
            while(rs.next()){
                
                for(int j = 0; j < al.size(); j++){
                    ms1 = (MessageStructure)al.get(j);
                read = ms1.read;
                protocol = ms1.protocol;
                status = ms1.protocol;
                locked = ms1.locked;
                type = ms1.type;
                address = ms1.address;
                date = ms1.date;
                subject = ms1.subject;
                body = ms1.body;
                toa = ms1.toa;
                sc_toa = ms1.sc_toa;
                service_center = ms1.service_center;
                date_sent = ms1.date_sent;
                contact_name = ms1.contact_name;
                
                    if(rs.getString("body").equals(body.replace("\\'", "'").replace("\\ ", "\\"))
                        
                            && rs.getString("date").equals(date)
                            && rs.getString("address").equals(address)){
//                        System.out.println("Duplicate Found!");
                        duplicates++;
                        al.remove(j);
                        //System.out.println(body+ "\t"+ms1.body);
                    }
                    else{
                        
                    }
                }
                count++;
            }
            
            
            */
            System.out.println("Duplicates Found in Database: "+duplicates);
            System.out.println("ArrayList Left: "+al.size());
            System.out.println("New ArrayList is: "+al1.size());
            MessageStructure ms;
            for(int j = 0; j< al.size(); j++){
                ms = (MessageStructure)al.get(j);
                //System.out.println(ms.body);
            }
            
            UpdateDatabase ud = new UpdateDatabase(al1);
        }catch(Exception ex){
            System.out.println(ex);
        }
        
            
    }
}