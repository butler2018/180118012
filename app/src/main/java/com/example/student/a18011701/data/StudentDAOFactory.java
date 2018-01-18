package com.example.student.a18011701.data;

import android.content.Context;

/**
 * Created by Student on 2018/1/18.
 */

public class StudentDAOFactory {
    public static StudentDAO getDAOInstance(Context context, DBType dbType)
    {
        switch (dbType) {
            case MEMORY:
                return new StudentScoreDAO();

            case FILE:
                return new StudentFileDAO(context);

        }
        return  null;


        }
    }






