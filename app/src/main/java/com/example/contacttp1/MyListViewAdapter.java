package com.example.contacttp1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyListViewAdapter extends BaseAdapter {
    Context con;
    ArrayList<Contact> data;

    public MyListViewAdapter(Context con, ArrayList<Contact> list) {
        this.con = con;
        this.data = list;
    }

    @Override
    public int getCount() {
        //envoie les nombre des views a créer

        return data.size();
    }

    @Override
    public Object getItem(int i) {
        //envoie la donnée dans la position i
        return i;
    }

    @Override
    public long getItemId(int i) {
        //envoie l'id de l'item i
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //envoi la view a afficher
        //creation d'un view
        LayoutInflater inf= LayoutInflater.from(con);
        View v= inf.inflate(R.layout.viewcontact,null);
        //recuperation des holders
        TextView tvnom=v.findViewById(R.id.view_contact_name_txt);
        TextView tvprenom=v.findViewById(R.id.view_contact_lastname_txt);
        TextView tvnum=v.findViewById(R.id.view_contact_num);
        ImageView btn_call=v.findViewById(R.id.view_contact_btn_call);
        ImageView btn_del=v.findViewById(R.id.view_contact_btn_delete);

        Contact c=data.get(i);
        tvnom.setText(c.nom);
        tvprenom.setText(c.prenom);
        tvnum.setText(c.numero);
        btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.remove(i);
                notifyDataSetChanged();
            }
        });

        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_DIAL);
                i.setData(Uri.parse("tel:"+c.numero));
                con.startActivity(i);
            }
        });



        return v;
    }
}
