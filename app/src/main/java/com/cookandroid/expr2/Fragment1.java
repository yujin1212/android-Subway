package com.cookandroid.expr2;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment1 extends Fragment {

    private double[] ctValues;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1, container, false);

        setHasOptionsMenu(true);

        Bundle bundle = this.getArguments();
        double[] ctValues = new double[19];
        if (bundle != null) {
            for (int i = 0; i < ctValues.length; i++) {
                String key = "ct" + (i + 1);
                if (bundle.containsKey(key)) {
                    ctValues[i] = bundle.getDouble(key);
                } else {
                    // Handle case when key is not found in the bundle
                    Toast.makeText(getActivity(), "Bundle key not found: " + key, Toast.LENGTH_SHORT).show();
                    // You can set a default value or take appropriate action
                }
            }
        }
//
        TextView[] textView = new TextView[19];
        int[] textId = {R.id.ct1, R.id.ct2, R.id.ct3, R.id.ct4, R.id.ct5, R.id.ct6, R.id.ct7, R.id.ct8, R.id.ct9, R.id.ct10,
                R.id.ct11, R.id.ct12, R.id.ct13, R.id.ct14, R.id.ct15, R.id.ct16, R.id.ct17, R.id.ct18, R.id.ct19};

        for (int i = 0; i < textView.length; i++) {
            textView[i] = view.findViewById(textId[i]);
            textView[i].setText(String.valueOf(ctValues[i]));
            if (ctValues[i] <= 25.0) {
                textView[i].setBackgroundColor(Color.parseColor("#A3DFFF"));
            } else if (ctValues[i] <= 50.0) {
                textView[i].setBackgroundColor(Color.parseColor("#C2FFDE"));
            }else if (ctValues[i] <= 75.0) {
                textView[i].setBackgroundColor(Color.parseColor("#FFC399"));
            }
            else {
                textView[i].setBackgroundColor(Color.parseColor("#FF8F9C"));
            }
        }

        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}
