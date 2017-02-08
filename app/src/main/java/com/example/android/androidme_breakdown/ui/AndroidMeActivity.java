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

import com.example.android.androidme_breakdown.R;
import com.example.android.androidme_breakdown.data.AndroidImageAssets;

public class AndroidMeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);


        // If there is no saved fragment state, set the fragment image resource id to be
        // the first image in the head, body, and leg image lists
        if (savedInstanceState == null) {

            // Creating a new head BodyPartFragment
            BodyPartFragment headFragment = new BodyPartFragment();
            // Setting it's image resource id
            headFragment.setId(AndroidImageAssets.getHeads().get(0));
            // Adding the fragment to its container using a transaction
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.headContainer, headFragment)
                    .commit();

            // New body fragment
            BodyPartFragment bodyFragment = new BodyPartFragment();
            bodyFragment.setId(AndroidImageAssets.getBods().get(0));
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.bodyContainer, bodyFragment)
                    .commit();

            // New leg fragment
            BodyPartFragment legFragment = new BodyPartFragment();
            legFragment.setId(AndroidImageAssets.getLegs().get(0));
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.legContainer, legFragment)
                    .commit();
        }
    }
    
}
