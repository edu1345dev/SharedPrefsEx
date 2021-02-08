package com.example.sharedprefsex

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        initProfile(configSharedPrefs())
    }

    private fun initProfile(prefs: SharedPreferences) {
        val tvName = findViewById<TextView>(R.id.tv_name)
        val tvRegistration = findViewById<TextView>(R.id.tv_registration)

        val showName = prefs.getBoolean(MainActivity.SHOW_NAME, true)
        val showRegistration = prefs.getBoolean(MainActivity.SHOW_REGISTRATION, true)

        tvName.text = "José"
        tvRegistration.text = "123456"

        tvName.visibility = if (showName) View.VISIBLE else View.GONE
        tvRegistration.visibility = if (showRegistration) View.VISIBLE else View.GONE
    }

    private fun configSharedPrefs() =
        getSharedPreferences(MainActivity.USER_PREFS, Context.MODE_PRIVATE)
}