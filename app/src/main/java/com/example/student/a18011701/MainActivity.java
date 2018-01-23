package com.example.student.a18011701;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.student.a18011701.data.DBType;
import com.example.student.a18011701.data.Student;
import com.example.student.a18011701.data.StudentDAO;
import com.example.student.a18011701.data.StudentDAOFactory;
import com.example.student.a18011701.data.StudentFileDAO;
import com.example.student.a18011701.data.StudentScoreDAO;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static StudentDAO dao;
    DBType dbType;
    ListView lv;
    ArrayList<String> studentNames;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbType = DBType.CLOUD; //選擇用哪個服務 => StudentDAOFactory
        dao = StudentDAOFactory.getDAOInstance(this,dbType);
        //dao = new StudentFileDAO(this); //new 物件
        studentNames = new ArrayList<>();
        adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, studentNames);
        lv = (ListView) findViewById(R.id.listview);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent it = new Intent(MainActivity.this, EditActivity.class);
                it.putExtra("id", dao.getList().get(position).id);
                startActivity(it);
            }
        });
    }

    @Override
    protected void onResume() {   //回此頁顯示項目
        super.onResume();
        refreshData();
    }

    public  void refreshData()
    {
        studentNames.clear();
        for(Student s : dao.getList())
        {
            studentNames.add(s.name);

        }
        adapter.notifyDataSetChanged();

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

