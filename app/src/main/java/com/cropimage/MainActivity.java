package com.cropimage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements OnClickListener{

    ImageView ivProfile;
    Context context = this;
    Button btnUpload;
    CameraHandler cameraHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        ivProfile = (ImageView) findViewById(R.id.iv_upload);
        btnUpload = (Button) findViewById(R.id.btn_upload_image);
        btnUpload.setOnClickListener(this);
        cameraHandler = new CameraHandler(context);
        cameraHandler.setIvPicture(ivProfile);
    }

    @Override
    public void onClick(View view) {
        if (view == btnUpload) {
            cameraHandler.showView();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        cameraHandler.onResult(requestCode, resultCode, data);
        Log.v("", "code = > " + requestCode);
    }
}