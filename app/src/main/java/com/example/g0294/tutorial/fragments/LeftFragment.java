package com.example.g0294.tutorial.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.g0294.tutorial.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LeftFragment extends Fragment {

    private EditText editText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_left, null);
        editText = (EditText) view.findViewById(R.id.editText1);
        return view;
    }

    // Call Back接口
    public void getEditText(Linter linter) {
        String msg = editText.getText().toString();
        String tes = "";
        linter.getResult(msg, tes);
    }

    /* 接口 */
    public interface Linter {
        /*定義取得訊息的方法*/
        void getResult(String result, String res);
    }
}
