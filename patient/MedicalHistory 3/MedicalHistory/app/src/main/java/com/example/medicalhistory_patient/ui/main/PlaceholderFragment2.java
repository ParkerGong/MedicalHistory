package com.example.medicalhistory_patient.ui.main;

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
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.medicalhistory_patient.MainActivity;
import com.example.medicalhistory_patient.R;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.example.medicalhistory_patient.MainActivity.setEdit;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment2 extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";
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



        final EditText t1 = root.findViewById(R.id.主诉患病时间);
        final EditText t2 = root.findViewById(R.id.可能的诱因);
        final EditText t3 = root.findViewById(R.id.持续时间);
        final EditText t4 = root.findViewById(R.id.病情演变时间);
        final EditText t5 = root.findViewById(R.id.新近出现的症状);
        final EditText t6 = root.findViewById(R.id.伴随症状);
        final EditText t7 = root.findViewById(R.id.诊疗经过);
        final EditText t8 = root.findViewById(R.id.与鉴别诊断有关的阴性资料);
        final EditText t9 = root.findViewById(R.id.体重);
        final EditText t10 = root.findViewById(R.id.曾患疾病);
        final EditText t11 = root.findViewById(R.id.高血压等治疗情况);
        final EditText t12 = root.findViewById(R.id.其他传染病史);
        final EditText t13 = root.findViewById(R.id.过敏原);
        final EditText t14 = root.findViewById(R.id.预防接种史);
        final EditText t15 = root.findViewById(R.id.出生地);
