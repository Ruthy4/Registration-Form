package com.example.weekfiveregistrationform

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test

class UserProfileActivityTest {

    @get:Rule
    val activityScenario = ActivityScenarioRule(UserProfileActivity::class.java)

    @Test
    fun test_userProfileActivity_InView() {
        onView(withId(R.id.user_profile_parent)).check(matches(isDisplayed()))
    }

    @Test
    fun test_userInputFieldsInView() {
        onView(withId(R.id.profile_username_text_view)).check(matches(isDisplayed()))
        onView(withId(R.id.profile_email_text_view)).check(matches(isDisplayed()))
        onView(withId(R.id.profile_phone_number_text_view)).check(matches(isDisplayed()))
        onView(withId(R.id.profile_gender_text_view)).check(matches(isDisplayed()))
    }

    @Test
    fun test_isButtonInView(){
        onView(withId(R.id.follow_ruth_button)).check(matches(isDisplayed()))
        onView(withId(R.id.message_button)).check(matches(isDisplayed()))
    }
}