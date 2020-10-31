package com.kostya_zinoviev.lifecyclelivedataviewmodel.ViewModel;

import androidx.lifecycle.LiveData;

public class MyCustomLiveData extends LiveData<String> {

    public void setData(String data){
        this.setValue(data);
    }

    public String getData(){
        return this.getValue();
    }
}
