package com.example.medicalhistory.ui.main;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import androidx.annotation.NonNull;

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
public class Sub3Fragment1 extends PlaceholderFragment1 {

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
    private static Spinner s25;
    private static Spinner s26;
    private static Spinner s27;
    private static Spinner s28;
    private static Spinner s29;
    private static Spinner s30;
    private static Spinner s31;
    private static Spinner s32;
    private static Spinner s33;
    private static Spinner s34;
    private static Spinner s35;
    private static Spinner s36;
    private static Spinner s37;
    private static Spinner s38;
    private static Spinner s39;
    private static Spinner s40;
    private static Spinner s41;
    private static Spinner s42;
    private static Spinner s43;
    private static Spinner s44;
    private static Spinner s45;
    private static Spinner s46;
    private static Spinner s47;
    private static Spinner s48;
    private static Spinner s49;
    private static Spinner s50;
    private static Spinner s51;
    private static Spinner s52;
    private static Spinner s53;
    private static Spinner s54;
    private static Spinner s55;
    private static Spinner s56;
    private static Spinner s57;
    private static Spinner s58;
    private static Spinner s59;
    private static Spinner s60;
    private static Spinner s61;
    private static Spinner s62;
    private static Spinner s63;
    private static Spinner s64;
    private static Spinner s65;
    private static Spinner s66;
    private static Spinner s67;
    private static Spinner s68;
    private static Spinner s69;
    private static Spinner s70;
    private static Spinner s71;
    private static Spinner s72;
    private static Spinner s73;
    private static Spinner s74;
    private static Spinner s75;
    private static Spinner s76;
    private static Spinner s77;
    private static Spinner s78;
    private static Spinner s79;
    private static Spinner s80;
    private static Spinner s81;
    private static Spinner s82;

