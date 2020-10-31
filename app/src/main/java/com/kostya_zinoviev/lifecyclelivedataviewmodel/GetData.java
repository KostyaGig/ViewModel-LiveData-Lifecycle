package com.kostya_zinoviev.lifecyclelivedataviewmodel;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;

import static androidx.lifecycle.Lifecycle.State.CREATED;

public class GetData implements LifecycleObserver {



    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void getData(){
        Log.i("data2","getData");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void setData(){
        Log.i("data2","sendData");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    public void any(){
        Log.i("data2","any");
    }


}
