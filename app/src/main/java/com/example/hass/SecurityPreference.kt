package com.example.hass

import android.content.Context
import android.content.SharedPreferences

class SecurityPreference(context: Context) {

    private val security: SharedPreferences =
        context.getSharedPreferences("User", Context.MODE_PRIVATE)

    fun armazenarString(key: String, nome: String){
        security.edit().putString(key, nome).apply()
    }

    fun obterString(key: String): String {
        return security.getString(key, "") ?: ""
    }
}