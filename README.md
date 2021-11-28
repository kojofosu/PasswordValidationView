# PasswordValidationView
![Jit](https://img.shields.io/jitpack/v/github/kojofosu/PasswordValidationView?style=for-the-badge&color=2F9319) 

Android UI component that  validates passwords.

All design credits goes to [Piotr Sliwa](https://dribbble.com/dslv) And inspired by [this design](https://dribbble.com/shots/4957240-Fintech-Onboarding-Principles/attachments/10692818?mode=media)

![inpsired-design](https://user-images.githubusercontent.com/20203694/137953838-5b68f10d-9924-43de-b6b1-8a0d3600850f.gif)

## Demo 
<img src="https://user-images.githubusercontent.com/20203694/137968459-52de55ea-59a0-4e3d-bffe-1203e0baa68a.gif" alt="demo"  width="300" />

## Setup

Add it in your root `build.gradle` at the end of repositories:

```groovy
allprojects {
    repositories {
        //...omitted for brevity
        maven { url 'https://jitpack.io' }
    }
}
```



Add the dependency

```groovy
dependencies {
   implementation "com.github.kojofosu:PasswordValidationView:$latest_release"
}
```

## Usage
Sample implementation [here](app/)

### Password Validation View
- Add `PasswordValidationView` to your xml layout.

```xml
    <com.mcdev.passwordvalidationview.PasswordValidationView
        android:id="@+id/password_validation_view"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>
```

#### :bulb: `Important` : To avoid the soft keyboard from covering the password validation view, place the view inside a `TextInputLayout` 

```xml
    <!-- The text input layout-->
    <com.google.android.material.textfield.TextInputLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Password">
        
        <!-- The text input edit text for the password -->
        <com.google.android.material.textfield.TextInputEditText
            android:id="@+id/password_et"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:inputType="textPassword"
            android:layout_margin="20dp"/>
        
        <!-- The passwrod validation view -->
        <com.mcdev.passwordvalidationview.PasswordValidationView
            android:id="@+id/pvv"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"/>
    </com.google.android.material.textfield.TextInputLayout>
```

### Initialize and customise PasswordValidationView

```kotlin
        val passEditText = findViewById<EditText>(R.id.password_et) // edittext for the password
        val validationView = findViewById<PasswordValidationView>(R.id.pvv) //PasswordValidationView

        validationView.passwordEditText = passEditText //Pass the edittext of for the password to validate
        validationView.passwordMinLength = 10 //minimum password length
        validationView.enabledColor = android.R.color.holo_orange_dark //change valid password activation color
```

### Check if password is complete and valid
```kotlin
    validationView.isPasswordValid //returns true if password is complete and valid
```


### Licensed under the [Apache-2.0 License](LICENSE)
