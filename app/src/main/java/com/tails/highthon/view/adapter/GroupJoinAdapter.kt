package com.tails.highthon.view.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tails.highthon.BR
import com.tails.highthon.R
import com.tails.highthon.data.models.Group
import com.tails.highthon.databinding.GroupItemBinding
import com.tails.highthon.view.ui.activity.GroupDetailJoinActivity
import kotlinx.android.synthetic.main.group_item.view.*

class GroupJoinAdapter : RecyclerView.Adapter<GroupJoinAdapter.ViewHolder>(), View.OnClickListener {

    var item = ArrayList<Group>()

    fun addItem(group: Group) {
        item.add(group)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = GroupItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = item.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(item[position])
        when(position){
            0-> holder.itemView.groupImage.setImageResource(R.drawable.a)
            1-> holder.itemView.groupImage.setImageResource(R.drawable.b)
            2-> holder.itemView.groupImage.setImageResource(R.drawable.c)
            3-> holder.itemView.groupImage.setImageResource(R.drawable.d)
        }
        holder.itemView.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val intent = Intent(view.context, GroupDetailJoinActivity::class.java)
        view.context.startActivity(intent)
    }

    class ViewHolder(private val binding: GroupItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item: Group) {
            binding.setVariable(BR.group, item)
        }
    }
}
