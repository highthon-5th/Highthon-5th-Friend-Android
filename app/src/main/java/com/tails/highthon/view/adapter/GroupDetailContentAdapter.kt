package com.tails.highthon.view.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tails.highthon.BR
import com.tails.highthon.data.models.Content
import com.tails.highthon.databinding.GroupDetailContentBinding
import com.tails.highthon.view.ui.activity.ContentDetailActivity
import com.tails.highthon.view.ui.activity.GroupDetailActivity

class GroupDetailContentAdapter : RecyclerView.Adapter<GroupDetailContentAdapter.ViewHolder>(), View.OnClickListener {

    private var item = ArrayList<Content>()

    fun addItem(content: Content) {
        item.add(content)
        notifyDataSetChanged()
    }

    fun reverse(){
        item.reverse()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = GroupDetailContentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = item.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(item[position])
        holder.itemView.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val intent = Intent(view.context, ContentDetailActivity::class.java)
        view.context.startActivity(intent)
    }

    class ViewHolder(private val binding: GroupDetailContentBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: Content) {
            binding.setVariable(BR.content, item)
        }
    }
}
