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
    /**
     * Rigorous Test.
     */

    @Test
    public void testExample1() {
        int n = 5;
        long k = 10;
        assertEquals(14, Solution.maxMoney(n, k));
    }

    @Test
    public void testExample2() {
        int n = 3;
        long k = 3;
        assertEquals(5, Solution.maxMoney(n, k));
    }


}
