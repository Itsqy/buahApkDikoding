package com.example.submissiondikoding

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class BuahAdapter(val listBuah: ArrayList<Buah>) :
    RecyclerView.Adapter<BuahAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvAsal: TextView = itemView.findViewById(R.id.tv_item_native)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuahAdapter.ListViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_row_buah, parent,false )
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: BuahAdapter.ListViewHolder, position: Int) {
        val (name, asal, photo, desc) = listBuah[position]

        Glide.with(holder.itemView.context)
            .load(photo)
            .apply(RequestOptions())
            .into(holder.imgPhoto)

        holder.tvName.text = name
        holder.tvAsal.text = asal

        val context = holder.itemView.context

        holder.itemView.setOnClickListener {
            val moveDetail = Intent(context, DetailBuahActivity::class.java)
            moveDetail.putExtra(DetailBuahActivity.EXTRA_ASAL, asal)
            moveDetail.putExtra(DetailBuahActivity.EXTRA_NAME, name)
            moveDetail.putExtra(DetailBuahActivity.EXTRA_IMG, photo)
            moveDetail.putExtra(DetailBuahActivity.EXTRA_DESC, desc)

            context.startActivity(moveDetail)
        }
    }

    override fun getItemCount(): Int {
        return listBuah.size
    }
}