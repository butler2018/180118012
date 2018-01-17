package com.example.student.a18011701;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.student.a18011701.data.Student;

public class EditActivity extends AppCompatActivity {
    Student s;
    TextView tv1,tv2,tv3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        int id = getIntent().getIntExtra("id",0);
        s= MainActivity.dao.getStudent(id);
        tv1 = (TextView) findViewById(R.id.textView);
        tv2 = (TextView) findViewById(R.id.textView2);
        tv3 = (TextView) findViewById(R.id.textView3);
        tv1.setText(String.valueOf(s.id));
        tv2.setText(s.name);
        tv3.setText(String.valueOf(s.score));

    }

    public void clickBack(View v){
        Intent it = new Intent(EditActivity.this,MainActivity.class);
        startActivity(it);
    }
    public void clickDelete(View v)
    {



    }


    public void clickEdit(View v)
    {
        Intent it = new Intent(EditActivity.this,Edit1Activity.class);
        it.putExtra("id", 0);
        startActivity(it);
    }
}
