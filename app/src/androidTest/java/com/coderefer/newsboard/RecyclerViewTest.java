package com.coderefer.newsboard;

/**
 * Created by vamsitallapudi on 19/01/18.
 */

/*
 * Copyright 2016, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.support.test.espresso.UiController;
import android.support.test.espresso.ViewAction;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.view.View;


/**
 * Test class showcasing some {@link RecyclerViewActions} from Espresso.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class RecyclerViewTest {

    private static final int ITEM_BELOW_THE_FOLD = 12;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

//    @Test
//    public void scrollToItemBelowFold_checkItsText() {
//        // First scroll to the position that needs to be matched and click on it.
//        onView(withId(R.id.recyclerView))
//                .perform(RecyclerViewActions.actionOnItemAtPosition(ITEM_BELOW_THE_FOLD, click()));
//
//        // Match the text in an item below the fold and check that it's displayed.
//        String itemElementText = mActivityRule.getActivity().getResources().getString(
//                R.string.item_element_text) + String.valueOf(ITEM_BELOW_THE_FOLD);
//        onView(withId(R.id.tv_heading)).check(matches("Apple defends complying with China over VPNs"));
//    }

    @Test
    public void itemInMiddleOfList_hasSpecialText() {
        // First, scroll to the view holder using the isInTheMiddle matcher.
        onView(withId(R.id.recyclerView)).perform(RecyclerViewActions.scrollToPosition(ITEM_BELOW_THE_FOLD));

        // Check that the item has the special text.
//        String middleElementText =
//                mActivityRule.getActivity().getResources().getString(R.string.middle);
//        onView(withText("Apple defends complying with China over VPNs")).check(matches(isDisplayed()));

//        onView(withId(R.id.recyclerView)).perform(RecyclerViewActions.actionOnHolderItem(isAtEnd(),performAction()));
//                .check(matches(withText("Apple defends complying with China over VPNs")));

        onView(withRecyclerView(R.id.recyclerView)
                .atPositionOnView(ITEM_BELOW_THE_FOLD, R.id.tv_heading))
                .check(matches(withText("Apple defends complying with China over VPNs")));


    }
    public static RecyclerViewMatcher withRecyclerView(final int recyclerViewId) {
        return new RecyclerViewMatcher(recyclerViewId);
    }

    /**
     * Matches the {@link ListRecyclerAdapter.NewsHolder}s in the middle of the list.
     */
    private static Matcher<ListRecyclerAdapter.NewsHolder> isInTheMiddle() {
        return new TypeSafeMatcher<ListRecyclerAdapter.NewsHolder>() {
            @Override
            protected boolean matchesSafely(ListRecyclerAdapter.NewsHolder customHolder) {
                return customHolder.getIsInTheMiddle();
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("item in the middle");
            }
        };
    }
    private static Matcher<ListRecyclerAdapter.NewsHolder> isAtEnd() {
        return new TypeSafeMatcher<ListRecyclerAdapter.NewsHolder>() {
            @Override
            protected boolean matchesSafely(ListRecyclerAdapter.NewsHolder customHolder) {
                return customHolder.getIsAtEnd();
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("xyz");
            }
        };
    }
    private static ViewAction performAction(){
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return null;
            }

            @Override
            public String getDescription() {
                return null;
            }

            @Override
            public void perform(UiController uiController, View view) {

            }
        };
    }
}
