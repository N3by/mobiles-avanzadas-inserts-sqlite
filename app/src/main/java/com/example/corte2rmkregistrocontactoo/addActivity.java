package com.example.corte2rmkregistrocontactoo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class addActivity extends AppCompatActivity {
// los declaro, sisisi
    EditText ptName, ptLastName, ptAge, ptPhone,ptMail, ptCity, ptMovie;
    Spinner spnGender;
    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
//aqui conecto la parte visual con el codigo
        ptName = findViewById(R.id.ptName);
        ptLastName = findViewById(R.id.ptLastName);
        ptAge = findViewById(R.id.ptAge);
        ptPhone = findViewById(R.id.ptPhone);
        ptMail = findViewById(R.id.ptMail);
        ptCity = findViewById(R.id.ptCity);
        spnGender = findViewById(R.id.spnGender);
        btnEnviar = findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() { // creo el onclick listener, de paso me crea el resto de metodos.
            @Override
            public void onClick(View view) {
                MyDatabaseHelper MyDB = new MyDatabaseHelper(MainActivity.class); // my databse helper, seria una clase. aqui instancio el objeto, para poder hacer cositas con los metodos de ese objeto.
                MyDB.addContact(ptName.getText().toString().trim(), // aqui recibo los datos y los "casteo" a string para manejarme con ellos.
                        ptLastName.getText().toString().trim(),
                        ptAge.getText().toString().trim(),
                        ptPhone.getText().toString().trim(),
                        ptMail.getText().toString().trim(),
                        ptCity.getText().toString().trim(),
                        spnGender.getSelectedItem().toString());

            }
        });


    }
}