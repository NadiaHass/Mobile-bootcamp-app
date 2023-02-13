package com.example.mobilebootcamp.ui.fragments.resultFragments;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.RadioGroup;

import com.example.mobilebootcamp.R;

public class AnimFragment extends Fragment {
    Animation scale,translate,rotate,alpha,currentAnimation;
    Interpolator reverse, custom, currentInterpolator;
    int duration=500;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scale= AnimationUtils.loadAnimation(getContext(),R.anim.scale);
        translate =AnimationUtils.loadAnimation(getContext(),R.anim.translate);
        rotate =AnimationUtils.loadAnimation(getContext(),R.anim.rotate);
        alpha=AnimationUtils.loadAnimation(getContext(),R.anim.alpha);
        reverse=new Interpolator() {
            @Override
            public float getInterpolation(float v) {
                return 1-v;
            }
        };
        custom=new Interpolator() {
            @Override
            public float getInterpolation(float v) {
                return (float)(Math.pow(Math.E,-v/0.3)*Math.sin(10*v)+1);
            }
        };
        currentAnimation=alpha;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_anim, container, false);
        View moraba3=view.findViewById(R.id.moraba3);
        RadioGroup animGroup=view.findViewById(R.id.anim);
        RadioGroup durationGroup=view.findViewById(R.id.duration);
        RadioGroup interpolatorGroup=view.findViewById(R.id.interpolator);
        moraba3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moraba3.startAnimation(currentAnimation);
            }
        });
        animGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.alpha:currentAnimation=alpha;break;
                    case R.id.scale:currentAnimation=scale;break;
                    case R.id.rotate:currentAnimation=rotate;break;
                    case R.id.translate:currentAnimation=translate;break;
                    default:break;
                }
                currentAnimation.setDuration(duration);
                currentAnimation.setInterpolator(currentInterpolator);
            }
        });
        durationGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.short_time: duration=500;
                    default: duration=1000;
                }
                currentAnimation.setDuration(duration);
            }
        });
        interpolatorGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
               switch (i){
                   case R.id.linear :currentInterpolator=new LinearInterpolator();break;
                   case R.id.accelerate :currentInterpolator=new AccelerateInterpolator();break;
                   case R.id.decelerate :currentInterpolator=new DecelerateInterpolator();break;
                   case R.id.anticipate :currentInterpolator=new AnticipateInterpolator();break;
                   case R.id.overshoot :currentInterpolator=new OvershootInterpolator();break;
                   case R.id.bounce :currentInterpolator=new BounceInterpolator();break;
                   case R.id.cycle :currentInterpolator=new CycleInterpolator(1);break;
                   case R.id.reverse :currentInterpolator=reverse;break;
                   case R.id.custom :currentInterpolator=custom;break;
                   default:break;
               }
               currentAnimation.setInterpolator(currentInterpolator);
            }
        });
        return view;
    }
}