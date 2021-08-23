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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import com.example.medicalhistory_patient.MainActivity;
import com.example.medicalhistory_patient.R;
import com.soundcloud.android.crop.Crop;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import id.zelory.compressor.Compressor;

import static android.app.Activity.RESULT_OK;

/**
 * A placeholder fragment containing a simple view.
 */
public class Sub4Fragment2 extends Fragment {
//    private ImageView ivMyPhoto;
    public static String PatientID;//存放患者唯一识别ID
    private String localPath = "/sdcard/MedicalHistory";
    public static String localPath1;
    File photoFile1;//专门用作回调
    //对每一项初始化参数
    //X片
    File XpianphotoFile = new File(localPath1, "XPx.png");
    boolean Xpianflag = true ;
    //CT
    File CTphotoFile = new File(localPath1, "CTx.png");
    boolean CTflag = true ;
    //MRI
    File MRIphotoFile = new File(localPath1, "MRI.png");
    boolean MRIflag = true ;
    //骨扫描
    File GSMphotoFile = new File(localPath1, "GSM.png");
    boolean GSMflag = true ;
    //PET-CT
    File PETCTphotoFile = new File(localPath1, "PET.png");
    boolean PETCTflag = true ;
    //超声
    File CSphotoFile = new File(localPath1, "CSx.png");
    boolean CSflag = true ;



    private static final String ARG_SECTION_NUMBER = "section_number";
    public static Sub4Fragment2 newInstance(int index) {
        Sub4Fragment2 fragment = new Sub4Fragment2();
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
        View root = inflater.inflate(R.layout.fragment4_sub2, container, false);
//        final EditText textView = root.findViewById(R.id.zhusu3);
//        List<EditText> text1 = Collections.singletonList(textView);
//        Spinner s1=(Spinner)root.findViewById(R.id.zhusu2);
//        List<Spinner> text2 = Collections.singletonList(s1);
//        for(int i = 0;i<text1.size();i++) MainActivity.setSpinner(text2.get(i).getSelectedItem());
//        for(int i = 0;i<text1.size();i++)MainActivity.setEdit(text1.get(i));
        /////////////////////////x片监听//////////////////
        ImageView XpianivMyPhoto = root.findViewById(R.id.X片显示);
        Button XpianPIC = root.findViewById(R.id.X片拍照);
        Button XpianSHOW = root.findViewById(R.id.X片拍照显示);


        XpianPIC.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                File XpianphotoFile = new File(localPath1, "XPx.png");
                photoFile1 = new File(localPath1, "XPx.png");
                playPhoto(root,XpianphotoFile);
            }
        });
        XpianSHOW.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                File XpianphotoFile = new File(localPath1, "XPx.png");
                Show(XpianphotoFile,XpianivMyPhoto, Xpianflag);
                Xpianflag =! Xpianflag;
            }
        });

        /////////////////////////CT监听//////////////////


        ImageView CTivMyPhoto = root.findViewById(R.id.CT显示);
        Button CTPIC = root.findViewById(R.id.CT拍照);
        Button CTSHOW = root.findViewById(R.id.CT拍照显示);
        CTPIC.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                File CTphotoFile = new File(localPath1, "CTx.png");
                photoFile1 = new File(localPath1, "CTx.png");
                playPhoto(root,CTphotoFile);
            }
        });
        CTSHOW.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                File CTphotoFile = new File(localPath1, "CTx.png");
                Show(CTphotoFile,CTivMyPhoto,CTflag);
                CTflag =! CTflag;
            }
        });

        /////////////////////////MRI监听//////////////////


        ImageView MRIivMyPhoto = root.findViewById(R.id.MRI显示);
        Button MRIPIC = root.findViewById(R.id.MRI拍照);
        Button MRISHOW = root.findViewById(R.id.MRI拍照显示);
        MRIPIC.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                File MRIphotoFile = new File(localPath1, "MRI.png");
                photoFile1 = new File(localPath1, "MRI.png");
                playPhoto(root,MRIphotoFile);
            }
        });
        MRISHOW.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                File MRIphotoFile = new File(localPath1, "MRI.png");
                Show(MRIphotoFile,MRIivMyPhoto,MRIflag);
                MRIflag =! MRIflag;
            }
        });

        /////////////////////////骨扫描监听//////////////////


        ImageView GSMivMyPhoto = root.findViewById(R.id.骨扫描显示);
        Button GSMPIC = root.findViewById(R.id.骨扫描拍照);
        Button GSMSHOW = root.findViewById(R.id.骨扫描拍照显示);
        GSMPIC.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                File GSMphotoFile = new File(localPath1, "GSM.png");
                photoFile1 = new File(localPath1, "GSM.png");
                playPhoto(root,GSMphotoFile);
            }
        });
        GSMSHOW.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                File GSMphotoFile = new File(localPath1, "GSM.png");
                Show(GSMphotoFile,GSMivMyPhoto,GSMflag);
                GSMflag =! GSMflag;
            }
        });

        /////////////////////////PET-CT监听//////////////////


        ImageView PETCTivMyPhoto = root.findViewById(R.id.PETCT显示);
        Button PETCTPIC = root.findViewById(R.id.PETCT拍照);
        Button PETCTSHOW = root.findViewById(R.id.PETCT拍照显示);
        PETCTPIC.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                File PETCTphotoFile = new File(localPath1, "PET.png");
                photoFile1 = new File(localPath1, "PET.png");
                playPhoto(root,PETCTphotoFile);
            }
        });
        PETCTSHOW.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                File PETCTphotoFile = new File(localPath1, "PET.png");
                Show(PETCTphotoFile,PETCTivMyPhoto,PETCTflag);
                PETCTflag =! PETCTflag;
            }
        });

        /////////////////////////超声监听//////////////////


        ImageView CSivMyPhoto = root.findViewById(R.id.超声显示);
        Button CSPIC = root.findViewById(R.id.超声拍照);
        Button CSSHOW = root.findViewById(R.id.超声拍照显示);
        CSPIC.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                File CSphotoFile = new File(localPath1, "CSx.png");
                photoFile1 = new File(localPath1, "CSx.png");
                playPhoto(root,CSphotoFile);
            }
        });
        CSSHOW.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                File CSphotoFile = new File(localPath1, "CSx.png");
                Show(CSphotoFile,CSivMyPhoto,CSflag);
                CSflag =! CSflag;
            }
        });


        return root;
    }







    public void playPhoto(View view, File photoFile) {
//        localPath = "/sdcard/MedicalHistory";
//        photoFile = new File(localPath, "temp.png");
        if ((photoFile.getParentFile() != null) && (!photoFile.getParentFile().exists())) {
            photoFile.getParentFile().mkdirs();
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

                //把照片名字取出来
                String photoNameString = photoFile1.toString();
                String photoName = photoNameString.substring(photoNameString.length()-8,photoNameString.length()-5);
                System.out.println("--------------------------------------------");
                System.out.println(photoName);
                InputStream zhuanhua= null;


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

    public static String getPatientID(String str){
        PatientID = str;
        localPath1 = Environment.getExternalStorageDirectory().getPath()+ "/Android/data/com.example.medicalhistory_patient/MedicalHistory/" + PatientID;//增加了PatientID的localPath
        return localPath1;
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

}