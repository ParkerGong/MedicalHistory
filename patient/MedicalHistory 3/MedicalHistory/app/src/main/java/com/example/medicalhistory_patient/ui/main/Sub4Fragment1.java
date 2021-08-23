package com.example.medicalhistory_patient.ui.main;

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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;

import com.example.medicalhistory_patient.MainActivity;
import com.example.medicalhistory_patient.R;
import com.soundcloud.android.crop.Crop;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import id.zelory.compressor.Compressor;

import static android.app.Activity.RESULT_OK;
import static com.example.medicalhistory_patient.MainActivity.fasongtu;

/**
 * A placeholder fragment containing a simple view.
 */
public class Sub4Fragment1 extends PlaceholderFragment1 {

    public static String PatientID;//存放患者唯一识别ID
    private static final String ARG_SECTION_NUMBER = "section_number";
    public final String localPath = Environment.getExternalStorageDirectory().getPath()+ "/Android/data/com.example.medicalhistory_patient/MedicalHistory/";
//    public static String localPath;
    public static String localPath1;//存放新的带ID的地址
    File photoFile1;//专门用作回调

    boolean XCGflag = true ;
    boolean NCGflag = true ;
    boolean NXflag = true ;
    boolean SHflag = true ;
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
        View root = inflater.inflate(R.layout.fragment4_sub1, container, false);
        //final EditText xingbie = root.findViewById(R.id.xingbie2);
        //List<EditText> text1 = Collections.singletonList(xingbie);
//        for(int i = 0;i<text1.size();i++) setEdit(text1.get(i));
//        EditText editText=(EditText)root.findViewById(R.id.病历ID);
//        PatientID=editText.getText().toString();
//
//        String localPath1 = localPath + PatientID;//增加了PatientID的localPath

//        PatientID = getIntent().getString("ID");
//        MainActivity activity = (MainActivity) getActivity();
//        EditText PtID = activity.findViewById(R.id.病历ID);
//        PatientID = PtID.getText().toString();
//        String localPath1 = localPath + PatientID;//增加了PatientID的localPath

//        //对每一项初始化参数
//        //血常规
//        File XCGphotoFile = new File(localPath1, "XCG.png");
//
//        //尿常规
//        File NCGphotoFile = new File(localPath1, "NCG.png");
//
//        //凝血
//        File NXphotoFile = new File(localPath1, "NXx.png");
//
//        //生化
//        File SHphotoFile = new File(localPath1, "SHx.png");
//
//        //肿瘤标志物
//        File ZLBZWphotoFile = new File(localPath1, "ZLx.png");





        ////////////start/////////////
        /////////////////////////血常规监听//////////////////
        ImageView XCGivMyPhoto = root.findViewById(R.id.血常规显示);
        Button XCGPIC = root.findViewById(R.id.血常规拍照);
        Button XCGSHOW = root.findViewById(R.id.血常规拍照显示);


