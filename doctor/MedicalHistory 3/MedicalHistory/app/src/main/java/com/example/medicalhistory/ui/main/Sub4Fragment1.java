package com.example.medicalhistory.ui.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;

import com.example.medicalhistory.MainActivity;
import com.example.medicalhistory.R;
import com.soundcloud.android.crop.Crop;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

import static android.app.Activity.RESULT_OK;

/**
 * A placeholder fragment containing a simple view.
 */
public class Sub4Fragment1 extends PlaceholderFragment1 {


    private static final String ARG_SECTION_NUMBER = "section_number";
    private static File XCGphotoFile;
    private final String localPath = Environment.getExternalStorageDirectory().getPath()+ "/Android/data/com.example.medicalhistory/MedicalHistory/";
    private final String Path = Environment.getExternalStorageDirectory().getPath()+ "/Pictures/";
    public static String bed;

    File photoFile1;//专门用作回调
    //对每一项初始化参数
    //血常规

    boolean XCGflag = true ;
    //尿常规

    boolean NCGflag = true ;
    //凝血

    boolean NXflag = true ;
    //生化

    boolean SHflag = true ;
    //肿瘤标志物

    boolean ZLBZWflag = true ;



    public static Sub4Fragment1 newInstance(int index) {
        Sub4Fragment1 fragment = new Sub4Fragment1();
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
        MainActivity mainActivity = (MainActivity) getActivity();
        View root = inflater.inflate(R.layout.fragment4_sub1, container, false);
        //final EditText xingbie = root.findViewById(R.id.xingbie2);
        //List<EditText> text1 = Collections.singletonList(xingbie);
//        for(int i = 0;i<text1.size();i++) setEdit(text1.get(i));
        ////////////start/////////////
        /////////////////////////血常规监听//////////////////
        ImageView XCGivMyPhoto = root.findViewById(R.id.血常规显示);
        Button XCGSHOW = root.findViewById(R.id.血常规拍照显示);


        root.findViewById(R.id.血常规请求).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spinner spn =  mainActivity.findViewById(R.id.床位);
                try {
                    MainActivity.PicRCV(spn.getSelectedItem().toString(),MainActivity.ceshi.getString("PatientID"),"XCG");
//                    System.out.println("------------------请求图片---------------------");
//                    System.out.println(MainActivity.ceshi.getString("PatientID")+"  "+spn.getSelectedItem().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });


//        XCGPIC.setOnClickListener(new Button.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                photoFile1 = new File(localPath, "血常规.png");
//                playPhoto(root,XCGphotoFile);
//            }
//        });
//        XCGSHOW.setOnClickListener(new Button.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                Show(XCGphotoFile,XCGivMyPhoto, XCGflag);
//                switch (v.getId()){
//                    case R.id.血常规拍照显示:
////                    case R.id.example:
////                        XCGflag =! XCGflag;
//                        break;
//                }
//
//
//            }
//        });

        XCGSHOW.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                File XCGphotoFile = null;
                try {
                    XCGphotoFile = new File(localPath+ MainActivity.ceshi.getString("PatientID")+"/", "XCG.png");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Show(XCGphotoFile,XCGivMyPhoto, XCGflag);
                XCGflag =! XCGflag;
            }
        });

        /////////////////////////尿常规监听//////////////////
        ImageView NCGivMyPhoto = root.findViewById(R.id.尿常规显示);
//        Button NCGPIC = root.findViewById(R.id.尿常规拍照);
        Button NCGSHOW = root.findViewById(R.id.尿常规拍照显示);


        root.findViewById(R.id.尿常规请求).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spinner spn =  mainActivity.findViewById(R.id.床位);
                try {
                    EditText editText =
                            MainActivity.PicRCV(spn.getSelectedItem().toString(),MainActivity.ceshi.getString("PatientID"),"NCG");
//                    System.out.println("------------------请求图片---------------------");
//                    System.out.println(MainActivity.ceshi.getString("PatientID")+"  "+spn.getSelectedItem().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
//        NCGPIC.setOnClickListener(new Button.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                photoFile1 = new File(localPath, "尿常规.png");
//                playPhoto(root,NCGphotoFile);
//            }
//        });
        NCGSHOW.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                File NCGphotoFile = null;
                try {
                    NCGphotoFile = new File(localPath+ MainActivity.ceshi.getString("PatientID")+"/", "NCG.png");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Show(NCGphotoFile,NCGivMyPhoto, NCGflag);
                NCGflag =! NCGflag;
            }
        });

        /////////////////////////凝血监听//////////////////
        ImageView NXivMyPhoto = root.findViewById(R.id.凝血显示);
