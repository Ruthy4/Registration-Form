package com.example.weekfiveregistrationform

import com.google.common.truth.Truth
import org.junit.Assert.*
import org.junit.Test

class ValidatorTest{
    @Test
    fun whenPhoneNumberIsValid(){
        val validNumber = "08069271995"
        val validate = Validator.mobileValidate(validNumber)


        Truth.assertThat(validate).isEqualTo(true)
    }

    @Test
    fun whenPhoneNumberIs_moreThan_required_digits(){
        val validNumber = "04469271995"
        val validate = Validator.mobileValidate(validNumber)


        Truth.assertThat(validate).isEqualTo(false)
    }

    @Test
    fun whenPhoneNumberIs_lessThan_required_digits(){
        val validNumber = "08065271"
        val validate = Validator.mobileValidate(validNumber)


        Truth.assertThat(validate).isEqualTo(false)
    }

    @Test
    fun whenPhoneNumber_startsWith234(){
        val validNumber = "2348169271995"
        val validate = Validator.mobileValidate(validNumber)


        Truth.assertThat(validate).isEqualTo(true)
    }

    @Test
    fun isEmailValid(){
        val validEmail = "fabian@123.com"
        val validate = Validator.emailValidate(validEmail)

        Truth.assertThat(validate).isEqualTo(true)
    }


    @Test
    fun isEmailInvalid(){
        val validEmail = "Fabian@123.com23"
        val validate = Validator.emailValidate(validEmail)

        Truth.assertThat(validate).isEqualTo(false)
    }

    @Test
    fun usernameIsValid(){

    }
}