package com.example.corte2rmkregistrocontactoo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton btnAdd;

    MyDatabaseHelper myDB;
    ArrayList<String> ffriend_id, ffriend_name, ffriend_phone, ffriend_gender;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, addActivity.class);
                startActivity(intent);
            }
        });
        myDB = new MyDatabaseHelper(MainActivity.this); // inicializa una clase. a la clase le va a pasar:
        // inicializar los array list:
        ffriend_id = new ArrayList<>();
        ffriend_name = new ArrayList<>();
        ffriend_phone = new ArrayList<>();
        ffriend_gender = new ArrayList<>();

        storeDataInArrays();
        customAdapter = new CustomAdapter(MainActivity.this, ffriend_id, ffriend_name, ffriend_phone, ffriend_gender); // aqui meto los que cree como array list.
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this)); // hacer que el recycler view esta formateado como un layout de tipo linear.
    }
    void storeDataInArrays(){
        Cursor cursor = myDB.readAllData(); // almacenar los datos leido en el objeto cursor.
        if(cursor.getCount() == 0){
            Toast.makeText(this, "No hay datos", Toast.LENGTH_SHORT).show();
        }else{
            while(cursor.moveToNext()){
                ffriend_id.add(cursor.getString(0)); // leer de la base de datos el x index-campo de la tabla.
                ffriend_name.add(cursor.getString(1));
                ffriend_phone.add(cursor.getString(4));
                ffriend_gender.add(cursor.getString(7));
            }
        }
    }
}