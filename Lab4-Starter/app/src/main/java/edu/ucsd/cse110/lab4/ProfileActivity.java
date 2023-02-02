package edu.ucsd.cse110.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        loadProfile();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        saveProfile();
    }

    public void onGoBackClicked(View view) {

        finish();

    }

    public void loadProfile() {

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);

        // Get fields by id and write data to them
        TextView name = findViewById(R.id.name_textview);
        name.setText(prefs.getString("name", ""));

        TextView status = findViewById(R.id.status_textview);
        status.setText(prefs.getString("status", ""));
    }

    public void saveProfile() {
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        // Write to prefs
        TextView name = findViewById(R.id.name_textview);
        editor.putString("name", name.getText().toString());

        TextView status = findViewById(R.id.status_textview);
        editor.putString("status", status.getText().toString());

        editor.apply();
    }   
}