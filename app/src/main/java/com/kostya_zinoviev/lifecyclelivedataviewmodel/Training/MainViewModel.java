package com.kostya_zinoviev.lifecyclelivedataviewmodel.Training;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    MainLiveData mainLiveData = new MainLiveData();
    int counter = 0;

    public void plus(){
        counter++;
        String counterString = String.valueOf(counter);
        mainLiveData.setData(counterString);
    }

    public void minus(){
        counter--;
        String stringCounter = String.valueOf(counter);
        mainLiveData.setData(stringCounter);
    }

}
