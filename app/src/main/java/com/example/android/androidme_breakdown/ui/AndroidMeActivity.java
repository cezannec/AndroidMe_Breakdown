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

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.example.android.androidme_breakdown.R;
import com.example.android.androidme_breakdown.data.AndroidImageAssets;

public class AndroidMeActivity extends AppCompatActivity {

    // Keep track of the number of clicks
    private int mClickCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);


        // If there is no saved fragment state, set the fragment image resource id to be
        // the first image in the head, body, and leg image lists
        if (savedInstanceState == null) {

            // The intent may not always have a selected value for the head, body, and leg index
            // So, if the intent does not include a value, set the default index to be the first image the array at index 0

            // Get the correct index to access in the array of head images from the intent
            // Set the default value to 0
            int headIndex = getIntent().getIntExtra("head", 0);
            // Creating a new head BodyPartFragment
            BodyPartFragment headFragment = new BodyPartFragment();
            // Setting it's image resource id
            // Set the id to the retrieved head index
            headFragment.setId(AndroidImageAssets.getHeads().get(headIndex));
            // Adding the fragment to its container using a transaction
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.headContainer, headFragment)
                    .commit();

            int bodyIndex = getIntent().getIntExtra("body", 0);
            // New body fragment
            BodyPartFragment bodyFragment = new BodyPartFragment();
            bodyFragment.setId(AndroidImageAssets.getBods().get(bodyIndex));
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.bodyContainer, bodyFragment)
                    .commit();

            int legIndex = getIntent().getIntExtra("leg", 0);
            // New leg fragment
            BodyPartFragment legFragment = new BodyPartFragment();
            legFragment.setId(AndroidImageAssets.getLegs().get(legIndex));
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.legContainer, legFragment)
                    .commit();
        }

        // Sets up the click listener
        setupHeadClickListener();
    }


    // This method attaches a click listener to the head BodyPartFragment
    // It responds to clicks by replacing the head fragment with the next image in the head assets list
    void setupHeadClickListener() {
        FrameLayout headView = (FrameLayout) findViewById(R.id.headContainer);

        // Set a click listener on the head fragment
        headView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // On a click, increase the number of clicks by one
                mClickCount++;

                // If the click count is a valid index, create a new head fragment
                if (mClickCount < 12) {
                    BodyPartFragment headFragment = new BodyPartFragment();
                    headFragment.setId(AndroidImageAssets.getHeads().get(mClickCount));

                    // Make this transaction "undoable" by adding the fragment to the backStack
                    getSupportFragmentManager().beginTransaction()
                            .add(R.id.headContainer, headFragment)
                            .addToBackStack(null)
                            .commit();
                }
            }

        });
    }

    // Override the onBackPressed method and decrement the click count
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mClickCount--;
    }

}
