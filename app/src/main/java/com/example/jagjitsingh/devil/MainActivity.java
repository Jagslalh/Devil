package com.example.jagjitsingh.devil;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;

public class MainActivity extends AppCompatActivity {
    Data g;
    EditText editText, Login;
    Button log,kl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        g = new Data(getApplicationContext());
        editText = (EditText) findViewById(R.id.editText);
        Login = (EditText) findViewById(R.id.LoginEmailorPhone);
        log = (Button) findViewById(R.id.LoginButton);
        kl=(Button)findViewById(R.id.kl);
        add();
        show();




    }
    void add() {
        log.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                boolean a = g.insert(editText.getText().toString(), Login.getText().toString());
                if (a == true) {
                    Toast.makeText(getApplicationContext(), "hello", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "hello1223", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }





    public void show() {

        kl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor d = g.get(editText.getText().toString(), Login.getText().toString());
                if (d.getCount() == 0)
                {
                    showl("Error", "no data");
                    return;
                }

                StringBuffer b = new StringBuffer();
                while (d.moveToNext()) {
                    b.append("id:  " + d.getString(0) + "\n");
                    b.append("Name:  " + d.getString(1) + "\n");

                }
                showl("Data", b.toString());


            }
        });
    }
        public void showl(String title,String message)
    {
        AlertDialog.Builder b=new AlertDialog.Builder(this);
        b.setCancelable(true);
        b.setTitle(title);
        b.setMessage(message);
        b.show();
    }
}


