package com.apisylux.smsbackup;

//import java.util.Date;
import java.sql.Date;
public class MessageStructure {
    
    int read,status,locked,protocol,type;
    String address,date;
    String subject,body,toa,sc_toa,service_center;
    String date_sent,contact_name;
    
    public MessageStructure(){
        
    }
    public void setValues(int Protocol,String Address,String Date,
            int Type,String Subject,String Body,String Toa,
            String Sc_toa,String Service_Center,int Read,int Status,
            int Locked,String Date_sent,String Contact_Name){
        this.protocol = Protocol;
        this.address = Address;
        this.date = Date;
        this.type = Type;
        this.subject = Subject;
        this.body = Body;
        this.toa = Toa;
        this.sc_toa = Sc_toa;
        this.service_center = Service_Center;
        this.read = Read;
        this.status = Status;
        this.locked = Locked;
        this.date_sent = Date_sent;
        this.contact_name = Contact_Name;
    }
    public void getValues(){
        
    }

}
