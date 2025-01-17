package com.example.lab2;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    ListView city_list;
    ArrayAdapter<String> cityAdapter;
    ArrayList<String> dataList;

    Button addbut, delbut;
    EditText text;

    String city = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        city_list = findViewById(R.id.cnt_view);
        String[] cities = {"Edmonton", "Calgary", "Vancouver", "Moscow", "Toronto", "Tokyo", "Amritsar"};
        dataList = new ArrayList<>();
        dataList.addAll(Arrays.asList(cities));
        cityAdapter = new ArrayAdapter<>(this, R.layout.content, dataList);
        city_list.setAdapter(cityAdapter);
        text = findViewById(R.id.simpleEditText);
        addbut = findViewById(R.id.add_but);
        addbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = text.getText().toString().trim();
                dataList.add(inputText);
                cityAdapter.notifyDataSetChanged();
                text.setText("");
            }
        });
        city_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                city = dataList.get(position);

            }
        });

        delbut = findViewById(R.id.del_but);
        delbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataList.remove(city);
                cityAdapter.notifyDataSetChanged();
                city = null;
            }
        });


    }


}