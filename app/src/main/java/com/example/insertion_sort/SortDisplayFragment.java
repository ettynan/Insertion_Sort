package com.example.insertion_sort;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;

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

       // Retrieve the ArrayList passed from InputFragment
        int[] inputArray = null;
        if (getArguments() != null) {
            ArrayList<Integer> arrayList = getArguments().getIntegerArrayList("inputArray");
            if (arrayList != null) {
                inputArray = convertArrayListToArray(arrayList);
            } else {
                // For the case where the "inputArray" is not in the arguments
                binding.textViewInputArray.setText(getString(R.string.no_input_array));
                return;
            }
        } else {
            // Use the string resource for the default message
            binding.textViewInputArray.setText(getString(R.string.no_input_array));
        }
        displayArray(inputArray);
    }

    // Display the array and sorted array
    private void displayArray(int[] inputArray) {
        if (inputArray == null) {
            binding.textViewInputArray.setText(getString(R.string.no_input_array));
            return;
        }

        // Display the original array
        StringBuilder arrayString = new StringBuilder("Input Array: ");
        for (int num : inputArray) {
            arrayString.append(num).append(" ");  // Efficient concatenation with StringBuilder
        }
        binding.textViewInputArray.setText(arrayString.toString());

        // Perform the Insertion Sort
        insertionSort(inputArray);

        // Display sorted array using StringBuilder
        StringBuilder sortedArrayString = new StringBuilder("Sorted Array: ");
        for (int num : inputArray) {
            sortedArrayString.append(num).append(" ");
        }
        binding.textViewSortedArray.setText(sortedArrayString.toString());
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
    protected void insertionSort(int[] array) {
        int n =array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;

            // Move elements of array[0..i-1] that are greater than key
            // to one position ahead of their current position
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}