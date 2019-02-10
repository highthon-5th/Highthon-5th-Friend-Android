package com.tails.highthon.view.ui.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tails.highthon.R
import kotlinx.android.synthetic.main.activity_create_group.*

class CreateGroupActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View) {
        when(v.id){
            R.id.making->{
                Toast.makeText(applicationContext, "그룹을 생성했습니다.", Toast.LENGTH_SHORT).show()
                finish()
            }
            R.id.star->{
                star.setCardBackgroundColor(resources.getColor(R.color.dark, null))
                game.setCardBackgroundColor(resources.getColor(R.color.white, null))
                pass.setCardBackgroundColor(resources.getColor(R.color.white, null))
                study.setCardBackgroundColor(resources.getColor(R.color.white, null))
                exercise.setCardBackgroundColor(resources.getColor(R.color.white, null))
                more.setCardBackgroundColor(resources.getColor(R.color.white, null))
            }
            R.id.game->{
                star.setCardBackgroundColor(resources.getColor(R.color.white, null))
                game.setCardBackgroundColor(resources.getColor(R.color.dark, null))
                pass.setCardBackgroundColor(resources.getColor(R.color.white, null))
                study.setCardBackgroundColor(resources.getColor(R.color.white, null))
                exercise.setCardBackgroundColor(resources.getColor(R.color.white, null))
                more.setCardBackgroundColor(resources.getColor(R.color.white, null))
            }
            R.id.pass->{
                star.setCardBackgroundColor(resources.getColor(R.color.white, null))
                game.setCardBackgroundColor(resources.getColor(R.color.white, null))
                pass.setCardBackgroundColor(resources.getColor(R.color.dark, null))
                study.setCardBackgroundColor(resources.getColor(R.color.white, null))
                exercise.setCardBackgroundColor(resources.getColor(R.color.white, null))
                more.setCardBackgroundColor(resources.getColor(R.color.white, null))
            }
            R.id.study->{
                star.setCardBackgroundColor(resources.getColor(R.color.white, null))
                game.setCardBackgroundColor(resources.getColor(R.color.white, null))
                pass.setCardBackgroundColor(resources.getColor(R.color.white, null))
                study.setCardBackgroundColor(resources.getColor(R.color.dark, null))
                exercise.setCardBackgroundColor(resources.getColor(R.color.white, null))
                more.setCardBackgroundColor(resources.getColor(R.color.white, null))
            }
            R.id.exercise->{
                star.setCardBackgroundColor(resources.getColor(R.color.white, null))
                game.setCardBackgroundColor(resources.getColor(R.color.white, null))
                pass.setCardBackgroundColor(resources.getColor(R.color.white, null))
                study.setCardBackgroundColor(resources.getColor(R.color.white, null))
                exercise.setCardBackgroundColor(resources.getColor(R.color.dark, null))
                more.setCardBackgroundColor(resources.getColor(R.color.white, null))
            }
            R.id.more->{
                star.setCardBackgroundColor(resources.getColor(R.color.white, null))
                game.setCardBackgroundColor(resources.getColor(R.color.white, null))
                pass.setCardBackgroundColor(resources.getColor(R.color.white, null))
                study.setCardBackgroundColor(resources.getColor(R.color.white, null))
                exercise.setCardBackgroundColor(resources.getColor(R.color.white, null))
                more.setCardBackgroundColor(resources.getColor(R.color.dark, null))
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_group)

        star.setOnClickListener(this)
        game.setOnClickListener(this)
        pass.setOnClickListener(this)
        study.setOnClickListener(this)
        exercise.setOnClickListener(this)
        more.setOnClickListener(this)

        making.setOnClickListener(this)
    }
}
