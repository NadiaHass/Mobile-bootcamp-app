package com.example.mobilebootcamp.ui.fragments.resultFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.mobilebootcamp.R;

public class PopupMenuFragment extends Fragment {
    Button btn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_popup_menu, container, false);
        btn = view.findViewById(R.id.btn_popup);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show the popup menu
                showPopupMenu(v);
            }
        });
        // Inflate the layout for this fragment
        return view;
    }
    private void showPopupMenu(View v) {
        PopupMenu popupMenu = new PopupMenu(getActivity(), v);
        popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

        // Set up the click listener for the popup menu items
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.option1) {
                    Toast.makeText(getContext(), "You choosed the first option", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (item.getItemId() == R.id.option2) {
                    Toast.makeText(getContext(), "You choosed the second option", Toast.LENGTH_SHORT).show();
                    return true;
                } else if (item.getItemId() == R.id.option3) {
                    Toast.makeText(getContext(), "You choosed the third option", Toast.LENGTH_SHORT).show();
                    return true;
                } else {
                    return false;
                }
            }
        });
        // Show the popup menu
        popupMenu.show();
    }
}