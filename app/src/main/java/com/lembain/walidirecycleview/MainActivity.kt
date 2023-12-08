package com.lembain.walidirecycleview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), RecyclerViewClickListener {

    private lateinit var rvBooks: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rvBooks = findViewById(R.id.rv_book)
        rvBooks.setHasFixedSize(true)

        rvBooks.layoutManager = LinearLayoutManager(this)
        val listBookAdapter = ListBookAdapter(listBook)
        rvBooks.adapter = listBookAdapter

        val listHeroAdapter = ListBookAdapter(listBook)
        rvBooks.adapter = listHeroAdapter
        listHeroAdapter.clickListener = this
    }

    private val listBook: ArrayList<Book>
        get() {
            val dataName = resources.getStringArray(R.array.data_name)
            val dataDescription = resources.getStringArray(R.array.data_description)
            val dataPhoto = resources.getStringArray(R.array.data_photo)
            val listBook = ArrayList<Book>()
            for (i in dataName.indices) {
                val book = Book(dataName[i], dataDescription[i], dataPhoto[i])
                listBook.add(book)
            }
            return listBook
        }

    override fun onItemClickListener(view: View, book: Book) {

        //Toast.makeText(this, "Hallo ${book.name}", Toast.LENGTH_LONG).show()

        val detailActivity = Intent(this@MainActivity, DetailBuku::class.java)
        detailActivity.putExtra(DetailBuku.EXTRA_NAME, book)
//        intent.getParcelableExtra<Person>(EXTRA_PERSON, Person::class.java)

        startActivity(detailActivity)
    }


}