package com.ellen.superwatermark;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.ellen.baselibrary.util.BitmapUtils;
import com.ellen.watermark.WatemarkUtils;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bitmap bitmap = BitmapUtils.getColorBitmap(300,300,"#2d2d2d");
        bitmap = WatemarkUtils.createWatermark(bitmap,"sgf",100,Color.RED,0,0);
        imageView = findViewById(R.id.image);
        imageView.setImageBitmap(bitmap);
    }
}
