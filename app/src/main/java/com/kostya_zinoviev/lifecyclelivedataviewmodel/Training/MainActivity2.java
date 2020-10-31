package com.kostya_zinoviev.lifecyclelivedataviewmodel.Training;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.kostya_zinoviev.lifecyclelivedataviewmodel.R;

public class MainActivity2 extends  AppCompatActivity {
    MainViewModel mainViewModel;
    Observer<String> observer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        final Button plus = findViewById(R.id.plus);
        final Button minus = findViewById(R.id.minus);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainViewModel.counter == 5){
                    Toast.makeText(MainActivity2.this, "Counter = 5" , Toast.LENGTH_SHORT).show();
                }

                mainViewModel.plus();
            }
        });

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainViewModel.counter==0){
                    mainViewModel.counter =0;
                }
                mainViewModel.minus();
            }
        });

       observer = new Observer<String>() {
           @Override
           public void onChanged(String s) {
               final TextView result = findViewById(R.id.result);
               result.setText(s);
           }
       };

    }

    @Override
    protected void onStart() {
        super.onStart();

        //Подписываем наш livedata на обсервера
        mainViewModel.mainLiveData.observe(this, observer);

    }

    @Override
    protected void onStop() {
        super.onStop();
        mainViewModel.mainLiveData.removeObserver(observer);
    }

}
