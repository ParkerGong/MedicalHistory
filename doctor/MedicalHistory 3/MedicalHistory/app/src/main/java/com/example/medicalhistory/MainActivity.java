package com.example.medicalhistory;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;

import com.example.medicalhistory.ui.main.PlaceholderFragment1;
import com.example.medicalhistory.ui.main.PlaceholderFragment2;
import com.example.medicalhistory.ui.main.Sub4Fragment1;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Environment;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.medicalhistory.ui.main.SectionsPagerAdapter;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.URL;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class MainActivity extends AppCompatActivity {
    private static String URL = "http://172.20.10.6:8000";//该处绑定服务端IP
    public static boolean s1;
    private static TextView text;
    private static TextView text2;
    private static final HashMap<String,Editable> hashMap = new HashMap<>();
    private static final HashMap<String,Editable> hashMap1 = new HashMap<>();
    private static final int MAX_DATA_PACKET_LENGTH = 204800;
    public static JSONObject ceshi;
    private final byte[] buffer = new byte[MAX_DATA_PACKET_LENGTH];
    private final byte[] buffer1 = new byte[647];
    private static DatagramPacket dataPacket;
    private static DatagramPacket dataPacket3;
    private static DatagramPacket dataPacket4;
    public static boolean fg;
    private static byte[] tupian;
    private static byte[] tupian1;

    private static DatagramPacket da;
    private static DatagramPacket da3;
    private static DatagramPacket da4;
    private static DatagramSocket udpSocket;//1030 医生版发送端口（未处理）
    public static DatagramSocket udpSocket0;//1032 连接成功判断
    public static DatagramSocket udpSocket3;//请求床号1033 存图片
    public static DatagramSocket udpSocket4;//请求床号1031 存文本
    public static String text3;//存床号
    public static String bedname;
    @SuppressLint("WrongViewCast")


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        String[] permissions =
                {android.Manifest.permission.CAMERA, android.Manifest.permission.CHANGE_WIFI_STATE,
                        android.Manifest.permission.ACCESS_NETWORK_STATE,android.Manifest.permission.ACCESS_WIFI_STATE,
                        android.Manifest.permission.WRITE_EXTERNAL_STORAGE,android.Manifest.permission.READ_EXTERNAL_STORAGE,
                        android.Manifest.permission.CHANGE_NETWORK_STATE};
        ActivityCompat.requestPermissions(MainActivity.this, permissions, 1);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.tex);
        Button lianjie = (Button)findViewById(R.id.lianjie);
        Button send = (Button)findViewById(R.id.send);
        Button chuanghao1 = (Button)findViewById(R.id.chuanghao1);

        Spinner s1 =(Spinner)findViewById(R.id.床位);
        spinner(s1);
        Button reboot = (Button)findViewById(R.id.reboot);
        //重设APP
        reboot.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNormalDialog();

            }
        });

        send.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                //医生发送JSON给服务器
                new Thread() {
                    @Override

                    public void run() {

                        super.run();
                        String strUrl=URL+"/create_doc/";
                        URL url=null;
                        try {
                            //检查是否有空的，有的话就补充，防止出现空value
                            Iterator iter = hashMap.entrySet().iterator();
                            while(iter.hasNext()){
                                Map.Entry entry = (Map.Entry) iter.next();
                                Object key = entry.getKey();
                                Object val = entry.getValue();
                                if(val.toString().length() == 0){
                                    System.out.println(key);
                                    System.out.println(val);
                                    val = "医生未填写";
                                    Editable editable = new SpannableStringBuilder(val.toString());
                                    hashMap.put(key.toString(),editable);
                                }
                            }

                            Spinner s1 =(Spinner)findViewById(R.id.床位);
                            String chaunghaosend = s1.getSelectedItem().toString();
                            HashMap<String,String> test = new HashMap<>();
                            Editable chuanghaosendED = new SpannableStringBuilder(chaunghaosend);
                            hashMap.put("chuanghao",chuanghaosendED);

                            System.out.println(chaunghaosend);
                            text.post(() -> text.setText("正在发送"));
                            JSONObject jsonObject = new JSONObject(String.valueOf(hashMap));
                            System.out.println("-------------------------------");
                            System.out.println(jsonObject.toString());
                            url = new URL(strUrl);
                            HttpURLConnection con = (HttpURLConnection)url.openConnection();
                            con.setDoInput(true);
                            con.setDoOutput(true);
                            con.setRequestMethod("POST");
                            con.setRequestProperty("Content-Type","application/json");
                            con.setRequestProperty("Charset","UTF-8");
                            con.setUseCaches(false);
                            con.connect();
                            OutputStream dd = con.getOutputStream();
                            dd.write(jsonObject.toString().getBytes());
                            dd.flush();
                            dd.close();
                            System.out.println(con.getResponseCode());
                            con.disconnect();
                            text.post(() -> text.setText("成功发送病历"));
                        } catch (IOException | JSONException e) {
                            e.printStackTrace();
                        }}
                }.start();

            }
        });

        lianjie.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                 //医生发送床号给服务器
            new Thread() {
             @Override

            public void run() {
                super.run();
                String strUrl=URL+"/connect/";
                URL url=null;
                try {
                    text.post(() -> text.setText("尝试与服务器建立连接"));
                    HashMap<String,String> test = new HashMap<>();
                    Spinner spn = findViewById(R.id.床位);
                    test.put("chuanghao",spn.getSelectedItem().toString());
                    System.out.println(spn.getSelectedItem().toString());
                    JSONObject jsonObject = new JSONObject(String.valueOf(test));
                    System.out.println(jsonObject.toString());
                    url = new URL(strUrl);
                    HttpURLConnection con = (HttpURLConnection)url.openConnection();
                    con.setDoInput(true);
                    con.setDoOutput(true);
                    con.setRequestMethod("POST");
                    con.setRequestProperty("Content-Type","application/json");
                    con.setRequestProperty("Charset","UTF-8");
                    con.setUseCaches(false);
                    con.connect();
                    OutputStream dd = con.getOutputStream();
                    dd.write(jsonObject.toString().getBytes());
                    dd.flush();
                    dd.close();
                    System.out.println(con.getResponseCode());
                    con.disconnect();
                    text.post(() -> text.setText("成功连接"));
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                    text.post(() -> text.setText("连接失败"));
                }}
            }.start();

            }
        });




        chuanghao1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                //////////////////////////医生接收js字符串////////////////////////////
                new Thread()
                {
                    @Override
                    public void run()
                    {
                        super.run();
                        String strUrl=URL+"/docter_send_text/";

                        URL url=null;
                        try {

                            text.post(() -> text.setText("信息更新完毕"));
                            Spinner s1 =(Spinner)findViewById(R.id.床位);
                            String chaunghaosend = s1.getSelectedItem().toString();
                            HashMap<String,String> test = new HashMap<>();
                            test.put("chuanghao",chaunghaosend);
                            JSONObject jsonObject = new JSONObject(String.valueOf(test));
                            url = new URL(strUrl);
                            HttpURLConnection con = (HttpURLConnection)url.openConnection();
                            con.setDoInput(true);
                            con.setDoOutput(true);
                            con.setRequestMethod("POST");
                            con.setRequestProperty("Content-Type","application/json");
                            con.setRequestProperty("Charset","UTF-8");
                            con.setUseCaches(false);
                            con.connect();
                            OutputStream dd = con.getOutputStream();
                            dd.write(jsonObject.toString().getBytes());
                            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(con.getInputStream()));
                            String result = "";
                            String readLine = null;
                            System.out.println("---------------接收字符串------------------");
                            while ((readLine=bufferedReader.readLine())!=null)
                            {
                                result+=readLine;
                            }
                            bufferedReader.close();
                            con.disconnect();
                            JSONObject ff = new JSONObject(result);
                            ceshi = ff;
                            System.out.println(ceshi);
                            PlaceholderFragment1.set();
                            PlaceholderFragment2.set();
                            text.post(() -> text.setText("信息更新完毕"));
                        }
                        catch (IOException | JSONException e) {
                            e.printStackTrace();
                        }}
                }.start();

            }});



        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());

        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        viewPager.setOffscreenPageLimit(9);//重要代码！！！导航栏限制个数！
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);


    }




    public static void setEdit(List<String> st, List<EditText> view)
    {
        for(int i =0;i<view.size();i++)
        {if(view.get(i).getText()!=null)
        {
            Editable itm = view.get(i).getText();
            if(itm.toString() != ""){
                hashMap.put(st.get(i),itm);
            }
            else {
                String nosp = "无特殊";
                Editable editable = new SpannableStringBuilder(nosp);
                itm = editable;
                hashMap.put(st.get(i),itm);
            }


        }
            }

    }

    public static void setSpinner(List<String> st, List<Object> view)
    {
        for(int i =0;i<view.size();i++)
        {hashMap.put(st.get(i),new SpannableStringBuilder((CharSequence) view.get(i)));}
    }


