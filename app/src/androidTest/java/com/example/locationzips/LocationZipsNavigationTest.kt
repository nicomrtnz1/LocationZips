package com.example.locationzips

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.*
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LocationZipsNavigationTest {
    @Test
    fun testViewNavigation() {

        val activityScenario: ActivityScenario<MainActivity> =
            ActivityScenario.launch(MainActivity::class.java)


        onView(withId(R.id.startButton)).perform(click())
        //verify
        onView(withId(R.id.locationSesarchFragment)).check(matches(isDisplayed()))
        // Nav back
        pressBack()
        //verify
        onView(withId(R.id.titleConstraint)).check(matches(isDisplayed()))
    }
}