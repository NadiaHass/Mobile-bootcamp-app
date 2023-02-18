package com.example.mobilebootcamp.ui.fragments.resultFragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobilebootcamp.R;
import com.example.mobilebootcamp.ui.activities.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.concurrent.Executor;


public class LoginFragment extends Fragment {
    Button signUpButton ;
    EditText editTextEmail, editTextPassword;
    TextView textViewSignUp ;

    private FirebaseAuth mAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        signUpButton = view.findViewById(R.id.btn_login);
        editTextEmail = view.findViewById(R.id.et_address);
        editTextPassword = view.findViewById(R.id.et_password);
        textViewSignUp = view.findViewById(R.id.tv_signup);

        mAuth = FirebaseAuth.getInstance();

        signUpButton.setOnClickListener(v-> {
                    String email = editTextEmail.getText().toString();
                    String password = editTextPassword.getText().toString();

                    if (email.equals("") || password.equals("")) {
                        Toast.makeText(requireActivity(), "Complete your data", Toast.LENGTH_LONG).show();
                    } else {
                        mAuth.signInWithEmailAndPassword(email, password)
                                .addOnCompleteListener( requireActivity(), task -> {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(requireActivity(), "signInWithEmail:success",
                                                Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(requireActivity() , MainActivity.class));
                                        getActivity().finish();
                                    } else {
                                        Toast.makeText(requireActivity(), "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();

                                    }
                                }
                                );
                    }
                });

            textViewSignUp.setOnClickListener(v -> {
                Fragment fragment = new AuthFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();

            });

        return view;
    }
}