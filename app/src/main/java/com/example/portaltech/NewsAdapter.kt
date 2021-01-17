package com.example.portaltech

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.portaltech.Test.RVAdapter
import kotlinx.android.synthetic.main.news_list.view.*
import kotlinx.android.synthetic.main.news_list.view.tv_judul_berita
import kotlinx.android.synthetic.main.news_list.view.tv_tanggal_berita
import kotlinx.android.synthetic.main.update_news_list.view.*

class NewsAdapter(val ctx: Context,val items: List<DataUser>)
    : RecyclerView.Adapter<RVAdapter.ViewHolder>() {

    lateinit var itemview: View

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RVAdapter.ViewHolder {
        itemview = LayoutInflater.from(ctx).inflate(R.layout.item_list, parent, false)
        return RVAdapter.ViewHolder(itemview)
    }

    override fun onBindViewHolder(holder: RVAdapter.ViewHolder, position: Int) {
        holder.bindItem(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        fun bindItem(items: DataNews){
            itemView.tv_judul_berita.text = items.title
            itemView.tv_tanggal_berita.text = items.tanggal
            itemView.btn_update_portal_saya.setOnClickListener {

            }
            itemView.btn_delete_portal_saya.setOnClickListener {

            }
        }
    }
}