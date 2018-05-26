package com.example.kwankaew.ebook.Model

import android.os.AsyncTask
import com.beust.klaxon.JsonReader
import com.beust.klaxon.Klaxon
import java.io.StringReader
import java.net.URL
/**
 * Created by kwankaew on 30/3/2018 AD.
 */
class RealBookRepositoty:BookRepository() {
    val bookList = ArrayList<Book>()
    override fun loadAllBooks() {
        bookList.clear()
        val task = BookLoaderTask()
        task.execute()
    }

    override fun getBooks(): ArrayList<Book> {
        return bookList
    }


    inner class BookLoaderTask: AsyncTask<String,Unit,String>(){
        override fun doInBackground(vararg p0: String?): String {
            val url = URL("https://theory.cpe.ku.ac.th/~jittat/courses/sw-spec/ebooks/books.json")
            val json = url.readText()
            return  json
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            if(result != null){
                val kalxon = Klaxon()
                JsonReader(StringReader(result)).use { reader ->
                    reader.beginArray {
                        while (reader.hasNext()) {
                            kalxon.parse<Book>(reader)?.let { bookList.add(it) }
                        }
                    }
                }
            }

            setChanged()
            notifyObservers()
        }

    }
}