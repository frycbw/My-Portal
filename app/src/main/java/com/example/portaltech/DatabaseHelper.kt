package com.example.portaltech

import android.content.Context
import android.database.Cursor
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

    fun cekData(username: String?): DataUser? {
        val query =
            "SELECT * FROM ${DataUser.TABLE_USER} WHERE ${DataUser.USERNAME} =  \"$username\""

        val db = this.writableDatabase
        val cursor = db.rawQuery(query,null)
        var dataUser: DataUser? = null

        if(cursor.moveToFirst()){
            cursor.moveToFirst()

            val nama = cursor.getString(0)
            val username_ = cursor.getString(1)
            val password = cursor.getString(2)

            dataUser = DataUser(nama,username_,password)
            cursor.close()
        }
        db.close()
        return dataUser
    }
}
val Context.database: DatabaseHelper
    get() = DatabaseHelper.getInstance(applicationContext)