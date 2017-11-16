package com.example.clapp_project;

/**
 * Created by fawzan on 11/16/17.
 */

import android.app.Application;


import com.example.clapp_project.db.DaoMaster;
import com.example.clapp_project.db.DaoSession;
import com.example.clapp_project.db.User;

import org.greenrobot.greendao.database.Database;

/**
 * Created by Akinsete on 1/14/16.
 */

public class AppController extends Application {
    private DaoSession mDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        mDaoSession = new DaoMaster(
                new DaoMaster.DevOpenHelper(this, "greendao_demo.db").getWritableDb()).newSession();

        // USER CREATION FOR DEMO PURPOSE
        if (mDaoSession.getUserDao().loadAll().size() == 0) {
            mDaoSession.getUserDao().insert(new User(1L, "Fawzan"));
        }
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

}