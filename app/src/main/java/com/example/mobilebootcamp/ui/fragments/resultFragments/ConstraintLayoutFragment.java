package com.example.mobilebootcamp.ui.fragments.resultFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mobilebootcamp.R;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;


public class ConstraintLayoutFragment extends Fragment implements View.OnClickListener {
boolean clicked=false;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_constraint_layout, container, false);
        ViewGroup layout=(ViewGroup)view;
        int childCount=layout.getChildCount();
        for (int i=0;i<childCount;i++)layout.getChildAt(i).setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        if (clicked)return;
        clicked=true;
        String message;
        switch (view.getId()){
            case R.id.btn_0:message="I am view_0\nmy position is left to left of parent and top to top of parent";break;
            case R.id.btn_1:message="I am view_1\nmy position is top to top of parent and left to right of view 0 ";break;
            case R.id.btn_2:message="I am view_2\nmy position is left to left of parent and top to bottom of view 0";break;
            case R.id.btn_3:message="I am view_3\nmy position is right to right of parent and top to top of parent";break;
            case R.id.btn_4:message="I am view_4\nmy position is left to right of view2 and right to left of view3";break;
            case R.id.btn_5:message="I am view_5\nmy position is top,right,left,bottom to top,right,left,bottom of parent";break;
            case R.id.btn_6:message="I am view_6\nmy position is left to left of parent and top to bottom of view 5";break;
            case R.id.btn_7:message="I am view_7\nmy position is top to top of parent and bottom to bottom of view 6 ";break;
            case R.id.btn_8:message="I am view_8\nmy position is center between view 5 bottom and parent bottom,right and left to right of view 9";break;
            case R.id.btn_9:message="I am view_9\nmy position  is center between view 5 bottom and parent bottom,left and right to left of view 8\"";break;
            case R.id.btn_10:message="I am view_10\nmy position is right to left of view 11 and parent bottom,left with weight 1 ";break;
            case R.id.btn_11:message="I am view_11\nmy position is bottom to bottom of parent and right to right of parent ";break;

            default:message="hi";
        }
        Snackbar.make(view,message, BaseTransientBottomBar.LENGTH_LONG).show();
        //Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
        clicked=false;
    }
}