package com.example.helloworld;

import static org.junit.Assert.assertEquals;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import androidx.lifecycle.Lifecycle;
import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class Lab1Test {
    @Rule public ActivityScenarioRule<MainActivity> rule = new ActivityScenarioRule<>(MainActivity.class);

    @Test public void testStudentNameIsDisplayed() {
        ActivityScenario scenario = rule.getScenario();
        scenario.moveToState(Lifecycle.State.CREATED);
        scenario.onActivity(activity -> {
            TextView name_display = activity.findViewById(R.id.name);
            assertEquals(View.INVISIBLE, name_display.getVisibility());
            assertEquals("Vincent Zhang", name_display.getText());
        });

    }
}
