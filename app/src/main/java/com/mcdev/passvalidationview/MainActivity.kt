package com.mcdev.passvalidationview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import com.mcdev.passwordvalidationview.PasswordValidationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pet = findViewById<EditText>(R.id.password_et)
        val pvv = findViewById<PasswordValidationView>(R.id.pvv)

        pvv.passwordEditText = pet
        pvv.passwordMinLength = 10
        pvv.enabledColor = android.R.color.holo_orange_dark

        pvv.setOnClickListener {
            Log.d("TAG", "onCreate: ${pvv.isPasswordValid}")
        }

    }
}