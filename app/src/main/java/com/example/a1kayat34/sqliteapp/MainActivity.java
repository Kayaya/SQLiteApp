package com.example.a1kayat34.sqliteapp;

import android.app.AlertDialog;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    private MyHelper myhelper;

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

        myhelper = new MyHelper(this);

    }

    public void onClick(View view){
        if(view.getId()==R.id.btn_add){

            Long returned_id;
            //get id Edit Text
            EditText etid = (EditText)findViewById(R.id.et_id);

            //get title
            EditText ettitle = (EditText)findViewById(R.id.et_title);
            String title = ettitle.getText().toString();
            //get artist
            EditText etartist = (EditText)findViewById(R.id.et_artist);
            String artist= etartist.getText().toString();

            returned_id = myhelper.insertSong(title,artist);

            etid.setText(String.valueOf(returned_id));

        }
        else if(view.getId()==R.id.btn_searh){
            Song mysong;
            String song_title, song_artist;
            EditText etid = (EditText)findViewById(R.id.et_id);
            Long id = Long.parseLong(etid.getText().toString());

            mysong = myhelper.findSong(id);
            if(mysong == null){
                new AlertDialog.Builder(this).setMessage("Error! ID "+id.toString()+" not found!...").setPositiveButton("OK", null).show();

            }
            else {

                song_title = mysong.getTitle();
                song_artist = mysong.getArtist();

                EditText ettitle = (EditText) findViewById(R.id.et_title);
                EditText etartist = (EditText) findViewById(R.id.et_artist);

                etartist.setText(String.valueOf(song_title));
                ettitle.setText(String.valueOf(song_artist));
            }

        }
        else if(view.getId()==R.id.btn_update){
            EditText ettitle = (EditText) findViewById(R.id.et_title);
            EditText etartist = (EditText) findViewById(R.id.et_artist);
            EditText etid = (EditText) findViewById(R.id.et_id);
            EditText etyear = (EditText) findViewById(R.id.et_year);

            String title= ettitle.getText().toString();
            String artist= etartist.getText().toString();
            Long id = Long.parseLong(etid.getText().toString());
            Long year = Long.parseLong(etyear.getText().toString());

            int result=0;

            result = myhelper.updateRecord(id, title,artist,year);
            if(result == 0){

            }


        }
        else if(view.getId()==R.id.btn_delete){

        }

    }

}
