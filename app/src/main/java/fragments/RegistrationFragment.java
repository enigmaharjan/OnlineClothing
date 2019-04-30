package fragments;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.onlineclothing.R;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegistrationFragment extends Fragment {

    private EditText etUsername, etPassword, etRePassword;
    private Button btnRegister;

    public RegistrationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_registration, container, false);
        etPassword = view.findViewById(R.id.etPasswordRegistration);
        etRePassword = view.findViewById(R.id.etConfirmPasswordRegistration);
        etUsername = view.findViewById(R.id.etUsernameRegistration);
        btnRegister = view.findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = etPassword.getText().toString();
                String rePassword = etRePassword.getText().toString();
                String username= etUsername.getText().toString();

                if(password.equals(rePassword)){
                    Register();
                }
                else{
                    Toast.makeText(getActivity(), "Password Doesn't Match", Toast.LENGTH_LONG).show();
                }
            }
        });
        return view;
    }

    private void Register() {
        SharedPreferences sharedPreferences = this.getActivity().getSharedPreferences("User", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("username", etUsername.getText().toString());
        editor.putString("password", etPassword.getText().toString());
        editor.commit();

        Toast.makeText(getActivity(), "Successfully Registered", Toast.LENGTH_LONG).show();

    }

}
