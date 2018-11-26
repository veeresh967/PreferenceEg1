package com.veeresh.b37_preferenceeg1;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class WelcomeFragment extends Fragment {
    //WELCOME FRAGMENT HAS 2 EDIT TEXTS & 2 BUTTONS - DECLARE THOSE VARIABLES
    EditText et1, et2;
    Button b1, b2;
    public WelcomeFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_welcome, container, false);
        //WELCOME FRAGMENT HAS 2 EDIT TEXTS & 2 BUTTONS - INITIALIZE THOSE VARIABLES
        et1 = v.findViewById(R.id.editText1);
        et2 = v.findViewById(R.id.editText2);
        b1 = v.findViewById(R.id.button1);
        b2 = v.findViewById(R.id.button2);
        //LET US TAKE 2 BUTTON CLICK LISTENERS - FOR LOGIN & REGISTER BUTTONS
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TASK 5 : CHECK IF CREDENTIALS ARE CORRECT
                String email = et1.getText().toString().trim();
                String pw = et2.getText().toString().trim();
                if(email.equals("") || pw.equals("")){
                    Toast.makeText(getActivity(), "FIELDS CANT BE EMPTY..TRY AGAIN", Toast.LENGTH_SHORT).show();
                    et1.setText(""); et2.setText(""); et1.requestFocus();
                }else{
                    //fiels are not empty - READ SHARED PREFERENCE VALUES FOR COMPARING
                    SharedPreferences sp = getActivity().getSharedPreferences("credentials", 0);
                    String original_email = sp.getString("email", null);
                    String original_pw = sp.getString("pw", null);
                    if(email.equals(original_email) && pw.equals(original_pw)){
                        //matching
                        //TASK 6-a : SUCCESS - NOW OPEN HOME FRAGMENT
                        MainActivity mainActivity = (MainActivity) getActivity();
                        mainActivity.loadHomeFragment(original_email);
                        //END OF TASK 6-a
                    }else{
                        Toast.makeText(getActivity(), "WRONG CREDENTIALS..TRY AGAIN", Toast.LENGTH_SHORT).show();
                        et1.setText(""); et2.setText(""); et1.requestFocus();
                    }
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TASK 2-a: WHEN USER CLICKS REGISTER BUTTON, OPEN REGISTER FRAGMENT
                MainActivity mainActivity = (MainActivity) getActivity();
                mainActivity.loadRegisterFragment();
                //END OF TASK 2-a
            }
        });
        return v;
    }

}
