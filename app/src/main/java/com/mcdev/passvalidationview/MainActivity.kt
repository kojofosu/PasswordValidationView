package com.mcdev.passvalidationview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import com.mcdev.passwordvalidationview.PasswordValidationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val passEditText = findViewById<EditText>(R.id.password_et)
        val validationView = findViewById<PasswordValidationView>(R.id.pvv)

        validationView.passwordEditText = passEditText
        validationView.passwordMinLength = 10
        validationView.enabledColor = R.color.success_green

        validationView.setOnClickListener {
            Log.d("TAG", "onCreate: ${validationView.isPasswordValid}")
        }

    }
}