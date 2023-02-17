package com.example.mobilebootcamp.ui.fragments.resultFragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.mobilebootcamp.R;


public class OptionMenuFragment extends Fragment {
    FrameLayout frame;
    private Toolbar toolbar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_option_menu, container, false);
        frame = view.findViewById(R.id.menu_background);
        toolbar = view.findViewById(R.id.toolbar);

        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        // Inflate the layout for this fragment
        return view;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the fragment's options menu to be shown in the app bar
        setHasOptionsMenu(true);

    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.option_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_blue:
                int color = ContextCompat.getColor(getContext(), R.color.blue);
                frame.setBackgroundColor(color);
                // Do something
                return true;
            case R.id.action_red:
                int color_red = ContextCompat.getColor(getContext(), R.color.red);
                frame.setBackgroundColor(color_red);
                // Do something else
                return true;
            case R.id.action_green:
                int color_green = ContextCompat.getColor(getContext(), R.color.green);
                frame.setBackgroundColor(color_green);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }
}