package com.example.kwankaew.ebook.Model

import android.os.AsyncTask
import android.util.JsonReader
import com.beust.klaxon.Klaxon
import java.io.StringReader
import java.net.URL

class LoadBookRepository:BookRepository() {

    val booklist = ArrayList<Book>()

    override fun loadAllBooks(){
        booklist.clear()
    }

    override fun getBooks(): ArrayList<Book> {
        return booklist
    }

    inner class BookLoaderTask: AsyncTask<String,Unit,String>(){
        override fun doInBackground(vararg p0: String?): String {
            val url = URL("https://theory.cpe.ku.ac.th/~jittat/courses/sw-spec/ebooks/books.json")
            val json = url.readText();
            return json
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            if(result != null) {
                val klaxon = Klaxon()
                JsonReader(StringReader(result)).use { reader ->
                    reader.beginArray {
                        while (reader.hasNext()) {
                            klaxon.parse<Book>(reader)?.let { booklist.add(it) }
                        }
                    }
                }
            }
        }

    }
}

private fun JsonReader.beginArray(function: () -> Unit) {

}

