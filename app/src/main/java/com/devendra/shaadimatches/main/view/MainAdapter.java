package com.devendra.shaadimatches.main.view;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.devendra.shaadimatches.R;
import com.devendra.shaadimatches.databinding.MainViewItemBinding;
import com.devendra.shaadimatches.singleinstance.PicassoInstance;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

    private ItemListener listener;
    private List<UserEntity> userEntities;

    public void setListener(ItemListener listener) {
        this.listener = listener;
    }

    public MainAdapter() {
        userEntities = new ArrayList<>();
    }

    public interface ItemListener {
        void onRowClick();
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.main_view_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.bind(userEntities.get(position));
    }

    @Override

    public int getItemCount() {
        return userEntities.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {
        MainViewItemBinding binding;

        private MainViewHolder(MainViewItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }

        private void bind(UserEntity current) {

            binding.tvGender.setText(current.getGender());
            binding.tvAge.setText(current.getAge());
            binding.tvEmail.setText(current.getEmail());
            binding.tvEmail.setText(current.getEmail());
            binding.tvLocation.setText(current.getLocation());
            binding.tvRegistered.setText(current.getRegistered());

         /*   PicassoInstance.getPicassoInstance()
                    .get().load(current.getPicture()).into(binding.ivProfile);*/
        }
    }

    public void setUsers(List<UserEntity> userEntities) {
        this.userEntities.clear();
        this.userEntities = userEntities;
        notifyDataSetChanged();
    }
}