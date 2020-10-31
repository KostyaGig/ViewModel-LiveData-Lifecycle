package com.kostya_zinoviev.lifecyclelivedataviewmodel.Training2;

import android.app.Application;
import android.content.Context;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.contentcapture.ContentCaptureContext;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.logging.Logger;

public class MainViewModel3 extends ViewModel {

    public MutableLiveData<String> liveData = new MutableLiveData<>();
    public String name;
    public Context context;

    public MainViewModel3(String name,Context context){
        this.name = name;
        this.context = context.getApplicationContext();
    }

    public void startTimer(){
        new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                String second = String.valueOf(millisUntilFinished/1000);
                liveData.setValue(second);
            }

            @Override
            public void onFinish() {
                Toast.makeText(context, "Your name is " + name, Toast.LENGTH_SHORT).show();
            }
        }.start();

    }

}
