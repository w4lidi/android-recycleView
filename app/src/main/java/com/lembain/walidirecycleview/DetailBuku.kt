package com.lembain.walidirecycleview

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.bumptech.glide.Glide

class DetailBuku() : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.TIRAMISU)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_buku)
       val img :ImageView = findViewById(R.id.imageView)
        val judul : TextView = findViewById(R.id.textJudul)
        val decs : TextView = findViewById(R.id.textDetail)

        val objRecv = intent.getParcelableExtra(EXTRA_NAME, Book::class.java)

        Glide.with(this).load(objRecv?.photo).into(img)

        judul.text = objRecv?.name
        decs.text = objRecv?.description
    }

    companion object {
        val EXTRA_NAME: String? = "extra_data"
    }
}