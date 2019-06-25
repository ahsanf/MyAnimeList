package com.example.ahsan.myanimelist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.jar.Attributes;

public class DetailActivity extends AppCompatActivity {
    private TextView tvName, tvRemarks, tvDetail;
    private ImageView imgPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        tvName = (TextView) findViewById(R.id.iii);
        tvDetail = (TextView) findViewById(R.id.aaa);
        tvRemarks = (TextView) findViewById(R.id.rrr);
        imgPhoto = (ImageView) findViewById(R.id.img);
        initData();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    void initData() {
        Intent intent = getIntent();
        tvName.setText(intent.getStringExtra("Name"));
        tvDetail.setText(intent.getStringExtra("Detail"));
        tvRemarks.setText(intent.getStringExtra("Remarks"));
        Glide.with(this)
                .load(intent.getStringExtra("Photo"))
                .crossFade()
                .into(imgPhoto);


    }
}


