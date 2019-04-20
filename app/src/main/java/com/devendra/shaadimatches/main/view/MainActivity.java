package com.devendra.shaadimatches.main.view;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.devendra.shaadimatches.R;
import com.devendra.shaadimatches.databinding.ActivityMainBinding;
import com.devendra.shaadimatches.main.contract.MainContract;
import com.devendra.shaadimatches.main.presenter.MainPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private ActivityMainBinding binding;
    private MainPresenter presenter;
    private MainAdapter mainAdapter;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        context = this;
        presenter = new MainPresenter(this);
        initRecyclerView();
        presenter.create();

        mainAdapter.setListener(new MainAdapter.ItemListener() {
            @Override
            public void onConnect() {
                Toast.makeText(context, getString(R.string.connect_clicked),
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onDecline(View viewToAnimate, int position) {
                mainAdapter.removeUser(viewToAnimate, position);
            }
        });

    }

    private void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        binding.recyclerView.setLayoutManager(linearLayoutManager);
        mainAdapter = new MainAdapter();
        binding.recyclerView.setAdapter(mainAdapter);
    }

    @Override
    public void setUsers(List<UserEntity> userEntities) {
        mainAdapter.setUsers(userEntities);
    }

    @Override
    public void toggleUsersVisibility(boolean show) {
        binding.recyclerView.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    public void toggleLoading(boolean isLoading) {
        binding.progressBarLoading.setVisibility(isLoading ? View.VISIBLE : View.GONE);

    }

    @Override
    public void toggleErrorVisibility(boolean show) {
        binding.textViewErrorMsg.setVisibility(show ? View.VISIBLE : View.GONE);

    }

    @Override
    public void setError(String error) {
        binding.textViewErrorMsg.setText(error);
    }


    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume(this);
    }

    @Override
    protected void onPause() {
        presenter.onPause();
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }
}
