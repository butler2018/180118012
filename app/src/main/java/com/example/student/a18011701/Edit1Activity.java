package com.example.student.a18011701;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Edit1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit1);
    }
    public void clickBack1(View v){
        Intent it = new Intent(Edit1Activity.this,EditActivity.class);
        startActivity(it);
    }

    public void clickEdit1(View v){
        Intent it = new Intent(Edit1Activity.this,EditActivity.class);
        startActivity(it);
    }


}
