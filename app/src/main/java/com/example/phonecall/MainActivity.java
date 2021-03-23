package com.example.phonecall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText phonenumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.btn1);
        phonenumber=(EditText)findViewById(R.id.number);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_CALL);
                String number=phonenumber.getText().toString();

                if(number.trim().isEmpty())
                {
                    Toast.makeText(MainActivity.this,"Please Enter Your Number: ",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    intent.setData(Uri.parse("tel:"+number));
                }
                if(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED)
                {
                    Toast.makeText(MainActivity.this,"Please Grant Permission",Toast.LENGTH_SHORT).show();
                    requestpermission();
                }
                else
                {
                    startActivity(intent);
                }
            }
        });
    }
    private void requestpermission()
    {
        ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CALL_PHONE},1);
    }
}