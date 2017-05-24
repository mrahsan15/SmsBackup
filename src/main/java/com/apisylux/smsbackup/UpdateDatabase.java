package com.apisylux.smsbackup;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;

public class UpdateDatabase {
    MessageStructure ms1;
        int read,status,locked,protocol,type;
        String address,date;
        String subject,body,toa,sc_toa,service_center;
        String date_sent,contact_name;
        int count=0;
        public UpdateDatabase(ArrayList al){
            try{
                Connection con = new CreateConnection().ConnectMysql();
                Statement st = con.createStatement();
                for(int i = 0; i < al.size(); i++){
                    ms1 = (MessageStructure)al.get(i);
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
                    String query = "INSERT INTO SmsChats "
                        + "(ID, protocol, address, date, type, "
                        + "subject, body, toa, sc_toa, service_center,"
                        + " _read, status, locked, date_sent, contact_name) "
                        + "VALUES (NULL, "+protocol+", '"+address+"', '"+date+"', '"+type+"',"
                        + " '"+subject+"', '"
                        +body
                        +"', '"+toa+"', '"+sc_toa+"', '"+service_center+"',"
                        + " '"+read+"', '"+status+"', '"+locked+"', '"+date_sent+"', '"+contact_name+"')";
                    try{
                        int updated = st.executeUpdate(query);
                        count++;
                    }catch (Exception exx){
                        System.out.println("This Mesasge is not Updated: "+body+"\n Due to following Reasong: "+exx);
                    }


                }
                System.out.println(count+" Entries Updated!");
            }catch(Exception ex){
                System.out.println(ex);
            
            }
    }
    
}
