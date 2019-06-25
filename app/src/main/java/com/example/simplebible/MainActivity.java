package com.example.simplebible;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static TextView textView;
    public static TextView titleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickButton(View view) {
        textView = findViewById(R.id.textview);
        titleView = findViewById(R.id.titleview);
        GetVerses getVerses = new GetVerses();
        getVerses.execute();
    }
}
