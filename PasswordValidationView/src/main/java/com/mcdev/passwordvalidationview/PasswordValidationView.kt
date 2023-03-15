package com.mcdev.passwordvalidationview

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.mcdev.passwordvalidationview.databinding.PasswordValidationViewBinding

class PasswordValidationView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyle: Int = 0

) : LinearLayout(context, attributeSet, defStyle) {

    val specialCharRegex: Regex = Regex("[!\"#\$%&'()*+,-./:;<=>?@[\\]^_`{|}~]]")
    var isLower = false
    var isUpper = false
    var isDigit = false
    var isSpecialChar = false
    var isLengthy = false
    var onValidationListener: OnValidationListener? = null

    inline fun setOnValidationListener(crossinline listener: (Boolean) -> Unit) {
        this.onValidationListener = object : OnValidationListener {
            override fun onUpdate(isValid: Boolean) = listener(isValid)
        }
    }

    fun setOnValidationListener(listener: OnValidationListener) {
        this.onValidationListener = listener
    }

    var enabledColor: Int = android.R.color.holo_blue_dark
    var isPasswordValid: Boolean = false
        private set

    /*view binding*/
    private val binding =
        PasswordValidationViewBinding.inflate(LayoutInflater.from(context), this, true)

    var excludeView: ValidatorView = ValidatorView.NONE
    var passwordEditText: EditText? = null
        set(value) {
            value!!.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    //TODO("Not yet implemented")
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    validatePassword(p0.toString())
                    checkValidation(p0.toString())
                }

                override fun afterTextChanged(p0: Editable?) {
                }
            })
            field = value
        }

    var passwordMinLength: Int = 6
        set(value) {
            binding.lengthLay.lengthSymbol.text = "$value+"
            field = value
        }

    private fun validatePassword(string: String) {
        if (string.isBlank() || string.chars().anyMatch(Character::isLowerCase).not()) {
            //lowercase
            binding.lowercaseLay.lowerCaseSymbol.setTextColor(
                resources.getColor(
                    R.color.gray,
                    context.theme
                )
            )
            binding.lowercaseLay.lowerCaseTv.setTextColor(
                resources.getColor(
                    R.color.gray,
                    context.theme
                )
            )
            isLower = false
        }
        if (string.isBlank() || string.chars().anyMatch(Character::isUpperCase).not()) {
            //uppercase
            binding.uppercaseLay.upperCaseSymbol.setTextColor(
                resources.getColor(
                    R.color.gray,
                    context.theme
                )
            )
            binding.uppercaseLay.upperCaseTv.setTextColor(
                resources.getColor(
                    R.color.gray,
                    context.theme
                )
            )
            isUpper = false
        }
        if (string.isBlank() || string.chars().anyMatch(Character::isDigit).not()) {
            //digits
            binding.digitsLay.digitsSymbol.setTextColor(
                resources.getColor(
                    R.color.gray,
                    context.theme
                )
            )
            binding.digitsLay.digitsTv.setTextColor(resources.getColor(R.color.gray, context.theme))
            isDigit = false
        }
        if (string.isBlank() || string.length < passwordMinLength) {
            //length
            binding.lengthLay.lengthSymbol.setTextColor(
                resources.getColor(
                    R.color.gray,
                    context.theme
                )
            )
            binding.lengthLay.lengthTv.setTextColor(resources.getColor(R.color.gray, context.theme))
            isLengthy = false
        }
        if (string.isBlank() || string.contains(regex = specialCharRegex).not()) {
            //special characters
            binding.specialCharLay.specialCharSymbol.setTextColor(
                resources.getColor(
                    R.color.gray,
                    context.theme
                )
            )
            binding.specialCharLay.specialCharTv.setTextColor(
                resources.getColor(
                    R.color.gray,
                    context.theme
                )
            )
            isSpecialChar = false
        }


        if (string.chars().anyMatch(Character::isLowerCase)) {
            binding.lowercaseLay.lowerCaseSymbol.setTextColor(
                resources.getColor(
                    enabledColor,
                    context.theme
                )
            )
            binding.lowercaseLay.lowerCaseTv.setTextColor(
                resources.getColor(
                    enabledColor,
                    context.theme
                )
            )

            if (isLower.not()) {
                animateSymbol(binding.lowercaseLay.lowerCaseSymbol)
                isLower = true
            }
        }
        if (string.chars().anyMatch(Character::isUpperCase)) {
            binding.uppercaseLay.upperCaseSymbol.setTextColor(
                resources.getColor(
                    enabledColor,
                    context.theme
                )
            )
            binding.uppercaseLay.upperCaseTv.setTextColor(
                resources.getColor(
                    enabledColor,
                    context.theme
                )
            )

            if (isUpper.not()) {
                animateSymbol(binding.uppercaseLay.upperCaseSymbol)
                isUpper = true
            }
        }
        if (string.chars().anyMatch(Character::isDigit)) {
            binding.digitsLay.digitsSymbol.setTextColor(
                resources.getColor(
                    enabledColor,
                    context.theme
                )
            )
            binding.digitsLay.digitsTv.setTextColor(resources.getColor(enabledColor, context.theme))

            if (isDigit.not()) {
                animateSymbol(binding.digitsLay.digitsSymbol)
                isDigit = true
            }
        }
        if (string.length > passwordMinLength) {
            binding.lengthLay.lengthSymbol.setTextColor(
                resources.getColor(
                    enabledColor,
                    context.theme
                )
            )
            binding.lengthLay.lengthTv.setTextColor(resources.getColor(enabledColor, context.theme))

            if (isLengthy.not()) {
                animateSymbol(binding.lengthLay.lengthSymbol)
                isLengthy = true
            }
        }
        if (string.contains(regex = specialCharRegex)) {
            binding.specialCharLay.specialCharSymbol.setTextColor(
                resources.getColor(
                    enabledColor,
                    context.theme
                )
            )
            binding.specialCharLay.specialCharTv.setTextColor(resources.getColor(enabledColor, context.theme))

            if (isSpecialChar.not()) {
                animateSymbol(binding.specialCharLay.specialCharSymbol)
                isSpecialChar = true
            }
        }
    }

    private fun animateSymbol(view: View, anim: Techniques = Techniques.Tada) {
        YoYo.with(anim)
            .duration(900)
            .playOn(view)
    }

    private fun checkValidation(string: String) {
        isPasswordValid = (string.isNotBlank()
                && isLower
                && isUpper
                && isDigit
                && isLengthy
                && isSpecialChar)
        onValidationListener!!.onUpdate(isPasswordValid)
    }
}