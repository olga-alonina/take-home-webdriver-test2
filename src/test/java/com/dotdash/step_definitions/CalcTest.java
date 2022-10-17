package com.dotdash.step_definitions;

import org.junit.Test;


import static com.dotdash.utilities.methods.actions;



public class CalcTest {
    @Test
    public void testCalc() {
        actions("48.5+1.5");
        actions("6÷3");
        actions("2×4");
        actions("8−2");
        actions("123CE");
        actions("123CECE");
    }
}




