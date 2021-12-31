package com.example.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*

class LoginActivity : AppCompatActivity() {
    lateinit var etName: EditText
    lateinit var etPassword: EditText
    lateinit var loginBtn: Button
    lateinit var txtForgotpassword: TextView
    lateinit var txtSignUp: TextView

    val validName = arrayOf("nipun","ironman", "captainamerica", "hulk", "blackwidow", "thor", "blackpanther")
    val validPassword = arrayOf("das","tony", "steve", "bruce", "natasha", "thor", "tchalla")

    lateinit var sharedPreferences : SharedPreferences



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences = getSharedPreferences(getString(R.string.preference_file_name),Context.MODE_PRIVATE)


        val LoggedIn = sharedPreferences.getBoolean("isLoggedIn",false)
        setContentView(R.layout.activity_login)

        if(LoggedIn){
            val intent = Intent(this@LoginActivity,AvengersActivity::class.java)
            startActivity(intent)
            finish()
        }

        title = "Login"

        etName = findViewById(R.id.enterNameID)
        etPassword = findViewById(R.id.enterPasswordID)
        loginBtn = findViewById(R.id.loginBtn)
        txtForgotpassword = findViewById(R.id.txtForgotPassword)
        txtSignUp = findViewById(R.id.txtSignUp)


        loginBtn.setOnClickListener {
            val i: Int
            var f = 0
            var nameOfAvenger: String
            val nameInput = etName.text.toString()
            val passwordInput = etPassword.text.toString()
           // val intent = ;
            for (i in 0..6) {
                if (validName[i] == (nameInput)&&validPassword[i] == (passwordInput))
                {


                        nameOfAvenger = validName[i].toString().uppercase(Locale.getDefault())

                        savePreferences(nameOfAvenger)

                        f = 1
                        startActivity(Intent(this@LoginActivity, AvengersActivity::class.java))
                        Toast.makeText(this@LoginActivity, "Login Successful!", Toast.LENGTH_SHORT).show()

                }
            }
        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }
    fun savePreferences(title:String){
        sharedPreferences.edit().putBoolean("isLoggedIn",true).apply()
        sharedPreferences.edit().putString("Title",title).apply()
    }
}