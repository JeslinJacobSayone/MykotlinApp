package com.example.sayone.mykotlinapp.app;

import android.app.Application;
import android.widget.Toast;

import com.example.sayone.mykotlinapp.model.Person;
import com.example.sayone.mykotlinapp.utilities.Dbhandler;

public class AppClass extends Application{

    private Person mPerson;
    private static AppClass mAppClass;
    @Override
    public void onCreate() {
        super.onCreate();
        mAppClass=this;
        mPerson=new Person();
    }

    public static AppClass getApp(){
        return mAppClass;
    }

    public void setPerson(String name , String email , String ph , String pass){
        mPerson.name=name;
        mPerson.email=email;
        mPerson.phone= ph;
        mPerson.password=pass;

        Dbhandler dbhandler = new Dbhandler(getApplicationContext());
        boolean result=dbhandler.insertUser(mPerson);
        if(result){
            Toast.makeText(getApplicationContext(), "inserted succesfully", Toast.LENGTH_SHORT).show();
        }

    }

    public Person getPerson() {
        return mPerson;
    }
}
