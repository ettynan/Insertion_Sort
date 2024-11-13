package com.example.insertion_sort;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
import java.util.ArrayList;

public class SortDisplayFragmentTest {

    private final SortDisplayFragment fragment = new SortDisplayFragment();

    @Test
    public void testInsertionSort() {
        // Test to verify that the insertionSort method correctly sorts an array
        // with multiple elements, including duplicates.
        int[] unsortedArray = {5, 2, 9, 1, 5, 6};
        int[] expectedSortedArray = {1, 2, 5, 5, 6, 9};

        // Perform the insertion sort on the array
        fragment.insertionSort(unsortedArray);

        // Assert that the sorted array matches the expected sorted order
        assertArrayEquals(expectedSortedArray, unsortedArray);
    }

    @Test
    public void testInsertionSortWithEmptyArray() {
        // Test to check the behavior of insertionSort with an empty array.
        // Expected result is an unchanged empty array.
        int[] unsortedArray = {};
        int[] expectedSortedArray = {};

        // Perform the insertion sort on the empty array
        fragment.insertionSort(unsortedArray);

        // Assert that the empty array remains unchanged
        assertArrayEquals(expectedSortedArray, unsortedArray);
    }

    @Test
    public void testInsertionSortWithSingleElement() {
        // Test to check the behavior of insertionSort with a single-element array.
        // Expected result is the unchanged array with the single element.
        int[] unsortedArray = {3};
        int[] expectedSortedArray = {3};

        // Perform the insertion sort on the single-element array
        fragment.insertionSort(unsortedArray);

        // Assert that the single-element array remains unchanged
        assertArrayEquals(expectedSortedArray, unsortedArray);
    }

    @Test
    public void testConvertArrayListToArray() {
        // Test to verify that the convertArrayListToArray method correctly
        // converts a populated ArrayList<Integer> to an int array.
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(3);
        arrayList.add(1);
        arrayList.add(4);
        arrayList.add(1);
        arrayList.add(5);

        int[] expectedArray = {3, 1, 4, 1, 5};

        // Convert the ArrayList to an int array
        int[] resultArray = fragment.convertArrayListToArray(arrayList);

        // Assert that the resulting array matches the expected array
        assertArrayEquals(expectedArray, resultArray);
    }

    @Test
    public void testConvertArrayListToArrayEmpty() {
        // Test to check the behavior of convertArrayListToArray with an empty ArrayList.
        // Expected result is an empty int array.
        ArrayList<Integer> arrayList = new ArrayList<>();

        int[] expectedArray = {};

        // Convert the empty ArrayList to an int array
        int[] resultArray = fragment.convertArrayListToArray(arrayList);

        // Assert that the resulting array is empty as expected
        assertArrayEquals(expectedArray, resultArray);
    }
}
