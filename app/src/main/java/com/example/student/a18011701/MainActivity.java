package com.example.student.a18011701;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.student.a18011701.data.Student;
import com.example.student.a18011701.data.StudentScoreDAO;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    final public static StudentScoreDAO dao = new StudentScoreDAO(); //new 物件
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {   //回此頁顯示項目
        super.onResume();
        lv = (ListView)findViewById(R.id.listview);
        ArrayList<String>studentName = new ArrayList<>(); // 讀陣列
        for (Student s : dao.getList())
        {
            studentName.add(s.name);
        }
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(MainActivity.this
        ,android.R.layout.simple_list_item_1,studentName); //畫介面
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
               Intent it = new Intent(MainActivity.this,EditActivity.class);
                it.putExtra("id", dao.getList().get(position).id);
               startActivity(it);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {    //放入main_menu, menu
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //放入右上角跳頁按鈕
        if (item.getItemId() == R.id.menu_add) ;
        {
            Intent it = new Intent(MainActivity.this, AddActivity.class);
            startActivity(it);
        }
        return super.onOptionsItemSelected(item);
    }


}
