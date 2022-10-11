package com.example.contacttp1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class Edit extends AppCompatActivity {

    EditText ed_rech;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        rv = findViewById(R.id.rv_edit);
        ed_rech = findViewById(R.id.ed_rech_edit);
        ed_rech.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {





            }

            @Override
            public void afterTextChanged(Editable editable) {


            }
        });

//        if(!Acceuil.data.isEmpty())
//        ArrayAdapter ad=new ArrayAdapter(Edit.this, android.R.layout.simple_list_item_1,Acceuil.data);
//        MyListViewAdapter ad=new MyListViewAdapter(Edit.this,Acceuil.data);
        MyContactRecycleAdapter ad=new MyContactRecycleAdapter(Edit.this,Acceuil.data);
////        LinearLayoutManager manger=new LinearLayoutManager(Edit.this,LinearLayoutManager.HORIZONTAL,true);
        GridLayoutManager manger=new GridLayoutManager(Edit.this,1, GridLayoutManager.VERTICAL,false);
        rv.setLayoutManager(manger);
        rv.setAdapter(ad);

    }
}