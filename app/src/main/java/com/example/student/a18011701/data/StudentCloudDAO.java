package com.example.student.a18011701.data;

import android.content.Context;

import com.example.student.a18011701.MainActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 *  1.StudentCloudDAO(final Context context)
 *  2. ValueEventListener()  => a)onDataChange(DataSnapshot dataSnapshot)  b)onCancelled
 *  3.  boolean add(Student s)
 *  4.  void saveFile()
 *  5.  ArrayList<Student> getList()
 *  6.  Student getStudent(int id)
 *  7.  boolean update(Student s)
 *  8.  boolean delete(int id)
 *  9.  boolean delete(int id)
 *
 * Created by Student on 2018/1/18.
 */

public class StudentCloudDAO implements StudentDAO {
    public ArrayList<Student> mylist;
    Context context;
    FirebaseDatabase database;
    DatabaseReference myRef;

    public StudentCloudDAO(final Context context)
    {
        this.context = context;
        mylist = new ArrayList<>();
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("scores");
        myRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Gson gson = new Gson();
                mylist = gson.fromJson(value, new TypeToken<ArrayList<Student>>(){}.getType());
                if (mylist == null)   //若 mylist 為null,new ArrayList
                {
                    mylist = new ArrayList<>();
                }
                ((MainActivity)context).refreshData();
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value

            }
        });

    }

    public boolean add(Student s)
    {
        if (mylist == null)                 //若 mylist 為null,new ArrayList
        {
            mylist = new ArrayList<>();
        }

        mylist.add(s);
        saveFile();
        return true;
    }

    private void saveFile()
    {
        // Write a message to the database
        Gson gson = new Gson();
        String data = gson.toJson(mylist);


        myRef.setValue(data);
    }

    public ArrayList<Student> getList()
    {
        return mylist;
    }

    public Student getStudent(int id)
    {
        for (Student s : mylist)
        {
            if (s.id == id)
            {
                return s;
            }
        }
        return null;
    }
    public boolean update(Student s)
    {
        for (Student t : mylist)
        {
            if (t.id == s.id)
            {
                t.name = s.name;
                t.score = s.score;
                saveFile();
                return true;
            }
        }
        return false;
    }
    public boolean delete(int id)
    {
        for (int i=0;i<mylist.size();i++)
        {
            if (mylist.get(i).id == id)
            {
                mylist.remove(i);
                saveFile();
                return true;
            }
        }
        return false;
    }
}



