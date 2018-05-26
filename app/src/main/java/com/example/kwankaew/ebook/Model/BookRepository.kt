package com.example.kwankaew.ebook.Model

import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by kwankaew on 30/3/2018 AD.
 */
abstract class BookRepository : Observable(){
    val bookList = ArrayList<Book>()
    abstract fun loadAllBooks()
    abstract fun getBooks(): ArrayList<Book>

}