package com.example.splashscreen;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EmployeeLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_login);
        final TextInputEditText user = (TextInputEditText) findViewById(R.id.user);
        final TextInputEditText pass = (TextInputEditText) findViewById(R.id.pass);
        Button login=(findViewById(R.id.login));
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String username = user.getText().toString().trim();
                    String password = pass.getText().toString().trim();
                    if (username.isEmpty() && password.isEmpty()) {
                        user.setError("wrong username!");
                        pass.setError("wrong password!");
                        //Toast.makeText(getApplicationContext(), "please enter both username and password!", Toast.LENGTH_SHORT).show();
                    } else if (username.equals("user") && password.equals("user")) {
                        startActivity(new Intent(EmployeeLogin.this, Employee.class));
                    } else {
                        //Toast.makeText(getApplicationContext(),"Wrong username/password combination",Toast.LENGTH_SHORT).show();
                        user.setError("wrong username!");
                        pass.setError("wrong password!");
                        startActivity(new Intent(EmployeeLogin.this, Employee.class));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
