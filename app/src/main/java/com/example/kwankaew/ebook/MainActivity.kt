package com.example.kwankaew.ebook

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.kwankaew.ebook.Model.Book
import com.example.kwankaew.ebook.Model.BookRepository
import com.example.kwankaew.ebook.Model.MockBookRepository
import com.example.kwankaew.ebook.Model.RealBookRepository
import com.example.kwankaew.ebook.presenter.BookPresenter
import com.example.kwankaew.ebook.presenter.BookView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , BookView{

    lateinit var present: BookPresenter
    lateinit var repositoty: BookRepository
    var adapter: ArrayAdapter<Book>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        repositoty = MockBookRepository()
        repositoty = RealBookRepository()
        present = BookPresenter(this,repositoty)
        present.start()
    }


    override fun setBookList(books: ArrayList<Book>) {
        println(books)
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, books)
        listView.adapter = adapter
    }
}
