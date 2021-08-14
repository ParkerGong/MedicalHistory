package com.example.medicalhistory_patient;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;

import com.example.medicalhistory_patient.ui.main.Sub4Fragment1;
import com.example.medicalhistory_patient.ui.main.Sub4Fragment2;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.RequiresApi;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Environment;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.medicalhistory_patient.ui.main.SectionsPagerAdapter;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    private static Collection<Editable> strings;
    private static TextView text;
    private static final HashMap<String,Editable> hashMap = new HashMap<>();
    private static final int MAX_DATA_PACKET_LENGTH = 1000000;
    private final byte[] buffer = new byte[MAX_DATA_PACKET_LENGTH];
    private static HashMap<String,String> PictureList = new HashMap<>();//放图片list的地址
    private static byte[] tupian;
    private static byte[] tupian1;
    private static DatagramPacket dataPacket;
    private static DatagramPacket dataPacket1;
    private static DatagramPacket dataPacket2;
    private static DatagramPacket da;
    private static DatagramPacket da1;
    private static DatagramPacket da2;
    private static DatagramSocket udpSocket;//发送图片数据
    public static DatagramSocket udpSocket0;//连接服务器
    public static DatagramSocket udpSocket1;//发送文本数据
    public static DatagramSocket udpSocket3;//发送床号
    public static String text3;//存床号
    public static String PatientID;//存放患者唯一识别ID



    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String[] permissions =
                {android.Manifest.permission.CAMERA, android.Manifest.permission.CHANGE_WIFI_STATE,
                        android.Manifest.permission.ACCESS_NETWORK_STATE,android.Manifest.permission.ACCESS_WIFI_STATE,
                        android.Manifest.permission.WRITE_EXTERNAL_STORAGE,android.Manifest.permission.READ_EXTERNAL_STORAGE,
                        android.Manifest.permission.CHANGE_NETWORK_STATE};
        ActivityCompat.requestPermissions(MainActivity.this, permissions, 1);
        text = findViewById(R.id.tex);
        Button send = (Button)findViewById(R.id.send);
        Button link = (Button)findViewById(R.id.lianjie);
        HashMap<String,String> test = new HashMap<>();
        Button reboot = (Button)findViewById(R.id.reboot);

        //重设APP
        reboot.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNormalDialog();

            }
        });


        findViewById(R.id.确认ID).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText PatID=findViewById(R.id.病历ID);
                Sub4Fragment1.getPatientID(PatID.getText().toString());
                Sub4Fragment2.getPatientID(PatID.getText().toString());
                System.out.println("-------------------------------------------------------------");
                System.out.println(PatID.getText().toString());
                text.post(new Runnable() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void run() {
                        text.setText("已确认患者ID");
                    }
                });
            }
        });

        link.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 患者发送床号
                new Thread() {
                    @Override

                    public void run() {
                        super.run();
                        String strUrl="http://192.168.186.100:8000/connect/";
                        URL url=null;
                        try {
                            text.post(() -> text.setText("尝试与服务器建立连接"));
                            Spinner s1 =(Spinner)findViewById(R.id.bednumber1);
                            String chaunghaosend = s1.getSelectedItem().toString();
                            test.put("chuanghao",chaunghaosend);
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
                            text.post(new Runnable() {
                                @SuppressLint("SetTextI18n")
                                @Override
                                public void run() {
                                    text.setText("成功连接服务器");
                                }
                            });
                        } catch (IOException | JSONException e) {
                            e.printStackTrace();
                            text.post(() -> text.setText("服务器连接失败"));
                        }}
                }.start();


            }
        });
