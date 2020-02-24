package com.aldi.osakasequelstrip.Adapter


import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.aldi.osakasequelstrip.BatchFormActivity
import com.aldi.osakasequelstrip.Model.BatchModel
import com.aldi.osakasequelstrip.R
import kotlinx.android.synthetic.main.activity_batch.view.*
import kotlinx.android.synthetic.main.list_batch.view.*


class BatchAdapter(private val context: Context, private val listBatch: ArrayList<BatchModel>) : RecyclerView.Adapter<BatchAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent.context).inflate(R.layout.list_batch,parent,false))
    }

    override fun getItemCount(): Int = listBatch!!.size

    override fun onBindViewHolder(holder: Holder, position: Int) {

        holder.view.tvBatch.text = listBatch?.get(position)?.batch
        holder.view.tvMusim.text = "Musim : "+listBatch?.get(position)?.musim
        holder.view.tvDurasi.text = "Durasi : "+listBatch?.get(position)?.durasi
        holder.view.tvTgl.text = "Tanggal Keberangkatan : "+listBatch?.get(position)?.tglawal

        holder.view.cvList.setOnClickListener {
            val update = Intent(context,BatchFormActivity::class.java)
            update.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                 update.putExtra("edit","1")
                update.putExtra("batch", listBatch?.get(position)?.batch)
                update.putExtra("musim",listBatch?.get(position)?.musim)
                update.putExtra("durasi",listBatch?.get(position)?.durasi)
                update.putExtra("tglawal",listBatch?.get(position)?.tglawal)
                update.putExtra("tglakhir",listBatch?.get(position)?.tglakhir)
                update.putExtra("destinasi",listBatch?.get(position)?.destinasi)
            context.startActivity(update)
        }
    }



    class Holder(val view:View) : RecyclerView.ViewHolder(view)

}