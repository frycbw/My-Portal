package com.example.portaltech

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.portaltech.Test.TestUser
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvw_link_daftar.setOnClickListener {
            startActivity(Intent(this, RegitrationActivity::class.java))
        }

        btn_masuk.setOnClickListener {
            startActivity<Home>()
            finish()
        }
    }
}