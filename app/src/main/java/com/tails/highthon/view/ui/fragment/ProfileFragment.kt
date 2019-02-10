package com.tails.highthon.view.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.tails.highthon.R
import com.tails.highthon.data.models.Group
import com.tails.highthon.view.adapter.GroupAdapter
import kotlinx.android.synthetic.main.fragment_profile.*


class ProfileFragment : Fragment() {

    private val adapter by lazy { GroupAdapter() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        profileRecycler.layoutManager = LinearLayoutManager(context)
        profileRecycler.adapter = adapter
        profileRecycler.addItemDecoration(
            DividerItemDecoration(context, LinearLayoutManager(context).orientation))

        adapter.addItem(Group("비투비를 사랑하는 모임", "저희는 비투비를 좋아하는 그룹입니다.\n" +
                "티켓팅 많이 함께해요!"))
    }
}