package com.aldi.osakasequelstrip

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.aldi.osakasequelstrip.Adapter.BatchAdapter
import com.aldi.osakasequelstrip.Adapter.Endpoint
import com.aldi.osakasequelstrip.Model.BatchModel
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_batch.*
import org.json.JSONObject
import kotlin.collections.ArrayList

class BatchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_batch)

    }

    override fun onResume() {
        super.onResume()
        fan()
    }

fun fan(){
    val loading = ProgressDialog(this)
    loading.setMessage("Memuat data...")
    loading.show()
    var listBatch = ArrayList<BatchModel>()
   rvBatch.setHasFixedSize(true)
   rvBatch.layoutManager = LinearLayoutManager(this)
    AndroidNetworking.get(Endpoint.READ)
        .setPriority(Priority.MEDIUM)
        .build()
        .getAsJSONObject(object : JSONObjectRequestListener{

            override fun onResponse(response: JSONObject?) {
                listBatch.clear()

                val jsonArray = response?.optJSONArray("result")

                if(jsonArray?.length() == 0){
                    loading.dismiss()
                    Toast.makeText(applicationContext,"Data Batch Kosong",Toast.LENGTH_SHORT).show()
                }

                for(i in 0 until jsonArray?.length()!!){

                    val jsonObject = jsonArray?.optJSONObject(i)
                    listBatch.add(BatchModel(jsonObject.getInt("nomor"),
                        jsonObject.getString("batch"),
                        jsonObject.getString("musim"),
                        jsonObject.getString("durasi"),
                        jsonObject.getString("tglawal"),
                        jsonObject.getString("tglakhir"),
                        jsonObject.getString("destinasi")
                    ))

                    if(jsonArray?.length() - 1 == i){

                        loading.dismiss()
                       val adapter = BatchAdapter(applicationContext,listBatch)
                          adapter.notifyDataSetChanged()

                           rvBatch.adapter = adapter

                    }

                }

            }

            override fun onError(anError: ANError?) {
                loading.dismiss()
                Log.d("ONERROR",anError?.errorDetail?.toString())
                Toast.makeText(applicationContext,"Connection Failure",Toast.LENGTH_SHORT).show()
            }
        })
}
}


