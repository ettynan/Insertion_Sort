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

    // Test for input with commas instead of spaces
    @Test
    public void testIsInputValid_InvalidInput_WithCommas() {
        // Create an instance of InputFragment
        InputFragment fragment = new InputFragment();
        String input = "1,2,3,4";  // Uses commas instead of spaces
        // Assert that the input is invalid
        assertFalse(fragment.isInputValid(input));
    }

    // Test for input with multiple spaces between numbers
    @Test
    public void testIsInputValid_InvalidInput_WithMultipleSpaces() {
        // Create an instance of InputFragment
        InputFragment fragment = new InputFragment();
        String input = "1  2 3 4";  // Extra spaces between numbers
        // Assert that the input is invalid if you expect single spaces
        assertFalse(fragment.isInputValid(input));
    }

    // Test for input with leading or trailing spaces
    @Test
    public void testIsInputValid_LeadingTrailingSpaces() {
        // Create an instance of InputFragment
        InputFragment fragment = new InputFragment();
        String input = " 1 2 3 4 ";  // Leading and trailing spaces
        // Assert that the input is valid after trimming the spaces
        assertTrue(fragment.isInputValid(input));
    }

    // Test case for input with valid numbers but with leading zeros
    @Test
    public void testIsInputValid_ValidInput_WithLeadingZero() {
        // Create an instance of InputFragment
        InputFragment fragment = new InputFragment();
        String input = "01 02 03";  // Leading zeros in numbers
        // Assert that the input is valid if leading zeros are allowed
        assertTrue(fragment.isInputValid(input));
    }

    // Test case for input with whitespace-only input
    @Test
    public void testIsInputValid_WhitespaceOnlyInput() {
        // Create an instance of InputFragment
        InputFragment fragment = new InputFragment();
        String input = "    ";  // Only spaces
        // Assert that the input is invalid (empty input after trimming)
        assertFalse(fragment.isInputValid(input));
    }

    // Test case for input where numbers are in descending order
    @Test
    public void testIsInputValid_ValidInput_DescendingOrder() {
        // Create an instance of InputFragment
        InputFragment fragment = new InputFragment();
        String input = "9 8 7 6 5";  // Valid numbers, descending order
        // Assert that the input is valid
        assertTrue(fragment.isInputValid(input));
    }

}
