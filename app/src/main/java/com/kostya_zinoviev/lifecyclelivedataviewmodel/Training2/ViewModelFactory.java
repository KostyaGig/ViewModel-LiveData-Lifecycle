package com.kostya_zinoviev.lifecyclelivedataviewmodel.Training2;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ViewModelFactory implements ViewModelProvider.Factory {

    private String name;
    private Context context;

    public ViewModelFactory(String name,Context context){
        this.name =name;
        this.context = context;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel3.class)){
            return (T) new MainViewModel3(name,context);
        }
        throw new IllegalArgumentException("ViewModelNotFound!");
    }

}
