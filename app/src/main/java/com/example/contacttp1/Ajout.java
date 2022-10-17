package com.example.contacttp1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Ajout extends AppCompatActivity {
    EditText ed_name,ed_lastname,ed_phone;
    Button btn_ajout,btn_cancel;
    ContactManager manager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);
         manager=new ContactManager(Ajout.this);
        manager.open();

        btn_ajout = findViewById(R.id.btn_ajout_ajout);
        btn_cancel = findViewById(R.id.btn_cancel_ajout);
        ed_name = findViewById(R.id.ed_name_ajout);
        ed_lastname = findViewById(R.id.ed_lastname_ajout);
        ed_phone = findViewById(R.id.ed_phone_ajout);


        btn_ajout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=ed_name.getText().toString();
                String lastname=ed_lastname.getText().toString();
                String phone=ed_phone.getText().toString();
                manager.add(phone,name,lastname);
                Contact c= new Contact(name,lastname,phone);
                Acceuil.data.add(c);
                finish();
            }
        });
    }
}