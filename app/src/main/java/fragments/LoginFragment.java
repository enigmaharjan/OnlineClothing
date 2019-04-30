package fragments;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.onlineclothing.MainActivity;
import com.example.onlineclothing.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    private EditText etUsername, etPassword;
    private Button btnLogin;


    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        etPassword = view.findViewById(R.id.etPasswordLogin);
        etUsername = view.findViewById(R.id.etUsernameLogin);
        btnLogin = view.findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    CheckUser();
            }
        });
        return view;
    }

    private void CheckUser() {
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("User", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username","");
        String password = sharedPreferences.getString("password","");

        if(username.equals(etUsername.getText().toString()) &&
                password.equals(etPassword.getText().toString())){
            Toast.makeText(getActivity(), "Login Successful", Toast.LENGTH_SHORT).show();

            Intent i = new Intent(getContext(), MainActivity.class);
            startActivity(i);


        }

    }

}
