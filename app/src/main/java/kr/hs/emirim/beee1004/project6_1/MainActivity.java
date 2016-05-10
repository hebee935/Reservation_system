package kr.hs.emirim.beee1004.project6_1;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import java.sql.Time;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Chronometer chrono;
    Button butStart,butDone;
    RadioButton radioDate, radioTime;
    CalendarView calView;
    TimePicker timePick;
    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chrono = (Chronometer)findViewById(R.id.chronoId);
        butStart = (Button)findViewById(R.id.startbuttonId);
        butDone = (Button)findViewById(R.id.endbuttonId);
        radioDate = (RadioButton)findViewById(R.id.radioIdDate);
        radioTime = (RadioButton)findViewById(R.id.radioIdTime);
        calView = (CalendarView)findViewById(R.id.calendarviewId);
        timePick = (TimePicker)findViewById(R.id.timePickerId);
        textResult = (TextView)findViewById(R.id.textViewId);

        timePick.setVisibility(View.INVISIBLE);
        calView.setVisibility(View.INVISIBLE);

        radioDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calView.setVisibility(View.VISIBLE);
                timePick.setVisibility(View.INVISIBLE);
            }
        });
        radioTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timePick.setVisibility(View.VISIBLE);
                calView.setVisibility(View.INVISIBLE);
            }
        });

        butStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.start();
                //chrono.setTextColor(Color.GRAY);
            }
        });
        butDone.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                chrono.stop();
                chrono.setTextColor(Color.GRAY);
                Calendar cal = Calendar.getInstance();
                cal.setTimeInMillis(calView.getDate());
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH)+1;
                int date = cal.get(Calendar.DATE);
                int hour = timePick.getHour();
                int minute = timePick.getMinute();
                String dateAndTime = year + "년 "+ month + "월 " + date + "일 ";

                if(hour>=12) {
                    dateAndTime += "오후 " + (hour - 12) + "시 ";
                }else{
                    dateAndTime += "오전 " + hour + "시 ";
                }
                if(minute>0){
                    dateAndTime += minute + "분";
                }

                textResult.setText(dateAndTime);
            }
        });
    }



}
