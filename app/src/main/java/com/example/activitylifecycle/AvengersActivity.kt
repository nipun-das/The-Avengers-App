package com.example.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.*

class AvengersActivity : AppCompatActivity() {

    var titleName: String? = "Hey Avengers"
    lateinit var sharedPreferences: SharedPreferences
    lateinit var logoutBtn: Button
    lateinit var btnIronMan: ViewGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        setContentView(R.layout.scroll_view_example)

        titleName = sharedPreferences.getString("Title", "The Avengers")

        title = titleName

        btnIronMan = findViewById(R.id.ironmanBtn)
        logoutBtn = findViewById(R.id.logoutBtn)


        logoutBtn.setOnClickListener {
            sharedPreferences.edit().clear().apply()
            startActivity(Intent(this@AvengersActivity, LoginActivity::class.java))
            Toast.makeText(this@AvengersActivity, "Log Out Successful!", Toast.LENGTH_SHORT)
                .show()

        }

        btnIronMan.setOnClickListener {
            sharedPreferences.edit().clear().apply()
            val intent = Intent(this@AvengersActivity, IronManActivity::class.java);
            startActivity(intent)
        }
    }

}

