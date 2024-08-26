package com.example.assignment_w8_s2

import android.icu.text.Transliterator.Position
import android.media.Rating
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class BookAdapter(val books:List<Books>):RecyclerView.Adapter<BookAdapter.BookViewHolder>(){
    class BookViewHolder(val row:View):RecyclerView.ViewHolder(row){
        val tvTitel=row.findViewById<TextView>(R.id.tv_title)
        val tvAuther=row.findViewById<TextView>(R.id.tv_author)
        val ivbook=row.findViewById<ImageView>(R.id.iv_book)
        val bookrate=row.findViewById<RatingBar>(R.id.rating_bar)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {

        val layout=LayoutInflater.from(parent.context).inflate(R.layout.item_book,parent,false)
        return BookViewHolder(layout)
    }

    override fun getItemCount(): Int {
      return books.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
       val book=books.get(position)
        holder.tvTitel.text=book.title
        holder.tvAuther.text=book.author
        holder.ivbook.setImageDrawable(holder.ivbook.context.getDrawable(book.imge))
        holder.bookrate.rating=book.rating
    }
}