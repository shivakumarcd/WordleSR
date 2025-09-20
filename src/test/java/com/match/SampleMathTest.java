package com.match;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SampleMathTest {

    @Test
    void testAdd() {
        SampleMath math = new SampleMath();
        int result = math.add(2, 3);
        assertEquals(5, result); // check if 2+3=5
    }
}
