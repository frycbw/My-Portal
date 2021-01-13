package com.example.portaltech

import android.content.Context
import org.jetbrains.anko.db.*
import android.database.sqlite.SQLiteDatabase

class DatabaseHelper(context: Context): ManagedSQLiteOpenHelper(context, "portal_tech.db", null, 1){
    companion object{
        private var instance : DatabaseHelper? = null
        @Synchronized
        fun getInstance(conntext: Context): DatabaseHelper{
            if(instance == null){
                instance = DatabaseHelper(conntext)
            }
            return instance as DatabaseHelper
        }
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.createTable(
            DataUser.TABLE_USER,
            true,
            DataUser.NAME to TEXT,
            DataUser.USERNAME to TEXT + PRIMARY_KEY,
            DataUser.PASSWORD to TEXT
        )
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.dropTable(DataUser.TABLE_USER, true)
    }
}
val Context.database: DatabaseHelper
    get() = DatabaseHelper.getInstance(applicationContext)