package com.example.splashscreen;

import android.app.Application;
import android.app.DatePickerDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.app.NotificationManager;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class empleave extends AppCompatActivity  {
    TextInputEditText eid, fname, lname, sdate, edate;
    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    Button rLeave,request;
     Calendar mCalendar;
    int y,m,d;
    public static final String CHANNELID="YOUR_CHANNEL_ID";
    public NotificationManagerCompat notificationManagerCompat;

   // private NotificationManagerCompat notificationManagerCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empleave);

       // notificationManagerCompat=NotificationManagerCompat.from(this);

    mCalendar = Calendar.getInstance();

        eid = (TextInputEditText) findViewById(R.id.id);
        fname = (TextInputEditText) findViewById(R.id.fname);
        lname = (TextInputEditText) findViewById(R.id.lname);
        sdate = (TextInputEditText) findViewById(R.id.sdate);
        edate = (TextInputEditText) findViewById(R.id.edate);
        request=(Button)findViewById(R.id.notify);

        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // int notificationId=0;
               // NotificationCompat.Builder builder=new NotificationCompat.Builder(getApplicationContext()).setSmallIcon(R.drawable.calendar_icon).setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.calendar_icon)).setContentTitle("Leave Manager Notification").setContentText("new leave request").setAutoCancel(true).setDefaults(NotificationCompat.DEFAULT_ALL);
               // Uri path= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
               // builder.setSound(path);
               // NotificationManager notificationManager=(NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                notificationManagerCompat=NotificationManagerCompat.from(empleave.this);
                Notification notification=new NotificationCompat.Builder(empleave.this, CHANNELID)
                        .setSmallIcon(R.drawable.ic_message_1)
                        .setContentTitle("app")
                        .setContentText("application")
                        .setPriority(NotificationCompat.PRIORITY_HIGH)
                        .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                        .build();

                notificationManagerCompat.notify(1,notification);
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

                    NotificationChannel channel=new NotificationChannel(CHANNELID,"Channel human readable title",NotificationManager.IMPORTANCE_HIGH);
                    NotificationManager manager=getSystemService(NotificationManager.class);
                    manager.createNotificationChannel(channel);

                }


            }
        });

        final DatePickerDialog.OnDateSetListener date=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                /*mCalendar.set(Calendar.YEAR,year);
                mCalendar.set(Calendar.MONTH,monthOfYear);
                mCalendar.set(Calendar.MONTH,dayOfMonth);*/
                y=year;
                 m=monthOfYear;
                 d=dayOfMonth;

                updateLabel();



            }
        };
        sdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(empleave.this,date,mCalendar.get(Calendar.YEAR),mCalendar.get(Calendar.MONTH),mCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        edate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(empleave.this,date,mCalendar.get(Calendar.YEAR),mCalendar.get(Calendar.MONTH),mCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });


        openHelper=new DataBaseHelper(this);
        db=openHelper.getReadableDatabase();
        rLeave = (Button) findViewById(R.id.btnl);
        rLeave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db=openHelper.getWritableDatabase();
                String emId, Efname, Elname, Esdate, Edate;
                emId = eid.getText().toString().trim();
                Efname = fname.getText().toString().trim();
                Elname = lname.getText().toString().trim();
                Esdate = sdate.getText().toString().trim();
                Edate = edate.getText().toString().trim();

                insert(emId,Efname,Elname,Esdate,Edate);
                Toast.makeText(getApplicationContext(),"leave request success",Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(empleave.this,approve.class);
                startActivity(intent);



            }
        });
    }

    public void insert(String emId, String efname, String elname, String esdate, String edate)
    {
        ContentValues values=new ContentValues();
        values.put(DataBaseHelper.COL6,emId);
        values.put(DataBaseHelper.COL7,efname);
        values.put(DataBaseHelper.COL8,elname);
        values.put(DataBaseHelper.COL9,esdate);
        values.put(DataBaseHelper.COL10,edate);
    }
    public void updateLabel(){
        String myFormat="dd/MM/yy";
        SimpleDateFormat sdf=new SimpleDateFormat(myFormat);
        sdate.setText(sdf.format(mCalendar.getTime()));
        edate.setText(sdf.format(mCalendar.getTime()));
        sdate.setText(new StringBuilder().append(d).append("/").append(m + 1 ).append("/").append(y).append(" "));
        edate.setText(new StringBuilder().append(d).append("/").append(m + 2 ).append("/").append(y).append(" "));
    }
   /* public void channel1(View v)
    {
        String Title="Leave";
        String Message="Leave";
        Notification notification=new NotificationCompat.Builder(this, Notify.CHANNEL_1)
                .setSmallIcon(R.drawable.ic_message_1)
                .setContentTitle(Title)
                .setContentText(Message)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManagerCompat.notify(1,notification);
    }*/
}
