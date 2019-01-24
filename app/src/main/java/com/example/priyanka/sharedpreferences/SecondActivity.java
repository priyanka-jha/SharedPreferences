package com.example.priyanka.sharedpreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final String MY_PREFS_NAME = "MyPrefs";
    SharedPreferences sharedPreferences;

    TextView nameText,surnameText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        nameText=findViewById(R.id.name);
        surnameText=findViewById(R.id.surname);

        sharedPreferences=this.getSharedPreferences(MY_PREFS_NAME, Context.MODE_PRIVATE);
        String name=sharedPreferences.getString("name","");
        String surname=sharedPreferences.getString("surname","");

        nameText.setText(name);
        surnameText.setText(surname);



    }

    //logout
    public void logout(View view) {

        sharedPreferences =getSharedPreferences(MY_PREFS_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.clear();
        editor.commit();

        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
