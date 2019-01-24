package com.example.priyanka.sharedpreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String MY_PREFS_NAME = "MyPrefs";

    EditText nameText,surnameText;
    Button save;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences=getApplicationContext().getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE);
        boolean appstatus=sharedPreferences.getBoolean("isNotFirst",false);

        //if user is logged in then redirect to second activity directly
        if (appstatus) {
            Intent i = new Intent(getApplicationContext(),SecondActivity.class);
            startActivity(i);
        }

        nameText=findViewById(R.id.name);
        surnameText=findViewById(R.id.surname);
        save=findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if ((nameText.getText().toString().trim().equals("") || surnameText.getText().toString().trim().equals(" "))) {
                    Toast.makeText(getApplicationContext(),"Please enter values",Toast.LENGTH_LONG).show();
                }
                else {


                    String name=nameText.getText().toString();
                    String surname=surnameText.getText().toString();

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("name",name);
                    editor.putString("surname",surname);
                    editor.putBoolean("isNotFirst",true);
                    editor.commit();

                    Intent i = new Intent(getApplicationContext(),SecondActivity.class);
                    startActivity(i);
                }

            }
        });

    }
}
