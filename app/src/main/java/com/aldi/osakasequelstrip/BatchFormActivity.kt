package com.aldi.osakasequelstrip

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
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
        if(i.hasExtra("edit")){

            if(i.getStringExtra("edit").equals("1")){
                editMode()
            }

        }
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

        btnBatchUpdate.setOnClickListener{
            update()
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
                    Toast.makeText(applicationContext,"Koneksi Gagal", Toast.LENGTH_SHORT).show()                    }
            })
    }

    private fun update(){
        val loading = ProgressDialog(this)
        loading.setMessage("Update data...")
        loading.show()
        AndroidNetworking.post(Endpoint.UPDATE)
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
                    Toast.makeText(applicationContext,"Koneksi Gagal", Toast.LENGTH_SHORT).show()                    }
            })
    }

    private fun editMode() {

        etBatch.setText(i.getStringExtra("batch"))
        musim = i.getStringExtra("musim")
        rgMusim.setOnCheckedChangeListener { radioGroup, i ->
            when (i) {
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
        etDurasi.setText(i.getStringExtra("durasi"))
        etTglAwal.setText(i.getStringExtra("tglawal"))
        etTglAkhir.setText(i.getStringExtra("tglakhir"))
        etDestinasi.setText(i.getStringExtra("destinasi"))
        etBatch.isEnabled = false

        btnBatchAdd.visibility = View.GONE
        btnBatchUpdate.visibility = View.VISIBLE
        btnBatchDelete.visibility = View.VISIBLE
    }
}
