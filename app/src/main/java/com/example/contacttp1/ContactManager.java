package com.example.contacttp1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class ContactManager {
    SQLiteDatabase db=null;
    Context con;

    public ContactManager(Context con) {
        this.con = con;
    }
    public void open(){
        ContactHelper helper=new ContactHelper(con,"contact_base.db",null,1);
        db=helper.getWritableDatabase();


    }
    public long add(String num,String name,String lastname){
        long a;
        ContentValues values=new ContentValues();
        values.put(ContactHelper.col_numero,num);
        values.put(ContactHelper.col_name,name);
        values.put(ContactHelper.col_LastName,lastname);
        a=db.insert(ContactHelper.table_contact,null,values);
        return a;

    }
    public ArrayList<Contact> getAllContact(){
        ArrayList<Contact> l=new ArrayList<>();
        Cursor cr=db.query(ContactHelper.table_contact,new String[]{ContactHelper.col_numero,ContactHelper.col_name,ContactHelper.col_LastName},null,null,null,null,null);
        cr.moveToFirst();
        while (!cr.isAfterLast()) {
            String i = cr.getString(0);
            String i1 = cr.getString(1);
            String i2 = cr.getString(2);
            l.add(new Contact(i1, i2, i));
            cr.moveToNext();
        }

        return l;
    }
//    public long delete(String num,String name,String lastname){
////        long a;
////        ContentValues values=new ContentValues();
////        values.put(ContactHelper.col_numero,num);
////        values.put(ContactHelper.col_name,name);
////        values.put(ContactHelper.col_LastName,lastname);
////        a=db.delete(ContactHelper.table_contact,null,values);
////        return a;
//
//
//    }
    public void close(){

    }
}
