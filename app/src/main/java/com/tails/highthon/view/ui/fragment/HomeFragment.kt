package com.tails.highthon.view.ui.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.tails.highthon.R
import com.tails.highthon.data.models.Group
import com.tails.highthon.view.adapter.GroupJoinAdapter
import com.tails.highthon.view.ui.activity.CreateGroupActivity
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(), View.OnClickListener {
    override fun onClick(v: View?) {
        val intent = Intent(context, CreateGroupActivity::class.java)
        context!!.startActivity(intent)
    }

    private val adapter by lazy { GroupJoinAdapter() }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        homeRecycler.layoutManager = LinearLayoutManager(context)
        homeRecycler.adapter = adapter
        homeRecycler.addItemDecoration(
                DividerItemDecoration(context, LinearLayoutManager(context).orientation))

        adapter.addItem(Group("비투비를 사랑하는 모임", "저희는 비투비를 좋아하는 그룹입니다.\n" +
                "티켓팅 많이 함께해요!"))
        adapter.addItem(Group("블랙핑크 콘서트 티켓팅", "3월 21일에 열리는 콘서트 티켓팅\n" +
                "해주실분들 구합니다."))
        adapter.addItem(Group("트와이스 콘서트 티켓팅", "2월 9일에 열리는 콘서트 티켓팅\n" +
                "해주실분들 구합니다."))
        adapter.addItem(Group("저스트 뮤직 콘서트 티켓팅", "3월 6일에 열리는 콘서트 티켓팅\n" +
                "해주실분들 구합니다."))

        makeGroupBtn.setOnClickListener(this)
    }
}