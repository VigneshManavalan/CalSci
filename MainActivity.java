package com.dev.calsci;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    Button fromHomeToCalci;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer= MediaPlayer.create(this,R.raw.buttonclickfinal);
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mediaPlayer.stop();
            }
        });
        setUpUI();
        setUpListeners();

    }

    private void setUpListeners() {
        fromHomeToCalci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                startActivity(new Intent(MainActivity.this,Calculator.class));
                finish();
            }
        });
    }

    private void setUpUI() {
        fromHomeToCalci=(Button)findViewById(R.id.btnHomeToCalci);
    }

}
