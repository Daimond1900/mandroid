package com.a1900.android.study_android.study.fragment.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;

import com.a1900.android.study_android.R;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by 1900 on 2017/6/17.
 */


public class DatePickerFragment extends DialogFragment {
    private static final String ARG_DATE = "date";
    public static final String EXTRA_DATE =
            "com.bignerdranch.android.criminalintent.date";

    private DatePicker datePicker;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_date, null);

        Date date = (Date) getArguments().getSerializable(ARG_DATE); /*从详情里面时间按钮传来的*/

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        datePicker = (DatePicker) view.findViewById(R.id.dialog_date_picker);
        datePicker.init(year, month, day, null);

        return new AlertDialog.Builder(getActivity())
                .setView(view)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 将日期控件上的时间，传递给详情界面上的时间按钮
                        int year = datePicker.getYear();
                        int month = datePicker.getMonth();
                        int day = datePicker.getDayOfMonth();
                        Date time = new GregorianCalendar(year, month, day).getTime();
                        sendResult(Activity.RESULT_OK, time);
                    }
                })
                .create();
    }

    /**
     * 取数据
     *
     * @param date
     * @return
     */
    public static DatePickerFragment newInstance(Date date) {
        Bundle agr = new Bundle();
        agr.putSerializable(ARG_DATE, date);
        DatePickerFragment datePickerFragment = new DatePickerFragment();
        datePickerFragment.setArguments(agr);
        return datePickerFragment;
    }

    /**
     * 返回数据
     *
     * @param resultCode
     * @param date
     */
    private void sendResult(int resultCode, Date date) {
        if (getTargetFragment() == null) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(EXTRA_DATE, date);

        getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, intent);
    }
}
