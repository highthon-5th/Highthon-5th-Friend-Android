package com.tails.highthon.view.ui.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.tails.highthon.R
import com.tails.highthon.data.models.Content
import com.tails.highthon.view.adapter.GroupDetailContentAdapter
import kotlinx.android.synthetic.main.activity_group_detail_join.*

class GroupDetailJoinActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View) {
        when(v.id) {
            R.id.detailJoinBtn -> {
                if (detailJoinBtn.text != "나가기") {
                    detailJoinBtn.setBackgroundResource(R.drawable.red)
                    detailJoinBtn.text = "나가기"
                    writeBtn.visibility = View.VISIBLE
                    adapter.addItem(Content("저 2월 10일 티켓팅 좀 도와주세요!!!"))
                    adapter.addItem(Content("저 2월 10일 티켓팅 좀 도와주세요!!!"))
                    adapter.addItem(Content("저 2월 10일 티켓팅 좀 도와주세요!!!"))
                    adapter.addItem(Content("저 2월 10일 티켓팅 좀 도와주세요!!!"))
                    Toast.makeText(applicationContext, "그룹에서 참여합니다.", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(applicationContext, "그룹에서 나갔습니다.", Toast.LENGTH_SHORT).show()
                    finish()
                }
            }
            R.id.writeBtn -> {
                if(writeBtn.visibility == View.VISIBLE) {
                    val intent = Intent(applicationContext, ContentWriteActivity::class.java)
                    startActivity(intent)
                }
            }
        }
    }

    private val adapter by lazy { GroupDetailContentAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_detail_join)

        groupDetailContentRecycler.layoutManager = LinearLayoutManager(applicationContext)
        groupDetailContentRecycler.adapter = adapter

        detailJoinBtn.setOnClickListener(this)
        writeBtn.setOnClickListener(this)
    }

}
