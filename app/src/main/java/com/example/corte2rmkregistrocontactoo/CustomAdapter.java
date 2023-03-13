package com.example.corte2rmkregistrocontactoo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;//3
    private ArrayList ffriend_id, ffriend_name, ffriend_phone, ffriend_gender; // vuelve a inicializar las array list que hizo en la main su database helper.

    // cuando inicializamo esta clase, queremos poder pasarle todos los array list que ya teniamos. // //1 este es el constructor.
    CustomAdapter(Context context,
                  ArrayList ffriend_id,
                  ArrayList ffriend_name,
                  ArrayList ffriend_phone,
                  ArrayList ffriend_gender){
        this.context = context;
        this.ffriend_id = ffriend_id;// lo hacemos para poder acceder a esos objetos de la clase toda la clase.
        this.ffriend_name = ffriend_name;
        this.ffriend_phone = ffriend_phone;
        this.ffriend_gender = ffriend_gender;

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);// aqui metemos el inflate.
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.ffriend_id_txt.setText(String.valueOf(ffriend_id.get(position))); // coje el estring del array
        holder.ffriend_name_txt.setText(String.valueOf(ffriend_name.get(position)));
        holder.ffriend_phone_txt.setText(String.valueOf(ffriend_phone.get(position)));
        holder.ffriend_gender_txt.setText(String.valueOf(ffriend_gender.get(position)));

    }
    @Override
    public int getItemCount() {
        return ffriend_id.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView ffriend_id_txt, ffriend_name_txt, ffriend_phone_txt, ffriend_gender_txt;  // instancia los textviews que requiera, con el nombre que les puso en el xml

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ffriend_id_txt = itemView.findViewById(R.id.ffriend_id_txt);
            ffriend_name_txt = itemView.findViewById(R.id.ffriend_name_txt);
            ffriend_phone_txt = itemView.findViewById(R.id.ffriend_phone_txt);
            ffriend_gender_txt = itemView.findViewById(R.id.ffriend_gender_txt);
        }
    }
}
