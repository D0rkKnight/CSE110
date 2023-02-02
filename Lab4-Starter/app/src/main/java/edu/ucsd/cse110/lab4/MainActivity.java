package edu.ucsd.cse110.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.TextView;

import java.util.Optional;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onLaunchProfileClicked(View view) {

        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);

    }

    public void onShowCounterClicked(View view) {
        Intent intent = new Intent(this, CounterActivity.class);

        TextView count = findViewById(R.id.counter_field);
        String countStr = count.getText().toString();

        Optional<Integer> maybeMax = Utilities.parseCount(countStr);

        // Check parse
        if (!maybeMax.isPresent()) {
            Utilities.showAlert(this, "Not a number");
            return;
        } 

        int max = maybeMax.get();

        if (max <= 0) {
            Utilities.showAlert(this, "Please enter positive");
            return;
        }

        intent.putExtra("max_count", max);
        startActivity(intent);
    }
}