package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegerValueTest {

    @Test
    public void testIncrement() {
        IntegerValue value = new IntegerValue(10);
        IntegerValue incrementedValue = value.increment();

        assertEquals(11, incrementedValue.fetchValue());
    }

    @Test
    public void testDecrement() {
        IntegerValue value = new IntegerValue(10);
        IntegerValue decrementedValue = value.decrement();

        assertEquals(9, decrementedValue.fetchValue());
    }

    @Test
    public void testIsPositive() {
        IntegerValue value = new IntegerValue(10);

        assertTrue(value.isPositive());
    }

    @Test
    public void testIsLessThan() {
        IntegerValue value = new IntegerValue(10);

        assertTrue(value.isLessThan(20));
    }
}