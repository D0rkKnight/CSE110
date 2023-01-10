package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView name_display = findViewById(R.id.name);
        name_display.setVisibility(View.INVISIBLE);

        final Button show_button = findViewById(R.id.show_button);
        show_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                name_display.setVisibility(View.VISIBLE);
            }
        });

        final Button hide_button = findViewById(R.id.hide_button);
        hide_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                name_display.setVisibility(View.INVISIBLE);
            }
        });
    }
}