package br.com.robertoveigajunior.alarmeservice.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by LamborghiniLeptop on 28/11/2016.
 */

public class Logger extends Service {

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        Log.i("ServicoMensagem", "****--- Serviço iniciado...");
    }

    @Override
    public void onDestroy() {
        Log.i("ServicoMensagem", "****--- Serviço encerrado...");
    }
}