//        link.setOnClickListener(v -> Link());


        send.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 患者发送文本
            new Thread() {
             @Override

            public void run() {
                super.run();
                String strUrl="http://192.168.186.100:8000/text_recv/";
                URL url=null;
                try {

                    text.post(() -> text.setText("正在发送"));

                    final EditText t1 = findViewById(R.id.病历ID);
                    List<EditText> chuangtext = Arrays.asList(t1);
                    List<String> chuangname = Arrays.asList("PatientID");
                    setEdit(chuangname,chuangtext);
                    List<String> chuanghao = Collections.singletonList("chuanghao");
                    Spinner chuanghao1 =(Spinner)findViewById(R.id.bednumber1);
                    hashMap.put(chuanghao.get(0),new SpannableStringBuilder((CharSequence) chuanghao1.getSelectedItem()));
                    text.post(() -> text.setText("正在检查填写内容"));
                    //检查是否有空的，有的话就补充，防止出现空value
                    Iterator iter = hashMap.entrySet().iterator();
                    while(iter.hasNext()){
                        Map.Entry entry = (Map.Entry) iter.next();
                        Object key = entry.getKey();
                        Object val = entry.getValue();
                        if(val.toString().length() == 0){
                            System.out.println(key);
                            System.out.println(val);
                            val = "患者未填写";
                            Editable editable = new SpannableStringBuilder(val.toString());
                            hashMap.put(key.toString(),editable);
                        }
                    }


                    text.post(() -> text.setText("正在发送文本"));
                    JSONObject jsonObject = new JSONObject(String.valueOf(hashMap));
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
                    text.post(() -> text.setText("发送成功"));
                    removeFileByTime(Environment.getExternalStorageDirectory().getPath()+ "/Android/data/com.example.medicalhistory_patient/MedicalHistory/");

                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                    text.post(() -> text.setText("发送失败"));
                }}
            }.start();


                 //患者发送图片
                new Thread() {
                    @Override


                    public void run() {
                        System.out.println("-------------------Start Send Pic--------------------");
                        text.post(() -> text.setText("正在发送图片"));
                        InputStream zhuanhua= null;
                        System.out.println(PictureList);
                        Iterator<Map.Entry<String, String>> iter = PictureList.entrySet().iterator();
                        while (iter.hasNext()){
                            Map.Entry entry = (Map.Entry) iter.next();
                            String key = entry.getKey().toString();
                            String value = entry.getValue().toString();
                            File file1 = new File(value);
                            try {
                                zhuanhua = file2InputStream(file1);
                            } catch (FileNotFoundException e) {
                                e.printStackTrace();
                            }
                            try {
                                readStream1(key,zhuanhua);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                            send(key,tupian);

                        }
                        }
                }.start();



            }
        });

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        viewPager.setOffscreenPageLimit(9);//重要代码！！！导航栏限制个数！
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);


    }


    public void get_spinner(Spinner spinner)
    {

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Object text2 = spinner.getSelectedItem();
                text3= text2.toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Log.i("Spinner","unSelected");
            }

        });}


    public static void removeFileByTime(String dirPath) {
        //获取目录下所有文件
        List<File> allFile = getDirAllFile(new File(dirPath));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        //获取当前时间
        Date end = new Date(System.currentTimeMillis());
        try {
            end = dateFormat.parse(dateFormat.format(new Date(System.currentTimeMillis())));
        } catch (Exception e){
            e.printStackTrace();
        }
        for (File file : allFile) {//ComDef
            try {
                //文件时间减去当前时间
                Date start = dateFormat.parse(dateFormat.format(new Date(file.lastModified())));
                long diff = end.getTime() - start.getTime();//这样得到的差值是微秒级别
                long days = diff / (1000 * 60 * 60 * 24);
                if(1 <= days){
                    deleteFile2(file);
                }

            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    //删除文件夹及文件夹下所有文件
    public static void deleteFile2(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                File f = files[i];
                deleteFile2(f);
            }
            file.delete();
        } else if (file.exists()) {
            file.delete();
        }
    }

    //获取指定目录下一级文件
    public static List<File> getDirAllFile(File file) {
        List<File> fileList = new ArrayList<>();
        File[] fileArray = file.listFiles();
        if(fileArray == null)
            return fileList;
        for (File f : fileArray) {
            fileList.add(f);
        }
        fileSortByTime(fileList);
        return fileList;
    }

    //对文件进行时间排序
    public static void fileSortByTime(List<File> fileList) {
        Collections.sort(fileList, new Comparator<File>() {
            public int compare(File p1, File p2) {
                if (p1.lastModified() < p2.lastModified()) {
                    return -1;
                }
                return 1;
            }
        });
    }


    public static void setSpinner(List<String> st, List<Object> view)
    {
        for(int i =0;i<view.size();i++)
        {hashMap.put(st.get(i),new SpannableStringBuilder((CharSequence) view.get(i)));}
    }

    public static void setEdit(List<String> st, List<EditText> view)
    {
        for(int i =0;i<view.size();i++)
        {if(view.get(i).getText()!=null)hashMap.put(st.get(i),view.get(i).getText());}

    }

    public static void setspinner(String st, int i)//患者版setSpinner修改
    {
        hashMap.put(st, new SpannableStringBuilder(String.valueOf(i)));
    }

    public static InputStream file2InputStream(File file) throws FileNotFoundException {
        return new FileInputStream(file);
    }

    public static byte[] readStream1(String str,InputStream inStream) throws Exception {
        byte[] buffer = new byte[1024];
        int len = -1;
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        while ((len = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        byte[] data = outStream.toByteArray();
        outStream.close();
        inStream.close();

        fasongtu(str,data);
        return data;
    }


    public static void fasongtu(String str, byte[] data){
        tupian = data;

    }

    public static void PictureListSet(String str, String data){
        PictureList.put(str,data);

    }

    public static void fasongtu1( String str,byte[] data){

        tupian1 = data;

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
                String strUrl="http://192.168.186.100:8000/picture_recv/";
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
                    con.addRequestProperty("Filename",s);
                    Spinner bednum = findViewById(R.id.bednumber1);
                    con.addRequestProperty("chuanghao",bednum.getSelectedItem().toString());
                    System.out.println(bednum.getSelectedItem().toString());
                    EditText PatID=findViewById(R.id.病历ID);
                    con.addRequestProperty("PatientID",PatID.getText().toString());
                    con.setUseCaches(false);
                    con.connect();
                    OutputStream dd = con.getOutputStream();
                    dd.write(out);
                    dd.flush();
                    dd.close();
                    System.out.println(con.getResponseCode());
                    con.disconnect();
                    text.post(() -> text.setText("发送成功"));
                } catch (IOException e) {
                    e.printStackTrace();
                    text.post(() -> text.setText("发送失败"));
                }
            }




        }.start();
    }
}
