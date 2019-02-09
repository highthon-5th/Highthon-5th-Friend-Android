package com.tails.highthon.view.viewholder

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder(private val view : View) :RecyclerView.ViewHolder(view), View.OnClickListener, View.OnLongClickListener{
    init {
        view.setOnClickListener(this)
        view.setOnLongClickListener(this)
    }
    /*
    private lateinit var things: THINGS
    private val binding by lazy { DataBindingUtil.bind<ItemDetailInfoBinding>(view) }
    */

    abstract fun bindData(data: Any)
/*    override fun bindData(data: Any) {
        if (data is things) {
            things = data
            draw()
        }
    }*/

    abstract fun draw()
/*    private fun drawItem() {
        itemView.run {
            binding?.things = things
            binding?.executePendingBindings()

            when (Patterns.WEB_URL.matcher(itemDetail.content).matches()) {
                true -> {
                    detail_info_content.textColor = ContextCompat.getColor(context, R.color.colorPrimaryDark)
                    Linkify.addLinks(detail_info_content, Linkify.WEB_URLS)
                }
                false -> detail_info_content.textColor = ContextCompat.getColor(context, R.color.white)
            }
        }
    }*/

    protected fun view() : View = view

    protected fun context() : Context = view.context

/*    override fun onClick(view: View) {
    }

    override fun onLongClick(view: View): Boolean {
        return false
    }*/
}