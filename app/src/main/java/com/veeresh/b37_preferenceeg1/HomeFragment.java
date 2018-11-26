package com.veeresh.b37_preferenceeg1;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    //HomeFragment  HAS 1 TEXTVIEW - DECLARE THOSE VARIABLES
    TextView tv;
    public HomeFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        //HomeFragment  HAS 1 TEXTVIEW - INITIALIZE THOSE VARIABLES
        tv = v.findViewById(R.id.textView1);
        //TASK 6-c : READ EMAIL COMING IN BUNDLE, DISPLAY ON TEXTVIEW
        Bundle bundle = getArguments();
        String email = bundle.getString("email");
        tv.setText("WELCOME : "+email);
        //END TASK 6-c
        return v;
    }

}
