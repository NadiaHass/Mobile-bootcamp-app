package com.example.mobilebootcamp.ui.fragments.resultFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.mobilebootcamp.R;
import com.example.mobilebootcamp.data.ScoreFragmentViewModel;

public class ViewModelFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_model, container, false);

        ScoreFragmentViewModel scoreViewModel = new ViewModelProvider(requireActivity()).get(ScoreFragmentViewModel.class);

        Button incrementButton = view.findViewById(R.id.btn_increment);

        TextView scoreTextView = view.findViewById(R.id.tv_score);

        scoreTextView.setText(String.valueOf(scoreViewModel.score));

        incrementButton.setOnClickListener(v -> {
            scoreViewModel.score ++;
            scoreTextView.setText(String.valueOf(scoreViewModel.score));
        });

        return view;
    }
}