//    public void Link()
//    {
//        new Thread() {
//            @RequiresApi(api = Build.VERSION_CODES.N)
//            @Override
//            public void run() {
//                try {
//                    DatagramPacket dataPacket0 = new DatagramPacket(buffer, MAX_DATA_PACKET_LENGTH, InetAddress.getByName("192.168.43.7"), 8089);
//                    dataPacket0.setData(("hello").getBytes());
//                    udpSocket0 = new DatagramSocket(1032);
//                    udpSocket0.send(dataPacket0);
//                    text.post(() -> text.setText("尝试与服务器建立连接"));
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                while (true) {
//                    try {
//                        DatagramPacket da = new DatagramPacket(buffer,2048);
//                        udpSocket0.receive(da);
//                        byte[] st = da.getData();
//                        text.post(() -> text.setText("已成功与服务器建立连接"));
//                    }
//                    catch (IOException ignored) {
//                    }
//                }
//            }
//        }.start();
//    }
    public void spinner(Spinner spinner)
    {

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object text2 = spinner.getSelectedItem();
                text3= text2.toString();
                //Sub4Fragment1.SetBed(text3);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.i("Spinner","unSelected");
            }

        });}

    public static InputStream file2InputStream(File file) throws FileNotFoundException {
        return new FileInputStream(file);
    }

    public static byte[] readStream1(InputStream inStream) throws Exception {
        byte[] buffer = new byte[1024];
        int len = -1;
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        while ((len = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        byte[] data = outStream.toByteArray();
        outStream.close();
        inStream.close();

        fasongtu1(data);
        return data;
    }

    public static void fasongtu( byte[] data){

        tupian=data;

    }
    public static void fasongtu1( byte[] data){

        tupian1 = data;

    }

    public static EditText PicRCV(String bednum, String PTID, String Fname){
        /////////医生接收图片//////
        new Thread()
        {
            @Override
            public void run()
            {
                super.run();
                String strUrl=URL+"/docter_send_imag/";

                URL url=null;
                try {
                    text.post(() -> text.setText("正在下载图片"));
                    HashMap<String,String> test = new HashMap<>();
                    test.put("chuanghao","1床");
                    test.put("PatientID","111");
                    test.put("Filename","XCG.PNG");
                    JSONObject jsonObject = new JSONObject(String.valueOf(test));
                    url = new URL(strUrl);
                    HttpURLConnection con = (HttpURLConnection)url.openConnection();
                    con.addRequestProperty("Filename",Fname);
                    con.addRequestProperty("chuanghao",bednum);
                    con.addRequestProperty("PatientID",PTID);
                    con.setDoInput(true);
                    con.setDoOutput(true);
                    con.setRequestMethod("POST");
                    con.setRequestProperty("Content-Type","application/json");
                    con.setRequestProperty("Charset","UTF-8");
                    con.setUseCaches(false);
                    con.connect();
                    OutputStream dd = con.getOutputStream();
                    dd.write(jsonObject.toString().getBytes());
                    InputStream inputStream=con.getInputStream();
                    InputStream is = (InputStream) con.getContent();
                    Bitmap bitmap= BitmapFactory.decodeStream(is);
                    is.close();
                    con.disconnect();
                    File file = new File(Environment.getExternalStorageDirectory().getPath()+"/Android/data/com.example.medicalhistory/MedicalHistory/"+PTID+"/",Fname+".png");
                    if ((file.getParentFile() != null) && (!file.getParentFile().exists())) {
                        file.getParentFile().mkdirs();}  //mkdirs 可创建多级目录，mkdir只能创建以及目录

                    FileOutputStream fos = new FileOutputStream(file);
                    bitmap.compress(Bitmap.CompressFormat.PNG,100,fos);
                    System.out.println(con.getResponseCode());
                    fos.flush();
                    fos.close();
                    text.post(() -> text.setText("下载完成"));
                }
                catch (IOException | JSONException e) {
                    e.printStackTrace();
                }}
        }.start();
        return null;
    }

    private void showNormalDialog(){
        /* @setIcon 设置对话框图标
         * @setTitle 设置对话框标题
         * @setMessage 设置对话框消息提示
         * setXXX方法返回Dialog对象，因此可以链式设置属性
         */
        final AlertDialog.Builder normalDialog =
                new AlertDialog.Builder(MainActivity.this);
        normalDialog.setTitle("确认是否重设所有");
        normalDialog.setMessage("重设后将清除本次填写的所有数据（仅限医生操作）");

        normalDialog.setPositiveButton("确定清除",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //...To-do

                        final Intent intent = getPackageManager().getLaunchIntentForPackage(getPackageName());
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);

                        //杀掉以前进程
                        android.os.Process.killProcess(android.os.Process.myPid());
                    }
                });
        normalDialog.setNegativeButton("取消",
                (dialog, which) -> {
                    //...To-do
                });
        // 显示
        final AlertDialog dialog = normalDialog.create();
        dialog.show();

        Button mNegativeButton = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);
        Button mPositiveButton = dialog.getButton(AlertDialog.BUTTON_POSITIVE);

        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) mNegativeButton.getLayoutParams();
        params.leftMargin = 10;
        params.rightMargin = 50;
        mNegativeButton.setLayoutParams(params);


    }

    private void send(String s,byte[] im)
    {
        new Thread() {
            @Override
            //发送图片数据包
            //发送图片数组
            public void run()
            {
                super.run();
                String strUrl=URL+"/picture_recv/";
                URL url=null;
                try
                {
                    url = new URL(strUrl);
                    HttpURLConnection con = (HttpURLConnection)url.openConnection();
                    con.setDoInput(true);
                    con.setDoOutput(true);
                    con.setRequestMethod("POST");
                    byte[] out=im;
                    if(out==null)
                        out=tupian1;
                    con.addRequestProperty("FileName",s);
                    con.setUseCaches(false);
                    con.connect();
                    OutputStream dd = con.getOutputStream();
                    dd.write(out);
                    dd.flush();
                    dd.close();
                    System.out.println(con.getResponseCode());
                    con.disconnect();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }




}