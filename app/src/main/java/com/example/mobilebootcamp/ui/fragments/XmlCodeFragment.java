package com.example.mobilebootcamp.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mobilebootcamp.R;
import com.example.mobilebootcamp.databinding.FragmentXmlCodeBinding;

import io.github.kbiakov.codeview.adapters.Options;
import io.github.kbiakov.codeview.highlight.ColorTheme;

public class XmlCodeFragment extends Fragment {
    private FragmentXmlCodeBinding binding;

    @Override
    public View onCreateView (@NonNull LayoutInflater inflater,
                              ViewGroup container,
                              Bundle savedInstanceState) {
        binding = FragmentXmlCodeBinding.inflate(inflater, container, false);

        String xmlCode = getArguments().getString("lesson");

        binding.codeView.setOptions(Options.Default.get(getActivity())
                .withLanguage("xml")
                .withCode(xmlCode)
                .withTheme(ColorTheme.SOLARIZED_LIGHT));

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}