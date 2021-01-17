package com.example.portaltech

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
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
            val dataUser = database.cekData(edt.text.toString())
            if(dataUser != null){
                if (dataUser.password.toString()==edt_login_password.text.toString()){
                    startActivity<Home>()
                    finish()
                }else{
                    toast("Username atau Password Salah")
                }

            }else{
                toast("Username atau Password Salah")
            }
        }
    }
}