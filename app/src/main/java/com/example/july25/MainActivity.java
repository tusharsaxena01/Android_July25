package com.example.july25;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CombinedVibration;
import android.os.VibratorManager;
import android.util.Log;
import android.view.View;

import com.example.july25.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    //Services

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = new Intent(MainActivity.this, MyService.class);

        binding.btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startService(intent);

            }
        });

        binding.btnStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(intent);
            }
        });

        Thread thread = new Thread(){
            @Override
            public void run() {
                super.run();

                for (int i = 0; i < 100; i++) {
                    int finalI = i;
//                    Log.e("Numbers", i+"");

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            binding.tv.setText(finalI+"");
                        }
                    });

                }
            }
        };
        thread.start();

    }
}