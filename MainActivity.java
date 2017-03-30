package com.example.admin.asthmaalert;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.security.spec.ECField;

public class MainActivity extends AppCompatActivity {


    TextView welcomeText;
    TextView statusText;

    private MediaPlayer mediaPlayer;
    private MediaRecorder mediaRecorder;
    private String OUTPUT_FILE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        welcomeText = (TextView) findViewById(R.id.welcome);
        statusText = (TextView) findViewById(R.id.status);
        OUTPUT_FILE = Environment.getExternalStorageDirectory()+"/audiorecroder.3gpp";


    }

    public void buttonTapped(View view) {
        switch (view.getId()) {
            case R.id.start:
                try {
                    statusText.setText("test");
                    beginRecording();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.stop:
                try {
                    statusText.setText("x");
                    stopRecording();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case R.id.play:
                try {
                    playRecording();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
    }

    private void playRecording() throws Exception {
        checkMediaPlayer();
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setDataSource(OUTPUT_FILE);
        mediaPlayer.prepare();
        mediaPlayer.start();

    }

    private void checkMediaPlayer() {
        if (mediaPlayer != null) {
            try {
                mediaPlayer.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void stopRecording() {
        if (mediaRecorder != null) {
            mediaRecorder.stop();
        }
        statusText.setText("xx");

    }

    private void beginRecording() throws Exception {
        statusText.setText("Recording...");
        checkMediaRecorder();
        File outFile = new File(OUTPUT_FILE);

        if (outFile.exists()) {
            outFile.delete();
        }
        statusText.setText("check output...");

        mediaRecorder = new MediaRecorder();
        statusText.setText("1");
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        statusText.setText("2");
        mediaRecorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        statusText.setText("3");
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        statusText.setText("4");
        mediaRecorder.setOutputFile(OUTPUT_FILE);
        statusText.setText("5");
        mediaRecorder.prepare();
        statusText.setText("6");
        mediaRecorder.start();
        statusText.setText("Recording part 2...");

    }

    private void checkMediaRecorder() {
        if (mediaRecorder != null) {
            mediaRecorder.release();
        }
    }


}
