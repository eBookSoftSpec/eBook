package com.example.kwankaew.ebook.presenter

import com.example.kwankaew.ebook.Model.BookRepository
import java.util.*

/**
 * Created by kwankaew on 30/3/2018 AD.
 */
class BookPresenter(val view: BookView,
                   val repository: BookRepository):Observer {
    fun start(){
        repository.addObserver(this)
        repository.loadAllBooks()

    }
    override fun update(obj: Observable?, arg: Any?) {
        if(obj == repository){
            view.setBookList(repository.getBooks())
        }
    }
}