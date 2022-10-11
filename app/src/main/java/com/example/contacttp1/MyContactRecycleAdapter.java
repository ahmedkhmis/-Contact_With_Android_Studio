package com.example.contacttp1;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyContactRecycleAdapter extends RecyclerView.Adapter<MyContactRecycleAdapter.MyViewHolder> {
    Context con;
    ArrayList<Contact> data;

    public MyContactRecycleAdapter(Context con, ArrayList<Contact> data) {
        this.con = con;
        this.data = data;
    }

    @NonNull
    @Override
    public MyContactRecycleAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //creation d'un view
        LayoutInflater inf= LayoutInflater.from(con);
        View v= inf.inflate(R.layout.viewcontact,null);
        return new MyViewHolder(v);//represent la view
    }

    @Override
    public void onBindViewHolder(@NonNull MyContactRecycleAdapter.MyViewHolder holder, int position) {
        Contact c=data.get(position);
        holder.tvnom.setText(c.nom);
        holder.tvprenom.setText(c.prenom);
        holder.tvnum.setText(c.numero);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tvnom;
        public TextView tvprenom;
        public TextView tvnum;
        public ImageView btn_call;
        public ImageView btn_del;
        public MyViewHolder(@NonNull View v) {
            super(v);
            //recuperation des holders
             tvnom=v.findViewById(R.id.view_contact_name_txt);
             tvprenom=v.findViewById(R.id.view_contact_lastname_txt);
             tvnum=v.findViewById(R.id.view_contact_num);
             btn_call=v.findViewById(R.id.view_contact_btn_call);
             btn_del=v.findViewById(R.id.view_contact_btn_delete);

             //events


            btn_del.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int indice=getAdapterPosition();
                    data.remove(indice);
                    notifyDataSetChanged();
                }
            });
            btn_call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int indice=getAdapterPosition();
                    Contact c=data.get(indice);
                    Intent i=new Intent(Intent.ACTION_DIAL);
                    i.setData(Uri.parse("tel:"+c.numero));
                    con.startActivity(i);
                }
            });
        }
    }
}