//        Button NXPIC = root.findViewById(R.id.凝血拍照);
        Button NXSHOW = root.findViewById(R.id.凝血拍照显示);

        root.findViewById(R.id.凝血请求).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spinner spn =  mainActivity.findViewById(R.id.床位);
                try {
                    EditText editText =
                            MainActivity.PicRCV(spn.getSelectedItem().toString(),MainActivity.ceshi.getString("PatientID"),"NXx");
//                    System.out.println("------------------请求图片---------------------");
//                    System.out.println(MainActivity.ceshi.getString("PatientID")+"  "+spn.getSelectedItem().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
//        NXPIC.setOnClickListener(new Button.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                photoFile1 = new File(localPath, "凝血.png");
//                playPhoto(root,NXphotoFile);
//            }
//        });
        NXSHOW.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                File NXphotoFile = null;
                try {
                    NXphotoFile = new File(localPath+ MainActivity.ceshi.getString("PatientID")+"/", "NXx.png");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Show(NXphotoFile,NXivMyPhoto, NXflag);
                NXflag =! NXflag;
            }
        });

        /////////////////////////生化监听//////////////////
        ImageView SHivMyPhoto = root.findViewById(R.id.生化显示);
//        Button SHPIC = root.findViewById(R.id.生化拍照);
        Button SHSHOW = root.findViewById(R.id.生化拍照显示);

        root.findViewById(R.id.生化请求).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spinner spn =  mainActivity.findViewById(R.id.床位);
                try {
                    EditText editText =
                            MainActivity.PicRCV(spn.getSelectedItem().toString(),MainActivity.ceshi.getString("PatientID"),"SHx");
//                    System.out.println("------------------请求图片---------------------");
//                    System.out.println(MainActivity.ceshi.getString("PatientID")+"  "+spn.getSelectedItem().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });

//        SHPIC.setOnClickListener(new Button.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                photoFile1 = new File(localPath, "生化.png");
//                playPhoto(root,SHphotoFile);
//            }
//        });
        SHSHOW.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                File SHphotoFile = null;
                try {
                    SHphotoFile = new File(localPath+ MainActivity.ceshi.getString("PatientID")+"/", "SHx.png");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Show(SHphotoFile,SHivMyPhoto, SHflag);
                SHflag =! SHflag;
            }
        });

        /////////////////////////肿瘤标志物监听//////////////////
        ImageView ZLBZWivMyPhoto = root.findViewById(R.id.肿瘤标志物显示);
//        Button ZLBZWPIC = root.findViewById(R.id.肿瘤标志物拍照);
        Button ZLBZWSHOW = root.findViewById(R.id.肿瘤标志物拍照显示);

        root.findViewById(R.id.肿瘤请求).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spinner spn =  mainActivity.findViewById(R.id.床位);
                try {
                    EditText editText =
                            MainActivity.PicRCV(spn.getSelectedItem().toString(),MainActivity.ceshi.getString("PatientID"),"ZLx");
//                    System.out.println("------------------请求图片---------------------");
//                    System.out.println(MainActivity.ceshi.getString("PatientID")+"  "+spn.getSelectedItem().toString());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
//        ZLBZWPIC.setOnClickListener(new Button.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                photoFile1 = new File(localPath, "肿瘤标志物.png");
//                playPhoto(root,ZLBZWphotoFile);
//            }
//        });
        ZLBZWSHOW.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                File ZLBZWphotoFile = null;
                try {
                    ZLBZWphotoFile = new File(localPath+ MainActivity.ceshi.getString("PatientID")+"/", "ZLx.png");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                Show(ZLBZWphotoFile,ZLBZWivMyPhoto, ZLBZWflag);
                ZLBZWflag =! ZLBZWflag;
            }
        });

        return root;
    }



    public void playPhoto(View view, File photoFile) {
//        localPath = "/sdcard/MedicalHistory";
//        photoFile = new File(localPath, "temp.png");
        if ((photoFile.getParentFile() != null) && (!photoFile.getParentFile().exists())) {
            try {
                photoFile.getParentFile().mkdirs();  //mkdirs 可创建多级目录，mkdir只能创建以及目录
            } catch (Exception ex) {
                Log.e("mkdir", "创建文件目录失败" + ex.toString());
            }
//                photoFile.getParentFile().mkdirs();

        }

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        Uri fileUri = getUriForFile(getContext(), photoFile);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
        startActivityForResult(intent, 100);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        //拍照完成后返回调用

        if (resultCode == RESULT_OK) {
            if (requestCode == 100) {
                //该方式获取到的图片是原图
                Crop.of(Uri.fromFile(photoFile1), Uri.fromFile(photoFile1)).start(getActivity());
            }
        }
    }

    private Uri getUriForFile(Context context, File file) {
        Uri fileUri;
        if (Build.VERSION.SDK_INT >= 24) {
            fileUri = FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", file);
        } else {
            fileUri = Uri.fromFile(file);
        }
        return fileUri;
    }



    private void Show(File photoFile, ImageView ivMyPhoto, boolean flag)
    {
        if(flag)
        {
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(photoFile);
                Bitmap bitmap = BitmapFactory.decodeStream(fis);
                ivMyPhoto.setImageBitmap(bitmap);
                ivMyPhoto.setVisibility(View.VISIBLE);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fis != null)
                        fis.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }}
        else {ivMyPhoto.setVisibility(View.GONE);}
    }
    public static void SetBed(String s)
    {
        bed= "1床";
        bed=s;
        XCGphotoFile = new File(Environment.getExternalStorageDirectory().getPath()+ "/Pictures/", bed+".png");
        System.out.println(bed);
    }
}