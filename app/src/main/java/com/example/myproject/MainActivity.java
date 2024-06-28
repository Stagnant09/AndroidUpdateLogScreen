package com.example.myproject;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import android.os.AsyncTask;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;
    TextView gotIt;
    TextView skipAll;
    ImageView bullet0;
    ImageView bullet1;
    ImageView bullet2;
    UpdateProgressBarTask updateTask;
    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Disable night mode
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        gotIt = findViewById(R.id.gotIt);
        skipAll = findViewById(R.id.skipAll);

        bullet0 = findViewById(R.id.bullet0);
        bullet1 = findViewById(R.id.bullet1);
        bullet2 = findViewById(R.id.bullet2);


        progressBar = findViewById(R.id.progressBar);
        progressBar.setMax(100000);
        progressBar.setProgress(0);
        updateTask = new UpdateProgressBarTask(); // Initialize the task
        updateTask.execute();


        gotIt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (id == 0) {
                    //Restart the progress bar

                    // Stop the current update progress bar task
                    if (updateTask != null && !updateTask.isCancelled()) {
                        updateTask.cancel(true);}

                    // Start a new update task
                    progressBar.setProgress(0);
                    updateTask = new UpdateProgressBarTask();
                    updateTask.execute();
                    // Set the style of the bullets
                    bullet0.setImageResource(R.drawable.new_moon);
                    bullet1.setImageResource(R.drawable.new_moon__1_);
                    bullet2.setImageResource(R.drawable.new_moon);
                    id++;
                } else if (id == 1) {
                    //Restart the progress bar

                    // Stop the current update progress bar task
                    if (updateTask != null && !updateTask.isCancelled()) {
                        updateTask.cancel(true);}

                    // Start a new update task
                    progressBar.setProgress(0);
                    updateTask = new UpdateProgressBarTask();
                    updateTask.execute();
                    // Set the style of the bullets
                    bullet0.setImageResource(R.drawable.new_moon);
                    bullet1.setImageResource(R.drawable.new_moon);
                    bullet2.setImageResource(R.drawable.new_moon__1_);
                    id++;
                } else if (id == 2) {
                    //Restart the progress bar

                    // Stop the current update progress bar task
                    if (updateTask != null && !updateTask.isCancelled()) {
                        updateTask.cancel(true);}

                    // Start a new update task
                    progressBar.setProgress(0);
                    updateTask = new UpdateProgressBarTask();
                    updateTask.execute();
                    // Set the style of the bullets
                    bullet0.setImageResource(R.drawable.new_moon__1_);
                    bullet1.setImageResource(R.drawable.new_moon);
                    bullet2.setImageResource(R.drawable.new_moon);
                    id = 0;
                }

            }
        });
    }

    private class UpdateProgressBarTask extends AsyncTask<Void, Integer, Void> {
        @Override
        protected Void doInBackground(Void... voids) {
            for (int i = 0; i <= 100000; i += 50) {
                if (isCancelled()) {
                    break; // Exit if the task is cancelled
                }
                try {
                    Thread.sleep(2); // Simulate a long-running task
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(i);
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            int progress = values[0];
            progressBar.setProgress(progress);
            //If progress == 100000 then trigger the click event of gotIt

            if (progress == 100000) {
                gotIt.performClick();
            }
        }


    }


}