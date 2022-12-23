package com.example.hass

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()

        val btnJogar: Button = findViewById(R.id.jogar)
        btnJogar.setOnClickListener {

            val nome1 = findViewById<TextView>(R.id.edit_user1).text.toString()
            val nome2 = findViewById<TextView>(R.id.edit_user2).text.toString()

            SecurityPreference(this).armazenarString("USER_NAME1", nome1)
            SecurityPreference(this).armazenarString("USER_NAME2", nome2)


            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onClick(view: View) {

    }
}