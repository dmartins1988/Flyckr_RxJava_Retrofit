package com.example.dmartins.flickrapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dmartins.flickrapp.R;
import com.example.dmartins.flickrapp.adapter.GalleryAdapter;
import com.example.dmartins.flickrapp.model.Photo;
import com.example.dmartins.flickrapp.presenter.FlickrPresenter;
import com.example.dmartins.flickrapp.service.FlickrService;
import com.example.dmartins.flickrapp.view.FlickrView;

import java.util.ArrayList;

/**
 * Created by E491 on 25/11/2016.
 */

public class GalleryFragment extends Fragment implements FlickrView{

    private static final String TAG = GalleryFragment.class.getSimpleName();

    RecyclerView mRecyclerView;
    GalleryAdapter mGalleryAdapter;
    FlickrPresenter mFlickrPresenter;
    FlickrService mFlickrService;

    public GalleryFragment() {    }

    public static GalleryFragment newInstance() {
        return new GalleryFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_gallery, container, false);

        mRecyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        ArrayList<Photo> photos = new ArrayList<>();
        mGalleryAdapter = new GalleryAdapter(photos, getActivity());
        mRecyclerView.setAdapter(mGalleryAdapter);

        mFlickrService = new FlickrService();
        mFlickrPresenter = new FlickrPresenter(this, mFlickrService);
        mFlickrPresenter.loadGallery();
        mFlickrPresenter.showPhoto();
        return v;
    }


    @Override
    public void displayRecentGallery(ArrayList<Photo> listPhotos) {
        mGalleryAdapter.clear();
        mGalleryAdapter.allPhotos(listPhotos);
        mGalleryAdapter.notifyDataSetChanged();
    }

    @Override
    public void displayPhotoClicked() {
        mGalleryAdapter.setOnItemClickListener(new GalleryAdapter.OnClickListener() {
            @Override
            public void onClick(Photo photo) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.container, PhotoInfoFragment.newInstance(photo));
                ft.addToBackStack(TAG);
                ft.commit();
            }
        });
    }


}
