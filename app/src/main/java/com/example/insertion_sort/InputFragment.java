package com.example.insertion_sort;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;
import androidx.navigation.NavController;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.annotation.Nullable;
import androidx.navigation.fragment.NavHostFragment;

import com.example.insertion_sort.databinding.FragmentInputBinding;

import java.util.ArrayList;

public class InputFragment extends Fragment {

    protected FragmentInputBinding binding;

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment using View Binding
        binding = FragmentInputBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // Set the user-friendly message in the TextView
        binding.textViewMessage.setText(getString(R.string.values_to_sort));

        // Set up button click listener
        binding.buttonSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = binding.editTextArray.getText().toString().trim();
                if (isInputValid(inputText)) {
                    //Convert input text to integer array
                    int[] convertedArray = convertInputToArray(inputText);
                    ArrayList<Integer> inputArray = new ArrayList<>();
                    for (int num : convertedArray) {
                        inputArray.add(num);
                    }

                    // Create a bundle to pass the array to the next fragment
                    Bundle bundle = new Bundle();
                    bundle.putIntegerArrayList("inputArray", inputArray);

                    // Find the NavController and navigate to the next fragment
                    NavController navController = NavHostFragment.findNavController(InputFragment.this);
                    navController.navigate(R.id.action_inputFragment_to_sortDisplayFragment, bundle);
                    // Call your sorting method here
                } else {
                    // Show specific error message if invalid
                    String errorMessage = getValidationErrorMessage(inputText);
                    Toast.makeText(getActivity(), errorMessage, Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Set up editor action listener for "Enter" key
        binding.editTextArray.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, android.view.KeyEvent event) {
                // Check if the action is "Enter" key press (IME_ACTION_DONE or ENTER)
                if (actionId == EditorInfo.IME_ACTION_DONE || event != null && event.getKeyCode() == android.view.KeyEvent.KEYCODE_ENTER) {
                    String inputText = binding.editTextArray.getText().toString().trim();

                    // Check if the input is "quit"
                    if (inputText.equalsIgnoreCase("quit")) {
                        // Ensure the fragment is attached to an activity before calling finish
                        if (getActivity() != null) {
                            getActivity().finish();  // Close the activity
                        }
                    }
                    // Return true to indicate that the action was handled
                    return true;
                }
                return false;  // Let the default behavior handle other cases
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        // Clear the input field using ViewBinding
        if (binding != null) {
            binding.editTextArray.setText(""); // Clears the EditText
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    // Validate input format
    public boolean isInputValid(String inputText) {
        // Trim the input first to remove any leading/trailing spaces
        inputText = inputText.trim();

        // Check if the input is empty
        if (inputText.isEmpty()) return false;

        // Split the input into an array of strings
        String[] numbers = inputText.split(" ");

        // Ensure the number of inputs is between 3 and 8
        if (numbers.length < 3 || numbers.length > 8) return false;

        // Validate each number in the array
        for (String num : numbers) {
            // Attempt to parse the string as an integer
            try {
                int value = Integer.parseInt(num);
                // Ensure the value is between 0 and 9
                if (value < 0 || value > 9) return false;
            } catch (NumberFormatException e) {
                // Return false if the parsing fails
                return false;
            }
        }
        // Return true if all checks pass
        return true;
    }

    // Method to get a specific error message
    public String getValidationErrorMessage(String inputText) {
        // Trim the input to handle leading/trailing spaces
        inputText = inputText.trim();

        // Return an error message if input is empty
        if (inputText.isEmpty()) {
            return getString(R.string.no_input_array);
        }

        // Split the input into an array of strings based on spaces
        String[] numbers = inputText.split(" ");

        if (numbers.length < 3 || numbers.length > 8) {
            return getString(R.string.error_size_mismatch);
        }
        // Loop through each element of the array to validate individual numbers
        for (String num : numbers) {
            try {
                // Try to parse the string to an integer
                int value = Integer.parseInt(num);
                if (value < 0 || value > 9) {
                    return getString(R.string.error_invalid_input);
                }
            } catch (NumberFormatException e) {
                // Return the non-numeric error message if the number cannot be parsed
                return getString(R.string.error_non_numeric);
            }
        }
        return null; // No error message -  input is valid
    }

    // Convert input string to an integer array
    private int[] convertInputToArray(String inputText) {
        String[] numbers = inputText.split(" ");
        int[] array = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            array[i] = Integer.parseInt(numbers[i]);
        }
        return array;
    }
}