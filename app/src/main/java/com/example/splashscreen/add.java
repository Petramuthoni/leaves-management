package com.example.splashscreen;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class add extends AppCompatActivity {
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    Button register;
    TextInputEditText id,fname,lname,email,pass;
    TextView t;
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        id=(TextInputEditText)findViewById(R.id.id);
        fname=(TextInputEditText)findViewById(R.id.fname);
        lname=(TextInputEditText)findViewById(R.id.lname);
        email=(TextInputEditText)findViewById(R.id.email);
        pass=(TextInputEditText)findViewById(R.id.pass);
        t=(TextView)findViewById(R.id.school);
       // s=(Spinner)findViewById(R.id.spinner);
        relativeLayout=(RelativeLayout)findViewById(R.id.relative);
      //  final String [] schools={"Business","Engineering","Science","Tourism","Art"};
      //  final ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,schools);
      //  s.setAdapter(adapter);

        openHelper=new DataBaseHelper(this);
        db=openHelper.getReadableDatabase();

        register=(Button) findViewById(R.id.btnl);
        register.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            { db=openHelper.getWritableDatabase();
               String eid,firstname,lastname,emailA,password;
               eid=id.getText().toString().trim();
               firstname=fname.getText().toString().trim();
               lastname=lname.getText().toString().trim();
               emailA=email.getText().toString().trim();
               password=pass.getText().toString().trim();

               insertData(eid,firstname,lastname,emailA,password);
                Toast.makeText(getApplicationContext(),"insertion success",Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void insertData(String eid, String firstname, String lastname, String emailA, String password)
    {
        ContentValues values=new ContentValues();
        values.put(DataBaseHelper.COL1,eid);
        values.put(DataBaseHelper.COL2,firstname);
        values.put(DataBaseHelper.COL3,lastname);
        values.put(DataBaseHelper.COL4,emailA);
        values.put(DataBaseHelper.COL5,password);
    }
}
