package com.apisylux.smsbackup;

import com.mongodb.*;
import java.util.ArrayList;

public class DuplicateMongoDBCheck {
    public DuplicateMongoDBCheck(){
        
        
    }
    public ArrayList DuplicateMongoDB(ArrayList text){
        MongoClient mongodb = new CreateConnection().ConnectMongo();
        DB database = mongodb.getDB("textmessages");
        DBCollection collection = database.getCollection("ahsan");
        ArrayList db = new ArrayList();
        DBCursor cursor = collection.find();
        
        for(int i = 0; i < collection.count(); i++){
            DBObject object = cursor.next();
            
            MessageStructure ms = new MessageStructure() ;
            ms.address = (String) object.get("address");
            ms.body = (String) object.get("body");
            ms.date = (String) object.get("date");
            ms.type =  Integer.parseInt((String) object.get("type"));
            ms.subject = (String) object.get("subject");
            db.add(ms);
        }
        for(int i = 0; i < text.size();){
            int check = 0;
            MessageStructure ms1 = (MessageStructure) text.get(i);
            for(int j = 0; j < db.size();j++){
                MessageStructure ms2 = (MessageStructure) db.get(j);
                if(
                (ms1.address).equals(ms2.address) && 
                (ms1.body).equals(ms2.body) &&
                (ms1.date).equals(ms2.date) && 
                (ms1.subject).equals(ms2.subject)
                ){
                    text.remove(i);
                    check++;
                    break;
                }
            }
            if(check == 0){
                i++;
            }
        }
        return text;
    }
}