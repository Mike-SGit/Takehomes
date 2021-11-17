package com.example;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Unit test for simple App.
 */
class AppTest {
    
    //set system.out to outContent
    private final  ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final  PrintStream originalOut = System.out;
    
    @BeforeEach
    public  void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }
    
    @AfterEach
    public  void restoreStreams() {
        System.setOut(originalOut);
    }

    
    @Test
    public void testExample() {
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        arr1.add(3);
        arr1.add(1);
        arr1.add(2);  
        arr1.add(2);
        arr1.add(4);
        Result.customSort(arr1);
        assertEquals("1\n3\n4\n2\n2\n", outContent.toString());
    }

    @Test
    public void testCustom() {
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        arr1.add(3);
        arr1.add(1);
        arr1.add(2);  
        arr1.add(2);
        arr1.add(4);
        arr1.add(7);
        arr1.add(9);
        arr1.add(4);
        arr1.add(1);

        Result.customSort(arr1);
        assertEquals("3\n7\n9\n1\n1\n2\n2\n4\n4\n", outContent.toString());
    }


}
