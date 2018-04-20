package com.example.dev.test;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Amir Hossein on 4/20/2018.
 */

public class RecyclerViewHomeAdapter extends RecyclerView.Adapter<RecyclerViewHomeAdapter.MyViewHolder> {

    private List<Model_Post_Home> listModelPostHome;

    public RecyclerViewHomeAdapter(List<Model_Post_Home> listModelPostHome) {
        this.listModelPostHome = listModelPostHome;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.model_post_home, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Model_Post_Home model_post_home = listModelPostHome.get(position);
        holder.photo.setImageResource(model_post_home.getPhoto());
        holder.name.setText(model_post_home.getName());
        holder.like.setText(model_post_home.getLike());
        holder.time.setText(model_post_home.getTime());
        holder.comment.setText(model_post_home.getComment());

    }

    @Override
    public int getItemCount() {
        return listModelPostHome.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView photo;
        public EditText comment;
        public TextView name, time, commentNumber, like;

        public MyViewHolder(View view) {
            super(view);
            photo = (ImageView) view.findViewById(R.id.ModelHomeFragment_imageView_photouser);
            name = (TextView) view.findViewById(R.id.ModelHomeFragment_textView_username);
            time = (TextView) view.findViewById(R.id.ModelHomeFragment_textView_time);
            commentNumber = (TextView) view.findViewById(R.id.ModelHomeFragment_TextView_commentNumber);
            comment = (EditText) view.findViewById(R.id.ModelHomeFragment_EditText_Comment);
//            comment.setRawInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);
            like = (TextView) view.findViewById(R.id.ModelHomeFragment_textView_likeNumber);
//            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
//            inputMethodManager.hideSoftInputFromWindow(comment.getWindowToken(), 0);

        }
    }
}