package com.example.insertion_sort;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
// Added 10/29/2024
import androidx.annotation.Nullable;

import com.example.insertion_sort.databinding.FragmentInputBinding;

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

        // Set up button click listener
        binding.buttonSort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = binding.editTextArray.getText().toString().trim();
                if (isInputValid(inputText)) {
                    // Proceed with sorting logic here
                    Toast.makeText(getActivity(), "Valid input: " + inputText, Toast.LENGTH_SHORT).show();
                    // Call your sorting method here
                } else {
                    Toast.makeText(getActivity(), "Please enter a valid array of integers (0-9) with size between 3 and 8.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    // Validate input format
    public boolean isInputValid(String inputText) {
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

}