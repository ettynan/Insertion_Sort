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
            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}