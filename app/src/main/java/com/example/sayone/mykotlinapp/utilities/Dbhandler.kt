package com.example.sayone.mykotlinapp.utilities

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.sayone.mykotlinapp.model.Person

class Dbhandler(context: Context): SQLiteOpenHelper(context,"Persons",null, DATABASE_VERSION) {

    companion object {
        val DATABASE_VERSION = 1
        private val TABLE_NAME="Persons"
        private val KEY_ID="Pid"
        private val KEY_NAME="Pname"
        private val KEY_EMAIL="Pemail"
        private val KEY_PHONE="Pphone"
        private val KEY_PASS="Ppass"
        private val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${TABLE_NAME}"
        val QUERY_TAG ="query"


    }

    override fun onCreate(db: SQLiteDatabase?) {
        val query:String="CREATE TABLE ${TABLE_NAME}( ${KEY_ID} INTEGER PRIMARY KEY , ${KEY_NAME} TEXT ,${KEY_EMAIL} TEXT , ${KEY_PHONE} TEXT, ${KEY_PASS} TEXT )"
        if (db != null) {
            db.execSQL(query)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        if (db != null) {
            db.execSQL(SQL_DELETE_ENTRIES)
            onCreate(db)
        }
    }

    fun insertUser(person:Person):Boolean{
        val db = writableDatabase
        val values=ContentValues()
        values.put("Pname",person.name)
        values.put("Pemail",person.email)
        values.put("Pphone",person.phone)
        values.put("Ppass",person.password)

        val newRow = db.insert(TABLE_NAME,null,values)
        return true

    }

    fun getUser(email:String,pass:String):Boolean{

        val db = readableDatabase
        var QUERY = "SELECT * FROM ${TABLE_NAME} WHERE ${KEY_EMAIL}='${email}' and ${KEY_PASS}='${pass}'"
        Log.e(QUERY_TAG,QUERY)
        var cursor:Cursor = db.rawQuery(QUERY,null)
        if (cursor.moveToFirst()){
            cursor.close()
            db.close()
            return true
        }
        else{
            cursor.close()
            db.close()
            return false
        }



    }

}

