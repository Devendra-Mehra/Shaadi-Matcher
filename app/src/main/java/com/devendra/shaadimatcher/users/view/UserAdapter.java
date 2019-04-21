package com.devendra.shaadimatcher.users.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.devendra.shaadimatcher.R;
import com.devendra.shaadimatcher.databinding.MainViewItemBinding;
import com.devendra.shaadimatcher.utils.CircleTransform;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MainViewHolder> {

    private ItemListener listener;
    private List<DisplayableUser> displayableUsers;

    public void setListener(ItemListener listener) {
        this.listener = listener;
    }

    public UserAdapter() {
        displayableUsers = new ArrayList<>();
    }

    public interface ItemListener {
        void onConnect();

        void onDecline(View viewToAnimate, int position);

    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainViewHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
                R.layout.main_view_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.bind(displayableUsers.get(position));
    }

    @Override

    public int getItemCount() {
        return displayableUsers.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {
        MainViewItemBinding binding;

        private MainViewHolder(MainViewItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            binding.fabConnect.setOnClickListener(v -> listener.onConnect());
            binding.fabDecline.setOnClickListener(v -> listener.onDecline(binding.fabDecline, getAdapterPosition()));
        }

        private void bind(DisplayableUser current) {
            binding.tvCreatedDate.setText(current.getRegistrationPeriod());
            binding.tvNameAge.setText(current.getFullNameAge());
            binding.tvLocation.setText(current.getLocation());
            binding.tvEmail.setText(current.getEmail());
            Picasso.get()
                    .load(current.getPicture())
                    .transform(new CircleTransform())
                    .into(binding.ivProfileImage);
        }

    }

    public void setUsers(List<DisplayableUser> displayableUsers) {
        this.displayableUsers.clear();
        this.displayableUsers = displayableUsers;
        notifyDataSetChanged();
    }

    public void removeUser(View viewToAnimate, int position) {
        Animation animation = AnimationUtils.loadAnimation(viewToAnimate.getContext()
                , android.R.anim.slide_out_right);
        viewToAnimate.startAnimation(animation);
        displayableUsers.remove(position);
        notifyItemRemoved(position);
    }


}