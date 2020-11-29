package com.example.lab_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btn;
    private EditText editText;
    private String urlHead="https://";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);
        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 创建Intent
                Intent intent = new Intent();
                // 为Intent设置Action属性
                intent.setAction(Intent.ACTION_VIEW);
                // 获取网址并解析为uri对象，设置Data属性
                intent.setData(Uri.parse(urlHead+editText.getText().toString()));
                startActivity(intent);
            }
        });
    }
}
