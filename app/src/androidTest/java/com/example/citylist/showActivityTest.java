package com.example.citylist;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Rule;
import org.junit.Test;

public class showActivityTest
{

   @Rule
   public ActivityScenarioRule<showActivity> activityRule=new ActivityScenarioRule<showActivity>(showActivity.class);

    @Test
    public void testSwitch()
    {


    }
}