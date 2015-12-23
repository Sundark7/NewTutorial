package com.example.g0294.tutorial.fragments;


import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.g0294.tutorial.R;

public class Fragment2 extends Fragment {

    private final String TAG = "Fragment2";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "-----Fragment2->>onCreate");
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.i(TAG, "-----Fragment2->>onAttach");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "-----Fragment2->>onCreateView");
        return inflater.inflate(R.layout.fragment2, null);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "-----Fragment2->>onActivityCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "-----Fragment2->>onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "-----Fragment2->>onResume");
    }

    @Override
    public void onPause() {
        Log.i(TAG, "-----Fragment2->>onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "-----Fragment2->>onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG, "-----Fragment2->>onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "-----Fragment2->>onDestroy");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "-----Fragment2->>onSaveInstanceState");
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        Log.i(TAG, "-----Fragment2->>onViewStateRestored");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG, "-----Fragment2->>onDetach");
    }
}
