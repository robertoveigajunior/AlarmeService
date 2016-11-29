package br.com.robertoveigajunior.alarmeservice.atividade5;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import br.com.robertoveigajunior.alarmeservice.R;
import br.com.robertoveigajunior.alarmeservice.service.BoundService;

public class Atividade5 extends AppCompatActivity {

    TextView txtStatus;
    Button btPrint;
    Button btStop;

    BoundService mBoundService;
    boolean mServiceBound = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_atividade5);
        txtStatus = (TextView)findViewById(R.id.txtStatus);
        btPrint = (Button) findViewById(R.id.btPrint);
        btStop = (Button)findViewById(R.id.btStop);
    }

    public void print(View v) {
        if (mServiceBound) {
            txtStatus.setText(mBoundService.getTimestamp());
        }
    }

    public void stopService(View v) {
        if (mServiceBound) {
            unbindService(mServiceConnection);
            mServiceBound = false;
        }
        Intent intent = new Intent(Atividade5.this,
                BoundService.class);
        stopService(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, BoundService.class);
        startService(intent);
        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mServiceBound) {
            unbindService(mServiceConnection);
            mServiceBound = false;
        }
    }

    private ServiceConnection mServiceConnection = new ServiceConnection() {

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mServiceBound = false;
        }

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            BoundService.MyBinder myBinder = (BoundService.MyBinder) service;
            mBoundService = myBinder.getService();
            mServiceBound = true;
        }
    };
}
