package com.devendra.shaadimatches.main.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import io.reactivex.disposables.CompositeDisposable;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.devendra.shaadimatches.R;
import com.devendra.shaadimatches.callback.DataCallback;
import com.devendra.shaadimatches.databinding.ActivityMainBinding;
import com.devendra.shaadimatches.network.implementing.MainServiceImpl;
import com.devendra.shaadimatches.network.response.MainResponse;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        MainServiceImpl mainService = new MainServiceImpl(new CompositeDisposable());


    }
}
