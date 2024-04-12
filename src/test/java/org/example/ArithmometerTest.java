package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArithmometerTest {

    @Test
    void calculate() {
        String exp = "10+25*2/2";
        int result = Arithmometer.calculate(exp);
        assertEquals(result, 35);
    }
}