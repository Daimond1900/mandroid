package com.a1900.android.study_android.study.fragment.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;

import com.a1900.android.study_android.R;

import java.util.Date;

/**
 * Created by 1900 on 2017/6/17.
 */


public class DatePickerFragment extends DialogFragment {
    private static final String ARG_DATE = "date";
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_date,null);
        return new AlertDialog.Builder(getActivity())
                .setView(view)
                .setPositiveButton("确定",null)
                .create();
    }

    public static DatePickerFragment newInstance(Date date){
        Bundle agr = new Bundle();
        agr.putSerializable(ARG_DATE,date);
        DatePickerFragment datePickerFragment = new DatePickerFragment();
        datePickerFragment.setArguments(agr);
        return datePickerFragment;
    }
}
