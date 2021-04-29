package com.example.weekfiveregistrationform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class UserProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_profile)

        //get the string coming from the intent and assign it to a variable
        val intent = intent
        val firstName = intent.getStringExtra("Username")
        val email = intent.getStringExtra("Email")
        val sex = intent.getStringExtra("Sex")
        val number = intent.getStringExtra("Number")

        //get the textView for the username and assign the value from the intent
        val username = findViewById<TextView>(R.id.profile_username_text_view)
        username.text = "$firstName"

        //get the email textView and assign it to the value from the intent
        val profileEmail = findViewById<TextView>(R.id.profile_email_text_view)
        profileEmail.text = "$email"

        //get the phoneNumber textView and assign the value from the intent
        val profilePhoneNumber = findViewById<TextView>(R.id.profile_phone_number_text_view)
        profilePhoneNumber.text = "$number"


        val profileGender = findViewById<TextView>(R.id.profile_gender_text_view)
        profileGender.text = "$sex"
    }
}