package com.example.portaltech.Test

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.portaltech.DataUser
import com.example.portaltech.R
import com.example.portaltech.UpdateUser
import com.example.portaltech.database
import kotlinx.android.synthetic.main.item_list.view.*
import org.jetbrains.anko.db.delete
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class RVAdapter(val ctx: Context, val items: List<DataUser>)
    : RecyclerView.Adapter<RVAdapter.ViewHolder>(){

    lateinit var itemview: View

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        itemview = LayoutInflater.from(ctx).inflate(R.layout.item_list, parent, false)
        return ViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        fun bindItem(items: DataUser){
            itemView.item_list_nama.text = items.name
            itemView.item_list_username.text = items.username
            itemView.item_list_password.text = items.password

            itemView.btn_update_user.setOnClickListener {
                itemView.context.startActivity<UpdateUser>(
                    "oldName" to items.name,
                    "oldUsername" to items.username,
                    "oldPassword" to items.password
                )
            }

            itemView.btn_delete_user.setOnClickListener {
                itemView.context.database.use {
                    delete(DataUser.TABLE_USER,"${DataUser.USERNAME} = {username}",
                        "username" to items.username!!.toString())
                }
                itemView.context.toast("Data dihapus")
            }
        }
    }
}