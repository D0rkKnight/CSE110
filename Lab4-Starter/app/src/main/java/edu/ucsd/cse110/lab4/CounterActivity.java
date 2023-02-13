package edu.ucsd.cse110.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CounterActivity extends AppCompatActivity {

    public int max_count;

    private ExecutorService backgroundThread = Executors.newSingleThreadExecutor();
    private Future<Void> future;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        // Get intent and set counter
        Bundle extras = getIntent().getExtras();
        this.max_count = extras.getInt("max_count");

        TextView counter = findViewById(R.id.counter);

        // Start bg thread
        future = backgroundThread.submit(() -> {
            int count = 0;

            do {
                final int countCopy = count; // For display, immutable

                // Update UI (ping pong to ui thread)
                runOnUiThread(() -> {
                    counter.setText(Integer.toString(countCopy));
                });
                

                count++;

                Thread.sleep(500);
            } while(count < this.max_count + 1);

            runOnUiThread(() -> {
                Utilities.showAlert(this, "Done counting!");
            });

            return null;
        } );
    }

    public void onGoBackClicked(View view) {
        finish();

        future.cancel(true);
    }
}