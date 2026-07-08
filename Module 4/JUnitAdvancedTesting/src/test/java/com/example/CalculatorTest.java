package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    @Order(1)
    @Tag("calculator")
    void shouldAddTwoNumbers() {
        assertEquals(5, calculator.add(2, 3));
    }

    @Test
    @Order(2)
    @Tag("calculator")
    void shouldSubtractTwoNumbers() {
        assertEquals(1, calculator.subtract(3, 2));
    }

    @Test
    @Order(3)
    void shouldThrowExceptionForInvalidInput() {
        ExceptionThrower thrower = new ExceptionThrower();
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, thrower::throwException);
        assertEquals("This is an exception", exception.getMessage());
    }

    @Test
    @Order(4)
    void shouldCompleteWithinTimeout() {
        assertTimeout(Duration.ofSeconds(1), () -> {
            Thread.sleep(100);
        });
    }
}
