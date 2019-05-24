package com.example.assignapp2019s1.puzzles;

//import android.support.test.rule.ActivityTestRule;
import android.support.test.*;
import android.support.test.espresso.*;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**@author Yishun Shi*/
public class PuzzleEightActivityTest {
//    @Rule
//   public ActivityTestRule<PuzzleEightActivity> rule  = new  ActivityTestRule<>(PuzzleEightActivity.class);


    @Test
     public void parseTest(){
        PuzzleEightActivity pea = new PuzzleEightActivity();
        assertEquals(24,(long)pea.parse("(1+7-4)*6"));
        assertEquals(-16,(long)pea.parse("1+7-4*6"));
        assertEquals(24,(long)pea.parse("24"));
        assertEquals(null,(long)pea.parse(""));
    }

}