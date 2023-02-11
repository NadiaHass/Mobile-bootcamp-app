package com.example.mobilebootcamp.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mobilebootcamp.R;
import com.example.mobilebootcamp.databinding.FragmentXmlCodeBinding;

public class XmlCodeFragment extends Fragment {
    private FragmentXmlCodeBinding binding;

    @Override
    public View onCreateView (@NonNull LayoutInflater inflater,
                              ViewGroup container,
                              Bundle savedInstanceState) {
        binding = FragmentXmlCodeBinding.inflate(inflater, container, false);

        String javaCode = getArguments().getString("lesson");

        binding.codeView.setCode(javaCode , "xml");

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}