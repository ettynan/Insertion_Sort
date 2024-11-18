package com.example.insertion_sort;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import java.util.ArrayList;
import java.util.List;
import androidx.core.text.HtmlCompat;

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

        // Set up the Quit button functionality
        binding.buttonQuit.setOnClickListener(v -> {
            // Quit the app by finishing the activity
            if (getActivity() != null) {
                getActivity().finish();
            }
        });
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
        arrayString.append("<br>");

        // Add the header for the sorting steps
        arrayString.append(getString(R.string.sorting_header)).append("<br>");

        // Perform insertion sort and append each step to the StringBuilder
        List<String> sortingSteps = insertionSort(inputArray);
        for (int i = 0; i < sortingSteps.size(); i++) {
            // Get the current sorting step and format it with the bolded number
            String formattedStep = boldSortedNumberInStep(sortingSteps.get(i), i);
            arrayString.append(formattedStep).append("<br>");
        }
        // Use Html.fromHtml() to render the formatted text with bold numbers
        binding.textViewInputArray.setText(HtmlCompat.fromHtml(arrayString.toString(), HtmlCompat.FROM_HTML_MODE_LEGACY));
    }

    protected String boldSortedNumberInStep(String step, int indexToBold) {
        // Split the step into individual strings (numbers) based on spaces
        String[] splitStep = step.split(" ");
        StringBuilder formattedStep = new StringBuilder();
        for (int j = 0; j < splitStep.length; j++) {
            // If reach the number to be bolded (based on the indexToBold parameter), apply the <b> HTML tag
            if (j == indexToBold) {
                formattedStep.append("<b>").append(splitStep[j]).append("</b>").append(" ");
            } else {
                formattedStep.append(splitStep[j]).append(" ");
            }
        }
        return formattedStep.toString();
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

            // Move elements of array[0..i-1] that are greater than key
            // to one position ahead of their current position
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;

            // Record the state of the array after each step
            StringBuilder step = new StringBuilder();
            for (int k = 0; k < n; k++) {
                if (k == i) {
                    // Bold the number being sorted
                    step.append("<b>").append(array[k]).append("</b>").append(" ");
                } else {
                    step.append(array[k]).append(" ");
                }
            }
            sortingSteps.add(step.toString());
        }
        return sortingSteps;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}