package com.kostya_zinoviev.lifecyclelivedataviewmodel;

import androidx.lifecycle.LiveData;

public class MyLiveData extends LiveData<String> {


    public void setData(String data){
        this.setValue(data);
    }

    public String getData(){
        return this.getValue();
    }

}
