package com.example.g0294.tutorial.ui;


import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ImageView;

import com.example.g0294.tutorial.R;

public class ImageResizeActivity extends Activity {
    protected ImageView img1, img2, img3, img4, img5, img6;
    protected int pWidth;

    public static int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            final int halfHeight = height / 2;
            final int halfWidth = width / 2;

            // Calculate the largest inSampleSize value that is a power of 2 and keeps both
            // height and width larger than the requested height and width.
            while ((halfHeight / inSampleSize) > reqHeight && (halfWidth / inSampleSize) > reqWidth) {
                inSampleSize *= 2;
            }
        }

        return inSampleSize;
    }

    public static Bitmap decodeSampledBitmapFromResource(Resources res, int resId, int reqWidth,
                                                         int reqHeight) {

        // First decode with inJustDecodeBounds=true to check dimensions
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);

        // Calculate inSampleSize
        options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_resize_layout);
        img1 = (ImageView) findViewById(R.id.img1);
        img2 = (ImageView) findViewById(R.id.img2);
        img3 = (ImageView) findViewById(R.id.img3);
        img4 = (ImageView) findViewById(R.id.img4);
        img5 = (ImageView) findViewById(R.id.img5);
        img6 = (ImageView) findViewById(R.id.img6);

        // img1.setImageResource(R.drawable.taiwan);
        // img2.setImageResource(R.drawable.america);
        // img3.setImageResource(R.drawable.china);
        // img4.setImageResource(R.drawable.japan);
        // img5.setImageResource(R.drawable.korea);
        // img6.setImageResource(R.drawable.canada);

        Bitmap bitmap;
        // bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.taiwan);
        // img1.setImageBitmap(bitmap);
        // bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.america);
        // img2.setImageBitmap(bitmap);
        // bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.china);
        // img3.setImageBitmap(bitmap);
        // bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.japan);
        // img4.setImageBitmap(bitmap);
        // bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.korea);
        // img5.setImageBitmap(bitmap);
        // bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.canada);
        // img6.setImageBitmap(bitmap);

        img1.post(new Runnable() {

            @Override
            public void run() {
                Log.i("TEST", "Layout width : " + img1.getWidth());
                pWidth = img1.getWidth();
            }
        });
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int dens = dm.densityDpi;

        bitmap = decodeSampledBitmapFromResource(getResources(), R.drawable.taiwan, pWidth, 120 * dens / 160);
        img1.setImageBitmap(bitmap);
        bitmap = decodeSampledBitmapFromResource(getResources(), R.drawable.america, pWidth, 120 * dens / 160);
        img2.setImageBitmap(bitmap);
        bitmap = decodeSampledBitmapFromResource(getResources(), R.drawable.china, pWidth, 120 * dens / 160);
        img3.setImageBitmap(bitmap);
        bitmap = decodeSampledBitmapFromResource(getResources(), R.drawable.japan, pWidth, 120 * dens / 160);
        img4.setImageBitmap(bitmap);
        bitmap = decodeSampledBitmapFromResource(getResources(), R.drawable.korea, pWidth, 120 * dens / 160);
        img5.setImageBitmap(bitmap);
        bitmap = decodeSampledBitmapFromResource(getResources(), R.drawable.canada, pWidth, 120 * dens / 160);
        img6.setImageBitmap(bitmap);

    }
}
