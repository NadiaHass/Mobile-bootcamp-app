package com.example.mobilebootcamp.ui.fragments.resultFragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mobilebootcamp.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class AlertDialogFragment extends Fragment {
    private EditText name;
    private Dialog dialog2;
    private BottomSheetDialog dialog3;
    private EditText age;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_alert_dialog, container, false);
        Button alertdial = view.findViewById(R.id.dialog1);
        Button custmdial = view.findViewById(R.id.dialog2);
        Button bottomdial = view.findViewById(R.id.dialog3);
        name = view.findViewById(R.id.ed_name_alert_dialog);
        age = view.findViewById(R.id.ed_age_alert_dialog);

        alertdial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialog1 = new AlertDialog.Builder(getContext());
                dialog1.setTitle("Welcome");
                dialog1.setMessage("Hello "+String.valueOf(name.getText())+" this is an alert dialog." +
                        "\nDo you want to delete your name ?");
                dialog1.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        name.setText("");
                    }
                });
                dialog1.setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                dialog1.show();
            }
        });
        custmdial.setOnClickListener(v->{
            ShowDialog();
        });
        bottomdial.setOnClickListener( v->{
          ShowBottomDialog();
                });

        return view;
    }
    private void ShowDialog(){
        dialog2=new Dialog(getContext());
        LinearLayout layout=new LinearLayout(getContext());
        layout.addView(View.inflate(getContext(),R.layout.simple_dialogue_example,null));
        dialog2.setContentView(layout);
        dialog2.show();

        Button close2=dialog2.findViewById(R.id.btn_close1);
        Button Next=dialog2.findViewById(R.id.btn_next);
        TextView text1=dialog2.findViewById(R.id.name);
        TextView text2=dialog2.findViewById(R.id.age);
        text1.setText(name.getText().toString());
        text2.setText(age.getText().toString());
        Next.setOnClickListener(v0 ->{
            dialog2.dismiss();
            ShowBottomDialog();
        });
        close2.setOnClickListener(v1->{
            dialog2.dismiss();
        });
    }
    private void ShowBottomDialog(){

        dialog3 = new BottomSheetDialog(getContext());
        LinearLayout layout = new LinearLayout(getContext());
        layout.addView(View.inflate(getContext(), R.layout.bottom_sheet_dialogue, null));
        dialog3.setContentView(layout);
        TextView text=dialog3.findViewById(R.id.name);
        text.setText(name.getText().toString() +"      " +age.getText().toString());
        dialog3.show();

        Button close2=dialog3.findViewById(R.id.btn_close2);
        Button previous=dialog3.findViewById(R.id.btn_previous);
        previous.setOnClickListener(v0 ->{
            dialog3.dismiss();
            ShowDialog();
        });
        close2.setOnClickListener(v2->{
            dialog3.dismiss();
        });


    }
}