package com.example.dmartins.flickrapp.activities;

import android.os.Bundle;

import com.example.dmartins.flickrapp.R;
import com.example.dmartins.flickrapp.fragments.GalleryFragment;

public class MainActivity extends BaseActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, GalleryFragment.newInstance(), TAG)
                .commit();
    }
}
