package com.example.contacttp1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ContactHelper extends SQLiteOpenHelper {
    public static final String table_contact="Contact";
    public static final String col_name="Name";
    public static final String col_LastName="LastName";
    public static final String col_numero="Numero";
    String req="create table "+table_contact+"("
            +col_numero+" varchar(20) primary Key,"
            +col_name+" Text not null,"
            +col_LastName+" Text not null"
            +")";

    public ContactHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //il creer le ficher de database et appeler oncreate

        db.execSQL(req);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
//        modification de la version de bd
        db.execSQL(" drop table "+table_contact);
        onCreate(db);
    }
}
