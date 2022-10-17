package com.example.contacttp1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class Edit extends AppCompatActivity {

    EditText ed_rech;
    RecyclerView rv;
    public ImageView rech_btn;
    ArrayList<Contact> data=Acceuil.data;


    MyContactRecycleAdapter ad=new MyContactRecycleAdapter(Edit.this,data);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        rv = findViewById(R.id.rv_edit);
        ed_rech = findViewById(R.id.ed_rech_edit);
        rech_btn = findViewById(R.id.ed_rech_btn);
        ed_rech.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                ArrayList<Contact> newdata=new ArrayList<>();
//                Toast.makeText(Edit.this,charSequence,Toast.LENGTH_LONG).show();
                for (Contact c:data
                ) {
                    if (c.nom.contains(charSequence.toString()) || c.prenom.contains(charSequence.toString()) || c.numero.contains(charSequence.toString())){
                        newdata.add(c);
//                        Toast.makeText(Edit.this,"c.nom",Toast.LENGTH_LONG).show();

                    }
                }
                if (newdata.isEmpty()){
                    ad=new MyContactRecycleAdapter(Edit.this,data);
                    GridLayoutManager manger=new GridLayoutManager(Edit.this,1, GridLayoutManager.VERTICAL,false);
                    rv.setLayoutManager(manger);
                    rv.setAdapter(ad);
                }

                ad=new MyContactRecycleAdapter(Edit.this,newdata);
                GridLayoutManager manger=new GridLayoutManager(Edit.this,1, GridLayoutManager.VERTICAL,false);
                rv.setLayoutManager(manger);
                rv.setAdapter(ad);







            }

            @Override
            public void afterTextChanged(Editable editable) {
//                Toast.makeText(Edit.this,editable.toString(),Toast.LENGTH_LONG).show();



            }
        });
        rech_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String research=ed_rech.getText().toString();
                ArrayList<Contact> newdata=new ArrayList<>();
//                Toast.makeText(Edit.this,charSequence,Toast.LENGTH_LONG).show();
                for (Contact c:data
                ) {
                    if (c.nom.equals(research.toString()) || c.prenom.equals(research.toString()) || c.numero.toString().equals(research.toString())){
                        newdata.add(c);
//                        Toast.makeText(Edit.this,"c.nom",Toast.LENGTH_LONG).show();

                    }
                }

                ad=new MyContactRecycleAdapter(Edit.this,newdata);
                GridLayoutManager manger=new GridLayoutManager(Edit.this,1, GridLayoutManager.VERTICAL,false);
                rv.setLayoutManager(manger);
                rv.setAdapter(ad);
            }
        });

//        if(!Acceuil.data.isEmpty())
//        ArrayAdapter ad=new ArrayAdapter(Edit.this, android.R.layout.simple_list_item_1,Acceuil.data);
//        MyListViewAdapter ad=new MyListViewAdapter(Edit.this,Acceuil.data);
////        LinearLayoutManager manger=new LinearLayoutManager(Edit.this,LinearLayoutManager.HORIZONTAL,true);
        GridLayoutManager manger=new GridLayoutManager(Edit.this,1, GridLayoutManager.VERTICAL,false);
        rv.setLayoutManager(manger);
        rv.setAdapter(ad);

    }
}