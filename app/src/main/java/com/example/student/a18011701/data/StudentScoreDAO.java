package com.example.student.a18011701.data;

import com.example.student.a18011701.MainActivity;
import com.example.student.a18011701.data.Student;
import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Student on 2018/1/17.
 */

public class StudentScoreDAO implements StudentDAO {
     public ArrayList<Student> mylist;

    public StudentScoreDAO() {

        mylist = new ArrayList<>();
    }



    public boolean add(Student s) {
        mylist.add(s);


        return true;
    }


    public ArrayList<Student> getList() {
        return mylist;
    }

    public Student getStudent(int id) {
        for (Student s : mylist) {
            if (s.id == id) {
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
                return true;
            }

        }return false;
    }



    public boolean delete(int id) {
        for (int i =0;i<=mylist.size();i++) {
            if (mylist.get(i).id == id)
            {
                 mylist.remove(i);
                return true;
            }

        }
        return false;
    }

}
