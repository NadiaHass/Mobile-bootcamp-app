package com.example.mobilebootcamp.ui.fragments.resultFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.mobilebootcamp.R;

public class RelativeLayoutFragment extends Fragment implements View.OnClickListener {
    boolean clicked=false;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_relative_layout, container, false);
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
            case R.id.view_0:message="I am view_0\nmy position is default position or align parent to top left";break;
            case R.id.view_1:message="I am view_1\nmy position is align parent layout in right";break;
            case R.id.view_2:message="I am view_2\nmy position is align parent layout in bottom";break;
            case R.id.view_3:message="I am view_3\nmy position is align parent layout to bottom right";break;
            case R.id.view_4:message="I am view_4\nmy position is center in my parent layout or center horizontal + center vertical";break;
            case R.id.view_5:message="I am view_5\nmy position is align view 4 in top";break;
            case R.id.view_6:message="I am view_6\nmy position is align view 4 in bottom";break;
            case R.id.view_7:message="I am view_7\nmy position is align view 4 in center vertical";break;
            case R.id.view_8:message="I am view_8\nmy position is align view 4 in left";break;
            case R.id.view_9:message="I am view_9\nmy position is align view 4 in right";break;
            case R.id.view_10:message="I am view_10\nmy position is above of view 4";break;
            case R.id.view_11:message="I am view_11\nmy position is below of view 4";break;
            case R.id.view_12:message="I am view_12\nmy position is to left of view 4";break;
            case R.id.view_13:message="I am view_13\nmy position is to right of view 4";break;
            case R.id.view_14:message="I am view_14\nmy position is to right of view 4 and above it";break;
            case R.id.view_15:message="I am view_15\nmy position is align view 4 in right and above view 14";break;
            case R.id.view_16:message="I am view_16\nmy position is below of view 4 and and align him in left and right";break;
            case R.id.view_17:message="I am view_17\nmy position is align parent layout in right and align view 4 in bottom and align view 15 in top";break;
            case R.id.view_18:message="I am view_18\nmy position is align view 4 in top right";break;
            default:message="hi";
        }
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
        clicked=false;
    }
}