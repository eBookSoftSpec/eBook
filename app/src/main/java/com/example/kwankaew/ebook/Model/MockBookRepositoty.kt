package com.example.kwankaew.ebook.Model

import android.os.AsyncTask
import java.net.URL

/**
 * Created by kwankaew on 30/3/2018 AD.
 */
class MockBookReposity :BookRepositoty(){
    val bookList = ArrayList<Book>()
    override fun loadAllBooks() {
        bookList.clear()
        bookList.add(Book(1,"AAA",120.0))
        bookList.add(Book(2,"BBB",150.0))
        bookList.add(Book(3,"CCC",200.0))
        setChanged()
        notifyObservers()


    }

    override fun getBooks(): ArrayList<Book> {
        return bookList
    }

}