package com.example.a1kayat34.sqliteapp;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create buttons
        Button add_button = (Button)findViewById(R.id.btn_add);
        add_button.setOnClickListener(this);
        Button search_button = (Button)findViewById(R.id.btn_searh);
        search_button.setOnClickListener(this);
        Button update_button = (Button)findViewById(R.id.btn_update);
        update_button.setOnClickListener(this);
        Button delete_button = (Button)findViewById(R.id.btn_delete);
        delete_button.setOnClickListener(this);

    }

    public void onClick(View view){


    }

}
