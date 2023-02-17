package com.example.mobilebootcamp.ui.fragments.resultFragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mobilebootcamp.R;
import com.example.mobilebootcamp.databinding.FragmentIntentEmailBinding;
import com.example.mobilebootcamp.databinding.FragmentJavaCodeBinding;

public class IntentEmailFragment extends Fragment {
    private FragmentIntentEmailBinding binding;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentIntentEmailBinding.inflate(inflater, container, false);
        binding.btnSendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // intent to email
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[] {String.valueOf(binding.edEmailDestination.getText())});
                intent.putExtra(Intent.EXTRA_SUBJECT, String.valueOf(binding.edSubject.getText()));
                intent.putExtra(Intent.EXTRA_TEXT, String.valueOf(binding.edContent.getText()));
                startActivity(Intent.createChooser(intent, "Send email"));
            }
        });
        // Inflate the layout for this fragment
        return binding.getRoot();
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}