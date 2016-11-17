package com.roach.massimo.roach;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by sweet on 2016-11-17.
 */

public class ElianaPersonFragment extends Fragment {



        View myView;

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.eliana_personality, container, false);
        return myView;
    }
    }


