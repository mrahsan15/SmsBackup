package com.apisylux.smsbackup;

import java.sql.*;

public class CreateDB {

        public CreateDB(){
            Connection con = new CreateConnection().ConnectMysql();
            Statement st = null;
            try{
                st = con.createStatement();
                String query = "CREATE TABLE SmsChats ( "
                       + "ID int(15) NOT NULL AUTO_INCREMENT, "
                       + "protocol int(2), "
                       + "address varchar(20), "
                       + "date varchar(25), "
                       + "type int(2), "
                       + "_read int(2), "
                       + "status int(2), "
                       + "locked int(2), "
                       + "subject varchar(15), "
                       + "body varchar(3000), "
                       + "toa varchar(15), "
                       + "sc_toa varchar(15), "
                       + "service_center varchar(3000), "
                       + "date_sent varchar(25), "
                       + "contact_name varchar(50), "
                       + "PRIMARY KEY (ID))";
                st.executeUpdate(query);
            }catch(Exception ex){
                System.out.println(ex);
                String query = "CREATE TABLE SmsChats ( "
                        + "ID int(15) NOT NULL AUTO_INCREMENT, "
                        + "protocol int(2), "
                        + "address varchar(20), "
                        + "date varchar(25), "
                        + "type int(2), "
                        + "_read int(2), "
                        + "status int(2), "
                        + "locked int(2), "
                        + "subject varchar(15), "
                        + "body varchar(3000), "
                        + "toa varchar(15), "
                        + "sc_toa varchar(15), "
                        + "service_center varchar(3000), "
                        + "date_sent varchar(25), "
                        + "contact_name varchar(50), "
                        + "PRIMARY KEY (ID))";
                try {
                    st.executeUpdate(query);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
}
