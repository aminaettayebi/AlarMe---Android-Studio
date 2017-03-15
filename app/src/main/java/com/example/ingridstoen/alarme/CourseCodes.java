package com.example.ingridstoen.alarme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CourseCodes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        Intent intent = getIntent();
        String username = intent.getStringExtra(Welcome.EXTRA_USERNAME);
        String password = intent.getStringExtra(Welcome.EXTRA_PASSWORD);

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText(username);
    }
}
