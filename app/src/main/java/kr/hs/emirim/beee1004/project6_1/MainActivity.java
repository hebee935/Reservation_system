package kr.hs.emirim.beee1004.project6_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

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
    }



}
