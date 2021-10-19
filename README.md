# PasswordValidationView
Android UI component that  validates passwords.

All design credits goes to [Piotr Sliwa](https://dribbble.com/dslv) And inspired by [this design](https://dribbble.com/shots/4957240-Fintech-Onboarding-Principles/attachments/10692818?mode=media)

![inpsired-design](https://user-images.githubusercontent.com/20203694/137953838-5b68f10d-9924-43de-b6b1-8a0d3600850f.gif)

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

### Split Button
- Add `PasswordValidationView` to your xml layout.

```xml
    <com.mcdev.passwordvalidationview.PasswordValidationView
        android:id="@+id/password_validation_view"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"/>
```

### Initialize and customise split button

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
