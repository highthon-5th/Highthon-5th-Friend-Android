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
import kotlinx.android.synthetic.main.activity_group_detail.*

class GroupDetailActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View) {
        when(v.id){
            R.id.detailBtn-> {
                Toast.makeText(applicationContext, "그룹에서 나갔습니다.", Toast.LENGTH_SHORT).show()
                finish()
            }
            R.id.writeBtn -> {
                val intent = Intent(applicationContext, ContentWriteActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private val adapter by lazy { GroupDetailContentAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_group_detail)

        detailBtn.setOnClickListener(this)
        writeBtn.setOnClickListener(this)
        groupDetailContentRecycler.layoutManager = LinearLayoutManager(applicationContext)
        groupDetailContentRecycler.adapter = adapter
        adapter.addItem(Content("저 2월 10일 티켓팅 좀 도와주세요!!!"))
        adapter.addItem(Content("저 2월 10일 티켓팅 좀 도와주세요!!!"))
        adapter.addItem(Content("저 2월 10일 티켓팅 좀 도와주세요!!!"))
        adapter.addItem(Content("저 2월 10일 티켓팅 좀 도와주세요!!!"))
    }

    override fun onRestart() {
        super.onRestart()
        adapter.addItem(Content("3월 6일 티켓 공구"))
        adapter.reverse()
    }
}
