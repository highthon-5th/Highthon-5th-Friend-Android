package com.tails.highthon.view.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.tails.highthon.R
import com.tails.highthon.data.models.Group
import com.tails.highthon.view.adapter.GroupJoinAdapter
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_search.*


class SearchFragment : Fragment() {

    private val adapter by lazy { GroupJoinAdapter() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchRecycler.layoutManager = LinearLayoutManager(context)
        searchRecycler.adapter = adapter
        searchRecycler.addItemDecoration(
            DividerItemDecoration(context, LinearLayoutManager(context).orientation)
        )

        searchEdit.setOnEditorActionListener { v, aid, e ->
            if (aid == EditorInfo.IME_ACTION_SEARCH) {
                adapter.addItem(Group("비투비를 사랑하는 모임", "저희는 비투비를 좋아하는 그룹입니다.\n" +
                        "티켓팅 많이 함께해요!"))
                return@setOnEditorActionListener true
            }
            false
        }
    }
}