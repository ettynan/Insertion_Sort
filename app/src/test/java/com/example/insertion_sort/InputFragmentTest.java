package com.example.insertion_sort;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

// Test class for InputFragment to validate input handling
public class InputFragmentTest {

    // Test case to validate that a correct input string returns true
    @Test
    public void testIsInputValid_ValidInput() {
        // Create an instance of InputFragment
        InputFragment fragment = new InputFragment();
        String input = "1 2 3 4";
        // Assert that the input is valid
        assertTrue(fragment.isInputValid(input));
    }

    // Test case to check that input with too few numbers returns false
    @Test
    public void testIsInputValid_InvalidInput_TooFewNumbers() {
        // Create an instance of InputFragment
        InputFragment fragment = new InputFragment();
        String input = "1 2";
        // Assert that the input is invalid
        assertFalse(fragment.isInputValid(input));
    }

    // Test case to check that input with too many numbers returns false
    @Test
    public void testIsInputValid_InvalidInput_TooManyNumbers() {
        // Create an instance of InputFragment
        InputFragment fragment = new InputFragment();
        String input = "1 2 3 4 5 6 7 8 9";
        // Assert that the input is invalid
        assertFalse(fragment.isInputValid(input));
    }

    // Test case to check that input containing non-numeric values returns false
    @Test
    public void testIsInputValid_InvalidInput_NonNumeric() {
        // Create an instance of InputFragment
        InputFragment fragment = new InputFragment();
        String input = "1 2 a 4";
        // Assert that the input is invalid
        assertFalse(fragment.isInputValid(input));
    }

    // Test case to check that input with numbers out of the defined range returns false
    @Test
    public void testIsInputValid_InvalidInput_OutOfRange() {
        // Create an instance of InputFragment
        InputFragment fragment = new InputFragment();
        String input = "1 2 10";
        // Assert that the input is invalid
        assertFalse(fragment.isInputValid(input));
    }

    // Test case to check that empty input returns false
    @Test
    public void testIsInputValid_EmptyInput() {
        // Create an instance of InputFragment
        InputFragment fragment = new InputFragment();
        String input = "";
        // Assert that the input is invalid
        assertFalse(fragment.isInputValid(input));
    }
}
