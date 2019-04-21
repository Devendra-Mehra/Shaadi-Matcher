package com.devendra.shaadimatcher.users.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.devendra.shaadimatcher.R;
import com.devendra.shaadimatcher.databinding.ActivityUsersBinding;
import com.devendra.shaadimatcher.users.contract.UserContract;
import com.devendra.shaadimatcher.users.presenter.UserPresenter;
import com.devendra.shaadimatcher.utils.StringHelper;

import java.util.List;

public class UserActivity extends AppCompatActivity implements UserContract.View {

    private ActivityUsersBinding binding;
    private UserPresenter presenter;
    private UserAdapter userAdapter;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_users);
        context = this;
        presenter = new UserPresenter(this, new StringHelper(context));
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

    private void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        binding.recyclerView.setLayoutManager(linearLayoutManager);
        userAdapter = new UserAdapter();
        binding.recyclerView.setAdapter(userAdapter);
    }

    @Override
    public void setUsers(List<DisplayableUser> displayableUsers) {
        userAdapter.setUsers(displayableUsers);
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
