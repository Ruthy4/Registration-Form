package com.example.weekfiveregistrationform

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.*
import com.example.weekfiveregistrationform.Validator.emailValidate
import com.example.weekfiveregistrationform.Validator.mobileValidate

class MainActivity : AppCompatActivity() {

    lateinit var options: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //get the id of the spinner component
        options = findViewById<Spinner>(R.id.options_spinner)

        val optionsList = arrayOf("Select Gender ", "Male", "Female", "Prefer not to say")

        options.adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, optionsList)

        //get ids of the views and assign to variables
        val submitButton = findViewById<Button>(R.id.submit_button)
        val firstName = findViewById<EditText>(R.id.username_edit_text)
        val emailEt = findViewById<EditText>(R.id.email_edit_text)
        val genderOptionSpinner = findViewById<Spinner>(R.id.options_spinner)
        val phoneNumberEt = findViewById<EditText>(R.id.phone_numberEt)

        //set an onclick listener to the submit button
        submitButton.setOnClickListener {
            val username = firstName.text.toString()
            val email = emailEt.text.toString()
            val gender = genderOptionSpinner.selectedItem.toString()
            val number = phoneNumberEt.text.toString()



            //checks if fields are empty and sends a toast message if they are
            if (email.trim().isEmpty()) {
                Toast.makeText(applicationContext, "please fill all fields correctly", Toast.LENGTH_SHORT).show() }

            if (username.trim().isEmpty()) {
                Toast.makeText(applicationContext, "please fill all fields correctly", Toast.LENGTH_SHORT).show() }

            if (number.trim().isEmpty()) {
                Toast.makeText(applicationContext, "please fill all fields correctly", Toast.LENGTH_SHORT).show() }

            if (gender.trim().isEmpty()) {
                Toast.makeText(applicationContext, "please fill all fields correctly", Toast.LENGTH_SHORT).show() }



            //sends an intent to the second activity if fields are not empty
            if (firstName.text.isNotEmpty() && phoneNumberEt.text.isNotEmpty() && emailEt.text.isNotEmpty()) {
                val intent = Intent(this, UserProfileActivity::class.java).apply {
                    putExtra("Username", username)
                    putExtra("Email", email)
                    putExtra("Sex", gender)
                    putExtra("Number", number)
                }
                startActivity(intent)
            }
        }


        //add a listener to the phoneNumber edit text to perform validation on text changed
        phoneNumberEt.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (mobileValidate(phoneNumberEt.text.toString())) {
                    submitButton.isEnabled = true
                } else {
                    phoneNumberEt.error = "Enter a valid phone number"
                    submitButton.isEnabled = false
                }
            }
        })



        //adds a listener to the email and validates on text changed
        emailEt.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (emailValidate(emailEt.text.toString())) {
                    submitButton.isEnabled = true
                } else {
                    emailEt.error = "Enter a valid Email"
                    submitButton.isEnabled = false
                }
            }
        })
    }
}