package com.mimitapp.mimitapp.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.mimitapp.mimitapp.R;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    private ImageSlider imageSlider;
    private ImageView map;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        imageSlider = view.findViewById(R.id.image_slider);

        setSliderViews();

        map = view.findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMap();
            }
        });

        return view;
    }

    private void openMap() {
        Uri uri = Uri.parse("geo:0, 0?q=Malout Institute of Management and Information Technology");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }

    private void setSliderViews() {
        ArrayList<SlideModel> imageList = new ArrayList<>(); // Create image list

// imageList.add(new SlideModel("String Url" or R.drawable));
// imageList.add(new SlideModel("String Url" or R.drawable, "title")); You can add title

        imageList.add(new SlideModel(R.drawable.ic_imgo,  ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.ic_imgt,  ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.ic_imgth, ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.ic_imgf,  ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.ic_imgfi, ScaleTypes.CENTER_CROP));

       // ImageSlider imageSlider = findViewById(R.id.image_slider);
        imageSlider.setImageList(imageList);
    }
}