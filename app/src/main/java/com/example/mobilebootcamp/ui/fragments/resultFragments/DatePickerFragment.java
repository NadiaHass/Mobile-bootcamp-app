package com.example.mobilebootcamp.ui.fragments.resultFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.mobilebootcamp.R;

import java.util.Calendar;

public class DatePickerFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_date_picker, container, false);

        DatePicker datePicker = view.findViewById(R.id.datePicker);
        TextView textView = view.findViewById(R.id.tv_date);
        Button getDateButton = view.findViewById(R.id.btn_get_date);

        // set the initial date of the DatePicker
        Calendar calendar = Calendar.getInstance();
        datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), null);

        getDateButton.setOnClickListener(v -> {
            int year = datePicker.getYear();
            int month = datePicker.getMonth();
            int day = datePicker.getDayOfMonth();

            textView.setText(year + " / " + month + " / " + day);
        });


        return view;
    }
}