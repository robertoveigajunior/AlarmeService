package br.com.robertoveigajunior.alarmeservice.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import br.com.robertoveigajunior.alarmeservice.R;
import br.com.robertoveigajunior.alarmeservice.service.Logger;

public class Login extends AppCompatActivity {

    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        i = new Intent(this, Logger.class);
    }

    public void start(View v) {
        startService(i);
    }

    public void stop(View v) {
        stopService(i);
    }

}
