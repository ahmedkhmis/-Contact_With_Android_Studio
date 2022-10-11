package com.example.contacttp1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn_qte,btn_val ;
    EditText ed_email,ed_pwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_qte = findViewById(R.id.btn_qte_auth);
        btn_val = findViewById(R.id.btn_val_auth);
        ed_email =findViewById(R.id.ed_mail_auth);
        ed_pwd = findViewById(R.id.ed_pwd_auth);

        btn_qte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btn_val.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = ed_email.getText().toString();
                String psw = ed_pwd.getText().toString();
                email="Ahmed@gmail.com";
                psw="12345";
                if(email.equalsIgnoreCase("Ahmed@gmail.com") && psw.equals("12345")){
//                        Intent i = new Intent(Intent.ACTION_DIAL);
//                        i.setData(Uri.parse("tel:27001360"));
//                        startActivity(i);

                    Intent i = new Intent(MainActivity.this,Acceuil.class);
                    startActivity(i);
                    finish();
                }
                else
                    Toast.makeText(MainActivity.this,"email or psw invalid",Toast.LENGTH_LONG).show();
            }
        });

    }}