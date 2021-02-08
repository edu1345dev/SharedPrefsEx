package com.example.sharedprefsex

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.SwitchCompat

class MainActivity : AppCompatActivity() {
    companion object{
        const val USER_PREFS = "USER_PREFS"
        const val SHOW_NAME = "show_nome"
        const val SHOW_REGISTRATION = "show_registration"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configSharedPrefs()
        configViews(configSharedPrefs())
    }

    private fun configViews(prefs: SharedPreferences) {
        val nameSwitch = findViewById<SwitchCompat>(R.id.sw_name)
        val regSwitch = findViewById<SwitchCompat>(R.id.sw_registration)
        val btProfile = findViewById<AppCompatButton>(R.id.bt_profile)

        nameSwitch.setOnCheckedChangeListener { _, isChecked ->
            prefs.edit().putBoolean(SHOW_NAME, isChecked).apply()
        }

        regSwitch.setOnCheckedChangeListener { _, isChecked ->
            prefs.edit().putBoolean(SHOW_REGISTRATION, isChecked).apply()
        }

        btProfile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }

    private fun configSharedPrefs() = getSharedPreferences(USER_PREFS, Context.MODE_PRIVATE)
}