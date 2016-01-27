package com.example.g0294.tutorial.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.g0294.tutorial.R;

import java.util.Calendar;

public class DateTimePickerActivity extends AppCompatActivity {
    private DatePicker datePicker;
    private TimePicker timePicker;
    private TextView tv_date, tv_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.datetime_picker_layout);
        tv_date = (TextView) findViewById(R.id.tv_date);
        tv_time = (TextView) findViewById(R.id.tv_time);
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        timePicker = (TimePicker) findViewById(R.id.timePicker);

        //設定初始時間
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH); //month初始值為0
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        tv_date.setText("初始日期：\n" + year + "-" + (month + 1) + "-" + day);
        tv_time.setText("初始日期：\n" + calendar.get(Calendar.HOUR) + ":" + calendar.get(Calendar.MINUTE) + ":" + calendar.get(Calendar.SECOND));

        datePicker.init(year, month, day, new DatePicker.OnDateChangedListener() {

            @Override
            public void onDateChanged(DatePicker view, int year,
                                      int monthOfYear, int dayOfMonth) {
                tv_date.setText("選擇的日期：\n" + year + "-" + (monthOfYear + 1) + "-" + dayOfMonth);

            }
        });

        timePicker.setIs24HourView(false);
        timePicker
                .setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
                    @Override
                    public void onTimeChanged(TimePicker view, int hourOfDay,
                                              int minute) {
                        String minutes;
                        if (minute < 10)
                            minutes = "0" + minute;
                        else
                            minutes = String.valueOf(minute);
                        if (view.is24HourView()) {
                            tv_time.setText("選擇的時間：\n" + hourOfDay + ":" + minutes);
                        } else {
                            String AMOrPM;
                            if (hourOfDay > 12) {
                                hourOfDay -= 12;
                                AMOrPM = "PM";
                            } else if (hourOfDay == 0) {
                                hourOfDay += 12;
                                AMOrPM = "AM";
                            } else if (hourOfDay == 12)
                                AMOrPM = "PM";
                            else
                                AMOrPM = "AM";

                            tv_time.setText("選擇的時間：\n" + AMOrPM + " " + hourOfDay + ":" + minutes);
                        }

                    }
                });

    }

}
