package com.gobeyond.wingsui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("TestPoint");
    }

    public void goToDODashboard(View view) {
        startActivity(new Intent(MainActivity.this,DoDashboardActivity.class));
    }

    public void goToCounterDashboard(View view) {
        startActivity(new Intent(MainActivity.this,CounterDashboardActivity.class));
    }
}