package com.example.portaltech

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.portaltech.Test.TestUser
import kotlinx.android.synthetic.main.activity_update_user.*
import org.jetbrains.anko.db.update
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class UpdateUser : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_user)

        val oldName = intent.getStringExtra("oldName")
        val oldUsername = intent.getStringExtra("oldUsername")
        val oldPassword = intent.getStringExtra("oldPassword")

        if(oldUsername.isNullOrBlank()){
            startActivity<TestUser>()
        }else{
            edt_update_name.setText(oldName)
            edt_update_username.setText(oldUsername)
            edt_update_password.setText(oldPassword)

            btn_update_data_user.setOnClickListener{
                database.use {
                    update(
                        DataUser.TABLE_USER,
                        DataUser.NAME to edt_update_name.text.toString(),
                        DataUser.USERNAME to edt_update_username.text.toString(),
                        DataUser.PASSWORD to edt_update_password.text.toString(),)
                        .whereArgs("${DataUser.USERNAME} = {username}",
                            "username" to oldUsername)
                        .exec()
                }
                toast("Data diperbarui")
                startActivity<TestUser>()
            }
        }
    }
}