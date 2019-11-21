package com.gosigitgo.audiovideojava;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //untuk hide status bar
        requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_video);

        VideoView videoView= findViewById(R.id.video_view);

        MediaController controller = new MediaController(this);
        controller.setAnchorView(videoView);
        videoView.setMediaController(controller);

        Uri uri=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.androidcommercial);

        videoView.setVideoURI(uri);
        videoView.requestFocus();
        videoView.start();

        //untuk hide action bar
        getSupportActionBar().hide();
    }
}
