package com.zhangziqi;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.zhangziqi.Enum.StringProcessEnum;

/**
 * This class contains unit tests for the Main class.
 * It verifies the behavior of the Main class under different conditions.
 */
class MainTest {
    //private final StringRemovalProcessor processor = new StringRemovalProcessor();
    private final String REMOVAL = StringProcessEnum.REMOVAL.name();
    private final String REPLACEMENT = StringProcessEnum.REPLACEMENT.name();

    /**
     * Tests the Main class with the REMOVAL mode.
     * This test checks that the program runs without throwing any exceptions
     * when provided with valid arguments in "remove" mode.
     */
    @Test
    void testMainWithRemoveMode() {
        // Prepare the arguments for the main method
        String[] args = {REMOVAL, "aabcccbbad"};
        // Call the main method with the prepared arguments
        Main.main(args);
        // Testing that it runs without exceptions
        assertTrue(true);
    }

    /**
     * Tests the Main class with the REPLACEMENT mode.
     * This test checks that the program runs without throwing any exceptions
     * when provided with valid arguments in "replace" mode.
     */
    @Test
    void testMainWithReplaceMode() {
        // Prepare the arguments for the main method
        String[] args = {REPLACEMENT, "abcccbad"};
        // Call the main method with the prepared arguments
        Main.main(args);
        // Testing that it runs without exceptions
        assertTrue(true);
    }


    /**
     * Tests the Main class with insufficient arguments.
     * This test checks that the program runs without throwing any exceptions
     * when provided with insufficient arguments.
     * It also verifies that the program handles the case where not enough arguments are provided.
     */
    @Test
    void testMainWithInsufficientArgs() {
        // Prepare the arguments for the main method (insufficient arguments)
        String[] args = {REPLACEMENT};
        // Call the main method with the prepared arguments
        Main.main(args);
        // Testing that it runs without exceptions
        assertTrue(true);
    }
}