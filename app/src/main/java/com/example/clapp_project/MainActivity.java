package com.example.clapp_project;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.clapp_project.db.DaoSession;
import com.example.clapp_project.db.User;
import com.example.clapp_project.db.UserDao;

public class MainActivity extends AppCompatActivity {


    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.name);

        //create a session
        DaoSession daoSession = ((AppController) getApplication()).getDaoSession();

        //get the session for relevant Object
        UserDao userDao = daoSession.getUserDao();

        //load the object
        User u1 = userDao.load(1L);

        if (u1 != null) {

            tv.setText(u1.getName());
        }
    }


}
