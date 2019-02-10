package com.tails.highthon.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tails.highthon.BR
import com.tails.highthon.data.models.Comment
import com.tails.highthon.data.models.Group
import com.tails.highthon.databinding.ContentCommentItemBinding

class CommentAdapter : RecyclerView.Adapter<CommentAdapter.ViewHolder>(){

    var item = ArrayList<Comment>()

    fun addItem(comment: Comment) {
        item.add(comment)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ContentCommentItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = item.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(item[position])
    }

    class ViewHolder(private val binding: ContentCommentItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: Comment) {
            binding.setVariable(BR.comment, item)
        }
    }
}
