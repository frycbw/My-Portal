package com.example.portaltech.Test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.portaltech.DataUser
import com.example.portaltech.R
import com.example.portaltech.database
import kotlinx.android.synthetic.main.activity_test_user.*
import org.jetbrains.anko.db.classParser
import org.jetbrains.anko.db.select

class TestUser : AppCompatActivity() {

    var adapter: RVAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_user)

        val list = getListData()
        
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapter = RVAdapter(this,list)

        rv_test_user.layoutManager = layoutManager
        rv_test_user.adapter = adapter
    }

    private fun getListData(): List<DataUser>{
        var listData : List<DataUser>? = null
        database.use{
            var result = select(DataUser.TABLE_USER)
            listData = result.parseList(classParser<DataUser>())
        }
        return listData!!
    }

    override fun onResume() {
        super.onResume()

        val listRefresh = getListData()
        adapter = RVAdapter(this,listRefresh)
        adapter?.notifyDataSetChanged()
        rv_test_user.adapter = adapter
    }

}