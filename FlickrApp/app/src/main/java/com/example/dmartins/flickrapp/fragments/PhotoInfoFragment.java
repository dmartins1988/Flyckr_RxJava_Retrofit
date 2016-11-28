package com.example.dmartins.flickrapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dmartins.flickrapp.R;
import com.example.dmartins.flickrapp.adapter.CommentsAdapter;
import com.example.dmartins.flickrapp.model.Comment;
import com.example.dmartins.flickrapp.model.Dates;
import com.example.dmartins.flickrapp.model.Owner;
import com.example.dmartins.flickrapp.model.Photo;
import com.example.dmartins.flickrapp.model.PhotoInfoResponse;
import com.example.dmartins.flickrapp.model.Title;
import com.example.dmartins.flickrapp.presenter.FlickrInfoPresenter;
import com.example.dmartins.flickrapp.service.FlickrService;
import com.example.dmartins.flickrapp.utils.DateUtil;
import com.example.dmartins.flickrapp.view.FlickrInfoView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by David Martins on 25/11/2016.
 */

public class PhotoInfoFragment extends Fragment implements FlickrInfoView {

    private static final String PHOTO = "photo";

    FlickrInfoPresenter mFlickrInfoPresenter;
    FlickrService mFlickrService;

    TextView usernameTv, realNameTv, noCommentsTv;
    ImageView photoImgView;
    RecyclerView commentsRecyclerView;
    CommentsAdapter adapter;
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
        noCommentsTv = (TextView) v.findViewById(R.id.no_comments_tv);
        photoImgView = (ImageView) v.findViewById(R.id.display_photo_img_view);
        commentsRecyclerView = (RecyclerView) v.findViewById(R.id.comments_recycler_view);
        commentsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ArrayList<Comment> comments = new ArrayList<>();
        adapter = new CommentsAdapter(getActivity(), comments);

        mFlickrService = new FlickrService();
        mFlickrInfoPresenter = new FlickrInfoPresenter(this, mFlickrService);

        mFlickrInfoPresenter.getPhotoInfo(photo.getId());
        mFlickrInfoPresenter.getPhotoComments(photo.getId());


        return v;
    }


    @Override
    public void showPhotoInfo(PhotoInfoResponse photo) {
        Owner ownerInfo = photo.getPhotoInfo().getOwner();
        if (!ownerInfo.getUsername().isEmpty()
                && !ownerInfo.getRealname().isEmpty()) {
            usernameTv.setText(photo.getPhotoInfo().getOwner().getUsername());
            //realNameTv.setText(photo.getPhotoInfo().getOwner().getRealname());
        }
        Title titleInfo = photo.getPhotoInfo().getTitle();
        if (titleInfo.getContent().isEmpty()) {

        }
        Dates dateInfo = photo.getPhotoInfo().getDates();
        if (!dateInfo.getPosted().isEmpty()) {
            realNameTv.setText(DateUtil.convertDateToFormat(Long.parseLong(dateInfo.getPosted())));
        }
        Comment commentsInfo = photo.getPhotoInfo().getComment();
        if (!commentsInfo.getContent().isEmpty()) {

        }
    }

    @Override
    public void displayPhoto() {
        Picasso.with(getActivity())
                .load(photo.getUrl())
                .into(photoImgView);
    }

    @Override
    public void displayPhotoComments(ArrayList<Comment> comments) {
        adapter.clear();
        adapter.addAll(comments);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void displayNoComments() {
        commentsRecyclerView.setVisibility(View.GONE);
        noCommentsTv.setVisibility(View.VISIBLE);
    }
}
