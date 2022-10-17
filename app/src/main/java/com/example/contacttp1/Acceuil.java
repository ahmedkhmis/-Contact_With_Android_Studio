package com.example.contacttp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class Acceuil extends AppCompatActivity {
    public static ArrayList<Contact> data=new ArrayList<>();
    Button btn_ajout,btn_edit;
    ContactManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);
        manager=new ContactManager(Acceuil.this);
        manager.open();
        btn_ajout = findViewById(R.id.btn_ajout_acceuil);
        btn_edit = findViewById(R.id.btn_edit_acceuil);
        btn_ajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Acceuil.this,Ajout.class);
                startActivity(i);
            }
        });
        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Acceuil.this,manager.getAllContact().toString(),Toast.LENGTH_LONG).show();
                Intent i = new Intent(Acceuil.this,Edit.class);
                startActivity(i);
            }
        });
    }
}