    private static final String ARG_SECTION_NUMBER = "section_number";
    LinearLayout layouttou;
    LinearLayout layoutxin;
    LinearLayout layoutfei;
    LinearLayout layoutxiong;
    LinearLayout layoutfu;
    LinearLayout layoutshenjing;
    LinearLayout layoutgangmen;
    LinearLayout layoutjizhu;
    public static Sub3Fragment1 newInstance(int index) {
        Sub3Fragment1 fragment = new Sub3Fragment1();
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
        View root = inflater.inflate(R.layout.fragment3_sub1, container, false);


        layouttou = root.findViewById(R.id.tou);
//        layouttou.setVisibility(View.GONE);
        Spinner touyou = root.findViewById(R.id.touyou);
        spinner_hideshow(touyou,layouttou);

        layoutxin = root.findViewById(R.id.xin);
//        layoutxin.setVisibility(View.GONE);
        Spinner xinyou = root.findViewById(R.id.xinyou);
        spinner_hideshow(xinyou,layoutxin);

        layoutxiong = root.findViewById(R.id.xiong);
//        layoutxiong.setVisibility(View.GONE);
        Spinner xiongyou = root.findViewById(R.id.xiongyou);
        spinner_hideshow(xiongyou,layoutxiong);

        layoutfei = root.findViewById(R.id.fei);
//        layoutfei.setVisibility(View.GONE);
        Spinner feiyou = root.findViewById(R.id.feiyou);
        spinner_hideshow(feiyou,layoutfei);

        layoutfu = root.findViewById(R.id.fu);
//        layoutfu.setVisibility(View.GONE);
        Spinner fuyou = root.findViewById(R.id.fuyou);
        spinner_hideshow(fuyou,layoutfu);

        layoutshenjing = root.findViewById(R.id.shenjing);
//        layoutshenjing.setVisibility(View.GONE);
        Spinner shenjingyou = root.findViewById(R.id.shenjingyou);
        spinner_hideshow(shenjingyou,layoutshenjing);

        layoutgangmen = root.findViewById(R.id.gangmen);
//        layoutgangmen.setVisibility(View.GONE);
        Spinner gangmen = root.findViewById(R.id.gangmenyou);
        spinner_hideshow(gangmen,layoutgangmen);

        layoutjizhu = root.findViewById(R.id.jizhu);
//        layoutjizhu.setVisibility(View.GONE);
        Spinner jizhu = root.findViewById(R.id.jizhuyou);
        spinner_hideshow(jizhu,layoutjizhu);


//        这里开始是数值绑定 EditText/////////////
        final EditText t1 = root.findViewById(R.id.体温);
        final EditText t2 = root.findViewById(R.id.脉搏);
        final EditText t3 = root.findViewById(R.id.血压1);
        final EditText t4 = root.findViewById(R.id.血压2);
        final EditText t5 = root.findViewById(R.id.身高);
        final EditText t6 = root.findViewById(R.id.体重);
        final EditText t7 = root.findViewById(R.id.BMI);
        final EditText t8 = root.findViewById(R.id.水肿部位);
        final EditText t9 = root.findViewById(R.id.皮下包块部位);
        final EditText t10 = root.findViewById(R.id.部位及特点);
        final EditText t11 = root.findViewById(R.id.瞳孔左);
        final EditText t12 = root.findViewById(R.id.瞳孔右);
        final EditText t13 = root.findViewById(R.id.外耳道异常分泌物性质);
        final EditText t14 = root.findViewById(R.id.牙齿2);
        final EditText t15 = root.findViewById(R.id.呼吸);
        final EditText t16 = root.findViewById(R.id.胸部位及特点);
        final EditText t17 = root.findViewById(R.id.乳房部位及特点);
        final EditText t18 = root.findViewById(R.id.叩诊异常部位);
        final EditText t19 = root.findViewById(R.id.锁骨中线);
        final EditText t20 = root.findViewById(R.id.腋中线);
        final EditText t21 = root.findViewById(R.id.肩胛线);
        final EditText t22 = root.findViewById(R.id.肺下缘移动度);
        final EditText t23 = root.findViewById(R.id.心尖搏动位于);
        final EditText t24 = root.findViewById(R.id.肋间锁骨中线内外侧);
        final EditText t25 = root.findViewById(R.id.搏动范围);
        final EditText t26 = root.findViewById(R.id.心脏部位及特点);
        final EditText t27 = root.findViewById(R.id.心脏叩诊部位及特点);
        final EditText t28 = root.findViewById(R.id.心率次数);
        final EditText t29 = root.findViewById(R.id.P2);
        final EditText t30 = root.findViewById(R.id.心部位及特点);
        final EditText t31 = root.findViewById(R.id.腹部部位);
        final EditText t32 = root.findViewById(R.id.血流方向);
        final EditText t33 = root.findViewById(R.id.心触诊部位);
        final EditText t34 = root.findViewById(R.id.腹部包块部位);
        final EditText t35 = root.findViewById(R.id.疝部位);
        final EditText t36 = root.findViewById(R.id.于右肋下);
        final EditText t37 = root.findViewById(R.id.于剑下);
        final EditText t38 = root.findViewById(R.id.AB线);
        final EditText t39 = root.findViewById(R.id.AC线);
        final EditText t40 = root.findViewById(R.id.DE线);
        final EditText t41 = root.findViewById(R.id.肾脏部位及特点);
        final EditText t42 = root.findViewById(R.id.膀胱上界位置);
        final EditText t43 = root.findViewById(R.id.腹部叩诊);
        final EditText t44 = root.findViewById(R.id.肝上界);
        final EditText t45 = root.findViewById(R.id.听诊肠鸣音次数);
        final EditText t46 = root.findViewById(R.id.血管杂音部位特点);
        final EditText t47 = root.findViewById(R.id.脊柱部位);
        final EditText t48 = root.findViewById(R.id.四肢特点);
        final EditText t49 = root.findViewById(R.id.肌力几级);
        final EditText t50 = root.findViewById(R.id.瘫痪部位及程度);
        final EditText t51 = root.findViewById(R.id.淋巴结数量);
        final EditText t52 = root.findViewById(R.id.淋巴结大小);
        final EditText t53 = root.findViewById(R.id.淋巴结质地);
        final EditText t54 = root.findViewById(R.id.淋巴结活动度);






///////////Spinner/////////////////
//        List<String> names1 = Collections.singletonList("touyouwu");///判断头部是否需填写
//        spinner(touyou,names1);
//
//        List<String> names2 = Collections.singletonList("xiongyouwu");///
//        spinner(xinyou,names2);
//
//        List<String> names3 = Collections.singletonList("feiyouwu");///
//        spinner(feiyou,names3);
//
//        List<String> names4 = Collections.singletonList("xinyouwu");///
//        spinner(xinyou,names4);
//
//        List<String> names5 = Collections.singletonList("shenjingyouwu");///
//        spinner(shenjingyou,names5);
//
//        List<String> names6 = Collections.singletonList("gangmenyouwu");///
//        Spinner switcher1 = root.findViewById(R.id.gangmenyou);
//        spinner(switcher1,names6);
//
//        List<String> names7 = Collections.singletonList("jizhuyouwu");///
//        Spinner switcher2 = root.findViewById(R.id.jizhuyou);
//        spinner(switcher2,names7);


        List<String> name1 = Collections.singletonList("yiban1");
        Spinner s1 =(Spinner)root.findViewById(R.id.发育);
        spinner(s1,name1);

        List<String> name2 = Collections.singletonList("yiban2");
        Spinner s2 =(Spinner)root.findViewById(R.id.营养);
        spinner(s2,name2);

        List<String> name3 = Collections.singletonList("yiban3");
        Spinner s3 =(Spinner)root.findViewById(R.id.体型);
        spinner(s3,name3);

        List<String> name4 = Collections.singletonList("yiban4");
        Spinner s4 =(Spinner)root.findViewById(R.id.体位);
        spinner(s4,name4);

        List<String> name5 = Collections.singletonList("yiban5");
        Spinner s5 =(Spinner)root.findViewById(R.id.病容);
        spinner(s5,name5);

        List<String> name6 = Collections.singletonList("yiban6");
        Spinner s6 =(Spinner)root.findViewById(R.id.表情);
        spinner(s6,name6);

        List<String> name7 = Collections.singletonList("yiban7");
        Spinner s7 =(Spinner)root.findViewById(R.id.步态);
        spinner(s7,name7);

        List<String> name8 = Collections.singletonList("yiban8");
        Spinner s8 =(Spinner)root.findViewById(R.id.语言);
        spinner(s8,name8);

        List<String> name9 = Collections.singletonList("yiban9");
        Spinner s9 =(Spinner)root.findViewById(R.id.神志);
        spinner(s9,name9);

        List<String> name10 = Collections.singletonList("yiban10");
        Spinner s10 =(Spinner)root.findViewById(R.id.对答);
        spinner(s10,name10);

        List<String> name11 = Collections.singletonList("yiban11");
        Spinner s11 =(Spinner)root.findViewById(R.id.配合检查);
        spinner(s11,name11);

        List<String> name12 = Collections.singletonList("pifu1");
        Spinner s12 =(Spinner)root.findViewById(R.id.色泽);
        spinner(s12,name12);

        List<String> name13 = Collections.singletonList("pifu2");
        Spinner s13 =(Spinner)root.findViewById(R.id.黄染);
        spinner(s13,name13);

        List<String> name14 = Collections.singletonList("pifu3");
        Spinner s14 =(Spinner)root.findViewById(R.id.色素沉着);
        spinner(s14,name14);

        List<String> name15 = Collections.singletonList("pifu4");
        Spinner s15 =(Spinner)root.findViewById(R.id.皮下瘀斑瘀点);
        spinner(s15,name15);

        List<String> name16 = Collections.singletonList("pifu5");
        Spinner s16 =(Spinner)root.findViewById(R.id.皮损);
        spinner(s16,name16);

        List<String> name17 = Collections.singletonList("pifu6");
        Spinner s17 =(Spinner)root.findViewById(R.id.皮肤温度与湿度);
        spinner(s17,name17);

        List<String> name18 = Collections.singletonList("pifu7");
        Spinner s18 =(Spinner)root.findViewById(R.id.皮肤弹性);
        spinner(s18,name18);

        List<String> name19 = Collections.singletonList("pifu8");
        Spinner s19 =(Spinner)root.findViewById(R.id.皮肤水肿);
        spinner(s19,name19);

        List<String> name20 = Collections.singletonList("pifu10");
        Spinner s20 =(Spinner)root.findViewById(R.id.皮下结节);
        spinner(s20,name20);

        List<String> name21 = Collections.singletonList("pifu11");
        Spinner s21 =(Spinner)root.findViewById(R.id.皮下包块);
        spinner(s21,name21);

        List<String> name22 = Collections.singletonList("toulu1");
        Spinner s22 =(Spinner)root.findViewById(R.id.头正常吗);
        spinner(s22,name22);

        List<String> name23 = Collections.singletonList("toulu2");
        Spinner s23 =(Spinner)root.findViewById(R.id.头形有无);
        spinner(s23,name23);

        List<String> name24 = Collections.singletonList("toulu3");
        Spinner s24 =(Spinner)root.findViewById(R.id.头形);
        spinner(s24,name24);

        List<String> name25 = Collections.singletonList("toulu4");
        Spinner s25 =(Spinner)root.findViewById(R.id.癣有无);
        spinner(s25,name25);

        List<String> name26 = Collections.singletonList("toulu5");
        Spinner s26 =(Spinner)root.findViewById(R.id.癣毛病);
        spinner(s26,name26);

        List<String> name27 = Collections.singletonList("toulu6");
        Spinner s27 =(Spinner)root.findViewById(R.id.脑袋压痛有无);
        spinner(s27,name27);

        List<String> name28 = Collections.singletonList("toulu7");
        Spinner s28 =(Spinner)root.findViewById(R.id.包块有无);
        spinner(s28,name28);

        List<String> name29 = Collections.singletonList("yan1");
        Spinner s29 =(Spinner)root.findViewById(R.id.稀疏有无);
        spinner(s29,name29);

        List<String> name30 = Collections.singletonList("yan2");
        Spinner s30 =(Spinner)root.findViewById(R.id.脱落有无);
        spinner(s30,name30);

        List<String> name31 = Collections.singletonList("yan3");
        Spinner s31 =(Spinner)root.findViewById(R.id.倒睫有无);
        spinner(s31,name31);

        List<String> name32 = Collections.singletonList("yan4");
        Spinner s32 =(Spinner)root.findViewById(R.id.眼睑);
        spinner(s32,name32);

        List<String> name33 = Collections.singletonList("yan5");
        Spinner s33 =(Spinner)root.findViewById(R.id.眼球);
        spinner(s33,name33);

        List<String> name34 = Collections.singletonList("yan6");
        Spinner s34 =(Spinner)root.findViewById(R.id.结膜);
        spinner(s34,name34);

        List<String> name35 = Collections.singletonList("yan7");
        Spinner s35 =(Spinner)root.findViewById(R.id.巩膜有无);
        spinner(s35,name35);

        List<String> name36 = Collections.singletonList("yan8");
        Spinner s36 =(Spinner)root.findViewById(R.id.巩膜轻重);
        spinner(s36,name36);

        List<String> name37 = Collections.singletonList("yan9");
        Spinner s37 =(Spinner)root.findViewById(R.id.角膜);
        spinner(s37,name37);

        List<String> name38 = Collections.singletonList("yan10");
        Spinner s38 =(Spinner)root.findViewById(R.id.角膜反射);
        spinner(s38,name38);

        List<String> name39 = Collections.singletonList("yan11");
        Spinner s39 =(Spinner)root.findViewById(R.id.对光反射);
        spinner(s39,name39);

        List<String> name40 = Collections.singletonList("yan12");
        Spinner s40 =(Spinner)root.findViewById(R.id.瞳孔1);
        spinner(s40,name40);

        List<String> name41 = Collections.singletonList("yan15");
        Spinner s41 =(Spinner)root.findViewById(R.id.调节反射);
        spinner(s41,name41);

        List<String> name42 = Collections.singletonList("yan16");
        Spinner s42 =(Spinner)root.findViewById(R.id.视野缺损);
        spinner(s42,name42);

        List<String> name43 = Collections.singletonList("yan17");
        Spinner s43 =(Spinner)root.findViewById(R.id.鼻泪管通畅);
        spinner(s43,name43);

        List<String> name44 = Collections.singletonList("er1");
        Spinner s44 =(Spinner)root.findViewById(R.id.耳廓);
        spinner(s44,name44);

        List<String> name45 = Collections.singletonList("er2");
        Spinner s45 =(Spinner)root.findViewById(R.id.外耳道异常分泌物);
        spinner(s45,name45);

        List<String> name46 = Collections.singletonList("er4");
        Spinner s46 =(Spinner)root.findViewById(R.id.乳突);
        spinner(s46,name46);

        List<String> name47 = Collections.singletonList("er5");
        Spinner s47 =(Spinner)root.findViewById(R.id.耳朵压痛左右);
        spinner(s47,name47);

        List<String> name48 = Collections.singletonList("er6");
        Spinner s48 =(Spinner)root.findViewById(R.id.粗试听力);
        spinner(s48,name48);

        List<String> name49 = Collections.singletonList("er7");
        Spinner s49 =(Spinner)root.findViewById(R.id.耳朵障碍左右);
        spinner(s49,name49);

        List<String> name50 = Collections.singletonList("bi1");
        Spinner s50 =(Spinner)root.findViewById(R.id.外形);
        spinner(s50,name50);

        List<String> name51 = Collections.singletonList("bi2");
        Spinner s51 =(Spinner)root.findViewById(R.id.鼻翼煽动有无);
        spinner(s51,name51);

        List<String> name52 = Collections.singletonList("bi3");
        Spinner s52 =(Spinner)root.findViewById(R.id.出血有无);
        spinner(s52,name52);

        List<String> name53 = Collections.singletonList("bi4");
        Spinner s53 =(Spinner)root.findViewById(R.id.阻塞有无);
        spinner(s53,name53);

        List<String> name54 = Collections.singletonList("bi5");
        Spinner s54 =(Spinner)root.findViewById(R.id.鼻甲肥大有无);
        spinner(s54,name54);

        List<String> name55 = Collections.singletonList("bi6");
        Spinner s55 =(Spinner)root.findViewById(R.id.鼻中隔偏曲有无);
        spinner(s55,name55);

        List<String> name56 = Collections.singletonList("bi7");
        Spinner s56 =(Spinner)root.findViewById(R.id.鼻中隔穿孔有无);
        spinner(s56,name56);

        List<String> name57 = Collections.singletonList("bi8");
        Spinner s57 =(Spinner)root.findViewById(R.id.副鼻窦压痛有无);
        spinner(s57,name57);

        List<String> name58 = Collections.singletonList("bi9");
        Spinner s58 =(Spinner)root.findViewById(R.id.嗅觉);
        spinner(s58,name58);

        List<String> name59 = Collections.singletonList("kou1");
        Spinner s59 =(Spinner)root.findViewById(R.id.口唇);
        spinner(s59,name59);

        List<String> name60 = Collections.singletonList("kou2");
        Spinner s60 =(Spinner)root.findViewById(R.id.牙齿有无);
        spinner(s60,name60);

        List<String> name61 = Collections.singletonList("kou3");
        Spinner s61 =(Spinner)root.findViewById(R.id.牙齿1);
        spinner(s61,name61);

        List<String> name62 = Collections.singletonList("kou5");
        Spinner s62 =(Spinner)root.findViewById(R.id.齿龈);
        spinner(s62,name62);

        List<String> name63 = Collections.singletonList("kou6");
        Spinner s63 =(Spinner)root.findViewById(R.id.舌);
        spinner(s63,name63);

        List<String> name64 = Collections.singletonList("kou7");
        Spinner s64 =(Spinner)root.findViewById(R.id.扁桃体);
        spinner(s64,name64);

        List<String> name65 = Collections.singletonList("kou8");
        Spinner s65 =(Spinner)root.findViewById(R.id.左度);
        spinner(s65,name65);

        List<String> name66 = Collections.singletonList("kou9");
        Spinner s66 =(Spinner)root.findViewById(R.id.右度);
        spinner(s66,name66);

        List<String> name67 = Collections.singletonList("kou10");
        Spinner s67 =(Spinner)root.findViewById(R.id.假膜有无);
        spinner(s67,name67);

        List<String> name68 = Collections.singletonList("kou11");
        Spinner s68 =(Spinner)root.findViewById(R.id.脓点及脓性分泌物有无);
        spinner(s68,name68);

        List<String> name69 = Collections.singletonList("kou12");
        Spinner s69 =(Spinner)root.findViewById(R.id.咽);
        spinner(s69,name69);

        List<String> name70 = Collections.singletonList("kou13");
        Spinner s70 =(Spinner)root.findViewById(R.id.喉发音);
        spinner(s70,name70);

        List<String> name71 = Collections.singletonList("jing1");
        Spinner s71 =(Spinner)root.findViewById(R.id.颈);
        spinner(s71,name71);

        List<String> name72 = Collections.singletonList("jing2");
        Spinner s72 =(Spinner)root.findViewById(R.id.颈静脉);
        spinner(s72,name72);

        List<String> name73 = Collections.singletonList("jing3");
        Spinner s73 =(Spinner)root.findViewById(R.id.颈动脉搏动);
        spinner(s73,name73);

        List<String> name74 = Collections.singletonList("jing4");
        Spinner s74 =(Spinner)root.findViewById(R.id.颈动脉血管杂音有无);
        spinner(s74,name74);

        List<String> name75 = Collections.singletonList("jing5");
        Spinner s75 =(Spinner)root.findViewById(R.id.气管);
        spinner(s75,name75);

        List<String> name76 = Collections.singletonList("jing6");
        Spinner s76 =(Spinner)root.findViewById(R.id.甲状腺);
        spinner(s76,name76);

        List<String> name77 = Collections.singletonList("jing7");
        Spinner s77 =(Spinner)root.findViewById(R.id.质地);
        spinner(s77,name77);

        List<String> name78 = Collections.singletonList("jing8");
        Spinner s78 =(Spinner)root.findViewById(R.id.结节有无);
        spinner(s78,name78);

        List<String> name79 = Collections.singletonList("jing9");
        Spinner s79 =(Spinner)root.findViewById(R.id.甲状腺压痛有无);
        spinner(s79,name79);

        List<String> name80 = Collections.singletonList("jing10");
        Spinner s80 =(Spinner)root.findViewById(R.id.震颤有无);
        spinner(s80,name80);

        List<String> name81 = Collections.singletonList("jing11");
        Spinner s81 =(Spinner)root.findViewById(R.id.甲状腺血管杂音有无);
        spinner(s81,name81);

        List<String> name82 = Collections.singletonList("jing12");
        Spinner s82 =(Spinner)root.findViewById(R.id.吞咽时包块有无);
        spinner(s82,name82);

        List<String> name83 = Collections.singletonList("xiong1");
        Spinner s83 =(Spinner)root.findViewById(R.id.胸廓是否对称);
        spinner(s83,name83);

        List<String> name84 = Collections.singletonList("xiong2");
        Spinner s84 =(Spinner)root.findViewById(R.id.胸廓有无畸形);
        spinner(s84,name84);

        List<String> name85 = Collections.singletonList("xiong3");
        Spinner s85 =(Spinner)root.findViewById(R.id.胸廓有无桶状胸等);
        spinner(s85,name85);

        List<String> name86 = Collections.singletonList("xiong4");
        Spinner s86 =(Spinner)root.findViewById(R.id.桶状胸等);
        spinner(s86,name86);

        List<String> name87 = Collections.singletonList("xiong5");
        Spinner s87 =(Spinner)root.findViewById(R.id.胸壁静脉有无曲张);
        spinner(s87,name87);

        List<String> name88 = Collections.singletonList("xiong6");
        Spinner s88 =(Spinner)root.findViewById(R.id.胸骨有无压痛);
        spinner(s88,name88);

        List<String> name89 = Collections.singletonList("xiong7");
        Spinner s89 =(Spinner)root.findViewById(R.id.有无皮下气肿);
        spinner(s89,name89);

        List<String> name90 = Collections.singletonList("xiong8");
        Spinner s90 =(Spinner)root.findViewById(R.id.有无包块);
        spinner(s90,name90);

        List<String> name91 = Collections.singletonList("ru1");
        Spinner s91 =(Spinner)root.findViewById(R.id.乳房发育);
        spinner(s91,name91);

        List<String> name92 = Collections.singletonList("ru2");
        Spinner s92 =(Spinner)root.findViewById(R.id.双侧是否对称);
        spinner(s92,name92);

        List<String> name93 = Collections.singletonList("ru3");
        Spinner s93 =(Spinner)root.findViewById(R.id.乳头正常吗);
        spinner(s93,name93);

        List<String> name94 = Collections.singletonList("ru4");
        Spinner s94 =(Spinner)root.findViewById(R.id.有无橘皮样外观);
        spinner(s94,name94);

        List<String> name95 = Collections.singletonList("ru5");
        Spinner s95 =(Spinner)root.findViewById(R.id.有无压痛);
        spinner(s95,name95);

        List<String> name96 = Collections.singletonList("ru6");
        Spinner s96 =(Spinner)root.findViewById(R.id.乳房包块);
        spinner(s96,name96);

        List<String> name97 = Collections.singletonList("ru7");
        Spinner s97 =(Spinner)root.findViewById(R.id.乳房包块左右);
        spinner(s97,name97);

        List<String> name98 = Collections.singletonList("fei1");
        Spinner s98 =(Spinner)root.findViewById(R.id.呼吸类型);
        spinner(s98,name98);

        List<String> name99 = Collections.singletonList("fei2");
        Spinner s99 =(Spinner)root.findViewById(R.id.呼吸运动);
        spinner(s99,name99);

        List<String> name100 = Collections.singletonList("fei3");
        Spinner s100 =(Spinner)root.findViewById(R.id.呼吸动度);
        spinner(s100,name100);

        List<String> name101 = Collections.singletonList("fei4");
        Spinner s101 =(Spinner)root.findViewById(R.id.呼吸动度左右);
        spinner(s101,name101);

        List<String> name102 = Collections.singletonList("fei5");
        Spinner s102 =(Spinner)root.findViewById(R.id.肋间隙);
        spinner(s102,name102);

        List<String> name103 = Collections.singletonList("fei6");
        Spinner s103 =(Spinner)root.findViewById(R.id.双侧);
        spinner(s103,name103);

        List<String> name104 = Collections.singletonList("fei7");
        Spinner s104 =(Spinner)root.findViewById(R.id.语颤);
        spinner(s104,name104);

        List<String> name105 = Collections.singletonList("fei8");
        Spinner s105 =(Spinner)root.findViewById(R.id.语颤左右);
        spinner(s105,name105);

        List<String> name106 = Collections.singletonList("fei9");
        Spinner s106 =(Spinner)root.findViewById(R.id.胸膜摩擦感有无);
        spinner(s106,name106);

        List<String> name107 = Collections.singletonList("fei10");
        Spinner s107 =(Spinner)root.findViewById(R.id.胸膜摩擦感左右);
        spinner(s107,name107);

        List<String> name108 = Collections.singletonList("fei11");
        Spinner s108 =(Spinner)root.findViewById(R.id.皮下捻发感有无);
        spinner(s108,name108);

        List<String> name109 = Collections.singletonList("fei12");
        Spinner s109 =(Spinner)root.findViewById(R.id.皮下捻发感左右);
        spinner(s109,name109);

        List<String> name110 = Collections.singletonList("fei13");
        Spinner s110 =(Spinner)root.findViewById(R.id.叩诊呈);
        spinner(s110,name110);

        List<String> name111 = Collections.singletonList("fei30");
        Spinner s111 =(Spinner)root.findViewById(R.id.呼吸规整否);
        spinner(s111,name111);

        List<String> name112 = Collections.singletonList("fei19");
        Spinner s112 =(Spinner)root.findViewById(R.id.呼吸音);
        spinner(s112,name112);

        List<String> name113 = Collections.singletonList("fei20");
        Spinner s113 =(Spinner)root.findViewById(R.id.呼吸音左右);
        spinner(s113,name113);

        List<String> name114 = Collections.singletonList("fei21");
        Spinner s114 =(Spinner)root.findViewById(R.id.干罗音有无);
        spinner(s114,name114);

        List<String> name115 = Collections.singletonList("fei22");
        Spinner s115 =(Spinner)root.findViewById(R.id.干罗音左和右);
        spinner(s115,name115);

        List<String> name116 = Collections.singletonList("fei23");
        Spinner s116 =(Spinner)root.findViewById(R.id.干罗音左右有无鼾音哨笛音等);
        spinner(s116,name116);

        List<String> name117 = Collections.singletonList("fei24");
        Spinner s117 =(Spinner)root.findViewById(R.id.湿罗音有无);
        spinner(s117,name117);

        List<String> name118 = Collections.singletonList("fei25");
        Spinner s118 =(Spinner)root.findViewById(R.id.湿罗音左右);
        spinner(s118,name118);

        List<String> name119 = Collections.singletonList("fei26");
        Spinner s119 =(Spinner)root.findViewById(R.id.大中小水泡音);
        spinner(s119,name119);

        List<String> name120 = Collections.singletonList("fei27");
        Spinner s120 =(Spinner)root.findViewById(R.id.胸膜摩擦音有无);
        spinner(s120,name120);

        List<String> name121 = Collections.singletonList("fei28");
        Spinner s121 =(Spinner)root.findViewById(R.id.胸膜摩擦音左右);
        spinner(s121,name121);

        List<String> name122 = Collections.singletonList("fei29");
        Spinner s122 =(Spinner)root.findViewById(R.id.语音传导);
        spinner(s122,name122);

        List<String> name123 = Collections.singletonList("xin1");
        Spinner s123 =(Spinner)root.findViewById(R.id.心前区);
        spinner(s123,name123);

        List<String> name124 = Collections.singletonList("xin2");
        Spinner s124 =(Spinner)root.findViewById(R.id.心尖搏动);
        spinner(s124,name124);

        List<String> name125 = Collections.singletonList("xin3");
        Spinner s125 =(Spinner)root.findViewById(R.id.剑突下搏动);
        spinner(s125,name125);

        List<String> name126 = Collections.singletonList("xin5");
        Spinner s126 =(Spinner)root.findViewById(R.id.肋间锁骨中线);
        spinner(s126,name126);

        List<String> name127 = Collections.singletonList("xin8");
        Spinner s127 =(Spinner)root.findViewById(R.id.有无抬举感);
        spinner(s127,name127);

        List<String> name128 = Collections.singletonList("xin9");
        Spinner s128 =(Spinner)root.findViewById(R.id.有无震颤);
        spinner(s128,name128);

        List<String> name129 = Collections.singletonList("xin10");
        Spinner s129 =(Spinner)root.findViewById(R.id.有无心包摩擦感);
        spinner(s129,name129);

        List<String> name130 = Collections.singletonList("xin12");
        Spinner s130 =(Spinner)root.findViewById(R.id.心脏相对);
        spinner(s130,name130);

        List<String> name131 = Collections.singletonList("xin15");
        Spinner s131 =(Spinner)root.findViewById(R.id.心律齐不);
        spinner(s131,name131);

        List<String> name132 = Collections.singletonList("xin16");
        Spinner s132 =(Spinner)root.findViewById(R.id.心音);
        spinner(s132,name132);

        List<String> name133 = Collections.singletonList("xin17");
        Spinner s133 =(Spinner)root.findViewById(R.id.心音2);
        spinner(s133,name133);

        List<String> name134 = Collections.singletonList("xin19");
        Spinner s134 =(Spinner)root.findViewById(R.id.有无S3);
        spinner(s134,name134);

        List<String> name135 = Collections.singletonList("xin20");
        Spinner s135 =(Spinner)root.findViewById(R.id.有无S4);
        spinner(s135,name135);

        List<String> name136 = Collections.singletonList("xin21");
        Spinner s136 =(Spinner)root.findViewById(R.id.奔马律有无);
        spinner(s136,name136);

        List<String> name137 = Collections.singletonList("xin22");
        Spinner s137 =(Spinner)root.findViewById(R.id.奔马律舒张期);
        spinner(s137,name137);

        List<String> name138 = Collections.singletonList("xin23");
        Spinner s138 =(Spinner)root.findViewById(R.id.有无开瓣音);
        spinner(s138,name138);

        List<String> name139 = Collections.singletonList("xin24");
        Spinner s139=(Spinner)root.findViewById(R.id.有无心包摩擦音);
        spinner(s139,name139);

        List<String> name140 = Collections.singletonList("xin25");
        Spinner s140 =(Spinner)root.findViewById(R.id.有无杂音);
        spinner(s140,name140);

        List<String> name141 = Collections.singletonList("fu1");
        Spinner s141 =(Spinner)root.findViewById(R.id.外形对称吗);
        spinner(s141,name141);

        List<String> name142 = Collections.singletonList("fu2");
        Spinner s142 =(Spinner)root.findViewById(R.id.有无胃肠型);
        spinner(s142,name142);

        List<String> name143 = Collections.singletonList("fu3");
        Spinner s143 =(Spinner)root.findViewById(R.id.有无胃肠蠕动波);
        spinner(s143,name143);

        List<String> name144 = Collections.singletonList("fu4");
        Spinner s144 =(Spinner)root.findViewById(R.id.腹式呼吸);
        spinner(s144,name144);

        List<String> name145 = Collections.singletonList("fu5");
        Spinner s145 =(Spinner)root.findViewById(R.id.肚脐);
        spinner(s145,name145);

        List<String> name146 = Collections.singletonList("fu6");
        Spinner s146 =(Spinner)root.findViewById(R.id.有无脐疝);
        spinner(s146,name146);

        List<String> name147 = Collections.singletonList("fu7");
        Spinner s147 =(Spinner)root.findViewById(R.id.有无手术疤痕);
        spinner(s147,name147);

        List<String> name148 = Collections.singletonList("fu9");
        Spinner s148 =(Spinner)root.findViewById(R.id.有无腹壁静脉曲张);
        spinner(s148,name148);

        List<String> name149 = Collections.singletonList("fu11");
        Spinner s149 =(Spinner)root.findViewById(R.id.腹部柔软吗);
        spinner(s149,name149);

        List<String> name150 = Collections.singletonList("fu12");
        Spinner s150 =(Spinner)root.findViewById(R.id.心脏有无压痛);
        spinner(s150,name150);

        List<String> name151 = Collections.singletonList("fu13");
        Spinner s151 =(Spinner)root.findViewById(R.id.心脏有无反跳痛);
        spinner(s151,name151);

        List<String> name152 = Collections.singletonList("fu14");
        Spinner s152 =(Spinner)root.findViewById(R.id.心脏有无肌紧张);
        spinner(s152,name152);

        List<String> name153 = Collections.singletonList("fu16");
        Spinner s153 =(Spinner)root.findViewById(R.id.心脏有无波动感);
        spinner(s153,name153);

        List<String> name154 = Collections.singletonList("fu17");
        Spinner s154 =(Spinner)root.findViewById(R.id.心脏有无振水音);
        spinner(s154,name154);

        List<String> name155 = Collections.singletonList("fu18");
        Spinner s155 =(Spinner)root.findViewById(R.id.心脏有无腹部包块);
        spinner(s155,name155);

        List<String> name156 = Collections.singletonList("fu20");
        Spinner s156=(Spinner)root.findViewById(R.id.心脏有无疝);
        spinner(s156,name156);

        List<String> name157= Collections.singletonList("fu22");
        Spinner s157 =(Spinner)root.findViewById(R.id.心脏肝脏);
        spinner(s157,name157);

        List<String> name158 = Collections.singletonList("fu25");
        Spinner s158 =(Spinner)root.findViewById(R.id.心脏肝脏光滑吗);
        spinner(s158,name158);

        List<String> name159 = Collections.singletonList("fu26");
        Spinner s159 =(Spinner)root.findViewById(R.id.心脏边缘锐吗);
        spinner(s159,name159);

        List<String> name160 = Collections.singletonList("fu27");
        Spinner s160 =(Spinner)root.findViewById(R.id.腹质地);
        spinner(s160,name160);

        List<String> name161 = Collections.singletonList("fu28");
        Spinner s161 =(Spinner)root.findViewById(R.id.腹有无压痛);
        spinner(s161,name161);

        List<String> name162 = Collections.singletonList("fu29");
        Spinner s162 =(Spinner)root.findViewById(R.id.腹肝颈静脉回流征);
        spinner(s162,name162);

        List<String> name163 = Collections.singletonList("fu30");
        Spinner s163 =(Spinner)root.findViewById(R.id.胆囊);
        spinner(s163,name163);

        List<String> name164 = Collections.singletonList("fu31");
        Spinner s164 =(Spinner)root.findViewById(R.id.M征);
        spinner(s164,name164);

        List<String> name165 = Collections.singletonList("fu32");
        Spinner s165 =(Spinner)root.findViewById(R.id.脾脏);
        spinner(s165,name165);

        List<String> name166 = Collections.singletonList("fu36");
        Spinner s166 =(Spinner)root.findViewById(R.id.脾脏表面);
        spinner(s166,name166);

        List<String> name167 = Collections.singletonList("fu37");
        Spinner s167 =(Spinner)root.findViewById(R.id.脾脏边缘);
        spinner(s167,name167);

        List<String> name168 = Collections.singletonList("fu38");
        Spinner s168 =(Spinner)root.findViewById(R.id.脾脏质地);
        spinner(s168,name168);

        List<String> name169 = Collections.singletonList("fu39");
        Spinner s169 =(Spinner)root.findViewById(R.id.脾脏有无压痛);
        spinner(s169,name169);

        List<String> name170 = Collections.singletonList("fu40");
        Spinner s170 =(Spinner)root.findViewById(R.id.肾脏有无双肾);
        spinner(s170,name170);

        List<String> name171 = Collections.singletonList("fu42");
        Spinner s171 =(Spinner)root.findViewById(R.id.输尿管压痛点有无);
        spinner(s171,name171);

        List<String> name172 = Collections.singletonList("fu43");
        Spinner s172 =(Spinner)root.findViewById(R.id.输尿管压痛点左右);
        spinner(s172,name172);

        List<String> name173 = Collections.singletonList("fu44");
        Spinner s173 =(Spinner)root.findViewById(R.id.输尿管压痛点肋脊点左右);
        spinner(s173,name173);

        List<String> name174 = Collections.singletonList("fu45");
        Spinner s174 =(Spinner)root.findViewById(R.id.输尿管压痛点肋臊点左右);
        spinner(s174,name174);

        List<String> name175 = Collections.singletonList("fu46");
        Spinner s175 =(Spinner)root.findViewById(R.id.膀胱);
        spinner(s175,name175);

        List<String> name176 = Collections.singletonList("fu47");
        Spinner s176 =(Spinner)root.findViewById(R.id.膀胱有无压痛);
        spinner(s176,name176);

        List<String> name177 = Collections.singletonList("fu50");
        Spinner s177 =(Spinner)root.findViewById(R.id.肝浊音界);
        spinner(s177,name177);

        List<String> name178 = Collections.singletonList("fu52");
        Spinner s178 =(Spinner)root.findViewById(R.id.肝区有无);
        spinner(s178,name178);

        List<String> name179 = Collections.singletonList("fu53");
        Spinner s179 =(Spinner)root.findViewById(R.id.肾区有无);
        spinner(s179,name179);

        List<String> name180 = Collections.singletonList("fu54");
        Spinner s180 =(Spinner)root.findViewById(R.id.肾区叩痛左右);
        spinner(s180,name180);

        List<String> name181 = Collections.singletonList("fu55");
        Spinner s181 =(Spinner)root.findViewById(R.id.移动性浊音有无);
        spinner(s181,name181);

        List<String> name182 = Collections.singletonList("fu56");
        Spinner s182 =(Spinner)root.findViewById(R.id.肠鸣音有无);
        spinner(s182,name182);

        List<String> name183 = Collections.singletonList("fu58");
        Spinner s183 =(Spinner)root.findViewById(R.id.气过水声有无);
        spinner(s183,name183);

        List<String> name184 = Collections.singletonList("fu59");
        Spinner s184 =(Spinner)root.findViewById(R.id.血管杂音有无);
        spinner(s184,name184);

        List<String> name185 = Collections.singletonList("jizhu1");
        Spinner s185 =(Spinner)root.findViewById(R.id.脊柱正常或畸形);
        spinner(s185,name185);

        List<String> name186 = Collections.singletonList("jizhu2");
        Spinner s186 =(Spinner)root.findViewById(R.id.脊柱畸形情况);
        spinner(s186,name186);

        List<String> name187 = Collections.singletonList("jizhu3");
        Spinner s187 =(Spinner)root.findViewById(R.id.活动度正常或受限);
        spinner(s187,name187);

        List<String> name188 = Collections.singletonList("jizhu4");
        Spinner s188 =(Spinner)root.findViewById(R.id.棘突有无压痛);
        spinner(s188,name188);

        List<String> name189 = Collections.singletonList("jizhu5");
        Spinner s189 =(Spinner)root.findViewById(R.id.有无叩痛);
        spinner(s189,name189);

        List<String> name190 = Collections.singletonList("jizhu7");
        Spinner s190 =(Spinner)root.findViewById(R.id.四肢有无畸形);
        spinner(s190,name190);

        List<String> name191 = Collections.singletonList("jizhu8");
        Spinner s191 =(Spinner)root.findViewById(R.id.有无杵状指趾);
        spinner(s191,name191);

        List<String> name192 = Collections.singletonList("jizhu9");
        Spinner s192 =(Spinner)root.findViewById(R.id.关节有无红肿等);
        spinner(s192,name192);

        List<String> name193 = Collections.singletonList("jizhu10");
        Spinner s193 =(Spinner)root.findViewById(R.id.关节有无红肿热积液等);
        spinner(s193,name193);

        List<String> name194 = Collections.singletonList("jizhu11");
        Spinner s194 =(Spinner)root.findViewById(R.id.肌肉有无);
        spinner(s194,name194);

        List<String> name195 = Collections.singletonList("jizhu12");
        Spinner s195 =(Spinner)root.findViewById(R.id.肌肉有无压痛萎缩);
        spinner(s195,name195);

        List<String> name196 = Collections.singletonList("jizhu13");
        Spinner s196 =(Spinner)root.findViewById(R.id.下肢静脉有无曲张);
        spinner(s196,name196);

        List<String> name197 = Collections.singletonList("jizhu14");
        Spinner s197 =(Spinner)root.findViewById(R.id.下肢有无水肿);
        spinner(s197,name197);

        List<String> name198 = Collections.singletonList("jizhu15");
        Spinner s198 =(Spinner)root.findViewById(R.id.有无骨折);
        spinner(s198,name198);

        List<String> name199 = Collections.singletonList("shen1");
        Spinner s199 =(Spinner)root.findViewById(R.id.神经系统浅感觉);
        spinner(s199,name199);

        List<String> name200 = Collections.singletonList("shen2");
        Spinner s200 =(Spinner)root.findViewById(R.id.神经系统浅感觉正常减退消失);
        spinner(s200,name200);

        List<String> name201 = Collections.singletonList("shen3");
        Spinner s201 =(Spinner)root.findViewById(R.id.神经系统深感觉正常减退消失);
        spinner(s201,name201);

        List<String> name202 = Collections.singletonList("shen4");
        Spinner s202 =(Spinner)root.findViewById(R.id.肌张力正常增强减弱消失);
        spinner(s202,name202);

        List<String> name203 = Collections.singletonList("shen6");
        Spinner s203 =(Spinner)root.findViewById(R.id.肢体瘫痪有无);
        spinner(s203,name203);

        List<String> name204 = Collections.singletonList("shen8");
        Spinner s204 =(Spinner)root.findViewById(R.id.腹壁反射正常减弱消失);
        spinner(s204,name204);

        List<String> name205 = Collections.singletonList("shen9");
        Spinner s205 =(Spinner)root.findViewById(R.id.跖反射正常减弱消失);
        spinner(s205,name205);

        List<String> name206 = Collections.singletonList("shen10");
        Spinner s206 =(Spinner)root.findViewById(R.id.提睾反射正常减弱消失);
        spinner(s206,name206);

        List<String> name207 = Collections.singletonList("shen11");
        Spinner s207 =(Spinner)root.findViewById(R.id.肛门反射正常减弱消失);
        spinner(s207,name207);

        List<String> name208 = Collections.singletonList("shen12");
        Spinner s208 =(Spinner)root.findViewById(R.id.肱二头肌反射正常否);
        spinner(s208,name208);

        List<String> name209 = Collections.singletonList("shen13");
        Spinner s209 =(Spinner)root.findViewById(R.id.肱三头肌反射正常否);
        spinner(s209,name209);

        List<String> name210 = Collections.singletonList("shen14");
        Spinner s210 =(Spinner)root.findViewById(R.id.桡骨膜反射正常否);
        spinner(s210,name210);

        List<String> name211 = Collections.singletonList("shen15");
        Spinner s211 =(Spinner)root.findViewById(R.id.膝腱反射正常否);
        spinner(s211,name211);

        List<String> name212 = Collections.singletonList("shen16");
        Spinner s212 =(Spinner)root.findViewById(R.id.跟腱反射正常否);
        spinner(s212,name212);

        List<String> name213 = Collections.singletonList("shen17");
        Spinner s213 =(Spinner)root.findViewById(R.id.Babinski氏征阴性阳性);
        spinner(s213,name213);

        List<String> name214 = Collections.singletonList("shen18");
        Spinner s214 =(Spinner)root.findViewById(R.id.Oppenheim氏征阴性阳性);
        spinner(s214,name214);

        List<String> name215 = Collections.singletonList("shen19");
        Spinner s215 =(Spinner)root.findViewById(R.id.Gordon氏征阴性阳性);
        spinner(s215,name215);

        List<String> name216 = Collections.singletonList("shen20");
        Spinner s216 =(Spinner)root.findViewById(R.id.Chaddock氏征阴性阳性);
        spinner(s216,name216);

        List<String> name217 = Collections.singletonList("shen21");
        Spinner s217 =(Spinner)root.findViewById(R.id.Hoffmann氏征阴性阳性);
        spinner(s217,name217);

        List<String> name218 = Collections.singletonList("shen22");
        Spinner s218 =(Spinner)root.findViewById(R.id.Kerning氏征阴性阳性);
        spinner(s218,name218);

        List<String> name219 = Collections.singletonList("shen23");
        Spinner s219 =(Spinner)root.findViewById(R.id.Brudzinski氏征阴性阳性);
        spinner(s219,name219);

        List<String> name220 = Collections.singletonList("lin1");
        Spinner s220 =(Spinner)root.findViewById(R.id.全身浅表淋巴结有无);
        spinner(s220,name220);

        List<String> name221 = Collections.singletonList("lin2");
        Spinner s221 =(Spinner)root.findViewById(R.id.全身淋巴结部位);
        spinner(s221,name221);

        List<String> name222 = Collections.singletonList("lin6");
        Spinner s222 =(Spinner)root.findViewById(R.id.淋巴结有无压痛);
        spinner(s222,name222);

        List<String> name223 = Collections.singletonList("lin7");
        Spinner s223 =(Spinner)root.findViewById(R.id.淋巴结有无粘连);
        spinner(s223,name223);




        List<EditText> text = Arrays.asList(t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15,t16,t17,t18,t19,t20,t21,t22,t23,t24,t25,t26,t27,t28,t29,t30,t31,t32,t33,t34,t35,t36,t37,t38,t39,t40,t41,t42,t43,t44,t45,t46,t47,t48,t49,t50,t51,t52,t53,t54);
        List<String> name = Arrays.asList("tiwen","maibo","xueya1","xueya2","shengao","tizhong","BMI","pifu9","pifu12","toulu8","yan13","yan14","er3","kou4","huxi","xiong9","ru8","fei14","fei15","fei16","fei17","fei18","xin4","xin6","xin7","xin11","xin13","xin14","xin18","xin26","fu8","fu10","fu15","fu19","fu21","fu23","fu24","fu33","fu34","fu35","fu41","fu48","fu49","fu51","fu57","fu60","jizhu6","jizhu16","shen5","shen7","lin3","lin4","lin5","lin8");

        setEdit(name,text);

        return root;
    }
    public void spinner_hideshow(Spinner spinner, LinearLayout layout)
    {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(spinner.getSelectedItem().toString().equals("有"))
                {
                    layout.setVisibility(View.VISIBLE);
                }
                else if(spinner.getSelectedItem().toString().equals("无"))
                {
                    layout.setVisibility(View.GONE);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.i("Spinner","unSelected");
            }
        });}

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

    public static void setET(String data,String name,EditText et) throws JSONException {
        JSONObject jsonObject = null;
        try {
            jsonObject=new JSONObject(data);
        } catch (JSONException e) {
            e.printStackTrace();
        }
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
            setET(MainActivity.ceshi, "tiwen", t1);
            setET(MainActivity.ceshi, "maibo", t2);
            setET(MainActivity.ceshi, "xueya1", t3);
            setET(MainActivity.ceshi, "xueya2", t4);
            setET(MainActivity.ceshi, "shengao", t5);
            setET(MainActivity.ceshi, "tizhong", t6);
            setET(MainActivity.ceshi, "BMI", t7);
            setET(MainActivity.ceshi, "pifu9", t8);
            setET(MainActivity.ceshi, "pifu12", t9);
            setET(MainActivity.ceshi, "toulu8", t10);
            setET(MainActivity.ceshi, "yan13", t11);
            setET(MainActivity.ceshi, "yan14", t12);
            setET(MainActivity.ceshi, "er3", t13);
            setET(MainActivity.ceshi, "kou4", t14);
            setET(MainActivity.ceshi, "huxi", t15);

            setSP(MainActivity.ceshi, "yiban1", s1);
            setSP(MainActivity.ceshi, "yiban2", s2);
            setSP(MainActivity.ceshi, "yiban3", s3);
            setSP(MainActivity.ceshi, "yiban4", s4);
            setSP(MainActivity.ceshi, "yiban5", s5);
            setSP(MainActivity.ceshi, "yiban6", s6);
            setSP(MainActivity.ceshi, "yiban7", s7);
            setSP(MainActivity.ceshi, "yiban8", s8);
            setSP(MainActivity.ceshi, "yiban9", s9);
            setSP(MainActivity.ceshi, "yiban10", s10);
            setSP(MainActivity.ceshi, "yiban11", s11);
            setSP(MainActivity.ceshi, "pifu1", s12);
            setSP(MainActivity.ceshi, "pifu2", s13);
            setSP(MainActivity.ceshi, "pifu3", s14);
            setSP(MainActivity.ceshi, "pifu4", s15);
            setSP(MainActivity.ceshi, "pifu5", s16);
            setSP(MainActivity.ceshi, "pifu6", s17);
            setSP(MainActivity.ceshi, "pifu7", s18);
            setSP(MainActivity.ceshi, "pifu8", s19);
            setSP(MainActivity.ceshi, "pifu10", s20);
            setSP(MainActivity.ceshi, "pifu11", s21);
            setSP(MainActivity.ceshi, "toulu1", s22);
            setSP(MainActivity.ceshi, "toulu2", s23);
            setSP(MainActivity.ceshi, "toulu3", s24);
            setSP(MainActivity.ceshi, "toulu4", s25);
            setSP(MainActivity.ceshi, "toulu5", s26);
            setSP(MainActivity.ceshi, "toulu6", s27);
            setSP(MainActivity.ceshi, "toulu7", s28);
            setSP(MainActivity.ceshi, "yan1", s29);
            setSP(MainActivity.ceshi, "yan2", s30);
            setSP(MainActivity.ceshi, "yan3", s31);
            setSP(MainActivity.ceshi, "yan4", s32);
            setSP(MainActivity.ceshi, "yan5", s33);
            setSP(MainActivity.ceshi, "yan6", s34);
            setSP(MainActivity.ceshi, "yan7", s35);
            setSP(MainActivity.ceshi, "yan8", s36);
            setSP(MainActivity.ceshi, "yan9", s37);
            setSP(MainActivity.ceshi, "yan10", s38);
            setSP(MainActivity.ceshi, "yan11", s39);
            setSP(MainActivity.ceshi, "yan12", s40);
            setSP(MainActivity.ceshi, "yan15", s41);
            setSP(MainActivity.ceshi, "yan16", s42);
            setSP(MainActivity.ceshi, "yan17", s43);
            setSP(MainActivity.ceshi, "er1", s44);
            setSP(MainActivity.ceshi, "er2", s45);
            setSP(MainActivity.ceshi, "er4", s46);
            setSP(MainActivity.ceshi, "er5", s47);
            setSP(MainActivity.ceshi, "er6", s48);
            setSP(MainActivity.ceshi, "er7", s49);
            setSP(MainActivity.ceshi, "bi1", s50);
            setSP(MainActivity.ceshi, "bi2", s51);
            setSP(MainActivity.ceshi, "bi3", s52);
            setSP(MainActivity.ceshi, "bi4", s53);
            setSP(MainActivity.ceshi, "bi5", s54);
            setSP(MainActivity.ceshi, "bi6", s55);
            setSP(MainActivity.ceshi, "bi7", s56);
            setSP(MainActivity.ceshi, "bi8", s57);
            setSP(MainActivity.ceshi, "bi9", s58);
            setSP(MainActivity.ceshi, "kou1", s59);
            setSP(MainActivity.ceshi, "kou2", s60);
            setSP(MainActivity.ceshi, "kou3", s61);
            setSP(MainActivity.ceshi, "kou5", s62);
            setSP(MainActivity.ceshi, "kou6", s63);
            setSP(MainActivity.ceshi, "kou7", s64);
            setSP(MainActivity.ceshi, "kou8", s65);
            setSP(MainActivity.ceshi, "kou9", s66);
            setSP(MainActivity.ceshi, "kou10", s67);
            setSP(MainActivity.ceshi, "kou11", s68);
            setSP(MainActivity.ceshi, "kou12", s69);
            setSP(MainActivity.ceshi, "kou13", s70);
            setSP(MainActivity.ceshi, "jing1", s71);
            setSP(MainActivity.ceshi, "jing2", s72);
            setSP(MainActivity.ceshi, "jing3", s73);
            setSP(MainActivity.ceshi, "jing4", s74);
            setSP(MainActivity.ceshi, "jing5", s75);
            setSP(MainActivity.ceshi, "jing6", s76);
            setSP(MainActivity.ceshi, "jing7", s77);
            setSP(MainActivity.ceshi, "jing8", s78);
            setSP(MainActivity.ceshi, "jing9", s79);
            setSP(MainActivity.ceshi, "jing10", s80);
            setSP(MainActivity.ceshi, "jing11", s81);
            setSP(MainActivity.ceshi, "jing12", s82);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        MainActivity.fg=!MainActivity.fg;
    }
}