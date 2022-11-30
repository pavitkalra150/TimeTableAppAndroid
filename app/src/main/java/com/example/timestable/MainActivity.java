package com.example.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    EditText number;
    Button create;
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number = findViewById(R.id.number);
        create = findViewById(R.id.button);
        list = findViewById(R.id.list);

        create.setOnClickListener(v -> {
            createTable();
        });

    }

    void createTable(){
        int value = Integer.parseInt(number.getText().toString());
        ArrayList<String> tableValues = new ArrayList<>();
        String[] res = new String[10];
        for(int i = 1;i<=10;i++){
            res[i-1] = String.valueOf(value * i);
            tableValues.add(res[i-1]);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tableValues);
        list.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}