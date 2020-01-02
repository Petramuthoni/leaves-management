package com.example.splashscreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class AdminEmployee extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_employee);
        ImageButton imageButton=(ImageButton) findViewById(R.id.adminbtn);
        ImageButton imageButton1=(ImageButton) findViewById(R.id.employeebtn);
        TextView tv=(TextView) findViewById(R.id.employeetv);
        TextView tv1=(TextView) findViewById(R.id.employeetv);
        tv1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(AdminEmployee.this,AdminLogin.class));
            }
        });
        tv.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(AdminEmployee.this,EmployeeLogin.class));
            }
        });
        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AdminEmployee.this,EmployeeLogin.class));
            }
        });
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AdminEmployee.this,AdminLogin.class));
            }
        });
    }
}
