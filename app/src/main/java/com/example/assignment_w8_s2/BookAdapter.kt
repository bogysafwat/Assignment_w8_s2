package com.example.assignment_w8_s2

import android.icu.text.Transliterator.Position
import android.media.Rating
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.assignment_w8_s2.databinding.ItemBookBinding

class BookAdapter(val books:List<Books>):ListAdapter<Books,BookAdapter.BookViewHolder>(BookItemDiffCallBack()){
    class BookViewHolder(val binding: ItemBookBinding):RecyclerView.ViewHolder(binding.root){
        companion object{
            fun from (parent: ViewGroup):BookViewHolder{
                val layoutInflater=LayoutInflater.from(parent.context)
                val binding=ItemBookBinding.inflate(layoutInflater,parent,false)
                return BookViewHolder(binding)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        return BookViewHolder.from(parent)

    }

    override fun getItemCount(): Int {
      return books.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
      holder.binding.book=books.get(position)
    }
}

class BookItemDiffCallBack:DiffUtil.ItemCallback<Books>() {
    override fun areItemsTheSame(oldItem: Books, newItem: Books): Boolean {
        return oldItem==newItem
    }

    override fun areContentsTheSame(oldItem: Books, newItem: Books): Boolean {
     return oldItem==newItem
    }

}