        XCGPIC.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                File XCGphotoFile = new File(localPath1, "XCG.png");
                photoFile1 = new File(localPath1, "XCG.png");
                System.out.println("---------------------------XCG----------------------------------");
                System.out.println(localPath1);
                System.out.println(PatientID);
                playPhoto(root,XCGphotoFile);
            }
        });


        XCGSHOW.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                File XCGphotoFile = new File(localPath1, "XCG.png");
                Show(XCGphotoFile,XCGivMyPhoto, XCGflag);
                XCGflag =! XCGflag;
            }
        });

        /////////////////////////尿常规监听//////////////////
        ImageView NCGivMyPhoto = root.findViewById(R.id.尿常规显示);
        Button NCGPIC = root.findViewById(R.id.尿常规拍照);
        Button NCGSHOW = root.findViewById(R.id.尿常规拍照显示);


        NCGPIC.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                File NCGphotoFile = new File(localPath1, "NCG.png");
                photoFile1 = new File(localPath1, "NCG.png");
                System.out.println("-----------------------------NCG--------------------------------");
                System.out.println(localPath1);
                System.out.println(PatientID);
                playPhoto(root,NCGphotoFile);
            }
        });
        NCGSHOW.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                File NCGphotoFile = new File(localPath1, "NCG.png");
                Show(NCGphotoFile,NCGivMyPhoto, NCGflag);
                NCGflag =! NCGflag;
            }
        });

        /////////////////////////凝血监听//////////////////
        ImageView NXivMyPhoto = root.findViewById(R.id.凝血显示);
        Button NXPIC = root.findViewById(R.id.凝血拍照);
        Button NXSHOW = root.findViewById(R.id.凝血拍照显示);


        NXPIC.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                File NXphotoFile = new File(localPath1, "NXx.png");
                photoFile1 = new File(localPath1, "NXx.png");
                System.out.println("------------------------------NX-------------------------------");
                System.out.println(localPath1);
                System.out.println(PatientID);
                playPhoto(root,NXphotoFile);
            }
        });
        NXSHOW.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                File NXphotoFile = new File(localPath1, "NXx.png");
                Show(NXphotoFile,NXivMyPhoto, NXflag);
                NXflag =! NXflag;
            }
        });

        /////////////////////////生化监听//////////////////
        ImageView SHivMyPhoto = root.findViewById(R.id.生化显示);
        Button SHPIC = root.findViewById(R.id.生化拍照);
        Button SHSHOW = root.findViewById(R.id.生化拍照显示);


        SHPIC.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                File SHphotoFile = new File(localPath1, "SHx.png");
                photoFile1 = new File(localPath1, "SHx.png");
                System.out.println("--------------------------------SH-----------------------------");
                System.out.println(localPath1);
                System.out.println(PatientID);
                playPhoto(root,SHphotoFile);
            }
        });
        SHSHOW.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                File SHphotoFile = new File(localPath1, "SHx.png");
                Show(SHphotoFile,SHivMyPhoto, SHflag);
                SHflag =! SHflag;
            }
        });

        /////////////////////////肿瘤标志物监听//////////////////
        ImageView ZLBZWivMyPhoto = root.findViewById(R.id.肿瘤标志物显示);
        Button ZLBZWPIC = root.findViewById(R.id.肿瘤标志物拍照);
        Button ZLBZWSHOW = root.findViewById(R.id.肿瘤标志物拍照显示);


        ZLBZWPIC.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                File ZLBZWphotoFile = new File(localPath1, "ZLx.png");
                photoFile1 = new File(localPath1, "ZLx.png");
                System.out.println("------------------------------ZL-------------------------------");
                System.out.println(localPath1);
                System.out.println(PatientID);
                playPhoto(root,ZLBZWphotoFile);
            }
        });
        ZLBZWSHOW.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                File ZLBZWphotoFile = new File(localPath1, "ZLx.png");
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
                //压缩图片
                photoFile1 = Compressor.getDefault(this.getContext()).compressToFile(photoFile1);
//                photoFile1 = new Compressor.Builder(Objects.requireNonNull(this.getContext()))
//                        .setQuality(75)
//                        .setCompressFormat(Bitmap.CompressFormat.WEBP)
//                        .setDestinationDirectoryPath(localPath+"血常规.png")
//                        .build()
//                        .compressToFile(photoFile1);
                //把照片名字取出来
                String photoNameString = photoFile1.toString();
                String photoName = photoNameString.substring(photoNameString.length()-8,photoNameString.length()-5);
                System.out.println("--------------------------------------------");
                System.out.println(photoName);
                InputStream zhuanhua= null;

//                try {
//
//                    zhuanhua = file2InputStream(photoFile1);
////                    System.out.println(zhuanhua);
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                }
                try {
                    MainActivity.PictureListSet(photoName,photoNameString);
                } catch (Exception e) {
                    e.printStackTrace();
                }




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
    public static byte[] readStream(String str, InputStream inStream) throws Exception {

        byte[] buffer = new byte[1024];
        int len = -1;
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        while ((len = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, len);
        }
        byte[] data = outStream.toByteArray();
        outStream.close();
        inStream.close();

//        fasongtu(str,data);
        return data;
    }

    public static String getPatientID(String str){
        PatientID = str;
        localPath1 = Environment.getExternalStorageDirectory().getPath()+ "/Android/data/com.example.medicalhistory_patient/MedicalHistory/" + PatientID;//增加了PatientID的localPath
        return localPath1;
    }

    public static InputStream file2InputStream(File file) throws FileNotFoundException {
        return new FileInputStream(file);
    }
}

