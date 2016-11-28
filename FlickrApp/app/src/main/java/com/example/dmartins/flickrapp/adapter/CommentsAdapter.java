package com.example.dmartins.flickrapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dmartins.flickrapp.R;
import com.example.dmartins.flickrapp.model.Comment;

import java.util.ArrayList;

/**
 * Created by E491 on 28/11/2016.
 */

public class CommentsAdapter extends RecyclerView.Adapter<CommentsAdapter.ViewHolder> {

    private Context mContext;
    private ArrayList<Comment> mListOfComments;

    public CommentsAdapter(Context mContext, ArrayList<Comment> mListOfComments) {
        this.mContext = mContext;
        this.mListOfComments = mListOfComments;
    }

    @Override
    public CommentsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CommentsAdapter.ViewHolder holder, int position) {
        Comment comments = mListOfComments.get(position);
        holder.usernameTv.setText(comments.getAuthorName());
        holder.commentTv.setText(comments.getContent());
    }

    @Override
    public int getItemCount() {
        return mListOfComments.size() == 0 ? 0 : mListOfComments.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView usernameTv;
        TextView commentTv;
        public ViewHolder(View itemView) {
            super(itemView);

            usernameTv = (TextView) itemView.findViewById(R.id.username_tv);
            commentTv = (TextView) itemView.findViewById(R.id.comment_tv);

        }
    }

    public void clear() {
        mListOfComments.clear();
    }

    public void addAll(ArrayList<Comment> comments) {
        mListOfComments.addAll(comments);
    }
}
