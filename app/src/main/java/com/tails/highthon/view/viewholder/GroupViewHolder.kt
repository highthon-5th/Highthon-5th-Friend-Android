package com.tails.highthon.view.viewholder

import android.view.View
import androidx.databinding.DataBindingUtil
import com.tails.highthon.data.models.Group
import com.tails.highthon.databinding.GroupItemBinding

class GroupViewHolder(view : View) : BaseViewHolder(view) {
    override fun draw() {
        itemView.run {
            binding?.group = group
            binding?.executePendingBindings()
        }
    }

    private lateinit var group: Group
    private val binding by lazy { DataBindingUtil.bind<GroupItemBinding>(view) }

    @Throws(Exception::class)
    override fun bindData(data: Any) {
        if (data is Group) {
            group = data
            draw()
        }
    }

    override fun onClick(view: View) {
    }

    override fun onLongClick(view: View): Boolean {
        return false
    }
}
