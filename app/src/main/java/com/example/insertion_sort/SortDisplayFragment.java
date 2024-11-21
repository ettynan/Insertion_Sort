package com.example.insertion_sort;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.List;

import com.example.insertion_sort.databinding.FragmentSortDisplayBinding;

public class SortDisplayFragment extends Fragment {

    private FragmentSortDisplayBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSortDisplayBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Retrieve the ArrayList safely to avoid null warnings using ternary operator (? :)
        ArrayList<Integer> inputList = getArguments() != null
                ? getArguments().getIntegerArrayList("inputArray")
                : null;

        // Check if the inputList is null. If is null, display an error message and stop.
        if (inputList == null) {
            // Set the textView to show a "no input array" message defined in the string resources.
            binding.textViewInputArray.setText(getString(R.string.no_input_array));
            return; // Exit the method since there is no valid input to process.
        }

        // inputList is NOT null, so convert it to an int array.
        int[] inputArray = convertArrayListToArray(inputList);
        displayArray(inputArray);

        // Set up the Quit button functionality
        binding.buttonQuit.setOnClickListener(v -> {
            // Quit the app by finishing the activity
            if (getActivity() != null) {
                getActivity().finish();
            }
        });
    }

    // Display the array and sorted array
    protected void displayArray(int[] inputArray) {
        // Display the original array
        StringBuilder arrayString = new StringBuilder("Input Array: ");
        for (int num : inputArray) {
            arrayString.append(num).append(" ");  // Efficient concatenation with StringBuilder
        }
        arrayString.append("\n");

        // Add the header for the sorting steps
        arrayString.append(getString(R.string.sorting_header)).append("\n");

        // Perform insertion sort and append each step to the StringBuilder
        List<String> sortingSteps = insertionSort(inputArray);
        for (String step : sortingSteps) {
            // Append sorting steps to the display string
            arrayString.append(step).append("\n");
        }
        binding.textViewInputArray.setText(arrayString.toString());
    }

    // Convert ArrayList to integer array
    protected int[] convertArrayListToArray(ArrayList<Integer> arrayList) {
        int[] array = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            array[i] = arrayList.get(i);
        }
        return array;
    }

    // Insertion Sort without built-in sorting functions/libraries
    protected List<String> insertionSort(int[] array) {
        List<String> sortingSteps = new ArrayList<>();
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;
            boolean isSorted = false;  // Flag to check if the array is sorted after the pass


            // Move elements of array[0..i-1] that are greater than key
            // to one position ahead of their current position
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
                isSorted = true;  // Array is no longer sorted, so set flag to false
            }
            array[j + 1] = key;


            // Record the state of the array after each step
            if (isSorted) {
                StringBuilder step = new StringBuilder();
                for (int value : array) {
                    step.append(value).append(" ");
                }
                sortingSteps.add(step.toString());
            }
        }
        return sortingSteps;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}