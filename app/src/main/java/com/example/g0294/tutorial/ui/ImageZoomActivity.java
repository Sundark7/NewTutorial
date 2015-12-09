package com.example.g0294.tutorial.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.g0294.tutorial.R;

public class ImageZoomActivity extends Activity implements SeekBar.OnSeekBarChangeListener{
    private int minWidth = 80;
    private ImageView imageView;
    private TextView textView1, textView2;
    private Matrix matrix =new Matrix();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_zoom_rotate);
        imageView = (ImageView)findViewById(R.id.imageView);
        SeekBar seekBar1 = (SeekBar)findViewById(R.id.seekBar1);
        SeekBar seekBar2 = (SeekBar)findViewById(R.id.seekBar2);
        textView1=(TextView)findViewById(R.id.textView1);
        textView2=(TextView)findViewById(R.id.textView2);
        seekBar1.setOnSeekBarChangeListener(this);
        seekBar2.setOnSeekBarChangeListener(this);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        seekBar1.setMax(dm.widthPixels-minWidth);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (seekBar.getId()==R.id.seekBar1){
            int newWidth = progress + minWidth;
            //int newHeight = newWidth;
            imageView.setLayoutParams(new LinearLayout.LayoutParams(newWidth,newWidth));
            textView1.setText("圖片大小: "+newWidth);
        }
        else if (seekBar.getId()==R.id.seekBar2){
            Bitmap bitmap = ((BitmapDrawable)(getResources().getDrawable(R.drawable.cat))).getBitmap();
            matrix.setRotate(progress);//設置旋轉角度
            bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(),matrix,true);
            imageView.setImageBitmap(bitmap);
            textView2.setText(progress+"度");
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
