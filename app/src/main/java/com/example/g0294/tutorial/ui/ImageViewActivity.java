package com.example.g0294.tutorial.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.g0294.tutorial.R;

public class ImageViewActivity extends Activity {
    private Button btn_center, btn_center_crop, btn_center_inside, btn_fit_center, btn_fit_start, btn_fit_xy;
    private ImageView imageView1, imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imageview_layout);
        imageView1 = (ImageView) findViewById(R.id.image1);
        imageView2 = (ImageView) findViewById(R.id.image2);
        ImageScaleListener listener = new ImageScaleListener();
        btn_center = (Button) findViewById(R.id.btn_center);
        btn_center.setOnClickListener(listener);
        btn_center_crop = (Button) findViewById(R.id.btn_center_crop);
        btn_center_crop.setOnClickListener(listener);
        btn_center_inside = (Button) findViewById(R.id.btn_center_inside);
        btn_center_inside.setOnClickListener(listener);
        btn_fit_center = (Button) findViewById(R.id.btn_fit_center);
        btn_fit_center.setOnClickListener(listener);
        btn_fit_start = (Button) findViewById(R.id.btn_fit_start);
        btn_fit_start.setOnClickListener(listener);
        btn_fit_xy = (Button) findViewById(R.id.btn_fit_xy);
        btn_fit_xy.setOnClickListener(listener);

    }

    class ImageScaleListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_center:
                    imageView1.setScaleType(ImageView.ScaleType.CENTER);
                    imageView2.setScaleType(ImageView.ScaleType.CENTER);
                    break;
                case R.id.btn_center_crop:
                    imageView1.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    imageView2.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    break;
                case R.id.btn_center_inside:
                    imageView1.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    imageView2.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    break;
                case R.id.btn_fit_center:
                    imageView1.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    imageView2.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    break;
                case R.id.btn_fit_start:
                    imageView1.setScaleType(ImageView.ScaleType.FIT_START);
                    imageView2.setScaleType(ImageView.ScaleType.FIT_START);
                    break;
                case R.id.btn_fit_xy:
                    imageView1.setScaleType(ImageView.ScaleType.FIT_XY);
                    imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
                    break;
            }
        }
    }
}
