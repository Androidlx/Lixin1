package com.example.lixin.zhoukao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MyCustomView.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyCustomView customView = (MyCustomView) findViewById(R.id.customview);
        customView.setOnClickListener(this);
    }


    @Override
    public void leftonClickListener(View left_btn) {
        Toast.makeText(this, "点击了 返回", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void RightClickListener(View right_btn) {
        Toast.makeText(this, "点击了 更多", Toast.LENGTH_SHORT).show();
    }
}
