package com.mcdev.passvalidationview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.mcdev.passwordvalidationview.OnValidationListener
import com.mcdev.passwordvalidationview.PasswordValidationView
import com.mcdev.passwordvalidationview.ValidatorView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val passEditText = findViewById<EditText>(R.id.password_et)
        val validationView = findViewById<PasswordValidationView>(R.id.pvv)
        val button = findViewById<Button>(R.id.btn)

        validationView.passwordEditText = passEditText
        validationView.passwordMinLength = 10
        //validationView.enabledColor = R.color.success_green
        validationView.setOnValidationListener {
            button.isEnabled = it
        }

    }
}