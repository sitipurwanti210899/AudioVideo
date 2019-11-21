package com.gosigitgo.audiovideojava;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoStreamingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_video_streaming);

        VideoView videostreaming = findViewById(R.id.video_streaming);

        MediaController controller = new MediaController(this);
        controller.setAnchorView(videostreaming);
        videostreaming.setMediaController(controller);

        Uri uri=Uri.parse("https://www.dropbox.com/s/2xziljidxo1jzva/Moana.mp4?dl=1");

        videostreaming.setVideoURI(uri);
        videostreaming.requestFocus();

        final ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage("Loading");
        dialog.setCancelable(false);
        dialog.show();

        videostreaming.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.start();
                dialog.dismiss();
            }
        });


    }
}
