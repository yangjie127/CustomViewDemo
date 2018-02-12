package com.alva.system.customviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.NoSuchAlgorithmException;

public class Md5Activity extends AppCompatActivity {
    private EditText editText;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_md5);
        initView();
    }

    private void initView() {
        editText = findViewById(R.id.edit_phone);
        textView = findViewById(R.id.text);
    }

    public void getCodeMd5(View view){
       String text =  editText.getText().toString().trim();
       if(TextUtils.isEmpty(text)){
           Toast.makeText(Md5Activity.this,"验证码不能为空",Toast.LENGTH_SHORT).show();
           return;
       }
        try {
            textView.setText(MD5EncryptUtil.encreptPass(text + "FKX04728L9SYCCJQYODU8E"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
