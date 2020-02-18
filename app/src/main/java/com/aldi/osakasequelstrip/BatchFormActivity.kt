package com.aldi.osakasequelstrip

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.aldi.osakasequelstrip.Adapter.Endpoint
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.activity_batch_form.*
import org.json.JSONObject

class BatchFormActivity : AppCompatActivity() {
    lateinit var i : Intent
    private var musim = "Spring"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_batch_form)
        i = intent
        rgMusim.setOnCheckedChangeListener { radioGroup, i ->
        when(i){
        R.id.radioSpring -> {
            musim = "Spring"
        }

            R.id.radioFall -> {
                musim = "Fall"
            }

            R.id.radioSummer -> {
                musim = "Summer"
            }

            R.id.radioSpring -> {
                musim = "Winter"
            }
        }
        }

        btnBatchAdd.setOnClickListener {
            create()
        }
    }


    private fun create(){
        val loading = ProgressDialog(this)
        loading.setMessage("Menambahkan data...")
        loading.show()
        AndroidNetworking.post(Endpoint.CREATE)
            .addBodyParameter("batch",etBatch.text.toString())
            .addBodyParameter("musim",musim)
            .addBodyParameter("durasi",etDurasi.text.toString())
            .addBodyParameter("tglawal",etTglAwal.text.toString())
            .addBodyParameter("tglakhir",etTglAkhir.text.toString())
            .addBodyParameter("destinasi",etDestinasi.text.toString())
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONObject(object : JSONObjectRequestListener {

                override fun onResponse(response: JSONObject?) {

                    loading.dismiss()
                    Toast.makeText(applicationContext,response?.getString("message"),Toast.LENGTH_SHORT).show()

                    if(response?.getString("message")?.contains("successfully")!!){
                        this@BatchFormActivity.finish()
                    }

                }
                override fun onError(anError: ANError?) {
                    loading.dismiss()
                    Log.d("ONERROR",anError?.errorDetail?.toString())
                    Toast.makeText(applicationContext,"Connection Failure", Toast.LENGTH_SHORT).show()                    }

            })

    }
}
