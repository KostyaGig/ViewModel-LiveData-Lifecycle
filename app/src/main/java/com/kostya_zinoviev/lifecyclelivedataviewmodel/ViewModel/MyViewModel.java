package com.kostya_zinoviev.lifecyclelivedataviewmodel.ViewModel;

import android.app.Application;
import android.content.Context;
import android.os.CountDownTimer;
import android.widget.TextView;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.kostya_zinoviev.lifecyclelivedataviewmodel.R;

public class MyViewModel extends ViewModel {

    private Context context;

    public MyCustomLiveData liveData = new MyCustomLiveData();

    public MyViewModel(){
        startTimer();
    }

    private void startTimer(){

        CountDownTimer timer = new CountDownTimer(20000,1000) {
            @Override
            public void onTick(long currentTime) {
                String currentSecond = String.valueOf(currentTime/1000);
                liveData.setData(currentSecond);
            }

            @Override
            public void onFinish() {

            }
        }.start();

    }
}
