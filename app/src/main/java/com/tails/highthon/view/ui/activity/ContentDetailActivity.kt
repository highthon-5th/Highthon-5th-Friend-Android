package com.tails.highthon.view.ui.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.tails.highthon.R
import com.tails.highthon.data.models.Comment
import com.tails.highthon.view.adapter.CommentAdapter
import kotlinx.android.synthetic.main.activity_content_detail.*

class ContentDetailActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        if(!commentEdit.text.isEmpty()){
            adapter.addItem(Comment("이민혁", commentEdit.text.toString()))
            commentEdit.text.clear()
            Toast.makeText(applicationContext, "댓글을 달았습니다.", Toast.LENGTH_SHORT).show()
        }else Toast.makeText(applicationContext, "댓글 내용을 입력하세요.", Toast.LENGTH_SHORT).show()
    }

    private val adapter by lazy { CommentAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_detail)

        contentDetailCommentRecycler.layoutManager = LinearLayoutManager(applicationContext)
        contentDetailCommentRecycler.adapter = adapter

        adapter.addItem(Comment("이민혁", "저는 영어를 싫어합니다."))
        adapter.addItem(Comment("이리온", "저는 영어를 너무너무 좋아합니다 ^!^"))
        adapter.addItem(Comment("이민혁", "저는 영어를 싫어합니다."))
        adapter.addItem(Comment("이리온", "저는 영어를 너무너무 좋아합니다 ^!^"))

        commentBtn.setOnClickListener(this)
    }


}
