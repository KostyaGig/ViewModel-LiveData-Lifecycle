package com.kostya_zinoviev.lifecyclelivedataviewmodel;


import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private MyLiveData myLiveData;
    Observer observer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Lifecycle
        //Подписываем на наш отслеживание Lifecycle getData
        GetData getData = new GetData();
        getLifecycle().addObserver(getData);



        //LiveData
        myLiveData = new MyLiveData();

        findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = findViewById(R.id.data);
                String data = editText.getText().toString();
                myLiveData.setData(data);
            }
        });

        observer = new Observer() {
            @Override
            public void onChanged(Object o) {
                TextView textView = findViewById(R.id.resultData);
                textView.setText(myLiveData.getData());
            }
        };

    }

    @Override
    protected void onStart() {
        super.onStart();

        //1 парметр - наблюдатель жизненного цикла это наше активити,2 - обсервер,при каждом изменении
        //Данных в LiveData,БУДЕТ СРАБАТЫВАТЬ МЕТОД В ОБСЕРВЕРЕ onChanged
        //в onstart отписываемся
        myLiveData.observe(this,observer);
    }

    @Override
    protected void onStop() {
        super.onStop();
        //Отписываемся в onStop
        if (observer != null){
            myLiveData.removeObserver(observer);
        }
    }
}
