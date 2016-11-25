package com.example.dmartins.flickrapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dmartins.flickrapp.R;
import com.example.dmartins.flickrapp.model.Photo;
import com.example.dmartins.flickrapp.model.PhotoInfoResponse;
import com.example.dmartins.flickrapp.view.FlickrInfoView;

/**
 * Created by E491 on 25/11/2016.
 */

public class PhotoInfoFragment extends Fragment implements FlickrInfoView {

    private static final String PHOTO = "photo";

    TextView usernameTv;
    TextView realNameTv;
    Photo photo;

    public PhotoInfoFragment() {    }

    public static PhotoInfoFragment newInstance(Photo photo) {
        PhotoInfoFragment fragment = new PhotoInfoFragment();
        Bundle args = new Bundle();
        args.putSerializable(PHOTO, photo);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            photo = (Photo) getArguments().getSerializable(PHOTO);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_photo_info, container, false);

        usernameTv = (TextView) v.findViewById(R.id.username_tv);
        realNameTv = (TextView) v.findViewById(R.id.real_name_tv);

        return v;
    }


    @Override
    public void showPhotoInfo(PhotoInfoResponse photo) {
        usernameTv.setText(photo.getPhotoInfo().getOwner().getUsername());
        realNameTv.setText(photo.getPhotoInfo().getOwner().getRealname());
    }
}
