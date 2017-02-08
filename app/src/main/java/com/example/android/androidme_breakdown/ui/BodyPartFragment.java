/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.androidme_breakdown.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.android.androidme_breakdown.R;


// Fragment class that holds an image for an AndroidMe body part (head, body, or legs)
public class BodyPartFragment extends Fragment {

    // Keep track of the image resource id with class variables
    public static final String IMG_ID = "IMG_ID";
    private int mImageId;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public BodyPartFragment() {
    }


    /**
     * Inflates the fragment layout file and sets the correct resource for the image to display
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Load current image resource id if it exists
        if (savedInstanceState != null) {
            mImageId = savedInstanceState.getInt(IMG_ID);
        }

        // Inflate the AndroidMe image segment, populating it with an image based on it's resource id
        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.body_part_image);

        // Set the currently selected image resource id
        imageView.setImageResource(mImageId);

        // Return the root view
        return rootView;
    }


    /**
     * Save the current image resource id
      */
    @Override
    public void onSaveInstanceState(Bundle currentState) {
        currentState.putInt(IMG_ID, mImageId);
    }

    // A setter method called setId(int id) that sets the image resource id for this fragment
    public void setId(int id) {
        this.mImageId = id;
    }

}
