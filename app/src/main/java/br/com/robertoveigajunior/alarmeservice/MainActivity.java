package br.com.robertoveigajunior.alarmeservice;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v4.content.SharedPreferencesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.robertoveigajunior.alarmeservice.alarm.Alarme;
import br.com.robertoveigajunior.alarmeservice.login.Login;
import br.com.robertoveigajunior.alarmeservice.receiver.AlarmReceiver;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goAlarm(View v) {
        Intent i = new Intent(this, Alarme.class);
        startActivity(i);
    }

    public void goLogin(View v) {
        Intent i = new Intent(this, Login.class);
        startActivity(i);
    }
}
