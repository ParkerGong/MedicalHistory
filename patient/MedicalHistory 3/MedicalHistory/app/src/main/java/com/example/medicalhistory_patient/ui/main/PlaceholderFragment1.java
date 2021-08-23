package com.example.medicalhistory_patient.ui.main;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.medicalhistory_patient.MainActivity;
import com.example.medicalhistory_patient.R;

import java.util.Arrays;
import java.util.List;

import static com.example.medicalhistory_patient.MainActivity.*;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment1 extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    public static PlaceholderFragment1 newInstance(int index) {
        PlaceholderFragment1 fragment = new PlaceholderFragment1();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        fragment.onStart();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }

    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main1, container, false);
        final EditText t1 = root.findViewById(R.id.name1);
        final EditText t2 = root.findViewById(R.id.gender1);
        final EditText t3 = root.findViewById(R.id.age1);
        final EditText t4 = root.findViewById(R.id.job1);
        final EditText t5 = root.findViewById(R.id.nation1);
        final EditText t6 = root.findViewById(R.id.marriage1);
        final EditText t7 = root.findViewById(R.id.birthplace1);
        final EditText t8 = root.findViewById(R.id.workplace1);
        final EditText t9 = root.findViewById(R.id.address1);
        final EditText t10 = root.findViewById(R.id.phone1);
        final EditText t11 = root.findViewById(R.id.adDate1);
        final EditText t12 = root.findViewById(R.id.recordDate1);
        final EditText t13 = root.findViewById(R.id.teller1);
        final EditText t14 = root.findViewById(R.id.reliability1);


        List<EditText> text = Arrays.asList(t1, t2, t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14);
        List<String> name = Arrays.asList("name","gender","age","job","nation","marriage1","birth_p","workplace","address","phone","admission_date","record_date","teller","reliability");
        setEdit(name,text);
        root.findViewById(R.id.确认信息).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity) getActivity();
                TextView textView =  mainActivity.findViewById(R.id.tex);

                List<EditText> text = Arrays.asList(t1, t2, t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14);
                List<String> name = Arrays.asList("name","gender","age","job","nation","marriage1","birth_p","workplace","address","phone","admission_date","record_date","teller","reliability");
                setEdit(name,text);
                textView.post(() -> textView.setText("成功确认患者基本信息"));
            }
        });
        return root;
    }
}