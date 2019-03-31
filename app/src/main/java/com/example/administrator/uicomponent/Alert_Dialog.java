package com.example.administrator.uicomponent;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Alert_Dialog extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alertdialog);
    }
    public void click(View view) {
        AlertDialog alertDialog = new AlertDialog.Builder(this).setView(R.layout.alertdialog_view)
                .setNegativeButton("Cancel",null).setPositiveButton("Sign in",null).create();
        alertDialog.show();
    }
}
