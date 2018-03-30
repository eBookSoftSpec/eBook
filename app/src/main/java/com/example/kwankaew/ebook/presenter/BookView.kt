package com.example.kwankaew.ebook.presenter

import com.example.kwankaew.ebook.Model.Book

/**
 * Created by kwankaew on 30/3/2018 AD.
 */
interface BookView {
    fun setBookList(books : ArrayList<Book>)
}