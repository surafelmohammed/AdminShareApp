package com.example.surafel.junittest;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AddTest {
    presenter actual = new presenter();
    MainActivity main = new MainActivity();

    @Test
    public void check(){
        int first = 5;
        int second = 10;
        assertEquals("the addition function does not work porperly",15,actual.add(first,second));
        assertEquals("the mulitplication function does not work properly",50,actual.multiply(first,second));
        assertEquals("the subtraction funciton does not work properly",-5,actual.substruct(first,second));
        second = 0;
        assertEquals("the division function does not work properly",0,actual.divide(first,second));
        //assertTrue(Integer.parseInt(main.firstNumber.getText().toString())==first);
    }
}
