package com.example.portaltech

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_regitration.*
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.toast

class RegitrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regitration)

        btn_daftar.onClick{
            val dataUser = database.cekData(edt_regis_username.text.toString())
            if (!ValidatorNull()){
                return@onClick
            }else{
                if (dataUser != null){
                    toast("Username Telah Digunakan")
                }else{
                    InsertData()
                    BackHome()
                }
            }
        }
    }

    private fun InsertData(){
        database.use {
            insert(
                DataUser.TABLE_USER,
                DataUser.NAME to edt_regis_name.text.toString(),
                DataUser.USERNAME to edt_regis_username.text.toString(),
                DataUser.PASSWORD to edt_regis_password.text.toString(),
            )
            toast("Data Disimpan")
        }
    }

    private fun ValidatorNull(): Boolean{
        when{
            edt_regis_name.text.toString().isBlank()->{
                edt_regis_name.requestFocus()
                edt_regis_name.error = "Nama Tidak Boleh Kosong"
                return false
            }

            edt_regis_username.text.toString().isBlank()->{
                edt_regis_username.requestFocus()
                edt_regis_username.error = "Username Tidak Boleh Kosong"
                return false
            }

            edt_regis_password.text.toString().isBlank()->{
                edt_regis_password.requestFocus()
                edt_regis_password.error = "Password Tidak Boleh Kosong"
                return false
            }
            else -> return true
        }
    }

    private fun BackHome(){
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}