package br.com.robertoveigajunior.alarmeservice.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

import br.com.robertoveigajunior.alarmeservice.R;

/**
 * Created by LamborghiniLeptop on 28/11/2016.
 */

public class AlarmReceiver extends BroadcastReceiver {
    private MediaPlayer mp = null;
    public AlarmReceiver() { }
    @Override
    public void onReceive(Context context, Intent intent) {
        mp = MediaPlayer.create(context, R.raw.hadouken);
        mp.start();
        //Toast.makeText(context, "Alarm....", Toast.LENGTH_LONG).show();
    }
}
