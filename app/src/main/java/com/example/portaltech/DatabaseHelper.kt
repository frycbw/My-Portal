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
        p0?.createTable(
            DataNews.TABLE_NEWS,
            true,
            DataNews.TITLE to TEXT,
            DataNews.TANGGAL to TEXT,
            DataNews.NEWS to TEXT,
            DataNews.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            DataNews.IMAGE to TEXT
        )
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.dropTable(DataUser.TABLE_USER, true)
        p0?.dropTable(DataNews.TABLE_NEWS, true)
    }
}
val Context.database: DatabaseHelper
    get() = DatabaseHelper.getInstance(applicationContext)