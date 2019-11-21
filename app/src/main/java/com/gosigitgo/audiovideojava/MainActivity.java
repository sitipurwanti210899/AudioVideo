package com.gosigitgo.audiovideojava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnPlay, btnPouse, btnStop, btnResume, btnVideo, btnVideoStreaming;
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPlay=findViewById(R.id.btn_play);
        btnPouse=findViewById(R.id.btn_pouse);
        btnStop=findViewById(R.id.btn_stop);
        btnResume=findViewById(R.id.btn_resume);
        btnVideo=findViewById(R.id.btn_video);
        btnVideoStreaming=findViewById(R.id.btn_video_streaming);

        btnPlay.setOnClickListener(this);
        btnPouse.setOnClickListener(this);
        btnStop.setOnClickListener(this);
        btnResume.setOnClickListener(this);
        btnVideo.setOnClickListener(this);
        btnVideoStreaming.setOnClickListener(this);

        btnPlay.setEnabled(true);

        btnPouse.setEnabled(false);
        btnStop.setEnabled(false);
        btnResume.setEnabled(false);

    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btn_play){
            mediaPlayer =new MediaPlayer();
            mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

            Uri uri=Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.music);

            try {
                mediaPlayer.setDataSource(MainActivity.this, uri);
                mediaPlayer.prepare();
                mediaPlayer.start();
            }catch (IOException e){
                e.printStackTrace();
            }

            btnPouse.setEnabled(true);
            btnStop.setEnabled(true);

            btnPlay.setEnabled(false);
            btnResume.setEnabled(false);

        }
            else if (id ==R.id.btn_pouse){
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                }
                btnPouse.setEnabled(false);
                btnPlay.setEnabled(false);
                btnStop.setEnabled(false);

                btnResume.setEnabled(true);
        }
            else if (id ==R.id.btn_stop){
                if (mediaPlayer.isPlaying()&& mediaPlayer!=null){
                    mediaPlayer.stop();
                }
            btnPlay.setEnabled(true);

            btnPouse.setEnabled(false);
            btnStop.setEnabled(false);
            btnResume.setEnabled(false);
        }
            else if (id ==R.id.btn_resume){
                if (mediaPlayer !=null){
                    mediaPlayer.start();
                }
                btnPouse.setEnabled(true);
                btnStop.setEnabled(true);

                btnPlay.setEnabled(false);
                btnResume.setEnabled(false);
        }
            else if (id ==R.id.btn_video){
            Intent intent = new Intent(MainActivity.this, VideoActivity.class);
            startActivity(intent);
        }
            else if (id ==R.id.btn_video_streaming){
            Intent intent = new Intent(MainActivity.this, VideoStreamingActivity.class);
            startActivity(intent);
        }


    }
}
