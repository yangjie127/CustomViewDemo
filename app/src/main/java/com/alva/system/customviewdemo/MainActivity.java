package com.alva.system.customviewdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.alva.system.customviewdemo.music.PhonographView;

import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final PhonographView gramophoneView = (PhonographView)findViewById(R.id.gramophone_view);
        final Button button = (Button)findViewById(R.id.btn_play_pause);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gramophoneView.getPlaying()){
                    button.setText("点击播放");
                }else{
                    button.setText("点击暂停");
                }
                gramophoneView.setPlaying(!gramophoneView.getPlaying());
            }
        });


        button.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                startActivity(new Intent(MainActivity.this,Md5Activity.class));
                return true;
            }
        });

        initMD5();

    }
    private String md5 = "";

    private void initMD5() {
        try {
            this.md5 = MD5EncryptUtil.encreptPass("862783032463711" + "FKX04728L9SYCCJQYODU8E");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        Log.e("yangjie","" + md5);
        Toast.makeText(this, "手动查找", 0).show();
    }

}

