package com.example.dmartins.flickrapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.dmartins.flickrapp.R;
import com.example.dmartins.flickrapp.model.Photo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by E491 on 25/11/2016.
 */

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {

    private ArrayList<Photo> mListPhoto;
    private Context mContext;

    public GalleryAdapter(ArrayList<Photo> mListPhoto, Context mContext) {
        this.mListPhoto = mListPhoto;
        this.mContext = mContext;
    }

    @Override
    public GalleryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.photo_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GalleryAdapter.ViewHolder holder, int position) {
        Photo photo = mListPhoto.get(position);
        Picasso
                .with(mContext)
                .load(photo.getUrl())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mListPhoto.size() == 0 ? 0 : mListPhoto.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.photo_item_img_view);
        }
    }

    public void allPhotos(ArrayList<Photo> photos) {
        mListPhoto.addAll(photos);
    }

    public void clear() {
        mListPhoto.clear();
    }
}