//        final EditText t16 = root.findViewById(R.id.嗜烟);
//        final EditText t17 = root.findViewById(R.id.嗜酒);
        final EditText t16 = root.findViewById(R.id.结婚年龄);
        final EditText t17 = root.findViewById(R.id.配偶情况);
        final EditText t18 = root.findViewById(R.id.疼痛肿胀1);
        final EditText t19 = root.findViewById(R.id.初潮年龄);
        final EditText t20 = root.findViewById(R.id.经期);
        final EditText t21 = root.findViewById(R.id.周期);
        final EditText t22 = root.findViewById(R.id.绝经年龄);
        final EditText t23 = root.findViewById(R.id.末次月经);
        final EditText t24 = root.findViewById(R.id.几岁结婚);
        final EditText t25 = root.findViewById(R.id.生育几胎);
        final EditText t26 = root.findViewById(R.id.家族史等);
        final EditText t27 = root.findViewById(R.id.曾到过);
        final EditText t28 = root.findViewById(R.id.抽烟年);
        final EditText t29 = root.findViewById(R.id.抽烟根);
        final EditText t30 = root.findViewById(R.id.喝酒年);
        final EditText t31 = root.findViewById(R.id.喝酒两);






        List<String> name1 = Collections.singletonList("xianbing3");
        Spinner s1 =(Spinner)root.findViewById(R.id.起病缓急);
        spinner(s1,name1);

        List<String> name2 = Collections.singletonList("xianbing4");
        Spinner s2 =(Spinner)root.findViewById(R.id.出现症状部位);
        spinner(s2,name2);

        List<String> name3 = Collections.singletonList("xianbing5");
        Spinner s3 =(Spinner)root.findViewById(R.id.疼痛性质);
        spinner(s3,name3);

        List<String> name4 = Collections.singletonList("xianbing6");
        Spinner s4 =(Spinner)root.findViewById(R.id.症状);
        spinner(s4,name4);

        List<String> name5 = Collections.singletonList("xianbing7");
        Spinner s5 =(Spinner)root.findViewById(R.id.疼痛程度);
        spinner(s5,name5);

        List<String> name6 = Collections.singletonList("xianbing9");
        Spinner s6 =(Spinner)root.findViewById(R.id.加重缓解情况);
        spinner(s6,name6);

        List<String> name7 = Collections.singletonList("xianbing11");
        Spinner s7 =(Spinner)root.findViewById(R.id.病情发展演变);
        spinner(s7,name7);

        List<String> name8 = Collections.singletonList("xianbing15");
        Spinner s8 =(Spinner)root.findViewById(R.id.精神);
        spinner(s8,name8);

        List<String> name9 = Collections.singletonList("xianbing16");
        Spinner s9 =(Spinner)root.findViewById(R.id.食欲);
        spinner(s9,name9);

        List<String> name10 = Collections.singletonList("xianbing17");
        Spinner s10 =(Spinner)root.findViewById(R.id.睡眠);
        spinner(s10,name10);

        List<String> name11 = Collections.singletonList("xianbing18");
        Spinner s11 =(Spinner)root.findViewById(R.id.大小便);
        spinner(s11,name11);

        List<String> name12 = Collections.singletonList("jiwang1");
        Spinner s12 =(Spinner)root.findViewById(R.id.平素健康状况);
        spinner(s12,name12);

        List<String> name13 = Collections.singletonList("jiwang4");
        Spinner s13 =(Spinner)root.findViewById(R.id.有无传染病);
        spinner(s13,name13);

        List<String> name14 = Collections.singletonList("jiwang5");
        Spinner s14 =(Spinner)root.findViewById(R.id.疟疾等);
        spinner(s14,name14);

        List<String> name15 = Collections.singletonList("jiwang6");
        Spinner s15 =(Spinner)root.findViewById(R.id.手术史);
        spinner(s15,name15);

        List<String> name16 = Collections.singletonList("jiwang7");
        Spinner s16 =(Spinner)root.findViewById(R.id.外伤史);
        spinner(s16,name16);

        List<String> name17 = Collections.singletonList("jiwang9");
        Spinner s17 =(Spinner)root.findViewById(R.id.药物过敏史);
        spinner(s17,name17);

        List<String> name18 = Collections.singletonList("geren2");
        Spinner s18 =(Spinner)root.findViewById(R.id.疫区居留史);
        spinner(s18,name18);

        List<String> name19 = Collections.singletonList("geren3");
        Spinner s19 =(Spinner)root.findViewById(R.id.放射性物质接触史);
        spinner(s19,name19);

        List<String> name20 = Collections.singletonList("geren4");
        Spinner s20 =(Spinner)root.findViewById(R.id.毒物接触史);
        spinner(s20,name20);

        List<String> name21 = Collections.singletonList("geren5");
        Spinner s21 =(Spinner)root.findViewById(R.id.毒品接触史);
        spinner(s21,name21);

        List<String> name22 = Collections.singletonList("geren6");
        Spinner s22 =(Spinner)root.findViewById(R.id.嗜烟);
        spinner(s22,name22);

        List<String> name23 = Collections.singletonList("geren7");
        Spinner s23 =(Spinner)root.findViewById(R.id.嗜酒);
        spinner(s23,name23);

        List<String> name24 = Collections.singletonList("zhusu1");
        Spinner s24 =(Spinner)root.findViewById(R.id.患病部位);
        spinner(s24,name24);

        List<String> name25 = Collections.singletonList("yuejing6");
        Spinner s25 =(Spinner)root.findViewById(R.id.经量);
        spinner(s25,name25);

        List<String> name26 = Collections.singletonList("yuejing7");
        Spinner s26 =(Spinner)root.findViewById(R.id.有无血块);
        spinner(s26,name26);

        List<String> name27 = Collections.singletonList("yuejing8");
        Spinner s27 =(Spinner)root.findViewById(R.id.有无痛经);
        spinner(s27,name27);

        List<String> name28 = Collections.singletonList("yuejing9");
        Spinner s28 =(Spinner)root.findViewById(R.id.白带);
        spinner(s28,name28);

        List<String> name29 = Collections.singletonList("yuejing12");
        Spinner s29 =(Spinner)root.findViewById(R.id.有无早产等);
        spinner(s29,name29);

        List<String> name30 = Collections.singletonList("yuejing13");
        Spinner s30 =(Spinner)root.findViewById(R.id.早产等);
        spinner(s30,name30);

        List<String> name31 = Collections.singletonList("geren14");
        Spinner s31 =(Spinner)root.findViewById(R.id.重大精神创伤史);
        spinner(s31,name31);

        List<String> name32 = Collections.singletonList("geren15");
        Spinner s32 =(Spinner)root.findViewById(R.id.冶游史);
        spinner(s32,name32);

        List<String> name33 = Collections.singletonList("geren16");
        Spinner s33 =(Spinner)root.findViewById(R.id.居住环境);
        spinner(s33,name33);









        List<EditText> text = Arrays.asList(t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,
                                            t15,t16,t17,t18,t19,t20,t21,t22,t23,t24,t25,t26,
                                            t27,t28,t29,t30,t31);
        List<String> name = Arrays.asList("xianbing1","xianbing2","xianbing8","xianbing10","xianbing12",
                "xianbing13","xianbing14","xianbing20","xianbing19","jiwang2","jiwang3","jiwang8",
                "jiwang10","jiwang11","geren1","geren8","geren9","zhusu2","yuejing1","yuejing2","yuejing3",
                "yuejing4","yuejing5","yuejing10","yuejing11","jiazu1","geren17","geren10","geren11","geren12",
                "geren13");
        setEdit(name,text);

        root.findViewById(R.id.确认信息).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                List<EditText> text1 = Arrays.asList(t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,
                        t15,t16,t17,t18,t19,t20,t21,t22,t23,t24,t25,t26,
                        t27,t28,t29,t30,t31);
                List<String> name1 = Arrays.asList("xianbing1","xianbing2","xianbing8","xianbing10","xianbing12",
                        "xianbing13","xianbing14","xianbing20","xianbing19","jiwang2","jiwang3","jiwang8",
                        "jiwang10","jiwang11","geren1","geren8","geren9","zhusu2","yuejing1","yuejing2","yuejing3",
                        "yuejing4","yuejing5","yuejing10","yuejing11","jiazu1","geren17","geren10","geren11","geren12",
                        "geren13");
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
                MainActivity.setspinner(namex.get(0), (int) spinner.getSelectedItemId());
                System.out.println(spinner.getSelectedItem());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.i("Spinner","unSelected");
            }
        });}

}