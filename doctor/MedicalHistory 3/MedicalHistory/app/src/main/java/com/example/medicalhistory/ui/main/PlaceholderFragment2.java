package com.example.medicalhistory.ui.main;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.medicalhistory.MainActivity;
import com.example.medicalhistory.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.example.medicalhistory.MainActivity.setEdit;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment2 extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
    @SuppressLint("StaticFieldLeak")
    private static Spinner s1;
    private static Spinner s2;
    private static Spinner s3;
    private static Spinner s4;
    private static Spinner s5;
    private static Spinner s6;
    private static Spinner s7;
    private static Spinner s8;
    private static Spinner s9;
    private static Spinner s10;
    private static Spinner s11;
    private static Spinner s12;
    private static Spinner s13;
    private static Spinner s14;
    private static Spinner s15;
    private static Spinner s16;
    private static Spinner s17;
    private static Spinner s18;
    private static Spinner s19;
    private static Spinner s20;
    private static Spinner s21;
    private static Spinner s22;
    private static Spinner s23;
    private static Spinner s24;

    @SuppressLint("StaticFieldLeak")
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
    private static EditText t16;
    private static EditText t17;
    private static EditText t18;
    private PageViewModel pageViewModel;


    public static PlaceholderFragment2 newInstance(int index) {
        PlaceholderFragment2 fragment = new PlaceholderFragment2();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageViewModel = new ViewModelProvider(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main2, container, false);
        t1 = root.findViewById(R.id.主诉患病时间);
        t2 = root.findViewById(R.id.可能的诱因);
        t3 = root.findViewById(R.id.持续时间);
        t4 = root.findViewById(R.id.病情演变时间);
        t5 = root.findViewById(R.id.新近出现的症状);
        t6 = root.findViewById(R.id.伴随症状);
        t7 = root.findViewById(R.id.诊疗经过);
        t8 = root.findViewById(R.id.与鉴别诊断有关的阴性资料);
        t9 = root.findViewById(R.id.体重);
        t10 = root.findViewById(R.id.曾患疾病);
        t11 = root.findViewById(R.id.高血压等治疗情况);
        t12 = root.findViewById(R.id.其他传染病史);
        t13 = root.findViewById(R.id.过敏原);
        t14 = root.findViewById(R.id.预防接种史);
        t15 = root.findViewById(R.id.出生地);
//        final EditText t16 = root.findViewById(R.id.嗜烟);
//        final EditText t17 = root.findViewById(R.id.嗜酒);
        t16 = root.findViewById(R.id.结婚年龄);
        t17 = root.findViewById(R.id.配偶情况);
        t18 = root.findViewById(R.id.疼痛肿胀1);


        List<String> name1 = Collections.singletonList("xianbing3");
        s1 =(Spinner)root.findViewById(R.id.起病缓急);


        List<String> name2 = Collections.singletonList("xianbing4");
        s2 =(Spinner)root.findViewById(R.id.出现症状部位);


        List<String> name3 = Collections.singletonList("xianbing5");
        s3 =(Spinner)root.findViewById(R.id.疼痛性质);


        List<String> name4 = Collections.singletonList("xianbing6");
        s4 =(Spinner)root.findViewById(R.id.症状);



        List<String> name5 = Collections.singletonList("xianbing7");
        s5 =(Spinner)root.findViewById(R.id.疼痛程度);


        List<String> name6 = Collections.singletonList("xianbing9");
        s6 =(Spinner)root.findViewById(R.id.加重缓解情况);


        List<String> name7 = Collections.singletonList("xianbing11");
        s7 =(Spinner)root.findViewById(R.id.病情发展演变);


        List<String> name8 = Collections.singletonList("xianbing15");
        s8 =(Spinner)root.findViewById(R.id.精神);


        List<String> name9 = Collections.singletonList("xianbing16");
        s9 =(Spinner)root.findViewById(R.id.食欲);


        List<String> name10 = Collections.singletonList("xianbing17");
        s10 =(Spinner)root.findViewById(R.id.睡眠);


        List<String> name11 = Collections.singletonList("xianbing18");
        s11 =(Spinner)root.findViewById(R.id.大小便);


        List<String> name12 = Collections.singletonList("jiwang1");
        s12 =(Spinner)root.findViewById(R.id.平素健康状况);


        List<String> name13 = Collections.singletonList("jiwang4");
        s13 =(Spinner)root.findViewById(R.id.有无传染病);


        List<String> name14 = Collections.singletonList("jiwang5");
        s14 =(Spinner)root.findViewById(R.id.疟疾等);


        List<String> name15 = Collections.singletonList("jiwang6");
        s15 =(Spinner)root.findViewById(R.id.手术史);


        List<String> name16 = Collections.singletonList("jiwang7");
        s16 =(Spinner)root.findViewById(R.id.外伤史);


        List<String> name17 = Collections.singletonList("jiwang9");
        s17 =(Spinner)root.findViewById(R.id.药物过敏史);


        List<String> name18 = Collections.singletonList("geren2");
        s18 =(Spinner)root.findViewById(R.id.疫区居留史);


        List<String> name19 = Collections.singletonList("geren3");
        s19 =(Spinner)root.findViewById(R.id.放射性物质接触史);


        List<String> name20 = Collections.singletonList("geren4");
        s20 =(Spinner)root.findViewById(R.id.毒物接触史);


        List<String> name21 = Collections.singletonList("geren5");
        s21 =(Spinner)root.findViewById(R.id.毒品接触史);


        List<String> name22 = Collections.singletonList("geren6");
        s22 =(Spinner)root.findViewById(R.id.嗜烟);


        List<String> name23 = Collections.singletonList("geren7");
        s23 =(Spinner)root.findViewById(R.id.嗜酒);


        List<String> name24 = Collections.singletonList("zhusu1");
        s24 =(Spinner)root.findViewById(R.id.患病部位);



        root.findViewById(R.id.确认信息).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                spinner(s24,name24);
                spinner(s23,name23);
                spinner(s22,name22);
                spinner(s21,name21);
                spinner(s20,name20);
                spinner(s19,name19);
                spinner(s18,name18);
                spinner(s17,name17);
                spinner(s16,name16);
                spinner(s15,name15);
                spinner(s14,name14);
                spinner(s13,name13);
                spinner(s12,name12);
                spinner(s11,name11);
                spinner(s10,name10);
                spinner(s9,name9);
                spinner(s8,name8);
                spinner(s7,name7);
                spinner(s6,name6);
                spinner(s5,name5);
                spinner(s4,name4);
                spinner(s3,name3);
                spinner(s2,name2);
                spinner(s1,name1);
                List<EditText> text = Arrays.asList(t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,
                        t15,t16,t17,t18);
                List<String> name = Arrays.asList("xianbing1","xianbing2","xianbing8","xianbing10","xianbing12",
                        "xianbing13","xianbing14","xianbing20","xianbing19","jiwang2","jiwang3","jiwang8",
                        "jiwang10","jiwang11","geren1","geren8","geren9","zhusu2");
                setEdit(name,text);
                MainActivity mainActivity = (MainActivity) getActivity();
                TextView textView =  mainActivity.findViewById(R.id.tex);
                textView.post(() -> textView.setText("成功确认病史采集信息"));
            }
        });








        return root;
    }

    public void spinner(Spinner spinner,List<String> namex)
    {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                List<Object> text2 = Collections.singletonList(spinner.getSelectedItem());
                MainActivity.setSpinner(namex,text2);
                System.out.println(spinner.getSelectedItem());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.i("Spinner","unSelected");
            }
        });}

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

    public static void setSP(JSONObject data, String name, Spinner s) throws JSONException {
        JSONObject jsonObject = data;

        int i=0;
        try {
            assert jsonObject != null;
            i=Integer.parseInt(jsonObject.getString(name));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        int finalI = i;
        s.post(() -> s.setSelection(finalI,true));

    }
    public static void set()
    {
            try {
                setET(MainActivity.ceshi, "xianbing1", t1);
                setET(MainActivity.ceshi, "xianbing2", t2);
                setET(MainActivity.ceshi, "xianbing8", t3);
                setET(MainActivity.ceshi, "xianbing10", t4);
                setET(MainActivity.ceshi, "xianbing12", t5);
                setET(MainActivity.ceshi, "xianbing13", t6);
                setET(MainActivity.ceshi, "xianbing14", t7);
                setET(MainActivity.ceshi, "xianbing20", t8);
                setET(MainActivity.ceshi, "xianbing19", t9);
                setET(MainActivity.ceshi, "jiwang2", t10);
                setET(MainActivity.ceshi, "jiwang3", t11);
                setET(MainActivity.ceshi, "jiwang8", t12);
                setET(MainActivity.ceshi, "jiwang10", t13);
                setET(MainActivity.ceshi, "jiwang11", t14);
                setET(MainActivity.ceshi, "geren1", t15);
                setET(MainActivity.ceshi, "geren8", t16);
                setET(MainActivity.ceshi, "geren9", t17);
                setET(MainActivity.ceshi, "zhusu2", t18);

                setSP(MainActivity.ceshi, "xianbing3", s1);
                setSP(MainActivity.ceshi, "xianbing4", s2);
                setSP(MainActivity.ceshi, "xianbing5", s3);
                setSP(MainActivity.ceshi, "xianbing6", s4);
                setSP(MainActivity.ceshi, "xianbing7", s5);
                setSP(MainActivity.ceshi, "xianbing9", s6);
                setSP(MainActivity.ceshi, "xianbing11", s7);
                setSP(MainActivity.ceshi, "xianbing15", s8);
                setSP(MainActivity.ceshi, "xianbing16", s9);
                setSP(MainActivity.ceshi, "xianbing17", s10);
                setSP(MainActivity.ceshi, "xianbing18", s11);
                setSP(MainActivity.ceshi, "jiwang1", s12);
                setSP(MainActivity.ceshi, "jiwang4", s13);
                setSP(MainActivity.ceshi, "jiwang5", s14);
                setSP(MainActivity.ceshi, "jiwang6", s15);
                setSP(MainActivity.ceshi, "jiwang7", s16);
                setSP(MainActivity.ceshi, "jiwang9", s17);
                setSP(MainActivity.ceshi, "geren2", s18);
                setSP(MainActivity.ceshi, "geren3", s19);
                setSP(MainActivity.ceshi, "geren4", s20);
                setSP(MainActivity.ceshi, "geren5", s21);
                setSP(MainActivity.ceshi, "geren6", s22);
                setSP(MainActivity.ceshi, "geren7", s23);
                setSP(MainActivity.ceshi, "zhusu1", s24);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            MainActivity.fg=!MainActivity.fg;
    }

}