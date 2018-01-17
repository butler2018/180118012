package com.example.student.a18011701;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.student.a18011701.data.Student;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }
    public void clickAdd(View v)
    {
        EditText ed1 = (EditText) findViewById(R.id.editText);
        EditText ed2 = (EditText) findViewById(R.id.editText2);
        EditText ed3 = (EditText) findViewById(R.id.editText3);//抓資料
                        // 轉int      抓放入ed1   轉字串
        int id = Integer.valueOf(ed1.getText().toString());
                          //抓放入ed1   轉字串
        String name = ed2.getText().toString();
        int score = Integer.valueOf(ed3.getText().toString());
                          // 放入陣列
        MainActivity.dao.add(new Student(id,name,score));
        finish();

    }



}
