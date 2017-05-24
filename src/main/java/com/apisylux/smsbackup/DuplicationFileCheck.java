package com.apisylux.smsbackup;
import java.util.*;
public class DuplicationFileCheck {
    MessageStructure ms1,ms2;
    int read,status,locked,protocol,type;
    String address,date;
    String subject,body,toa,sc_toa,service_center;
    String date_sent,contact_name;
    
    public DuplicationFileCheck(){
        
//        DuplicateMongoDBCheck mongocheck = new DuplicateMongoDBCheck(al);
        //DuplicateEntryDatabase ded = new DuplicateEntryDatabase(al);
    }
    public ArrayList DuplicateInFiles(ArrayList al){
        int count=1;
        int duplicate = 0;
        for(int i = 0; i< al.size(); i++){
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
            //System.out.println("Checking: "+body);
            for(int j = count; j < al.size();j++){
                ms2 = (MessageStructure)al.get(j);
                
                //System.out.println("One Loop is at: "+i+" and Other: "+j);
                if(date.equals(ms2.date) && date_sent.equals(ms2.date_sent)
                        && body.equals(ms2.body) && address.equals(ms2.address)){
                    duplicate++;
//                    System.out.println("Duplicate Found in File!");
                    al.remove(j);
                }
            }
            count++;
        }
        return al;
    }
}
