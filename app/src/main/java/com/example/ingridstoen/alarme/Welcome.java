package com.example.ingridstoen.alarme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


public class Welcome extends AppCompatActivity {

    public static final String EXTRA_COURSE1 = "com.example.ingridstoen.alarme.COURSE1";
    public static final String EXTRA_COURSE2 = "com.example.ingridstoen.alarme.COURSE2";
    public static final String EXTRA_COURSE3 = "com.example.ingridstoen.alarme.COURSE3";
    public static final String EXTRA_COURSE4 = "com.example.ingridstoen.alarme.COURSE4";
    EditText usernameEdit, passwordEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        usernameEdit = (EditText) findViewById(R.id.usernameField);
        passwordEdit = (EditText) findViewById(R.id.passwordField);
    }

    public void sendLogin(View view) {
        Intent intent = new Intent(this, CourseCodes.class);
        EditText etUsername = (EditText) findViewById(R.id.usernameField);
        EditText etPassword = (EditText) findViewById(R.id.passwordField);
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        DatabaseConnection dbConnection = new DatabaseConnection();
        dbConnection.addUser(username, password);

        String course1 = dbConnection.getCourses();
        String course2 = dbConnection.getCourses();
        String course3 = dbConnection.getCourses();
        String course4 = dbConnection.getCourses();

        intent.putExtra(EXTRA_COURSE1, course1);
        intent.putExtra(EXTRA_COURSE2, course2);
        intent.putExtra(EXTRA_COURSE3, course3);
        intent.putExtra(EXTRA_COURSE4, course4);

        startActivity(intent);
    }
}
