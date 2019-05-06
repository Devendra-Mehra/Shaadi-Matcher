package com.devendra.shaadimatcher.users.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.devendra.shaadimatcher.R;
import com.devendra.shaadimatcher.utils.CircleTransform;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import javax.inject.Inject;

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
        return new MainViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.main_view_item, parent, false));
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

        private FloatingActionButton fabConnect, fabDecline;
        private ImageView ivProfileImage;
        private TextView tvCreatedDate, tvNameAge, tvLocation, tvEmail;

        private MainViewHolder(View view) {
            super(view);

            fabConnect = view.findViewById(R.id.fab_connect);
            fabDecline = view.findViewById(R.id.fab_decline);
            ivProfileImage = view.findViewById(R.id.iv_profile_image);

            tvCreatedDate = view.findViewById(R.id.tv_created_date);
            tvNameAge = view.findViewById(R.id.tv_name_age);
            tvLocation = view.findViewById(R.id.tv_location);
            tvEmail = view.findViewById(R.id.tv_email);

            fabConnect.setOnClickListener(v -> listener.onConnect());
            fabDecline.setOnClickListener(v -> listener.onDecline(fabDecline,
                    getAdapterPosition()));
        }

        private void bind(DisplayableUser current) {
            tvCreatedDate.setText(current.getRegistrationPeriod());
            tvNameAge.setText(current.getFullNameAge());
            tvLocation.setText(current.getLocation());
            tvEmail.setText(current.getEmail());
            Picasso.get()
                    .load(current.getPicture())
                    .transform(new CircleTransform())
                    .into(ivProfileImage);
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