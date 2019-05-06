package com.devendra.shaadimatcher.users.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.devendra.shaadimatcher.R;
import com.devendra.shaadimatcher.users.contract.UserContract;
import com.devendra.shaadimatcher.users.presenter.UserPresenter;

import java.util.List;

import javax.inject.Inject;

import dagger.android.AndroidInjection;

public class UserActivity extends AppCompatActivity implements UserContract.View {


    @Inject
    public UserPresenter presenter;

    public UserAdapter userAdapter;

    private Context context;
    private RecyclerView recyclerView;
    private ProgressBar progressBarLoading;
    private TextView textViewErrorMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        context = this;
        initViewElements();
        initRecyclerView();
        presenter.create();

        userAdapter.setListener(new UserAdapter.ItemListener() {
            @Override
            public void onConnect() {
                Toast.makeText(context, getString(R.string.connect_clicked),
                        Toast.LENGTH_LONG).show();
            }

            @Override
            public void onDecline(View viewToAnimate, int position) {
                userAdapter.removeUser(viewToAnimate, position);
            }
        });

    }

    private void initViewElements() {

        recyclerView = findViewById(R.id.recycler_view);
        progressBarLoading = findViewById(R.id.progress_bar_loading);
        textViewErrorMsg = findViewById(R.id.text_view_error_msg);
    }

    private void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(linearLayoutManager);
        userAdapter = new UserAdapter();
        recyclerView.setAdapter(userAdapter);
    }

    @Override
    public void setUsers(List<DisplayableUser> displayableUsers) {
        userAdapter.setUsers(displayableUsers);
    }

    @Override
    public void toggleUsersVisibility(boolean show) {
        recyclerView.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    @Override
    public void toggleLoading(boolean isLoading) {
        progressBarLoading.setVisibility(isLoading ? View.VISIBLE : View.GONE);

    }

    @Override
    public void toggleErrorVisibility(boolean show) {
        textViewErrorMsg.setVisibility(show ? View.VISIBLE : View.GONE);

    }

    @Override
    public void setError(String error) {
        textViewErrorMsg.setText(error);
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
