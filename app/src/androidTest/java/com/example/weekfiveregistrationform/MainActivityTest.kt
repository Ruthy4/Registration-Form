package com.example.weekfiveregistrationform

import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.hamcrest.CoreMatchers.anything
import org.hamcrest.CoreMatchers.containsString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest{
    companion object {
        private const val USERNAME = "Rhoda Smith"
        private const val EMAIL = "frozenbear@gmail.com"
        private const val PHONE_NUMBER = "08169272233"
        private const val GENDER = "Female"
    }

    @get: Rule
    val activityScenario = ActivityScenarioRule(MainActivity::class.java)


    @Test
    fun test_isActivityInView(){
        onView(withId(R.id.newUi)).check(matches(isDisplayed()))
    }

    @Test
    fun test_button_visibility_name(){
        onView(withId(R.id.username_edit_text)).check(matches(isDisplayed()))
        onView(withId(R.id.submit_button)).check(matches(isDisplayed()))
    }

    @Test
    fun test_successful_login(){
        onView(withId(R.id.username_edit_text)).perform(replaceText(USERNAME))
        onView(withId(R.id.email_edit_text)).perform(replaceText(EMAIL))
        onView(withId(R.id.phone_numberEt)).perform(replaceText(PHONE_NUMBER))

        onView(withId(R.id.options_spinner)).perform(click())
        onData(anything()).atPosition(2).perform(click())
        onView(withId(R.id.options_spinner)).check(matches(withSpinnerText(containsString(GENDER))))

        onView(withId(R.id.submit_button)).perform(click())
        onView(withId(R.id.user_profile_parent)).perform(click()).check(matches(isDisplayed()))

        onView(withId(R.id.profile_username_text_view)).check(matches(isDisplayed()))
        onView(withId(R.id.profile_email_text_view)).check(matches(isDisplayed()))
        onView(withId(R.id.profile_phone_number_text_view)).check(matches(isDisplayed()))
        onView(withId(R.id.profile_gender_text_view)).check(matches(isDisplayed()))

        onView(withId(R.id.profile_username_text_view)).check(matches(withText(USERNAME)))
        onView(withId(R.id.profile_email_text_view)).check(matches(withText(EMAIL)))
        onView(withId(R.id.profile_phone_number_text_view)).check(matches(withText(PHONE_NUMBER)))
        onView(withId(R.id.profile_gender_text_view)).check(matches(withText(GENDER)))


    }

}
