package com.example.g0294.tutorial.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.g0294.tutorial.R;

public class SeekRatingBarActivity extends AppCompatActivity {
    private SeekBar seekBar;
    private RatingBar ratingBar, ratingBar_indicator;
    private TextView tv_seekBar;
    private Button btn_ratingIt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_ratingbar_layout);
        tv_seekBar = (TextView) findViewById(R.id.tv_seekbar);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        tv_seekBar.setText(seekBar.getProgress() + "/" + seekBar.getMax());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tv_seekBar.setText(progress + "/" + seekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
//                tv_seekBar.setText(seekBar.getProgress() + "/" + seekBar.getMax());
            }
        });
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        ratingBar_indicator = (RatingBar) findViewById(R.id.ratingBar_indicator);
        btn_ratingIt = (Button) findViewById(R.id.btn_ratingIt);
        btn_ratingIt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ratingBar_indicator.setRating(ratingBar.getRating());
            }
        });
    }
}
