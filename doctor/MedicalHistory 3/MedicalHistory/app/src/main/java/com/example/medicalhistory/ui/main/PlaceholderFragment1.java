package com.example.medicalhistory.ui.main;

import android.annotation.SuppressLint;
import android.app.FragmentManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.provider.ContactsContract;
import android.text.Editable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import com.example.medicalhistory.MainActivity;
import com.example.medicalhistory.R;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import static com.example.medicalhistory.MainActivity.*;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment1 extends Fragment {

    public static String PatientID;//存放患者唯一识别ID
    public static String localPath1;//存放新的带ID的地址
    private static EditText t1;
    private static EditText t2;
    private static EditText t3;
    private static EditText t4;
    private static EditText t5;
    private static EditText t6;
    private static EditText t7;
    private static EditText t8;
    private static EditText t9;
    private static EditText t10;
    private static EditText t11;
    private static EditText t12;
    private static EditText t13;
    private static EditText t14;
    private static EditText t15;

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
        t1 = root.findViewById(R.id.name1);
        t2 = root.findViewById(R.id.gender1);
        t3 = root.findViewById(R.id.age1);
        t4 = root.findViewById(R.id.job1);
        t5 = root.findViewById(R.id.nation1);
        t6 = root.findViewById(R.id.marriage1);
        t7 = root.findViewById(R.id.birthplace1);
        t8 = root.findViewById(R.id.workplace1);
        t9 = root.findViewById(R.id.address1);
        t10 = root.findViewById(R.id.phone1);
        t11 = root.findViewById(R.id.adDate1);
        t12 = root.findViewById(R.id.recordDate1);
        t13 = root.findViewById(R.id.teller1);
        t14 = root.findViewById(R.id.reliability1);
        t15 = root.findViewById(R.id.ID1);
        root.findViewById(R.id.确认信息).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity) getActivity();
                TextView textView =  mainActivity.findViewById(R.id.tex);

                List<EditText> text = Arrays.asList(t1, t2, t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15);
                List<String> name = Arrays.asList("name","gender","age","job","nation","marriage1","birth_p","workplace","address","phone","admission_date","record_date","teller","reliability","PatientID");
                setEdit(name,text);
                textView.post(() -> textView.setText("成功确认患者基本信息"));
            }
        });

        return root;
    }




    public static void setET(JSONObject data,String name,EditText et) throws JSONException {
        JSONObject jsonObject = data;

        assert jsonObject != null;
        JSONObject finalJsonObject = jsonObject;
        et.post(() -> {
            try {
                et.setText(finalJsonObject.getString(name));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        });
    }


    public static String getPatientID(String str){
        PatientID = str;
        localPath1 = Environment.getExternalStorageDirectory().getPath()+ "/Android/data/com.example.medicalhistory/MedicalHistory/" + PatientID;//增加了PatientID的localPath
        return localPath1;
    }





    public static void set()
    {
        try {
            setET(MainActivity.ceshi, "name", t1);
            setET(MainActivity.ceshi, "gender", t2);
            setET(MainActivity.ceshi, "age", t3);
            setET(MainActivity.ceshi, "job", t4);
            setET(MainActivity.ceshi, "nation", t5);
            setET(MainActivity.ceshi, "marriage1", t6);
            setET(MainActivity.ceshi, "birth_p", t7);
            setET(MainActivity.ceshi, "workplace", t8);
            setET(MainActivity.ceshi, "address", t9);
            setET(MainActivity.ceshi, "phone", t10);
            setET(MainActivity.ceshi, "admission_date", t11);
            setET(MainActivity.ceshi, "record_date", t12);
            setET(MainActivity.ceshi, "teller", t13);
            setET(MainActivity.ceshi, "reliability", t14);
            setET(MainActivity.ceshi, "PatientID", t15);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        MainActivity.fg=!MainActivity.fg;
    }
}