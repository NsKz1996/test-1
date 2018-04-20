package com.example.dev.test;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Amir Hossein on 4/20/2018.
 */

public class RecyclerViewNotificationAdapter extends RecyclerView.Adapter<RecyclerViewNotificationAdapter.MyViewHolder> {

    private List<Model_Notification> model_notificationList;

    public RecyclerViewNotificationAdapter(List<Model_Notification> model_notificationList) {
        this.model_notificationList = model_notificationList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.model_notification, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Model_Notification model_notification = model_notificationList.get(position);
        holder.photo.setImageResource(model_notification.getPhoto());
        holder.like.setText(model_notification.getLike());
        holder.comment.setText(model_notification.getComment());
        holder.share.setText(model_notification.getLike());
    }

    @Override
    public int getItemCount() {
        return model_notificationList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView photo;
        public TextView like, comment, share;

        public MyViewHolder(View view) {
            super(view);
            photo = (ImageView) view.findViewById(R.id.ModelNotification_CircularImageView_photo);
            like = (TextView) view.findViewById(R.id.modelnotification_textview_numberlike);
            comment = (TextView) view.findViewById(R.id.modelnotification_textview_numbercomment);
            share = (TextView) view.findViewById(R.id.modelnotification_textview_numbershare);

        }
    }
}
