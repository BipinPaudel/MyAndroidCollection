package com.bips.open_cv;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.SurfaceView;
import android.view.WindowManager;
import android.widget.Toast;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.android.JavaCameraView;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.OpenCVLoader;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity implements CameraBridgeViewBase.CvCameraViewListener{
//Used for logging success or failure messages
    private static final String TAG="OCVSAMPLE::Activity";

    private Mat grayScaleImage;
    private int absoluteFaceSize;
    //Loads camera view of OpenCV for us to use. This lets us see using OpenCV
    private CameraBridgeViewBase mOpenCvCameraView;

    private CascadeClassifier cascadeClassifier;

    //Used in Camera selection from menu (when implemented)

    private boolean mIsJavaCamera=true;
    private MenuItem menuItemSwitchCamera=null;

    InputStream is;
    //These variables are used at the moment to fix camera orientation from 270 degree to 0degree
    Mat mRgba;
    Mat mRgbaF;
    Mat mRgbaT;

    BaseLoaderCallback mLoaderCallback= new BaseLoaderCallback(this) {
        @Override
        public void onManagerConnected(int status) {
            switch (status){
                case LoaderCallbackInterface.SUCCESS:
                    Log.i(TAG,"Open CV loaded successfully");
                    initializeOpenCVDependencies();
                    mOpenCvCameraView.enableView();
                    break;
                default:
                    super.onManagerConnected(status);
                    break;
            }
        }
    };

    private void initializeOpenCVDependencies() {
        try{
//            is=getResources().openRawResource(R.raw.haarcascade_frontalface_default);
//            System.out.println("is read" +is.read());
//
           File cascadeDir=new File(Environment.getExternalStorageDirectory(),"cascade");
            if(!cascadeDir.exists()){
                cascadeDir.mkdir();
               // Toast.makeText(MainActivity.this, "la create bho folder", Toast.LENGTH_SHORT).show();
            }


            File mCascadeFile=new File(cascadeDir,"face_haar_cascade.xml");
//            FileOutputStream os=new FileOutputStream(mCascadeFile);
//
//            byte[] buffer = new byte[4096];
//            int bytesRead;
//
//            while ((bytesRead = is.read(buffer)) != -1) {
//                System.out.println(bytesRead);
//                //os.write(buffer, 0, bytesRead);
//            }
//            is.close();
           // os.close();
          //  Toast.makeText(this,mCascadeFile.getPath())

//             Load the cascade classifier
            System.out.println("path path--------" + mCascadeFile.getAbsolutePath());
            cascadeClassifier = new CascadeClassifier(mCascadeFile.getAbsolutePath());
            System.out.println(cascadeClassifier.load(mCascadeFile.getAbsolutePath()));
            cascadeClassifier.load(mCascadeFile.getAbsolutePath());
            if (cascadeClassifier.empty()){
                Toast.makeText(this,"finished hai finished",Toast.LENGTH_SHORT).show();
            }
            else
                Toast.makeText(this,cascadeClassifier.toString(),Toast.LENGTH_SHORT).show();
        }
        catch (Exception e){
            Log.e("OpenCVActivity","Error loading cascade",e);
        }
    }

    public MainActivity(){
        Log.i(TAG,"Instantiated new "+this.getClass());
    }









    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_main);

        mOpenCvCameraView = (JavaCameraView) findViewById(R.id.show_camera_view);
        mOpenCvCameraView.setVisibility(SurfaceView.VISIBLE);
        mOpenCvCameraView.setCvCameraViewListener(this);

    }
    @Override
    public void onPause()
    {
        super.onPause();
        if (mOpenCvCameraView != null)
            mOpenCvCameraView.disableView();
    }

    @Override
    public void onResume()
    {
        super.onResume();
        if (!OpenCVLoader.initDebug()) {
            Log.d(TAG, "Internal OpenCV library not found. Using OpenCV Manager for initialization");
            OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_3_0_0, this, mLoaderCallback);
        } else {
            Log.d(TAG, "OpenCV library found inside package. Using it!");
            mLoaderCallback.onManagerConnected(LoaderCallbackInterface.SUCCESS);
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (mOpenCvCameraView != null)
            mOpenCvCameraView.disableView();
    }
    @Override
    public void onCameraViewStarted(int width, int height) {
//        mRgba=new Mat(height,width, CvType.CV_8UC4);
//        mRgbaF = new Mat(height, width, CvType.CV_8UC4);
//        mRgbaT = new Mat(width, width, CvType.CV_8UC4);

        grayScaleImage=new Mat(height,width,CvType.CV_8UC4);
        absoluteFaceSize= (int) (height*0.2);
    }

    @Override
    public void onCameraViewStopped() {
//mRgba.release();
    }

    @Override
    public Mat onCameraFrame(Mat inputFrame) {
        Imgproc.cvtColor(inputFrame,grayScaleImage,Imgproc.COLOR_RGBA2RGB);

        MatOfRect faces = new MatOfRect();

        if (cascadeClassifier != null) {
            cascadeClassifier.detectMultiScale(grayScaleImage, faces, 1.1, 2, 2,
                    new Size(absoluteFaceSize, absoluteFaceSize), new Size());
        }

        // If there are any faces found, draw a rectangle around it
        Rect[] facesArray = faces.toArray();
        for (int i = 0; i <facesArray.length; i++)
            Imgproc.rectangle(inputFrame, facesArray[i].tl(), facesArray[i].br(), new Scalar(0, 255, 0, 255), 3);


        return inputFrame;
    }

//    @Override
//    public Mat onCameraFrame(CameraBridgeViewBase.CvCameraViewFrame inputFrame) {
//        // TODO Auto-generated method stub
////        mRgba = inputFrame.rgba();
////        // Rotate mRgba 90 degrees
////        Core.transpose(mRgba, mRgbaT);
////        Imgproc.resize(mRgbaT, mRgbaF, mRgbaF.size(), 0,0, 0);
////        Core.flip(mRgbaF, mRgba, 1 );
//
//
//
////        return mRgba; // This function must return
//    }



}





















