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

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.example.android.androidme_breakdown.R;
import com.example.android.androidme_breakdown.data.AndroidImageAssets;


// This fragment displays all of the AndroidMe images in one large list
// The list appears as a grid of images
public class ListFragment extends Fragment {

    // Keeping track of the last clicked index for each AndroidMe body part
    private int headPosition;
    private int bodyPosition;
    private int legPosition;

    // Mandatory empty constructor
    public ListFragment() {
    }

    // Inflates the GridView of all AndroidMe images
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View rootView = inflater.inflate(R.layout.fragment_list, container, false);

        // Get a reference to the GridView in the fragment_list xml layout file
        GridView gridView = (GridView) rootView.findViewById(R.id.imagesGridView);

        // Create the adapter
        // This adapter takes in the context and an ArrayList of ALL the image resources to display
        MasterListAdapter mAdapter = new MasterListAdapter(getContext(), AndroidImageAssets.getAll());

        // Set the adapter on the GridView
        gridView.setAdapter(mAdapter);

        // Creating a new Intent object here instead of inside the button click code
        // Then we'll be able to put information in the intent in the gridView onItemClickListener code
        final Intent intent = new Intent(getActivity(), AndroidMeActivity.class);

        // This creates and sets a click listener on the gridView
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Display a short Toast that shows the clicked on position
                //Toast.makeText(getContext(), "Position clicked = " + position, Toast.LENGTH_SHORT).show();

                // Create a Bundle that contains information about which head, body, and leg images have been clicked
                // So there should be three pieces of information in the Bundle
                // This will help set all image resources in the AndroidMe activity

                // Using the fact that there are 12 of each head, body, and leg images, we can
                // identify the correct body part that they are linked to based on the currentPosition/12
                // (This code also rounds down to the nearest int)
                int bodyPartIndex = position /12;

                // Modify the position so that it falls in the range of items in each image List
                int currentPosition = position - 12*bodyPartIndex;

                // Set the currently displayed item for the correct body part fragment
                switch(bodyPartIndex) {
                    case 0: //intent.putExtra("head", currentPosition);
                        headPosition = currentPosition;
                        break;
                    case 1: //intent.putExtra("body", currentPosition);
                        bodyPosition = currentPosition;
                        break;
                    case 2: //intent.putExtra("leg", currentPosition);
                        legPosition = currentPosition;
                        break;
                    default: break;
                }

                // For phone and tablet layouts, pass information in the intent
                Bundle b = new Bundle();
                b.putInt("head", headPosition);
                b.putInt("body", bodyPosition);
                b.putInt("leg", legPosition);

                // Attach the Bundle to an intent
                intent.putExtras(b);

            }
        });

        // The "Next" button launches a new AndroidMeActivity
        Button nextButton = (Button) rootView.findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Launch the intent created above by clicking on the "Next" button
                startActivity(intent);
            }
        });

        return rootView;
    }

}
