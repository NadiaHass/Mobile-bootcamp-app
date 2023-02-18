package com.example.mobilebootcamp.ui.fragments.resultFragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.mobilebootcamp.R;
import com.example.mobilebootcamp.ui.activities.MainActivity;
import com.google.firebase.auth.FirebaseAuth;

public class AuthFragment extends Fragment {
    Button signUpButton ;
    EditText editTextEmail, editTextPassword;
    TextView textViewLogin ;

    private FirebaseAuth mAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_auth, container, false);

        mAuth = FirebaseAuth.getInstance();

        signUpButton = view.findViewById(R.id.btn_sign_up);
        editTextEmail = view.findViewById(R.id.et_address);
        editTextPassword = view.findViewById(R.id.et_password);
        textViewLogin = view.findViewById(R.id.tv_login);

        signUpButton.setOnClickListener(v->{
            String email = editTextEmail.getText().toString();
            String password = editTextPassword.getText().toString();

            if ( email.equals("") || password.equals("")) {
                Toast.makeText(requireActivity() , "Complete your data" , Toast.LENGTH_LONG).show();
            }else{
                mAuth.createUserWithEmailAndPassword(email , password).addOnCompleteListener(requireActivity() , task->{
                    if (task.isSuccessful()){
                        Toast.makeText(requireActivity() , "createUserWithEmail:success" , Toast.LENGTH_LONG).show();
                        startActivity(new Intent(requireActivity() , MainActivity.class));
                        getActivity().finish();

                    }else{
                        Toast.makeText(requireActivity() , "createUserWithEmail:failure " + task.getException() , Toast.LENGTH_LONG).show();
                    }
                }
                );
            }
        });

        textViewLogin.setOnClickListener(v -> {
            Fragment fragment = new LoginFragment();
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, fragment).commit();

        });

        return view;
    }
}