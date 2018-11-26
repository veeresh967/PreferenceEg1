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
public class RegisterFragment extends Fragment {
    //REGISTER FRAGMENT HAS 3 EDIT TEXTS & 1 BUTTON - DECLARE THOSE VARIABLES
    EditText et1, et2, et3;
    Button b1;
    public RegisterFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_register, container, false);
        //REGISTER FRAGMENT HAS 3 EDIT TEXTS & 1 BUTTON - INITIALIZE THOSE VARIABLES
        et1 = v.findViewById(R.id.editText1);
        et2 = v.findViewById(R.id.editText2);
        et3 = v.findViewById(R.id.editText3);
        b1 = v.findViewById(R.id.button1);
        //LET US TAKE 1 BUTTON CLICK LISTENER - FOR SAVE BUTTON
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check if pw & confirm pw is same
                String email = et1.getText().toString().trim();
                String pw = et2.getText().toString().trim();
                String cpw = et3.getText().toString().trim();

                if(email.equals("") || pw.equals("") || cpw.equals("")){
                    Toast.makeText(getActivity(), "FIELDS CANT BE EMPTY..TRY AGAIN", Toast.LENGTH_SHORT).show();
                    et1.setText("");et2.setText("");et3.setText("");et1.requestFocus();
                }
                else if(pw.equals(cpw)) {
                    //TASK 3 : if pw & cpw is same - then SAVE USER CREDENTIALS TO SHARED PREFERENCE FILE
                    //3.a create [or] open preference file
                    SharedPreferences sp = getActivity().getSharedPreferences("credentials", 0);
                    //3.b open editor for write mode
                    SharedPreferences.Editor et = sp.edit();
                    //3.c write email & pw to preference file
                    et.putString("email", email);
                    et.putString("pw", pw);
                    //3.d apply [or] commit
                    et.apply();  //[or] et.commit();
                    Toast.makeText(getActivity(), "SAVED", Toast.LENGTH_SHORT).show();
                    //END OF TASK 3
                    //TASK 4-a : IF SAVED SUCCESSFULLY - GO TO PREVIOUS FRAGMENT
                    MainActivity mainactivity = (MainActivity) getActivity();
                    mainactivity.gobackToWelcomeFragment();
                    //END OF TASK 4-a
                }else {
                    Toast.makeText(getActivity(), "MISMATCH..TRY AGAIN", Toast.LENGTH_SHORT).show();
                    et2.setText("");et3.setText("");et2.requestFocus();
                }
            }
        });
        return v;
    }

}
