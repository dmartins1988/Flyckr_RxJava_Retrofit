package com.example.dmartins.flickrapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dmartins.flickrapp.R;
import com.example.dmartins.flickrapp.model.Owner;
import com.example.dmartins.flickrapp.model.Photo;
import com.example.dmartins.flickrapp.model.PhotoInfoResponse;
import com.example.dmartins.flickrapp.presenter.FlickrInfoPresenter;
import com.example.dmartins.flickrapp.presenter.FlickrPresenter;
import com.example.dmartins.flickrapp.service.FlickrService;
import com.example.dmartins.flickrapp.view.FlickrInfoView;
import com.squareup.picasso.Picasso;

/**
 * Created by E491 on 25/11/2016.
 */

public class PhotoInfoFragment extends Fragment implements FlickrInfoView {

    private static final String PHOTO = "photo";

    FlickrInfoPresenter mFlickrInfoPresenter;
    FlickrService mFlickrService;

    TextView usernameTv;
    TextView realNameTv;
    ImageView photoImgView;
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

        mFlickrService = new FlickrService();
        mFlickrInfoPresenter = new FlickrInfoPresenter(this, mFlickrService);
        mFlickrInfoPresenter.getPhotoInfo(photo.getId());

        usernameTv = (TextView) v.findViewById(R.id.username_tv);
        realNameTv = (TextView) v.findViewById(R.id.real_name_tv);
        photoImgView = (ImageView) v.findViewById(R.id.display_photo_img_view);

        return v;
    }


    @Override
    public void showPhotoInfo(PhotoInfoResponse photo) {
        Owner ownerInfo = photo.getPhotoInfo().getOwner();
        if (!ownerInfo.getUsername().isEmpty() && !ownerInfo.getRealname().isEmpty()) {
            usernameTv.setText(photo.getPhotoInfo().getOwner().getUsername());
            realNameTv.setText(photo.getPhotoInfo().getOwner().getRealname());
        }
    }

    @Override
    public void displayPhoto() {
        Picasso.with(getActivity())
                .load(photo.getUrl())
                .into(photoImgView);
    }
}
