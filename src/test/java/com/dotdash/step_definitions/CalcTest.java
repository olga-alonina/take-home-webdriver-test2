package com.dotdash.step_definitions;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;


import static com.dotdash.utilities.methods.actions;


public class CalcTest {
    @Test
    public void positiveTestCalc() {
        actions("48.5+1.5");
        actions("6÷3");
        actions("2×4");
        actions("8−2");
        actions("123CE");
        actions("123CECE");
    }

    @Test
    public void negativeTestCalc() {
        actions("6/3");
        actions("0/3");
        actions("2*8");
        actions("2x5");
        actions("22X3");
        actions("3/0");
        actions("-12+6");
        actions("-6-19");
        ArrayList<String>list = new ArrayList<>(Arrays.asList("sos", "anna", "cat"));
        for (int i = 0; i < list.size(); i++) {

        }
    }



}




