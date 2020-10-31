package com.kostya_zinoviev.lifecyclelivedataviewmodel.ViewModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import com.kostya_zinoviev.lifecyclelivedataviewmodel.R;

public class TestingViewModelActivity extends AppCompatActivity {

    private MyViewModel myViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_testing_view_model);

       myViewModel = new ViewModelProvider(this).get(MyViewModel.class);
    }

    @Override
    protected void onStart() {
        super.onStart();
        myViewModel.liveData.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String currentData) {
                TextView resultText = findViewById(R.id.result);

                resultText.setText(currentData);
            }
        });

    }



}
