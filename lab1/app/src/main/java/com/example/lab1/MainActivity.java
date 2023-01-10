package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView nameTv = (TextView) findViewById(R.id.nameTv);
        Button showBtn = (Button) findViewById(R.id.showBtn);
        Button hideBtn = (Button) findViewById(R.id.hideBtn);

        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameTv.setVisibility(View.VISIBLE);
            }
        });

        hideBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameTv.setVisibility(View.INVISIBLE);
            }
        });
    }
}