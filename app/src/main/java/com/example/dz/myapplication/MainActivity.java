package com.example.dz.myapplication;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {

    //SharedPreferences文件名
    private final static String SharedPreferencesFileName="config";

    //键
    private final static String Key_UserName="UserName";
    private final static String Key_UserNum="UserNum";

    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获得SharedPreferences实例
        preferences=getSharedPreferences(SharedPreferencesFileName,
                MODE_PRIVATE);
        editor=preferences.edit();
        Button btnWrite=(Button)findViewById(R.id.Write);
        Button btnRead=(Button)findViewById(R.id.Read);
        //其它代码
        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //写入键值对
                final EditText nam =(EditText)findViewById(R.id.name);
                final EditText num =(EditText)findViewById(R.id.number);
                editor.putString(Key_UserName, nam.getText().toString());
                editor.putString(Key_UserNum, num.getText().toString());

                //提交修改，此处换成commit()也可以
                editor.apply();
            }

        });
        btnRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String strUserName = preferences.getString(Key_UserName, null);
                String strUserNumber = preferences.getString(Key_UserNum, null);
                if (strUserName != null && strUserNumber != null)
                    Toast.makeText(MainActivity.this, "学号:" + strUserName + "姓名:" + strUserNumber, Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this, "无数据", Toast.LENGTH_LONG).show();
            }
        });




    }
}
