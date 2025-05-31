package com.automationexercise.tests.base;

public class TestUtilities extends BaseTest {
    // Espera estatica
    protected void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            log.warn("Problems when performing static waiting: " + e.getMessage());
        }
    }
}
