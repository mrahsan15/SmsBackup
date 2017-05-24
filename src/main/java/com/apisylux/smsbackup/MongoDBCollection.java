package com.apisylux.smsbackup;

import com.mongodb.*;
import java.util.ArrayList;

public class MongoDBCollection {
    public MongoDBCollection(){
        
    }
    public int UpdateRecord(ArrayList al){
        if(al.size()>0){
        try {
            MongoClient mongodb = new CreateConnection().ConnectMongo();
            DB database = mongodb.getDB("textmessages");
            DBCollection collection = database.getCollection("ahsan");
            for(int i = 0; i < al.size();i++){
                DBObject object = new BasicDBObject();
                MessageStructure ms = (MessageStructure) al.get(i);
                object.put("address", ms.address);
                object.put("body",ms.body);
                object.put("contact_name", ms.contact_name);
                object.put("date", ms.date);
                object.put("date_sent", ms.date_sent);
                object.put("locked", ms.locked);
                object.put("protocol", ms.protocol);
                object.put("read", ms.read);
                object.put("sc_toa", ms.sc_toa);
                object.put("service_center",ms.service_center);
                object.put("status", ms.status);
                object.put("subject", ms.subject);
                object.put("toa", ms.toa);
                object.put("type",ms.type);
                collection.insert(object);
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }        
    }
        return al.size();
    }
}