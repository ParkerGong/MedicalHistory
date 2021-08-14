package com.example.medicalhistory.ui.main;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.medicalhistory.R;

import java.util.Collections;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class Sub3Fragment2 extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    public static Sub3Fragment2 newInstance(int index) {
        Sub3Fragment2 fragment = new Sub3Fragment2();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
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
        View root = inflater.inflate(R.layout.fragment3_sub2, container, false);
//        for(int i = 0;i<text1.size();i++) MainActivity.setSpinner(text2.get(i).getSelectedItem());
//        for(int i = 0;i<text1.size();i++)MainActivity.setEdit(text1.get(i));
        Spinner spn = root.findViewById(R.id.专科查体选择);
        LinearLayout layoutjizhu = root.findViewById(R.id.脊柱转移提示);
        LinearLayout layoutgurouliu = root.findViewById(R.id.骨肉瘤提示);
        layoutgurouliu.setVisibility(View.GONE);
        layoutjizhu.setVisibility(View.GONE);

        spinner_hideshow(spn,layoutjizhu,layoutgurouliu);


        return root;
    }

    public void spinner_hideshow(Spinner spinner, LinearLayout layoutjizhu, LinearLayout layoutgurouliu)
    {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(spinner.getSelectedItem().toString().equals("脊柱转移"))
                {
                    layoutjizhu.setVisibility(View.VISIBLE);
                    layoutgurouliu.setVisibility(View.GONE);
                }
                else if(spinner.getSelectedItem().toString().equals("骨肉瘤"))
                {
                    layoutgurouliu.setVisibility(View.VISIBLE);
                    layoutjizhu.setVisibility(View.GONE);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.i("Spinner","unSelected");
            }
        });}

}