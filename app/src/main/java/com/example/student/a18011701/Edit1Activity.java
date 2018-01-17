package com.example.student.a18011701;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.student.a18011701.data.Student;

public class Edit1Activity extends AppCompatActivity {
    Student s;
    TextView tv4;
    EditText ed5,ed6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit1);

        int id = getIntent().getIntExtra("id",0);
        s = MainActivity.dao.getStudent(id);
        tv4 = (TextView) findViewById(R.id.textView4);
        ed5 = (EditText) findViewById(R.id.editText5);
        ed6 = (EditText) findViewById(R.id.editText6);
        tv4.setText(String.valueOf(s.id));
        ed5.setText(s.name);
        ed6.setText(String.valueOf(s.score));



    }
    public void clickBBack(View v){
        Intent it = new Intent(Edit1Activity.this,EditActivity.class);
        it.putExtra("id", s.id);
        startActivity(it);
    }

    public void clickEdit1(View v){

        int id = Integer.valueOf(tv4.getText().toString());
        String name = ed5.getText().toString();
        int score = Integer.valueOf(ed6.getText().toString());

        MainActivity.dao.update(new Student(id,name,score));
        Intent it = new Intent(Edit1Activity.this,MainActivity.class);
        startActivity(it);

    }


}
