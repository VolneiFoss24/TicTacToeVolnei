package com.example.hass

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var topStart: ImageView
    lateinit var topCenter: ImageView
    lateinit var topEnd: ImageView

    lateinit var centerStart: ImageView
    lateinit var center: ImageView
    lateinit var centerEnd: ImageView

    lateinit var bottomStart: ImageView
    lateinit var bottomCenter: ImageView
    lateinit var bottomEnd: ImageView

    lateinit var reset: Button

    private var isPlayer1 = true
    private var gameEnd = false

    private var winUser1 = 0
    private var winUser2 = 0




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()



        topStart = findViewById(R.id.top_start)
        topCenter = findViewById(R.id.top_center)
        topEnd = findViewById(R.id.top_end)

        centerStart = findViewById(R.id.center_start)
        center = findViewById(R.id.center)
        centerEnd = findViewById(R.id.center_end)

        bottomStart = findViewById(R.id.bottom_start)
        bottomCenter = findViewById(R.id.bottom_center)
        bottomEnd = findViewById(R.id.bottom_end)

        configureBox(topStart)
        configureBox(topCenter)
        configureBox(topEnd)

        configureBox(centerStart)
        configureBox(center)
        configureBox(centerEnd)

        configureBox(bottomStart)
        configureBox(bottomCenter)
        configureBox(bottomEnd)

        reset = findViewById(R.id.button_reset)
        reset.setOnClickListener {
            reset(topStart)
            reset(topCenter)
            reset(topEnd)

            reset(centerStart)
            reset(center)
            reset(centerEnd)

            reset(bottomStart)
            reset(bottomCenter)
            reset(bottomEnd)


        }
        findViewById<TextView>(R.id.user1).text = SecurityPreference(this).obterString("USER_NAME1")
        findViewById<TextView>(R.id.user2).text = SecurityPreference(this).obterString("USER_NAME2")
    }


    private fun configureBox(box: ImageView) {
        box.setOnClickListener {
            if (box.tag == null && !gameEnd) {
                if (isPlayer1) {
                    box.setImageResource(R.drawable.ic_baseline_close_24)
                    isPlayer1 = false
                    box.tag = 1

                } else {
                    box.setImageResource(R.drawable.ic_baseline_circle_24)
                    isPlayer1 = true
                    box.tag = 2

                }
            }
            if (playerWin(1)) {
                Toast.makeText(applicationContext, "Player 1 venceu!", Toast.LENGTH_SHORT).show()
                somaPlacar1(1)
                findViewById<TextView>(R.id.result_user1).text = winUser1.toString()
                gameEnd = true
            } else if (playerWin(2)) {
                Toast.makeText(applicationContext, "Player 2 venceu!", Toast.LENGTH_SHORT).show()
                somaPlacar2(1)
                findViewById<TextView>(R.id.result_user2).text = winUser2.toString()
                gameEnd = true

            }
        }
    }

    private fun reset(box: ImageView){
        box.setImageDrawable(null)
        box.tag = null
        isPlayer1 = true
        gameEnd = false
    }


    private fun playerWin(value: Int): Boolean {
        if (
            (topStart.tag == value && centerStart.tag == value && bottomStart.tag == value)
            || (topStart.tag == value && topCenter.tag == value && topEnd.tag == value)
            || (topCenter.tag == value && center.tag == value && bottomCenter.tag == value)
            || (centerStart.tag == value && center.tag == value && centerEnd.tag == value)
            || (topEnd.tag == value && centerEnd.tag == value && bottomEnd.tag == value)
            || (topStart.tag == value && center.tag == value && bottomEnd.tag == value)
            || (bottomStart.tag == value && bottomCenter.tag == value && bottomEnd.tag == value)
            || (topStart.tag == value && center.tag == value && bottomEnd.tag == value)
            || (topEnd.tag == value && center.tag == value && bottomStart.tag == value)
        ) {
            return true
        }
        return false
    }

    private fun somaPlacar1(ponto: Int){
        winUser1 += ponto

    }

    private fun somaPlacar2(ponto: Int){
        winUser2 += ponto
    }
}