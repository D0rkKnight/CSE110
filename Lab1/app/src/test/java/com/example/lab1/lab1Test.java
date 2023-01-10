package com.example.lab1;

import static org.junit.Assert.assertEquals;

import androidx.test.core.app.ActivityScenario;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class lab1Test {

    @Test
    public void test1() {
        ActivityScenario scenario = ActivityScenario.launch(MainActivity.class);

        onView()
    }

}
