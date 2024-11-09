package com.example.insertion_sort;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
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
        ArrayList<Integer> inputArray = null;
        if (getArguments() != null) {
            inputArray = getArguments().getIntegerArrayList("inputArray");
        }
        // Check if the ArrayList is null before using it
        if (inputArray != null) {
            // Display the original array in a TextView
            StringBuilder arrayString = new StringBuilder("Input Array: ");
            for (int num : inputArray) {
                arrayString.append(num).append(" ");
            }

            // Assuming you have a TextView with the ID textViewInputArray in your layout
            TextView inputArrayTextView = binding.textViewInputArray;
            inputArrayTextView.setText(arrayString.toString());
        } else {
            // Use the string resource for the default message
            binding.textViewInputArray.setText(getString(R.string.no_input_array));
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}