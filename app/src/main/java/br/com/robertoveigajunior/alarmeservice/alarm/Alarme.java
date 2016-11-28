package br.com.robertoveigajunior.alarmeservice.alarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.robertoveigajunior.alarmeservice.R;
import br.com.robertoveigajunior.alarmeservice.receiver.AlarmReceiver;

public class Alarme extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarme);
    }

    public void setTime(View v) {

        EditText text = (EditText) findViewById(R.id.txtSegundos);
        int i = Integer.parseInt(text.getText().toString());
        Intent intent = new Intent(this, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                this.getApplicationContext(), 0, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP,
                System.currentTimeMillis() + (i * 1000),
                pendingIntent);
        Toast.makeText(this, "Alarm set in " +i+ " seconds",Toast.LENGTH_LONG).show();

    }
}
