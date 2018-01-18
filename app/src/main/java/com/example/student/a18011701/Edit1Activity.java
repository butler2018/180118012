package com.example.student.a18011701;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.student.a18011701.data.Student;

public class Edit1Activity extends AppCompatActivity {
    int id;
    Student s;
    TextView tv4;
    EditText ed5,ed6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit1);

        id = getIntent().getIntExtra("id",0);
        s = MainActivity.dao.getStudent(id);
        tv4 = (TextView) findViewById(R.id.textView4);
        ed5 = (EditText) findViewById(R.id.editText5);
        ed6 = (EditText) findViewById(R.id.editText6);
        tv4.setText(String.valueOf(s.id));
        ed5.setText(s.name);
        ed6.setText(String.valueOf(s.score));
  }
    public void clickBBack(View v){
//        Intent it = new Intent(Edit1Activity.this,EditActivity.class);
//        it.putExtra("id", s.id);
//        startActivity(it);
          finish();
    }

    public void clickUpdate(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(Edit1Activity.this);
        builder.setTitle("確認更新");
        builder.setMessage("確認要更新本筆資料嗎?");
        builder.setPositiveButton("確認", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Student s = new Student(id,ed5.getText().toString(),
                        Integer.valueOf(ed6.getText().toString()));

//                int id = Integer.valueOf(tv4.getText().toString());
//                String name = ed5.getText().toString();
//                int score = Integer.valueOf(ed6.getText().toString());
            //    MainActivity.dao.update(new Student(id,name,score));

                MainActivity.dao.update(s);
                Intent it = new Intent(Edit1Activity.this,EditActivity.class);
                it.putExtra("id", id);
                startActivity(it);
            }
        });
        builder.setNeutralButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.show();
   }

}
