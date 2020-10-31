package com.kostya_zinoviev.lifecyclelivedataviewmodel.Training;

import androidx.lifecycle.LiveData;

public class MainLiveData extends LiveData<String> {

    public void setData(String data){
        this.setValue(data);
    }

    public String getData(){
        return this.getValue();
    }

}
