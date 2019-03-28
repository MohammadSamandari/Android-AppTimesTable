package com.mohammadsamandari.timestableapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ListView listView;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        seekBar = findViewById(R.id.seekBar);

        populateListView(1);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                if (progress < 1) {
                    seekBar.setProgress(1);
                } else {
                    populateListView(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void populateListView(Integer value) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, arrayList);

        for (int i = 1; i < 10; i++) {
            arrayList.add(i * value);
        }

        listView.setAdapter(arrayAdapter);
    }
}
