package com.example.Utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class LogUtilsTest {

    @Test
    public void info() {
        LogUtils.error("This is an INFO message.", "INFO", null);
        LogUtils.info("An error occurred: {}", "ERROR", new Object[]{"File not found"});
        LogUtils.debug("Debug message with multiple arguments: {} {} {}", "DEBUG", new Object[]{1, "two", 3.0});

    }
}
