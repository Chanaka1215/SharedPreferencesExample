package com.example.chanakafernando.sharedpreferencesexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private String myDate;
    private Button view, update, remove, clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PreferenceManager.initializeInstance(MainActivity.this);

        view = (Button) findViewById(R.id.view);
        update = (Button) findViewById(R.id.update);
        remove = (Button) findViewById(R.id.remove);
        clear =(Button) findViewById(R.id.clear);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Do","DOO1");
                myDate = PreferenceManager.getInstance().getUpdate(getString(R.string.current_date));
                Toast.makeText(MainActivity.this, myDate, Toast.LENGTH_LONG).show();
            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Do","DOO2");
                PreferenceManager.getInstance().setUpdate(getString(R.string.current_date), new Date() + "");
            }
        });

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              PreferenceManager.getInstance().remove(getString(R.string.current_date));
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PreferenceManager.getInstance().clear();

            }
        });


    }
}
