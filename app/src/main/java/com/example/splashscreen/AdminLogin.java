package com.example.splashscreen;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        final TextInputEditText user = (TextInputEditText) findViewById(R.id.user);
        final TextInputEditText pass = (TextInputEditText) findViewById(R.id.pass);
        Button btn1 = (Button) findViewById(R.id.btnl);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String username = user.getText().toString().trim();
                    String password = pass.getText().toString().trim();
                    if (username.isEmpty() || password.isEmpty()) {
                        user.setError("wrong username!");
                        pass.setError("wrong password!");
                        //Toast.makeText(getApplicationContext(), "please enter both username and password!", Toast.LENGTH_SHORT).show();
                    } else if (username.equals("admin") && password.equals("admin")) {
                        startActivity(new Intent(AdminLogin.this, MainActivity.class));
                    } else {
                        //Toast.makeText(getApplicationContext(),"Wrong username/password combination",Toast.LENGTH_SHORT).show();
                        user.setError("wrong username!");
                        pass.setError("wrong password!");
                        startActivity(new Intent(AdminLogin.this, AdminLogin.class));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
