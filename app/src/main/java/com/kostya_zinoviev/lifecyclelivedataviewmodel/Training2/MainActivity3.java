package com.kostya_zinoviev.lifecyclelivedataviewmodel.Training2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;

import com.kostya_zinoviev.lifecyclelivedataviewmodel.MainActivity;
import com.kostya_zinoviev.lifecyclelivedataviewmodel.R;

public class MainActivity3 extends AppCompatActivity {

    Observer<String> observer;
    MainViewModel3 mainViewModel;
    ViewModelFactory factory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        //Фабрика
       factory = new ViewModelFactory("Kostya", this);

       mainViewModel = new ViewModelProvider(this,factory).get(MainViewModel3.class);

        observer = new Observer<String>() {
            @Override
            public void onChanged(String s) {
                TextView resultText = findViewById(R.id.result);
                resultText.setText(s);
            }
        };

    }

    @Override
    protected void onResume() {
        super.onResume();
        //При onResume активити стартует таймер
        mainViewModel.startTimer();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mainViewModel.liveData.observe(this,observer);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mainViewModel.liveData.removeObserver(observer);
    }
}
