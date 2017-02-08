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

public class AndroidMeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);

        // TODO (3) Create new head, body, and leg fragments and add them to this activity
        // using a fragment manager and fragment transactions

        // This code should add the BodyPartFragments to their containers that were created in step 1
        // in the activity_android_me.xml layout file

        // If there is no saved fragment state, set the fragment image resource id to be
        // the first image in the head, body, and leg image lists
    }
}
