package com.aldi.osakasequelstrip.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aldi.osakasequelstrip.Model.WisataModel
import com.aldi.osakasequelstrip.R
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class WisataAdapter(val listWisata: ArrayList<WisataModel>) : RecyclerView.Adapter<WisataAdapter.ListViewHolder> () {

    override fun getItemCount(): Int {
        return listWisata.size
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    interface OnItemClickCallback {
        fun onItemClicked(data: WisataModel)
    }
    inner class ListViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        var imgWisata : ImageView = itemView.findViewById(R.id.imageViewWisata)
        var namaWisata : TextView =  itemView.findViewById(R.id.tvNameWisata)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.list_wisata, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val wisata = listWisata[position]
        Glide.with(holder.itemView.context)
            .load(wisata.photoWisata)
            .apply(RequestOptions())
            .into(holder.imgWisata)
        holder.namaWisata.text = wisata.namaWisata
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listWisata[holder.adapterPosition])
        }
    }



}