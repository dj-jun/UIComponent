package com.example.administrator.uicomponent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button myBtn_one;
    private Button myBtn_two;
    private Button myBtn_three;
    private Button myBtn_four;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myBtn_one = (Button)findViewById(R.id.btn_one);
        myBtn_two = (Button)findViewById(R.id.btn_two);
        myBtn_three = (Button)findViewById(R.id.btn_three);
        myBtn_four = (Button)findViewById(R.id.btn_four);
        myBtn_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Simple_Adapter.class);
                startActivity(intent);
            }
        });
        myBtn_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Alert_Dialog.class);
                startActivity(intent);
            }
        });
        myBtn_three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,XML_Menu.class);
                startActivity(intent);
            }
        });
        myBtn_four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Action_Mode.class);
                startActivity(intent);
            }
        });
    }
}
