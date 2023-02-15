package com.example.mobilebootcamp.ui.fragments.resultFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mobilebootcamp.R;
import com.example.mobilebootcamp.databinding.FragmentIntentPassDataBinding;
import com.example.mobilebootcamp.ui.activities.LessonActivity;

public class IntentPassDataFragment extends Fragment {
    FragmentIntentPassDataBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentIntentPassDataBinding.inflate(inflater, container, false);

        binding.btnChangeActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("name",String.valueOf(binding.edName.getText()));
                bundle.putString("age",String.valueOf(binding.edAge.getText()));

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                IntentPassDataOtherFragment newFragment = new IntentPassDataOtherFragment();
                newFragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.fragment_container, newFragment);

                //This will allow the user to navigate back
                // to the current fragment by pressing the back button.
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
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