package com.tails.highthon.view.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.tails.highthon.R
import kotlinx.android.synthetic.main.activity_content_write.*

class ContentWriteActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        Toast.makeText(applicationContext, "게시물이 작성되었습니다.", Toast.LENGTH_SHORT).show()
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_write)

        writeBtn.setOnClickListener(this)
    }
}
